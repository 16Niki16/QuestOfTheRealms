package sofia.sap.interview.project.game.gameplay;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.command.CommandResult;
import sofia.sap.interview.project.game.events.CharacterDiedEvent;
import sofia.sap.interview.project.game.events.KillEnemyEvent;
import sofia.sap.interview.project.game.exceptions.ItemNotAvailableException;
import sofia.sap.interview.project.game.items.Consumable;
import sofia.sap.interview.project.game.items.Gear;
import sofia.sap.interview.project.game.items.Item;
import sofia.sap.interview.project.game.items.ItemType;

public class CombatActions {
    public CommandResult attack(Character character, Enemy enemy) {
        int damage = character.attackEnemy();
        boolean dead = enemy.defendAgainstAllyCharacter(damage);

        if (dead) {
            return CommandResult.withEvent("The enemy has been eliminated!", new KillEnemyEvent(enemy));
        }
        return CommandResult.withoutEvent(String.format("Your attack was successful and dealt %d damage!", damage));
    }

    public CommandResult defend(Character character, Enemy enemy) {
        int damage = enemy.attackDamage();
        boolean dead = character.defendAgainstEnemy(damage);

        if (dead) {
            return CommandResult.withEvent(enemy.getDamageMessage(damage), new CharacterDiedEvent(character));
        }
        return CommandResult.withoutEvent(enemy.getDamageMessage(damage));
    }

    public CommandResult useItem(Character character, ItemType itemType) {
        Item item = character.getInventory().getItem(itemType);

        if (!(item instanceof Consumable consumable)) {
            throw new ItemNotAvailableException("The provided item is not consumable!");
        }
        character.applyPotion(consumable);
        return CommandResult.withoutEvent(consumable.itemMessage());
    }

    public CommandResult equip(Character character, ItemType itemType) {
        Item item = character.getInventory().getItem(itemType);

        if (!(item instanceof Gear gear)) {
            throw new ItemNotAvailableException("The provided item is not gear!");
        }
        character.equipGear(gear);

        return CommandResult.withoutEvent(gear.equipMessage());
    }

    public CommandResult unequip(Character character, ItemType itemType) {
        Item item = character.getEquippedItem(itemType);

        if (!(item instanceof Gear gear)) {
            throw new ItemNotAvailableException("The provided item is not gear!");
        }
        character.unequipGear(gear);

        return CommandResult.withoutEvent(gear.unequipMessage());
    }
}

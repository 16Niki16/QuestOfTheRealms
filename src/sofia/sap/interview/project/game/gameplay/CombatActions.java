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
    public CommandResult<Void> attack(Character character, Enemy enemy) {
        int damage = character.attackEnemy();
        boolean dead = enemy.defendAgainstAllyCharacter(damage);

        if (dead) {
            return CommandResult.withEvent("The enemy has been eliminated!", null, new KillEnemyEvent(enemy));
        }
        return CommandResult.messageResult(String.format("Your attack was successful and dealt %d damage!", damage));
    }

    public CommandResult<Void> defend(Character character, Enemy enemy) {
        int damage = enemy.attackDamage();
        boolean dead = character.defendAgainstEnemy(damage);

        if (dead) {
            return CommandResult.withEvent(enemy.getDamageMessage(damage), null, new CharacterDiedEvent(character));
        }
        return CommandResult.messageResult(enemy.getDamageMessage(damage));
    }

    public CommandResult<Void> useItem(Character character, ItemType itemType) {
        Item item = character.getInventory().getItem(itemType);

        if (!(item instanceof Consumable consumable)) {
            throw new ItemNotAvailableException("The provided item is not consumable!");
        }
        character.applyPotion(consumable);
        return CommandResult.messageResult(consumable.itemMessage());
    }

    public CommandResult<Void> equip(Character character, ItemType itemType) {
        Item item = character.getInventory().getItem(itemType);

        if (!(item instanceof Gear gear)) {
            throw new ItemNotAvailableException("The provided item is not gear!");
        }
        character.equipGear(gear);

        return CommandResult.messageResult(gear.equipMessage());
    }

    public CommandResult<Void> unequip(Character character, ItemType itemType) {
        Item item = character.getEquippedItem(itemType);

        if (!(item instanceof Gear gear)) {
            throw new ItemNotAvailableException("The provided item is not gear!");
        }
        character.unequipGear(gear);

        return CommandResult.messageResult(gear.unequipMessage());
    }
}

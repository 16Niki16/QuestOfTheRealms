package sofia.sap.interview.project.game.gameplay;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.command.result.EventResult;
import sofia.sap.interview.project.game.events.CharacterDamagedEvent;
import sofia.sap.interview.project.game.events.CharacterDiedEvent;
import sofia.sap.interview.project.game.events.CollectItemsEvent;
import sofia.sap.interview.project.game.events.EnemyDamagedEvent;
import sofia.sap.interview.project.game.events.ItemEquipEvent;
import sofia.sap.interview.project.game.events.ItemUsedEvent;
import sofia.sap.interview.project.game.events.KillEnemyEvent;
import sofia.sap.interview.project.game.exceptions.ChestNotAvailableException;
import sofia.sap.interview.project.game.exceptions.ItemNotAvailableException;
import sofia.sap.interview.project.game.items.Consumable;
import sofia.sap.interview.project.game.items.Gear;
import sofia.sap.interview.project.game.items.Item;
import sofia.sap.interview.project.game.items.ItemType;
import sofia.sap.interview.project.game.map.room.Chest;

import java.util.Collection;

public class CombatActions {
    public CommandResult attack(Character character, Enemy enemy) {
        int damage = character.attackEnemy();
        boolean dead = enemy.defendAgainstAllyCharacter(damage);

        if (dead) {
            return new EventResult(new KillEnemyEvent(enemy));
        }
        return new EventResult(EnemyDamagedEvent.damageEnemy(enemy, damage));
    }

    public CommandResult defend(Character character, Enemy enemy) {
        int damage = enemy.attackDamage();
        boolean dead = character.defendAgainstEnemy(damage);

        if (dead) {
            return new EventResult(new CharacterDiedEvent(character));
        }
        return new EventResult(CharacterDamagedEvent.characterDefendEvent(character, damage, enemy));
    }

    public CommandResult useItem(Character character, ItemType itemType) {
        Item item = character.getInventory().getItem(itemType);

        if (!(item instanceof Consumable consumable)) {
            throw new ItemNotAvailableException("The provided item is not consumable!");
        }
        character.applyPotion(consumable);
        return new EventResult(ItemUsedEvent.potionEffect(item));
    }

    public CommandResult equip(Character character, ItemType itemType) {
        Item item = character.getInventory().getItem(itemType);

        if (!(item instanceof Gear gear)) {
            throw new ItemNotAvailableException("The provided item is not gear!");
        }
        character.equipGear(gear);

        return new EventResult(ItemEquipEvent.equipEvent(item));
    }

    public CommandResult unequip(Character character, ItemType itemType) {
        Item item = character.getEquippedItem(itemType);

        if (!(item instanceof Gear gear)) {
            throw new ItemNotAvailableException("The provided item is not gear!");
        }
        character.unequipGear(gear);

        return CommandResult.withObject(gear.unequipMessage());
    }

    public CommandResult collect(Character character, Chest chest) {
        if (chest == null) {
            throw new ChestNotAvailableException("There isn't a chest in this room!");
        }

        Collection<Item> items = chest.collectItems();
        character.collectItems(items);
        return new EventResult(CollectItemsEvent.collectEvent(items));
    }
}

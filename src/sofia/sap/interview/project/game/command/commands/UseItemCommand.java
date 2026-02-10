package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.command.CommandResult;
import sofia.sap.interview.project.game.inventory.items.Collectable;
import sofia.sap.interview.project.game.inventory.items.Item;
import sofia.sap.interview.project.game.inventory.items.potions.Potion;

public class UseItemCommand implements Command {
    private final Character character;
    private final Collectable item;

    public UseItemCommand(Character character, Collectable item) {
        this.item = item;
        this.character = character;
    }

    @Override
    public CommandResult execute() {
        character.applyPotion((Potion) item);
        return new CommandResult(character.getItemEffectMessage((Item) item));
    }
}

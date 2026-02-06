package sofia.sap.interview.project.game.gameplay.command;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.inventory.items.Collectable;
import sofia.sap.interview.project.game.inventory.items.potions.Potion;

public class UseItemCommand implements Command {
    private final Character character;
    private final Collectable item;

    public UseItemCommand(Character character, Collectable item) {
        this.item = item;
        this.character = character;
    }

    @Override
    public void execute() {
        character.applyPotion((Potion) item);
    }
}

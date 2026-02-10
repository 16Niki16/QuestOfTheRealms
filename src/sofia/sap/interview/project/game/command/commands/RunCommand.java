package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.command.CommandResult;
import sofia.sap.interview.project.game.gameplay.Gameplay;
import sofia.sap.interview.project.game.map.directions.Direction;

import java.util.Set;

public class RunCommand implements Command {
    private Character character;
    private Gameplay gameplay;

    public RunCommand(Character character, Gameplay gameplay) {
        this.character = character;
        this.gameplay = gameplay;
    }

    @Override
    public CommandResult execute() {
        Set<Direction> possibleDirections = gameplay.getPossibleDirections();

        return null;
    }
}

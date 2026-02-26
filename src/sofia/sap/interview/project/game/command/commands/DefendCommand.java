package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.command.CommandResult;
import sofia.sap.interview.project.game.gameplay.GameContext;

public class DefendCommand implements Command {
    private final GameContext context;

    public DefendCommand(GameContext context) {
        this.context = context;
    }

    @Override
    public CommandResult execute() {
        Enemy enemy = this.context.gameplay().getEnemyOnCharacterCoordinates();

        return this.context.combat().defend(this.context.character(), enemy);
    }
}

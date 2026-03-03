package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.gameplay.GameSession;

public class DefendCommand implements Command {
    private final GameSession context;

    public DefendCommand(GameSession context) {
        this.context = context;
    }

    @Override
    public CommandResult<Void> execute() {
        Enemy enemy = this.context.gameplay().getEnemyOnCharacterCoordinates();

        return this.context.combat().defend(this.context.character(), enemy);
    }
}

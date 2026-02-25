package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.command.CommandResult;
import sofia.sap.interview.project.game.command.GameContext;

public class AttackCommand implements Command {
    private final GameContext context;

    public AttackCommand(GameContext context) {
        this.context = context;
    }

    @Override
    public CommandResult execute() {
        Enemy enemy = this.context.gameplay().getEnemyOnCharacterCoordinates();

        return this.context.combat().attack(this.context.character(), enemy);
    }

}

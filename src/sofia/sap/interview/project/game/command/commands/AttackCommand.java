package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.command.CommandResult;
import sofia.sap.interview.project.game.command.GameContext;
import sofia.sap.interview.project.game.events.GameEvent;
import sofia.sap.interview.project.game.events.KillEnemyEvent;
import sofia.sap.interview.project.game.exceptions.EnemyDeadException;

public class AttackCommand implements Command {
    private final GameContext context;

    public AttackCommand(GameContext context) {
        this.context = context;
    }

    @Override
    public CommandResult execute() {
        int damage = context.character().attackEnemy();
        Enemy enemy = context.gameplay().getEnemyOnCharacterCoordinates();

        try {
            enemy.defendAgainstAllyCharacter(damage);
            return new CommandResult(damageMessage(damage));
        } catch (EnemyDeadException e) {
            GameEvent kill = new KillEnemyEvent(enemy);
            context.log().handleEvent(kill);
            return new CommandResult(e.getLocalizedMessage());
        }
    }

    private String damageMessage(int damage) {
        return String.format("Your attack caused %d damage!", damage);
    }
}

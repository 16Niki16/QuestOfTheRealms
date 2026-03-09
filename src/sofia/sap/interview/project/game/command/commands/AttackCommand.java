package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.user.User;

public class AttackCommand implements Command {
    private final User user;

    public AttackCommand(User user) {
        this.user = user;
    }

    @Override
    public CommandResult execute() {
        GameSession session = this.user.getSession();
        Enemy enemy = session.gameplay().getEnemyOnCharacterCoordinates();

        return session.combat().attack(session.character(), enemy);
    }

}

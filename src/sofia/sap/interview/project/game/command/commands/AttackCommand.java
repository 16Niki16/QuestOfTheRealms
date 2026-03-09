package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.user.User;

public class AttackCommand implements Command {

    @Override
    public CommandResult execute(User user) {
        GameSession session = user.getSession();
        Enemy enemy = session.gameplay().getEnemyOnCharacterCoordinates();

        return session.combat().attack(session.character(), enemy);
    }

}

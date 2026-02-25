package sofia.sap.interview.project.game.gameplay;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.command.CommandResult;
import sofia.sap.interview.project.game.events.KillEnemyEvent;
import sofia.sap.interview.project.game.exceptions.CharacterDeathException;

public class CombatActions {
    public CommandResult attack(Character character, Enemy enemy) {
        int damage = character.attackEnemy();
        boolean dead = enemy.defendAgainstAllyCharacter(damage);

        if (dead) {
            return CommandResult.withEvent("The enemy has been eliminated!", new KillEnemyEvent(enemy));
        }
        return CommandResult.withoutEvent(String.format("Your attack was successful and dealt %d damage!", damage));
    }

    public CommandResult defend(Character character, Enemy enemy) {
        int damage = enemy.attackDamage();
        boolean dead = character.defendAgainstEnemy(damage);

        if (dead) {
            throw new CharacterDeathException("Your character died!");
        }
        return CommandResult.withoutEvent(enemy.getDamageMessage(damage));
    }
}

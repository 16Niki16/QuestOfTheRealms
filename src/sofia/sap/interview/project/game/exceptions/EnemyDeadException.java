package sofia.sap.interview.project.game.exceptions;

public class EnemyDeadException extends RuntimeException {
    public EnemyDeadException(String message) {
        super(message);
    }

    public EnemyDeadException(String message, Throwable thr) {
        super(message, thr);
    }
}

package sofia.sap.interview.project.game.exceptions;

public class EnemyDeathException extends RuntimeException {
    public EnemyDeathException(String message) {
        super(message);
    }

    public EnemyDeathException(String message, Throwable thr) {
        super(message, thr);
    }
}

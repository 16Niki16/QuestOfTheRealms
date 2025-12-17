package sofia.sap.interview.project.game.exceptions;

public class NotEnoughManaException extends RuntimeException {
    public NotEnoughManaException(String message) {
        super(message);
    }

    public NotEnoughManaException(String message, Throwable thr) {
        super(message, thr);
    }
}

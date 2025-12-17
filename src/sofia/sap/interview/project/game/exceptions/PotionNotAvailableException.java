package sofia.sap.interview.project.game.exceptions;

public class PotionNotAvailableException extends RuntimeException {
    public PotionNotAvailableException(String message) {
        super(message);
    }

    public PotionNotAvailableException(String message, Throwable thr) {
        super(message, thr);
    }
}

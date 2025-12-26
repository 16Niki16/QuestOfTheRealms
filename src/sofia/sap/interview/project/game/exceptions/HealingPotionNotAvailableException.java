package sofia.sap.interview.project.game.exceptions;

public class HealingPotionNotAvailableException extends ItemNotAvailableException {
    public HealingPotionNotAvailableException(String message) {
        super(message);
    }

    public HealingPotionNotAvailableException(String message, Throwable thr) {
        super(message, thr);
    }
}

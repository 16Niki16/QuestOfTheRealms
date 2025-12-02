package sofia.sap.interview.project.game.exceptions;

public class EquipException extends RuntimeException {
    public EquipException(String message) {
        super(message);
    }

    public EquipException(String message, Throwable thr) {
        super(message, thr);
    }
}

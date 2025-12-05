package sofia.sap.interview.project.game.exceptions;

public class CharacterDeathException extends RuntimeException {
    public CharacterDeathException(String message) {
        super(message);
    }

    public CharacterDeathException(String message, Throwable thr) {
        super(message, thr);
    }
}

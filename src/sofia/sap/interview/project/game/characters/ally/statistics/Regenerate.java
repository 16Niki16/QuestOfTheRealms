package sofia.sap.interview.project.game.characters.ally.statistics;

import sofia.sap.interview.project.game.characters.ally.Character;

import java.time.Duration;

public class Regenerate implements Runnable {
    private static final long TIMER = 5;
    private static final int REGEN_AMOUNT = 5;
    private final Character character;

    public Regenerate(Character character) {
        this.character = character;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(Duration.ofSeconds(TIMER));
                character.regen(REGEN_AMOUNT);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

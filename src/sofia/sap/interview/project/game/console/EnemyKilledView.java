package sofia.sap.interview.project.game.console;

import sofia.sap.interview.project.game.events.KillEnemyEvent;

public class EnemyKilledView implements GameEventView<KillEnemyEvent> {

    @Override
    public void render(KillEnemyEvent event) {
        String formattedOutput = String.format("The %s has been killed, congrats!", event.enemy().getType().getName());
        System.out.println(formattedOutput);
    }
}

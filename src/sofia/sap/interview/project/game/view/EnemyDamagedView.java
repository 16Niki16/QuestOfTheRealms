package sofia.sap.interview.project.game.view;

import sofia.sap.interview.project.game.events.EnemyDamagedEvent;

public class EnemyDamagedView implements GameEventView<EnemyDamagedEvent> {
    @Override
    public void render(EnemyDamagedEvent event) {
        String formatted = String.format("%s dealt %d damage your character",
                event.type().getName(), event.damage());
        System.out.println(formatted);
    }
}

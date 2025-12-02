package sofia.sap.interview.project.game.inventory;

import java.util.ArrayList;
import java.util.List;

public class Chest {
    private List<Collectable> content;

    public Chest() {
        this.content = new ArrayList<>();
    }

    public Chest(List<Collectable> content) {
        this.content = new ArrayList<>(content);
    }

}

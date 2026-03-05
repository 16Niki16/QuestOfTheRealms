package sofia.sap.interview.project.game.view;

import sofia.sap.interview.project.game.information.ViewInformation;

public interface ViewCommand<E extends ViewInformation> {
    void render(E information);
}

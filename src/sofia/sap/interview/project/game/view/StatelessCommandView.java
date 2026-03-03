package sofia.sap.interview.project.game.view;

import sofia.sap.interview.project.game.information.ViewInformation;

public interface StatelessCommandView<T extends ViewInformation> {
    void render(T information);
}

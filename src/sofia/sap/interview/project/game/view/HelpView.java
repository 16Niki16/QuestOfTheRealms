package sofia.sap.interview.project.game.view;

import sofia.sap.interview.project.game.command.commands.CommandDTO;
import sofia.sap.interview.project.game.information.HelpInformation;

import java.util.List;

public record HelpView() implements StatelessCommandView<HelpInformation> {
    @Override
    public void render(HelpInformation information) {
        List<CommandDTO> commands = information.commands();
        System.out.println("List of available commands:");
        for (CommandDTO command : commands) {
            System.out.println(command.commandFormat() + " " + command.description());
        }
    }
}

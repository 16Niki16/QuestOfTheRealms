package sofia.sap.interview.project.game.view;

import sofia.sap.interview.project.game.command.commands.CommandDTO;

import java.util.List;

public record HelpInformation(List<CommandDTO> commands) implements ViewInformation{
}

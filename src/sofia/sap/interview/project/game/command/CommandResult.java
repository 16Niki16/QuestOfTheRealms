package sofia.sap.interview.project.game.command;

public class CommandResult {
    private final String resultMessage;

    public CommandResult(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public String getResultMessage() {
        return this.resultMessage;
    }

}

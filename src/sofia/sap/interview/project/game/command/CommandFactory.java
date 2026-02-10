package sofia.sap.interview.project.game.command;

import sofia.sap.interview.project.game.gameplay.Gameplay;

public class CommandFactory {
    /***
     * place to create the command, depends on client input??
     *
     */
    public static Command createCommand(String input, Gameplay gameplay) {
        String[] commandSplit = input.split(" ");

        String command = commandSplit[0].toLowerCase();
        CombatOptions option = CombatOptions.getOption(command);
        switch (option) {
            case ATTACK -> new AttackCommand(gameplay.)
        }
        return null;
    }
}

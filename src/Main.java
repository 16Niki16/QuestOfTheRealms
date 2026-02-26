import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.ally.type.AllyCharacterType;
import sofia.sap.interview.project.game.command.CommandResult;
import sofia.sap.interview.project.game.gameplay.GameContext;
import sofia.sap.interview.project.game.command.commands.AttackCommand;
import sofia.sap.interview.project.game.command.commands.Command;
import sofia.sap.interview.project.game.command.commands.DefendCommand;
import sofia.sap.interview.project.game.command.commands.EquipGearCommand;
import sofia.sap.interview.project.game.command.commands.LookCommand;
import sofia.sap.interview.project.game.command.commands.MoveCommand;
import sofia.sap.interview.project.game.command.commands.OpenChestCommand;
import sofia.sap.interview.project.game.command.commands.UnequipGearCommand;
import sofia.sap.interview.project.game.command.commands.UseItemCommand;
import sofia.sap.interview.project.game.gameplay.Gameplay;
import sofia.sap.interview.project.game.map.Direction;
import sofia.sap.interview.project.game.quests.FindIronKey;
import sofia.sap.interview.project.game.quests.KillGoblinKing;
import sofia.sap.interview.project.game.quests.Quest;
import sofia.sap.interview.project.game.quests.QuestLog;
import sofia.sap.interview.project.game.quests.Reward;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Character dummy = new Character("niki", AllyCharacterType.MAGE);
        Gameplay game = new Gameplay();
        System.out.println(game.getPossibleDirections());
        Map<Quest, Reward> quests = Map.of(new KillGoblinKing(), Reward.BIG, new FindIronKey(), Reward.MEDIUM);
        QuestLog log = new QuestLog(quests);
        GameContext context = new GameContext(game, dummy, log);
        //look
        Command command1 = new LookCommand(context);
        CommandResult result1 = command1.execute();
        System.out.println(result1.resultMessage());
        //open chest
        Command command69 = new OpenChestCommand(context);
        CommandResult result69 = command69.execute();
        System.out.println(result69.resultMessage());
        //equip gear
        Command command68 = new EquipGearCommand(context, "iron dagger");
        CommandResult result68 = command68.execute();
        System.out.println(result68.resultMessage());
        //unequip gear
        Command command67 = new UnequipGearCommand(context, "iron dagger");
        CommandResult result67 = command67.execute();
        System.out.println(result67.resultMessage());
        //use item
        Command command66 = new UseItemCommand(context, "healing herb");
        CommandResult result66 = command66.execute();
        System.out.println(result66.resultMessage());
        //move
        Command command = new MoveCommand(context, Direction.EAST);
        CommandResult result = command.execute();
        System.out.println(result.resultMessage());
        //look
        CommandResult result2 = command1.execute();
        System.out.println(result2.resultMessage());
        //attack
        Command command2 = new AttackCommand(context);
        CommandResult result3 = command2.execute();
        System.out.println(result3.resultMessage());
        //defend
        Command command3 = new DefendCommand(context);
        CommandResult result4 = command3.execute();
        System.out.println(result4.resultMessage());
        //attack(check mana not enough)
        CommandResult result5 = command2.execute();
        System.out.println(result5.resultMessage());
        CommandResult result6 = command2.execute();
        System.out.println(result6.resultMessage());
        CommandResult result7 = command2.execute();
        System.out.println(result7.resultMessage());
        CommandResult result8 = command2.execute();
        System.out.println(result8.resultMessage());
        CommandResult result9 = command2.execute();
        System.out.println(result9.resultMessage());
        CommandResult result10 = command2.execute();
        System.out.println(result10.resultMessage());
        //Direction choice
        /*Command command4 = new DirectionChoiceCommand(context);
        CommandResult result0 = command4.execute();
        System.out.println(result0.resultMessage());
        //move
        Command command5 = new MoveCommand(context, Direction.NORTH);
        CommandResult result5 = command5.execute();
        System.out.println(result5.resultMessage());*/
    }
}
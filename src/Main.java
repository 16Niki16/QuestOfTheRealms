import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.ally.type.AllyCharacterType;
import sofia.sap.interview.project.game.command.commands.AttackCommand;
import sofia.sap.interview.project.game.command.commands.CheckQuestsCommand;
import sofia.sap.interview.project.game.command.commands.Command;
import sofia.sap.interview.project.game.command.commands.DefendCommand;
import sofia.sap.interview.project.game.command.commands.DirectionChoiceCommand;
import sofia.sap.interview.project.game.command.commands.EquipGearCommand;
import sofia.sap.interview.project.game.command.commands.HelpCommand;
import sofia.sap.interview.project.game.command.commands.LookCommand;
import sofia.sap.interview.project.game.command.commands.MoveCommand;
import sofia.sap.interview.project.game.command.commands.OpenChestCommand;
import sofia.sap.interview.project.game.command.commands.UnequipGearCommand;
import sofia.sap.interview.project.game.command.commands.UseItemCommand;
import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.console.ConsoleRenderer;
import sofia.sap.interview.project.game.gameplay.CombatActions;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.gameplay.GameState;
import sofia.sap.interview.project.game.gameplay.Gameplay;
import sofia.sap.interview.project.game.items.ItemType;
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
        CombatActions actions = new CombatActions();
        GameSession context = new GameSession(game, dummy, log, actions, GameState.RUNNING);
        ConsoleRenderer renderer = new ConsoleRenderer();
        //possible directions
        Command command4 = new DirectionChoiceCommand(context);
        CommandResult result4 = command4.execute();
        renderer.render(result4);
        //look
        Command command1 = new LookCommand(context);
        CommandResult result1 = command1.execute();
        renderer.render(result1);
        //open chest
        Command command69 = new OpenChestCommand(context);
        CommandResult result69 = command69.execute();
        renderer.render(result69);
        //move
        Command command = new MoveCommand(context, Direction.EAST);
        CommandResult result = command.execute();
        renderer.render(result);
        //help
        Command command2 = new HelpCommand();
        CommandResult result2 = command2.execute();
        renderer.render(result2);
        //quest information
        Command command3 = new CheckQuestsCommand(context);
        CommandResult result3 = command3.execute();
        renderer.render(result3);

        //equip gear
        Command command68 = new EquipGearCommand(context, ItemType.IRON_DAGGER);
        CommandResult result68 = command68.execute();
        renderer.render(result68);
        //unequip gear
        Command command67 = new UnequipGearCommand(context, ItemType.IRON_DAGGER);
        CommandResult result67 = command67.execute();
        renderer.render(result67);
        //use item
        Command command66 = new UseItemCommand(context, ItemType.HEALING_HERB);
        CommandResult result66 = command66.execute();
        renderer.render(result66);
        //look
        CommandResult result12 = command1.execute();
        renderer.render(result12);
        //attack
        Command command23 = new AttackCommand(context);
        CommandResult result33 = command23.execute();
        renderer.render(result33);
        //defend
        Command command32 = new DefendCommand(context);
        CommandResult result41 = command32.execute();
        renderer.render(result41);
        //attack(check mana not enough)
        CommandResult result5 = command23.execute();
        renderer.render(result5);
        CommandResult result6 = command23.execute();
        renderer.render(result6);
        CommandResult result7 = command23.execute();
        renderer.render(result7);
        CommandResult result8 = command23.execute();
        renderer.render(result8);
        CommandResult result9 = command23.execute();
        renderer.render(result9);
        CommandResult result10 = command23.execute();
        renderer.render(result10);
        //Direction choice
        Command command43 = new DirectionChoiceCommand(context);
        CommandResult result0 = command43.execute();
        renderer.render(result0);
        //move
        Command command5 = new MoveCommand(context, Direction.NORTH);
        CommandResult result51 = command5.execute();
        renderer.render(result51);
    }
}
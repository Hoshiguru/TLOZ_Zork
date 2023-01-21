package game.cmds;

import game.Player;
import game.exceptions.*;

public class CommandHandler {
    private MoveCommand moveCommand;
    private HelpCommand helpCommand;
    private ScoreCommand scoreCommand;
    private MapCommand mapCommand;
    private ItemCommands itemCommands;

    public CommandHandler() {
        moveCommand = new MoveCommand();
        helpCommand = new HelpCommand();
        scoreCommand = new ScoreCommand();
        mapCommand = new MapCommand();
        itemCommands = new ItemCommands();
    }

    public void handleCommand(String command, Player player) throws InvalidCommandException, InvalidDirectionException {
        if (command.startsWith("move")) {
            String input = command.substring(4);
            String[] parts = input.split(" ");
            String direction = parts[1];
            moveCommand.move(player, direction);
        } else if (command.equals("help")) {
            helpCommand.help();
        } else if (command.equals("score")) {
            scoreCommand.score(player);
        } else if (command.equals("map") || command.equals("m")) {
            mapCommand.map(player);
        } else if (command.equals("grab") || command.equals("g")) {
            itemCommands.grab(player);
        } else if (command.startsWith("drop")) {
            String input = command.substring(4);
            String[] parts = input.split(" ");
            if (parts.length > 1) {
                String item = parts[1];
                itemCommands.drop(player, item);
            } else {
                System.out.println("Please provide an item to drop. Type 'drop <item>' to drop an item.");
            }
        }
        else if (command.equals("inventory") || command.equals("i")) {
            itemCommands.inventory(player);
        } else {
            throw new InvalidCommandException("Unknown Command. Try to use help, to see all commands.");
        }
    }
}

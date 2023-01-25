package ch.bbw.tloz_zork.cmds;

import ch.bbw.tloz_zork.exceptions.InvalidCommandException;
import ch.bbw.tloz_zork.exceptions.InvalidDirectionException;
import ch.bbw.tloz_zork.game.Player;

import java.io.IOException;


public class CommandHandler {
    private MoveCommand moveCommand;
    private HelpCommand helpCommand;
    private ScoreCommand scoreCommand;
    private MapCommand mapCommand;
    private ItemCommands itemCommands;
    private CombatCommand combatCommand;

    public CommandHandler() {
        moveCommand = new MoveCommand();
        helpCommand = new HelpCommand();
        scoreCommand = new ScoreCommand();
        mapCommand = new MapCommand();
        itemCommands = new ItemCommands();
        combatCommand = new CombatCommand();
    }

    /**
     * Handles the commands
     *
     * @param command
     * @param player
     * @throws InvalidCommandException
     * @throws InvalidDirectionException
     */
    public void handleCommand(String command, Player player) throws InvalidCommandException, InvalidDirectionException, IOException {
        if (command.startsWith("move") || command.startsWith("walk")) {
            if (command.length() > 4) {
                String input = command.substring(4);
                String[] parts = input.split(" ");
                if (parts.length > 1) {
                    String direction = parts[1];
                    moveCommand.move(player, direction);
                } else {
                    System.out.println("Please tell, where you want to go. Type 'move <direction>' to walk.");
                }
            } else {
                System.out.println("Please tell, where you want to go. Type 'move <direction>' to walk.");
            }
        } else if (command.equals("help") || command.equals("h")) {
            helpCommand.help();
        } else if (command.equals("back")) {
            moveCommand.back(player);
        } else if (command.equals("score") || command.equals("s")) {
            scoreCommand.score(player);
        } else if (command.equals("map") || command.equals("m")) {
            mapCommand.map(player);
        } else if (command.equals("grab") || command.equals("g")) {
            itemCommands.grab(player);
        } else if (command.startsWith("drop")) {
            if (command.length() > 4) {
                String input = command.substring(4);
                String[] parts = input.split(" ");
                if (parts.length > 1) {
                    String item = parts[1];
                    itemCommands.drop(player, item);
                } else {
                    System.out.println("Please provide an item to drop. Type 'drop <item>' to drop an item.");
                }
            } else {
                System.out.println("Please provide an item to drop. Type 'drop <item>' to drop an item.");
            }
        } else if (command.startsWith("eat") || command.startsWith("e")) {
            if (command.length() > 3) {
                String input = command.substring(3);
                String[] parts = input.split(" ");
                if (parts.length > 1) {
                    String item = parts[1];
                    itemCommands.eat(player, item);
                } else {
                    System.out.println("Please provide an item to eat. Type 'eat <item>' to eat an item.");
                }
            } else {
                System.out.println("Please provide an item to eat. Type 'eat <item>' to eat an item.");
            }
        } else if (command.startsWith("use") || command.startsWith("u")) {
            if (command.length() > 3) {
                String input = command.substring(3);
                String[] parts = input.split(" ");
                if (parts.length > 1) {
                    String item = parts[1];
                    itemCommands.use(player, item);
                }
            } else {
                System.out.println("Please provide an item to eat. Type 'use <item>' to equip an weapon.");
            }
        } else if (command.equals("inventory") || command.equals("i")) {
            itemCommands.inventory(player);
        } else if (command.equals("fight") || command.equals("f")) {
            // Can only be entered a fight if there is an enemy at the Location
            if (player.getCurrentLocation().getEnemy() != null) {
                combatCommand.combat(player, player.getCurrentLocation().getEnemy(), false);
            } else {
                // Else it prints out this
                System.out.println("There are no enemies in this area");
            }
        } else {
            throw new InvalidCommandException("Unknown Command. Try to use help, to see all commands.");
        }
    }
}

package ch.bbw.tloz_zork.game;

import ch.bbw.tloz_zork.cmds.CommandHandler;
import ch.bbw.tloz_zork.exceptions.InvalidCommandException;
import ch.bbw.tloz_zork.exceptions.InvalidDirectionException;
import ch.bbw.tloz_zork.game.initializer.LocationInitializer;
import ch.bbw.tloz_zork.locations.Location;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Player player;
    private Location castle_ruin, woodland, castle, cave, desert, underwater_temple;
    private CommandHandler commandHandler;

    /**
     * @return the player
     */
    public void startGame() throws Exception {
        player = new Player(3, 3, 1, 5, 5, null, 20.0, null, false, false);
        commandHandler = new CommandHandler();
        Scanner scanner = new Scanner(System.in);
        String command;
        System.out.println("     /\\");
        System.out.println("    /  \\");
        System.out.println("   /____\\");
        System.out.println("  /\\    /\\");
        System.out.println(" /  \\  /  \\");
        System.out.println("/____\\/____\\");
        System.out.println("Welcome to");
        System.out.println("\n" +
                "▀█▀ █░█ █▀▀   █░░ █▀▀ █▀▀ █▀▀ █▄░█ █▀▄   █▀█ █▀▀   ▀█ █▀▀ █░░ █▀▄ ▄▀█\n" +
                "░█░ █▀█ ██▄   █▄▄ ██▄ █▄█ ██▄ █░▀█ █▄▀   █▄█ █▀░   █▄ ██▄ █▄▄ █▄▀ █▀█");
        System.out.println("Zork of the Wild");
        System.out.println("");
        System.out.println("Type 'start' to start the game");
        System.out.print("》 ");

        while (!(command = scanner.nextLine()).equalsIgnoreCase("start")) {
            System.out.println("Invalid command. Please type 'start' to begin the game.");
            System.out.print("》 ");
        }
        System.out.println("Is this your first time playing The Legends of Zelda: Zork of the Wild?");
        while (!player.isDead() || !player.isHasWon()) {
            System.out.print("》 ");
            switch (scanner.nextLine().toLowerCase()) {
                case "yes":
                case "y":
                    CombatTutorial combatTutorial = new CombatTutorial();
                    combatTutorial.dummyTutorial();
                case "no":
                case "n":
                    System.out.println("Then let's jump right into your adventure!");
                    initializeGame();
                    System.out.println("");
                    loading(1000);
                    System.out.print(".");
                    loading(1000);
                    System.out.print(".");
                    loading(1000);
                    System.out.print(".");
                    System.out.println("Link, are you awake? You're currently in " + player.getCurrentLocation().getIcon() + " " + player.getCurrentLocation().getName() + ". You have to find the master sword to defeat Ganon. Good luck!");
                    // Hier startet das Spiel
                    while (!player.isDead()) {
                        System.out.print("》 ");
                        command = scanner.nextLine();
                        try {
                            commandHandler.handleCommand(command, player);
                        } catch (InvalidCommandException | InvalidDirectionException e) {
                            System.out.println(e.getMessage());
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        if (player.isDead()) {
                            System.out.println();
                            System.out.println();
                            System.out.println();
                            System.out.println();
                            System.out.println();
                            System.out.println("\n" +
                                    "██╗░░░██╗░█████╗░██╗░░░██╗  ██████╗░██╗███████╗██████╗░\n" +
                                    "╚██╗░██╔╝██╔══██╗██║░░░██║  ██╔══██╗██║██╔════╝██╔══██╗\n" +
                                    "░╚████╔╝░██║░░██║██║░░░██║  ██║░░██║██║█████╗░░██║░░██║\n" +
                                    "░░╚██╔╝░░██║░░██║██║░░░██║  ██║░░██║██║██╔══╝░░██║░░██║\n" +
                                    "░░░██║░░░╚█████╔╝╚██████╔╝  ██████╔╝██║███████╗██████╔╝\n" +
                                    "░░░╚═╝░░░░╚════╝░░╚═════╝░  ╚═════╝░╚═╝╚══════╝╚═════╝░");
                            System.out.println("Game over!");
                        } else if (player.isHasWon()) {
                            System.out.println();
                            System.out.println();
                            System.out.println();
                            System.out.println();
                            System.out.println();
                            System.out.println("\n" +
                                    "██╗░░░██╗░█████╗░██╗░░░██╗  ░██╗░░░░░░░██╗░█████╗░███╗░░██╗\n" +
                                    "╚██╗░██╔╝██╔══██╗██║░░░██║  ░██║░░██╗░░██║██╔══██╗████╗░██║\n" +
                                    "░╚████╔╝░██║░░██║██║░░░██║  ░╚██╗████╗██╔╝██║░░██║██╔██╗██║\n" +
                                    "░░╚██╔╝░░██║░░██║██║░░░██║  ░░████╔═████║░██║░░██║██║╚████║\n" +
                                    "░░░██║░░░╚█████╔╝╚██████╔╝  ░░╚██╔╝░╚██╔╝░╚█████╔╝██║░╚███║\n" +
                                    "░░░╚═╝░░░░╚════╝░░╚═════╝░  ░░░╚═╝░░░╚═╝░░░╚════╝░╚═╝░░╚══╝");
                            System.out.println("Congratulations!");
                        }
                    }
                    break;
                default:
                    System.out.println("I need a yes or a no");
                    break;
            }
        }

    }
    /**
     * Initializes the game
     * @throws Exception
     */
    private void initializeGame() throws Exception {
        LocationInitializer locationInitializer = new LocationInitializer();
        List<Location> locations = locationInitializer.initializeLocations();

        player.setCurrentLocation(locations.get(0));
    }

    public static void loading(long limit) {

        long startTime = System.currentTimeMillis();
        long elapsedTime = 0L;

        while (elapsedTime < limit) {

            elapsedTime = (new Date()).getTime() - startTime;
        }
    }

}

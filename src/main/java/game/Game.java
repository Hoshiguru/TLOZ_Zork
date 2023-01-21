package game;

import game.cmds.*;
import game.exceptions.InvalidCommandException;
import game.exceptions.InvalidDirectionException;

import java.util.Scanner;

public class Game {
    private Player player;
    private Location castle_ruin, woodland, castle, cave, desert, underwater_temple;
    private CommandHandler commandHandler;

    //private Place places; // oder auch Räume
    public void startGame() {
        player = new Player(3, null, 20.0, null);
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
        System.out.println("\"The Legends of Zelda: Zork of the Wild\"");
        System.out.println("");
        System.out.println("Type start to start the game");
        System.out.print("> ");

        while (!(command = scanner.nextLine()).equalsIgnoreCase("start")) {
            System.out.println("Invalid command. Please type 'start' to begin the game.");
            System.out.print("> ");
        }
        initializeGame();
        System.out.println("Link, are you awake? You're currently in the Shrine of Life. Walk in direction to north, to exit.");
        // Hier startet das Spiel
        while (true) {
            System.out.print("> ");
            command = scanner.nextLine();
            try {
                commandHandler.handleCommand(command, player);
            } catch (InvalidCommandException e) {
                System.out.println(e.getMessage());
            } catch (InvalidDirectionException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void initializeGame() {
        // Hier wird alles initialisiert
        Item bow_and_arrow = new Item("Bow and Arrow", "A ranged weapon used to defeat enemies and hit distant targets.", 1.2, "\uD83C\uDFF9");
        Item iron_sword = new Item("Iron Sword", "A melee weapon used to defeat enemies and hit close targets.", 1.8, "\uD83D\uDDE1");
        Item shield = new Item("Shield", "A defensive item used to protect the player from enemy attacks.", 6.5, "\uD83D\uDEE1");
        Item health_potion = new Item("Health Potion", "A healing item used to restore health.", 0.5, "\uD83D\uDC9F");
        Item apple = new Item("Apple", "A healing item used to restore health.", 0.2, "\uD83C\uDF4E");

        // Initialisierung Räume
        castle_ruin = new Location("Castle Ruin", "\uD83C\uDFDB", "A mysterious, crumbling castle awaits exploration, filled with dangerous enemies and valuable treasures.", "castle_ruin", null);
        woodland = new Location("Woodland", "\uD83C\uDF33", "A dense forest filled with dangerous enemies and valuable treasures. Location of the master sword.", "woodland", iron_sword);
        castle = new Location("Castle", "\uD83C\uDFF0", "A grand and imposing castle stands at the center of the kingdom, guarded by powerful enemies and holding secrets of ancient power.", "castle", null);
        cave = new Location("Cave", "\uD83E\uDEA8", "A dark and treacherous cave system winds deep into the earth, filled with dangerous creatures and hidden treasures.", "cave", shield);
        desert = new Location("Desert", "\uD83C\uDFDC️", "A vast and scorching desert stretches as far as the eye can see, with hidden oases, ancient ruins, and deadly sandstorms.", "desert", bow_and_arrow);
        underwater_temple = new Location("Underwater Temple", "\uD83D\uDED5", "A mysterious underwater temple lies beneath the waves, filled with treacherous currents, ancient technology and deadly guardians.", "underwater_temple", health_potion);

        // Initialisierung Zugänge (Gates) -> Map
        Gate gateCastle_ruinWoodland = new Gate(castle_ruin, woodland, false);
        Gate gateWoodlandCastle = new Gate(woodland, castle, false);
        Gate gateCastle_ruinCave = new Gate(castle_ruin, cave, false);
        Gate gateCaveDesert = new Gate(cave, desert, false);
        Gate gateDesertUnderwater_temple = new Gate(desert, underwater_temple, false);

        // Festlegen von Himmelsrichtungen
        castle_ruin.setDirections(gateCastle_ruinWoodland, gateCastle_ruinCave, null, null);
        woodland.setDirections(null, null, gateCastle_ruinWoodland, gateWoodlandCastle);
        castle.setDirections(null, gateWoodlandCastle, null, null);
        cave.setDirections(null, gateCaveDesert, null, gateCastle_ruinCave);
        desert.setDirections(null, null, gateDesertUnderwater_temple, gateCaveDesert);
        underwater_temple.setDirections(gateDesertUnderwater_temple, null, null, null);

        // Item auffüllen
        player.addItem(apple);
        // Startposition festlegen
        player.setCurrentLocation(castle_ruin);
    }




}

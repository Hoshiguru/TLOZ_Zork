package game;

import java.util.Scanner;
import game.cmds.*;

public class Game {
    private Player player;
    //private game.Location currentLocation;
    private Location castle_ruin, woodland, castle, cave, desert, underwater_temple;
    //private Place places; // oder auch Räume
    public void startGame() {
        // Hier wird alles initialisiert
        player = new Player(3, null, 20.0, null);

        // TODO: Schreine hinzufügen

        // Initialisierung Räume
        castle_ruin = new Location("Castle Ruin","\uD83C\uDFDB" ,"A mysterious, crumbling castle awaits exploration, filled with dangerous enemies and valuable treasures.", "castle_ruin");
        woodland = new Location("Woodland","\uD83C\uDF33" ,"A dense forest filled with dangerous enemies and valuable treasures. game.Location of the master sword.", "woodland");
        castle = new Location("Castle", "\uD83C\uDFF0", "A grand and imposing castle stands at the center of the kingdom, guarded by powerful enemies and holding secrets of ancient power.", "castle");
        cave = new Location("Cave", "\uD83E\uDEA8", "A dark and treacherous cave system winds deep into the earth, filled with dangerous creatures and hidden treasures.", "cave");
        desert = new Location("Desert", "\uD83C\uDFDC️", "A vast and scorching desert stretches as far as the eye can see, with hidden oases, ancient ruins, and deadly sandstorms.", "desert");
        underwater_temple = new Location("Underwater Temple","\uD83D\uDED5", "A mysterious underwater temple lies beneath the waves, filled with treacherous currents, ancient technology and deadly guardians.", "underwater_temple");

        // Initialisierung Items
        Item bow_and_arrow = new Item("Bow and Arrow", "A ranged weapon used to defeat enemies and hit distant targets.", 1.2);
        Item iron_sword = new Item("Iron Sword", "A melee weapon used to defeat enemies and hit close targets.", 1.8);
        Item shield = new Item("Shield", "A defensive item used to protect the player from enemy attacks.", 6.5);

        // Initialisierung Zugänge (Gates) -> Map
        Gate gateCastle_ruinWoodland = new Gate(castle_ruin, woodland, false);
        Gate gateWoodlandCastle = new Gate(woodland, castle, false);
        Gate gateCastle_ruinCave = new Gate(castle_ruin, cave, false);
        Gate gateCaveDesert = new Gate(cave, desert, false);
        Gate gateDesertUnderwater_temple = new Gate(desert, underwater_temple, false);

        // Initialisierung Enemy
        Enemy bokoblin = new Enemy("Bokoblin", 1, 1, 10, bow_and_arrow);
        Enemy moblin = new Enemy("moblin", 1, 1, 10, iron_sword);
        Enemy lynel = new Enemy("lynel", 1, 1, 10, shield);

        // Festlegen von Himmelsrichtungen
        castle_ruin.setDirections(gateCastle_ruinWoodland,  gateCastle_ruinCave, null, null);
        woodland.setDirections(null, null, gateCastle_ruinWoodland, gateWoodlandCastle);
        castle.setDirections(null, gateWoodlandCastle, null, null);
        cave.setDirections(null, gateCaveDesert, null, gateCastle_ruinCave);
        desert.setDirections(null, null, gateDesertUnderwater_temple, gateCaveDesert);
        underwater_temple.setDirections(gateDesertUnderwater_temple, null, null, null);

        // Startposition festlegen
        player.setCurrentLocation(castle_ruin);

        // Hier startet das Spiel
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

        // Hier entsteht die game.Game Start Funktion, welche durchloopt
        boolean gameWon = false;
        while (gameWon != true) {
            System.out.print("> ");
            command = scanner.nextLine();
            if (command.startsWith("move")) {
                MoveCommand cmd = new MoveCommand();
                try {
                    String input = command.substring(4);
                    String[] parts = input.split(" ");
                    String direction = parts[1];
                    cmd.move(player, direction);
                }
                catch (Exception e) {
                    System.out.println("Please enter a valid direction • (n)orth, (e)ast, (s)outh, (w)est)");
                }
            } else if (command.equals("help")) {
               HelpCommand cmd = new HelpCommand();
               cmd.help();
            } else if (command.equals("score")) {
                ScoreCommand cmd = new ScoreCommand();
                cmd.score(player);
            } else if (command.equals("map")) {
                MapCommand cmd = new MapCommand();
                cmd.map(player);
            } else {
                System.out.println("Unknown Command. Try to use help, to see all commands.");
            }
        }

    }


}

import java.io.InputStreamReader;
import java.util.Scanner;

public class Game {
    private Player player;
    private Location currentLocation;
    private Location castle_ruin, woodland, castle, cave, desert, underwater_temple;
    //private Place places; // oder auch Räume
    public void startGame() {
        // Hier wird alles initialisiert
        player = new Player(3, null, 20.0, null);

        // TODO: Schreine hinzufügen

        // Initialisierung Räume
        castle_ruin = new Location("Castle Ruin", "A mysterious, crumbling castle awaits exploration, filled with dangerous enemies and valuable treasures.", "castle_ruin");
        woodland = new Location("Woodland", "A dense forest filled with dangerous enemies and valuable treasures. Location of the master sword.", "woodland");
        castle = new Location("Castle", "A grand and imposing castle stands at the center of the kingdom, guarded by powerful enemies and holding secrets of ancient power.", "castle");
        cave = new Location("Cave", "A dark and treacherous cave system winds deep into the earth, filled with dangerous creatures and hidden treasures.", "cave");
        desert = new Location("Desert", "A vast and scorching desert stretches as far as the eye can see, with hidden oases, ancient ruins, and deadly sandstorms.", "desert");
        underwater_temple = new Location("Underwater Temple", "A mysterious underwater temple lies beneath the waves, filled with treacherous currents, ancient technology and deadly guardians.", "underwater_temple");

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

        // Festlegen von Himmelsrichtungen
        castle_ruin.setDirections(gateCastle_ruinWoodland,  gateCastle_ruinCave, null, null);
        woodland.setDirections(null, null, gateCastle_ruinWoodland, gateWoodlandCastle);
        castle.setDirections(null, gateWoodlandCastle, null, null);
        cave.setDirections(null, gateCaveDesert, null, gateCastle_ruinCave);
        desert.setDirections(null, null, gateDesertUnderwater_temple, gateCaveDesert);
        underwater_temple.setDirections(gateDesertUnderwater_temple, null, null, null);

        // Startposition festlegen
        currentLocation = castle_ruin;

        // Hier startet das Spiel
        Scanner scanner = new Scanner(System.in);
        String command;
        Commands cmds = new Commands();

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


        // Hier entsteht die Game Start Funktion, welche durchloopt
        boolean gameWon = false;
        while (gameWon != true) {
            System.out.print(">");
            command = scanner.nextLine();
            switch (command) {
                case "start":
                    cmds.start();
                    break;
                case "help":
                    cmds.help();
                    break;
                case "score":
                    cmds.score();
                    break;
                case "map":
                    cmds.map(currentLocation);
                    break;
                default:
                    System.out.println("Unknown Command. Try to use help, to see all commands.");
                    break;
            }
        }

    }


}

import java.io.InputStreamReader;
import java.util.Scanner;

public class Game {
    //private Room playerPosition;
    private Player player;
    //private Place places; // oder auch Räume
    public void startGame() {
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
        System.out.println("Type START to start the game");

        boolean gameWon = false;
        while (gameWon != true) {
            command = scanner.nextLine();
            switch (command) {
                case "start":
                    cmds.start();
                    break;
                case "help":
                    cmds.help();
                    break;
                default:
                    System.out.println("Unknown Command. Try to use help, to see all commands.");
                    break;
            }
        }

    }
    // Hier wird alles initialisiert

    // Hier entsteht die Game Start Funktion, welche durchloopt
}

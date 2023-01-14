import java.io.InputStreamReader;
import java.util.Scanner;

public class Game {
    //private Room playerPosition;
    private Player player;
    //private Place places; // oder auch Räume
    Scanner scanner = new Scanner(new InputStreamReader(System.in));

    public void startGame() {
        System.out.println("     /\\");
        System.out.println("    /  \\");
        System.out.println("   /____\\");
        System.out.println("  /\\    /\\");
        System.out.println(" /  \\  /  \\");
        System.out.println("/____\\/____\\");
        System.out.println("Welcome to");
        System.out.println("\"The Legends of Zelda: Zork of the Wild\"");
        System.out.println("");
        System.out.println("Start");
        System.out.println("Quit");
    }
    // Hier wird alles initialisiert

    // Hier entsteht die Game Start Funktion, welche durchloopt
}

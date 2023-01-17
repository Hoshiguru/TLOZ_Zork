import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Commands {
    /**
     * Exit the game tab
     */
    public void exit(){
        System.out.println("Exit the Program..");
        System.exit(0);
    }

    /**
     * Get more inforrmation about commands
     */
    public void help(){
        System.out.println("## Move Commands ##\nnorth • south • east • west");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("## Interaction Commands ##\ncollect • map • score");
    }

    /**
     * Start the Game
     */
    public void start(){
        System.out.println("Link, are you awake? You're currently in the Shrine of Life. Walk in direction to north, to exit.");
    }

}

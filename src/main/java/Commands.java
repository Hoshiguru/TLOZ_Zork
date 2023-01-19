import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Commands {
    private Player player;

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
        System.out.println("## Move Commands ##\nMove\n(n)orth • (s)outh • (e)ast • (w)est");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("## Interaction Commands ##\ncollect • map • score");
    }
    // Move Commands
    public void move(Player player, String direction){
        // Get the current Location
        Location currentLocation = player.getCurrentLocation();
        switch(direction){
            case "n":
                direction = "north";
                break;
            case "s":
                direction = "south";
                break;
            case "e":
                direction = "east";
                break;
            case "w":
                direction = "west";
               break;
            default:
                break;
        }
        // Get the Gate of the current Location
        Gate gate = currentLocation.getDirections().get(direction);
        // Check if the Gate is null
        if(gate == null){
            System.out.println("You can't go there!");
        }else{
            // Get the Location of the Gate
            Location location1 = gate.getLocation1();
            Location location2 = gate.getLocation2();
            if (location1.getName().equals(currentLocation.getName())) {
                player.setCurrentLocation(location2);
                System.out.println(location2.getIcon() + "You are now in " + location2.getName());
                System.out.println(location2.getQuote());
            }
            else if (location2.getName().equals(currentLocation.getName())){
                player.setCurrentLocation(location1);
                System.out.println(location1.getIcon() + "You are now in " + location1.getName());
                System.out.println(location1.getQuote());
            }
            else {
                System.out.println("Hmm. For whatever reason, you can\'t pass here");
            }
            System.out.println(player.getCurrentLocation().getName());
        }
    }
    public void score(Player player){
        System.out.println("There is not much to see here yet.");
        System.out.println("Health: " + player.getHearts());
    }

    /**
     * Show the map and current location
     * @param player
     */
    public void map(Player player){
        Location location = player.getCurrentLocation();
        System.out.println(location.getIcon() + "Your are in " + location.getName());
        System.out.println("The map for this place is still being created...");
    }

    /**
     * Start the Game
     */
    public void start(){
        System.out.println("Link, are you awake? You're currently in the Shrine of Life. Walk in direction to north, to exit.");
    }

}

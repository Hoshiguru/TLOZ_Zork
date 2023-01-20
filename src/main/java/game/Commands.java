package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

// TODO: game.Commands in eigene Klasse auslagern
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
        System.out.println("## Move game.Commands ##\nMove\n(n)orth • (s)outh • (e)ast • (w)est");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("## Interaction game.Commands ##\ncollect • map • score");
    }
    // Move game.Commands
    public void move(Player player, String direction){
        // Get the current game.Location
        Location currentLocation = player.getCurrentLocation();
        switch (direction) {
            case "n" -> direction = "north";
            case "s" -> direction = "south";
            case "e" -> direction = "east";
            case "w" -> direction = "west";
            default -> {
            }
        }
        // Get the game.Gate of the current game.Location
        Gate gate = currentLocation.getDirections().get(direction);
        // Check if the game.Gate is null
        if(gate == null){
            System.out.println("You can't go there!");
        }else{
            // Get the game.Location of the game.Gate
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
     * Start the game.Game
     */
    public void start(){
        System.out.println("Link, are you awake? You're currently in the Shrine of Life. Walk in direction to north, to exit.");
    }

}

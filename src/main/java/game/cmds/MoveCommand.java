package game.cmds;

import game.*;
public class MoveCommand {
    public void move(Player player, String direction){
        // Get the current game.Location
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
}

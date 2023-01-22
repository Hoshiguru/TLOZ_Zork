package ch.bbw.tloz_zork.cmds;

import ch.bbw.tloz_zork.game.Gate;
import ch.bbw.tloz_zork.game.Player;
import ch.bbw.tloz_zork.locations.Location;

public class MoveCommand {
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
                player.setPreviousLocation(location1);
                player.setCurrentLocation(location2);
                System.out.println(location2.getIcon() + "You are now in " + location2.getName());
                System.out.println(location2.getQuote());
            }
            else if (location2.getName().equals(currentLocation.getName())){
                player.setPreviousLocation(location2);
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
    public void back(Player player) {
        if (player.getPreviousLocation() != null){
            if (player.getPreviousLocation() == player.getCurrentLocation()) {
                System.out.println("You cannot execute the 'back' command twice in a row.");
            } else {
                player.setCurrentLocation(player.getPreviousLocation());
                System.out.println(player.getCurrentLocation().getIcon() + "You are now in " + player.getCurrentLocation().getName());
                System.out.println(player.getCurrentLocation().getQuote());
            }
        } else {
            System.out.println("You can\'t go back.");
        }
    }
}

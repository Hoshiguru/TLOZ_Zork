package ch.bbw.tloz_zork.cmds;

import ch.bbw.tloz_zork.game.Gate;
import ch.bbw.tloz_zork.game.Player;
import ch.bbw.tloz_zork.locations.Dungeon;
import ch.bbw.tloz_zork.locations.Location;

public class MoveCommand {
    /**
     * Move the player to a new Location
     * @param player
     * @param direction
     */
    public void move(Player player, String direction){
        Location currentLocation = player.getCurrentLocation();
        // Get the game.Gate of the current game.Location
        Gate gate = currentLocation.getDirections().get(getFullDirection(direction));
        // Check if the game.Gate is null
        if(gate == null){
            System.out.println("You can't go there!");
        }else if (!gate.isBlocked(player)){
            player.increaseMoves();
            Location nextLocation = getNextLocation(currentLocation, gate);
            player.setPreviousLocation(currentLocation);
            player.setCurrentLocation(nextLocation);
            System.out.println(nextLocation.getIcon() + "You are now in " + nextLocation.getName());
            System.out.println(nextLocation.getQuote());
            System.out.println(nextLocation.getItems());
            checkEnemyStatus(nextLocation);
            if (nextLocation instanceof Dungeon) {
                Dungeon dungeon = (Dungeon) nextLocation;
                dungeon.startChallenge(player);
            }
        } else if (gate.isBlocked(player)){
            System.out.println("You need 6 heart chambers (max. hearts) to pass this gate. You need " + (6 - player.getMaxHearts()) + " more hearts. Complete dungeons to get more hearts.");
        }
        else {
            System.out.println("You can\'t go there.");
        }
    }

    /**
     * Check, if the Player uses a shortcut
     * @param direction
     * @return
     */
    private String getFullDirection(String direction) {
        switch (direction) {
            case "n" -> direction = "north";
            case "s" -> direction = "south";
            case "e" -> direction = "east";
            case "w" -> direction = "west";
            default -> {
            }
        }
        return direction;
    }

    /**
     * Get the next Location of the player
     * @param currentLocation
     * @param gate
     * @return
     */
    private Location getNextLocation(Location currentLocation, Gate gate) {
        Location location1 = gate.getLocation1();
        Location location2 = gate.getLocation2();
        if (location1.getName().equals(currentLocation.getName())) {
            return location2;
        } else if (location2.getName().equals(currentLocation.getName())){
            return location1;
        } else {
            System.out.println("Hmm. For whatever reason, you can\'t pass here");
            return currentLocation;
        }
    }

    /**
     * Check if there is an enemy in the current Location
     * @param location
     */
    protected void checkEnemyStatus(Location location) {
        if (location.getEnemy() != null && !location.getEnemy().getIsDead()){
            System.out.println("⚠️There is also a " + location.getEnemy().getName() + " in this area. This enemy holds a " + location.getEnemy().getItem().getName() + ".\nYou can 'fight' him anytime while you are in this Location");
        }
    }

    /**
     * Move the player to the previous Location
     * @param player
     */
    public void back(Player player) {
        if (player.getPreviousLocation() != null){
            if (player.getPreviousLocation() == player.getCurrentLocation()) {
                System.out.println("You cannot execute the 'back' command twice in a row.");
            }  else {
                player.increaseMoves();
                player.setCurrentLocation(player.getPreviousLocation());
                System.out.println(player.getCurrentLocation().getIcon() + "You are now in " + player.getCurrentLocation().getName());
                System.out.println(player.getCurrentLocation().getQuote());
            }
        } else {
            System.out.println("You can\'t go back.");
        }
    }

}
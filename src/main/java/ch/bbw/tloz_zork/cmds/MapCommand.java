package ch.bbw.tloz_zork.cmds;


import ch.bbw.tloz_zork.game.Player;
import ch.bbw.tloz_zork.locations.Location;

public class MapCommand {
    public void map(Player player){
        Location location = player.getCurrentLocation();
        System.out.println(location.getIcon() + "Your are in " + location.getName());
        System.out.println("The map for this place is still being created...");
    }
}

package ch.bbw.tloz_zork.cmds;
import game.Location;
import game.Player;

public class MapCommand {
    public void map(Player player){
        Location location = player.getCurrentLocation();
        System.out.println(location.getIcon() + "Your are in " + location.getName());
        System.out.println("The map for this place is still being created...");
    }
}

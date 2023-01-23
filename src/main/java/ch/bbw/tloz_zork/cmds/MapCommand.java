package ch.bbw.tloz_zork.cmds;


import ch.bbw.tloz_zork.game.Player;
import ch.bbw.tloz_zork.locations.Location;

import java.io.*;
import java.util.List;

public class MapCommand {
    /**
     * Displays the map for the current location
     * @param player
     */
    public void map(Player player) throws IOException {
        Location location = player.getCurrentLocation();
        String map = location.getAssignedMap();
        System.out.println(location.getIcon() + "Your are in " + location.getName());

        File file = new File("src/main/resources/map/map_" + map + ".txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            System.out.println(st);
        }
    }
}

package ch.bbw.tloz_zork.cmds;


import ch.bbw.tloz_zork.game.Player;
import ch.bbw.tloz_zork.locations.Location;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MapCommand {
    /**
     * Displays the map for the current location
     *
     * @param player
     */
    public void map(Player player) throws IOException {
        Location location = player.getCurrentLocation();
        String map = location.getAssignedMap();
        System.out.println(location.getIcon() + "Your are in " + location.getName());
        System.out.println(location.getQuote());
        if (map != null) {
            File file = new File("src/main/resources/map/map_" + map + ".txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                System.out.println(st);
            }
        } else {
            System.out.println("No map available");
        }
    }
}

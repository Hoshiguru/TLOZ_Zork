package ch.bbw.tloz_zork.game;

import ch.bbw.tloz_zork.locations.Location;

/**
 * Every location could have 4 Gates, which are the directions you can go to.
 * On every game.Gate, you can append only 2 Locations -> Please note the map for orientation in the documentation
 * @author Yao Kaiser
 */
public class Gate {
    private Location location1;
    private Location location2;
    private boolean isBlocked;

    public Gate(Location location1, Location location2, boolean isBlocked) {
        this.location1 = location1;
        this.location2 = location2;
        this.isBlocked = isBlocked;
    }

    public Location getLocation1() {
        return location1;
    }

    public void setLocation1(Location location1, Player player) {
        this.location1 = location1;
    }

    public Location getLocation2() {
        return location2;
    }

    public void setLocation2(Location location2, Player player) {
        this.location2 = location2;
    }

    /** Checks if the gate is blocked
     * @return the isBlocked
     */
    public boolean isBlocked(Player player) {
        if (player.getMaxHearts() < 6 && this.isBlocked) {
            this.isBlocked = true;
        } else {
            this.isBlocked = false;
        }
        return isBlocked;
    }
}

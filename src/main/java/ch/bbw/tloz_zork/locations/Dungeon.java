package ch.bbw.tloz_zork.locations;

import game.Item;
import game.Location;

public class Dungeon extends Location {
    private boolean isCompleted;
    private Item reward;

    public Dungeon(String name, String description, String icon) {
        super(name, description, icon);
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public Item getReward() {
        return reward;
    }

    public void setReward(Item reward) {
        this.reward = reward;
    }
}


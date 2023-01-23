package ch.bbw.tloz_zork.locations;

import ch.bbw.tloz_zork.items.Item;
import ch.bbw.tloz_zork.riddles.Riddle;

import java.util.ArrayList;
import java.util.Scanner;

public class Dungeon extends Location {
    private boolean isCompleted;
    private Item reward;
    private Riddle riddle;
    // TODO: Add a list of enemies
    public Dungeon(String name, String icon, String quote, String assignedMap, boolean isCompleted, Item reward, Riddle riddle) {
        super(name, icon, quote, assignedMap);
        this.isCompleted = isCompleted;
        this.reward = reward;
        this.riddle = riddle;
    }

    /**
     * Starts the challenge of the dungeon
     */
    public void startChallenge(){
        if (!isCompleted) {
            // TODO: Add a fight against enemies
            if(riddle != null) {
                System.out.println("\uD83D\uDEAA You just entered a dungeon. You can't go back, until you solved this riddle.");
                riddle.answerPrompt(this);
            } else {
                System.out.println("This challenge has neither a riddle nor enemies!");
            }
        }
        else {
            if (reward != null) {
                addItem(reward);
                System.out.println("✅ You have already completed this dungeon! You can grab a " + reward.getIcon() + reward.getName() + " as a reward.");
                setReward(null);
            } else {
                System.out.println("✅ You have already completed this dungeon and collected your rewards! Search for another one.");
            }
        }
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


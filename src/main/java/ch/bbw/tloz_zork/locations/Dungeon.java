package ch.bbw.tloz_zork.locations;

import ch.bbw.tloz_zork.cmds.CombatCommand;
import ch.bbw.tloz_zork.enemies.Enemy;
import ch.bbw.tloz_zork.game.Player;
import ch.bbw.tloz_zork.items.Item;
import ch.bbw.tloz_zork.riddles.Riddle;

public class Dungeon extends Location {
    private boolean isCompleted;
    private Item reward;
    private Riddle riddle;
    private Enemy enemy;
    private Player player;

    public Dungeon(String name, String icon, String quote, String assignedMap, boolean isCompleted, Item reward, Riddle riddle) {
        super(name, icon, quote, assignedMap);
        this.isCompleted = isCompleted;
        this.reward = reward;
        this.riddle = riddle;
    }

    public Dungeon(String name, String icon, String quote, String assignedMap, boolean isCompleted, Item reward, Enemy enemy, Player player) {
        super(name, icon, quote, assignedMap);
        this.isCompleted = isCompleted;
        this.reward = reward;
        this.enemy = enemy;
        this.player = player;
    }

    /**
     * Starts the challenge of the dungeon
     */
    public void startChallenge(){
        if (!isCompleted) {
            if(riddle != null) {
                System.out.println("\uD83D\uDEAA You just entered a dungeon. You can't go back, until you solved this riddle.");
                riddle.answerPrompt(this);
            }
            if(enemy != null) {
                CombatCommand combatCommand = new CombatCommand();
                System.out.println("\uD83D\uDEAA You just entered a dungeon. You can't go back, until you defeated this enemy.");
                combatCommand.combat(player, enemy, true);
            }
            else {
                System.out.println("This dungeon has neither a riddle nor enemies!");
            }
        }
        // TODO: Auswahl zwischen Herzkammern und Ausdauerkammern
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


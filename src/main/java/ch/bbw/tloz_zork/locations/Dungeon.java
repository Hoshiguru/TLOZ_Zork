package ch.bbw.tloz_zork.locations;

import ch.bbw.tloz_zork.cmds.CombatCommand;
import ch.bbw.tloz_zork.enemies.Enemy;
import ch.bbw.tloz_zork.game.Player;
import ch.bbw.tloz_zork.riddles.Riddle;

import java.util.Scanner;

public class Dungeon extends Location {
    private boolean isCompleted;
    private Riddle riddle;
    private Enemy enemy;

    public Dungeon(String name, String icon, String quote, String assignedMap, boolean isCompleted, Riddle riddle) {
        super(name, icon, quote, assignedMap);
        this.isCompleted = isCompleted;
        this.riddle = riddle;
    }

    public Dungeon(String name, String icon, String quote, String assignedMap, boolean isCompleted, Enemy enemy) {
        super(name, icon, quote, assignedMap);
        this.isCompleted = isCompleted;
        this.enemy = enemy;
    }

    /**
     * Starts the challenge of the dungeon
     */
    public void startChallenge(Player player){
        if (!isCompleted) {
            if(riddle != null) {
                System.out.println("\uD83D\uDEAA You just entered a dungeon. You can't go back, until you solved this riddle.");
                riddle.answerPrompt(this);
            } else if(enemy != null) {
                CombatCommand combatCommand = new CombatCommand();
                System.out.println("\uD83D\uDEAA You just entered a dungeon. You can't go back, until you defeated this enemy.");
                combatCommand.combat(player, enemy, true);
            } else {
                System.out.println("This dungeon has neither a riddle nor enemies!");
            }
            selectReward(player);
        }
        else {
            System.out.println("✅ You have already completed this dungeon and collected your rewards! Search for another one.");
        }
    }
    private void selectReward(Player player) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Select your reward: ");
        System.out.println("Please choose between ❤'heart' or \uD83D\uDD25'stamina'");
        System.out.print("》 ");
        String choice = scan.nextLine().toLowerCase();
        while(!(choice.equals("heart") || choice.equals("stamina"))){
            System.out.println("Invalid choice, please choose between 'heart' or 'stamina'");
            System.out.print("》 ");
            choice = scan.nextLine().toLowerCase();
        }
        switch (choice) {
            case "heart" -> {
                player.increaseMaxHearts();
                player.setHearts(player.getMaxHearts()); // After getting a heart container, the player will get full hearts
                System.out.println("You got a heart container! Now you have " + player.getMaxHearts() + " hearts.");
            }
            case "stamina" -> {
                player.increaseMaxStamina();
                player.setStamina(player.getMaxStamina()); // After getting a stamina container, the player will get full stamina
                System.out.println("You got a stamina container! Now you have " + player.getMaxStamina() + " stamina.");
            }
        }
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

}


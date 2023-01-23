package ch.bbw.tloz_zork.game;

import ch.bbw.tloz_zork.enemies.Enemy;
import ch.bbw.tloz_zork.game.Player;
import ch.bbw.tloz_zork.items.Item;

import java.util.ArrayList;
import java.util.Scanner;

public class CombatTutorial {
    ArrayList<Item> itemArrayList = new ArrayList<Item>();
    Player player = new Player(3, 1, 5, itemArrayList, 20.0, null);
    Item sword = new Item("Iron Sword", "A melee weapon used to defeat enemies and hit close targets.", 1.8, "⚔️");
    Enemy dummy = new Enemy("dummy", 1, 1, 2147483647, sword);
    Scanner command = new Scanner(System.in);

    public void dummyTutorial() {
        boolean contin = false;
        System.out.println("Then let's start with a quick tutorial on the combat system");
        System.out.println("You currently have " + player.getHearts() + " hearts");
        System.out.println("If you get to 0 hearts, you will lose the fight and have to start from the last checkpoint");
        System.out.println("this is the dummy");
        System.out.println(" ____________________________________________");
        System.out.println("| " + dummy.getName() + " | hearts: " + dummy.getHealth() + " | damage: " + dummy.getAp() + " | " + dummy.getItem().getName() + " |");
        System.out.println(" ____________________________________________");
        System.out.println("To win the fight, you have to get the dummy's health to 0");
        System.out.println("Press enter to continue");
        System.out.print("> ");
        command.nextLine();
        System.out.println("WATCH OUT! THE DUMMY IS GOING TO ATTACK YOU");
        System.out.println("Type in \"dodge\" to dodge the attack");

        while (!contin) {
            System.out.println(" _____________________________________________");
            System.out.println("| " + dummy.getName() + "  | hearts: " + dummy.getHealth() + " | damage: " + dummy.getAp() + " | " + dummy.getItem().getName() + " |");
            System.out.println("| player | hearts: " + player.getHearts() + " | damage: " + player.getAp() + " | stamina: " + player.getStamina() + " |");
            System.out.println(" _____________________________________________");
            System.out.print("> ");
            switch (command.nextLine().toLowerCase()) {
                case "dodge":
                    player.setStamina(player.getStamina() - 1);
                    System.out.println("Good job!");
                    contin = true;
                    break;
                default:
                    System.out.println("you have to defend yourself! try again");
            }
        }
        contin = false;
        System.out.println("Friendly reminder that you only have a certain amount of stamina to dodge!");
        System.out.println("Press enter to continue");
        System.out.print("> ");
        command.nextLine();
        System.out.println("Now you want to attack the dummy to win the fight");
        System.out.println("So please type in \"attack\" to attack the dummy");
        while (!contin) {
            System.out.println(" ____________________________________________");
            System.out.println("| " + dummy.getName() + "  | hearts: " + dummy.getHealth() + " | damage: " + dummy.getAp() + " | " + dummy.getItem().getName() + " |");
            System.out.println("| player | hearts: " + player.getHearts() + " | damage: " + player.getAp() + " | stamina: " + player.getStamina() + " |");
            System.out.println(" ____________________________________________");
            System.out.print("> ");
            switch (command.nextLine().toLowerCase()) {
                case "attack":
                    dummy.setHealth(dummy.getHealth() - 1);
                    System.out.println("Now you have dealt 1 damage to the dummy.");
                    System.out.println("If you have any items, you can deal more damage.");
                    System.out.println("Press enter to continue");
                    System.out.print("> ");
                    contin = true;
                    break;
                case "dodge":
                    System.out.println("He's not attacking you, so you don't have to dodge");
                    break;
                default:
                    System.out.println("you have to attack! try again");
            }
        }
        command.nextLine();
        System.out.println(" _____________________________________________");
        System.out.println("| " + dummy.getName() + "  | hearts: " + dummy.getHealth() + " | damage: " + dummy.getAp() + " | " + dummy.getItem().getName() + " |");
        System.out.println("| player | hearts: " + player.getHearts() + " | damage: " + player.getAp() + " | stamina: " + player.getStamina() + " |");
        System.out.println(" _____________________________________________");
        System.out.println("As you can see, the dummy has " + dummy.getHealth() + " hearts now.");
        System.out.println("The dummy also dropped an item");
        System.out.println("Type \"collect\" to collect the item");
        System.out.print("> ");
        switch (command.nextLine().toLowerCase()) {
            case "collect":
                System.out.println("You have collected " + dummy.getItem().getName() + "!");
                itemArrayList.add(dummy.getItem());
                break;
            case "attack":
                System.out.println("You are out of combat");
                break;
            case "dodge":
                System.out.println("You are out of combat");
                break;
            default:
                System.out.println("Collect the item before you continue");
        }
        System.out.println("You have defeated the dummy and completed the Tutorial!");
        System.out.println("Your adventure may start now!");
    }
}

package ch.bbw.tloz_zork.cmds;

import ch.bbw.tloz_zork.enemies.Enemy;
import ch.bbw.tloz_zork.game.Player;
import ch.bbw.tloz_zork.items.Item;

import java.util.ArrayList;
import java.util.Scanner;

public class CombatCommand {
    boolean contin = false;
    Scanner scan = new Scanner(System.in);

    public void combat(Player player, Enemy enemy) {
        ArrayList<Item> inventory = player.getInventory();
        System.out.println("You have decided to fight a " + enemy.getName() + "!");
        while (enemy.getHealth() > 0) {
            System.out.println("| " + enemy.getName() + " | hearts: " + enemy.getHealth() + " | damage: " + enemy.getAp() + " | " + enemy.getItem().getName() + " |");
            System.out.println("| Player | hearts: " + player.getHearts() + " | damage: " + player.getAp() + " | stamina: " + player.getStamina() + " |");
            System.out.println();
            while (!contin) {
                System.out.print("》 ");
                switch (scan.nextLine().toLowerCase()) {
                    case "attack", "a" -> {
                        System.out.println("The enemy gets -" + player.getAp() + " hearts");
                        enemy.setHealth(enemy.getHealth() - player.getAp());
                        contin = true;
                    }
                    case "item", "i" -> {
                        if (inventory.size() == 0) {
                            System.out.println("\uD83D\uDCBC Your inventory is empty.");
                        } else {
                            System.out.println("\uD83D\uDCBC Your inventory contains:");
                            for (Item item : inventory) {
                                System.out.println("〉" + item.getIcon() + item.getName() + " - " + item.getDescription() + " 【" + item.getWeight() + " kg】");
                            }
                        }
                    }
                    case "flee", "f" -> {
                        System.out.println("You escaped");
                        return;
                    }
                    case "help", "h" -> {
                        System.out.println("'Attack' to attack the enemy");
                        System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
                        System.out.println("'Item' to open your Inventory");
                        System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
                        System.out.println("'flee' to flee");
                    }
                    default -> System.out.println("Unknown Command. Try to use help, to see all commands.");
                }

            }
            contin = false;
            if (enemy.getHealth() > 0) {
                System.out.println(enemy.getName() + " wants to attack you");
                System.out.println("do you want to dodge?");
                System.out.print("》 ");
                while (!contin) {
                    switch (scan.nextLine().toLowerCase()) {
                        case "yes" -> {
                            player.setStamina(player.getStamina() - 1);
                            System.out.println("You dodged the attack");
                            contin = true;
                        }
                        case "no" -> {
                            player.setHearts(player.getHearts() - enemy.getAp());
                            System.out.println("You get -" + enemy.getAp() + " hearts");
                            contin = true;
                        }
                        default -> System.out.println("I need a yes or a no");
                    }
                }
            }
            contin = false;
        }

        System.out.println("You have received a " + enemy.getItem().getIcon() + enemy.getItem().getName());
        inventory.add(enemy.getItem());
        player.setInventory(inventory);
        enemy.setIsDead(true);
    }
}

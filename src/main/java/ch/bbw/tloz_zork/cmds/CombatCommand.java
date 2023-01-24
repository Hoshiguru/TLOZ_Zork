package ch.bbw.tloz_zork.cmds;

import ch.bbw.tloz_zork.enemies.Enemy;
import ch.bbw.tloz_zork.game.Player;
import ch.bbw.tloz_zork.items.Item;

import java.util.ArrayList;
import java.util.Scanner;

public class CombatCommand {
    boolean contin = false;
    Scanner scan = new Scanner(System.in);

    public void combat(Player player, Enemy enemy, boolean isInDungeon) {
        // New Array List to add enemies Item if defeated
        ArrayList<Item> inventory = player.getInventory();
        System.out.println("You have decided to fight a " + enemy.getName() + "!");
        // This while goes so long, until the enemies health goes to 0
        while (enemy.getHealth() > 0 && player.getHearts() > 0) {
            System.out.println("| " + enemy.getName() + " | hearts: " + enemy.getHealth() + " | damage: " + enemy.getAp() + " | " + enemy.getItem().getName() + " |");
            System.out.println("| Player | hearts: " + player.getHearts() + " | damage: " + player.getAp() + " | stamina: " + player.getStamina() + " |");
            System.out.println();
            // Loop
            while (!contin) {
                System.out.print("》 ");
                switch (scan.next().toLowerCase()) {
                    // Enemy health = enemy health - player ap
                    case "attack", "a" -> {
                        System.out.println("The enemy gets -" + player.getAp() + " hearts");
                        enemy.setHealth(enemy.getHealth() - player.getAp());
                        contin = true;
                    }
                    // Show inventory
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
                    case "eat", "e" -> {
                        System.out.println("What do you want to eat?");
                        System.out.print("》 ");
                        String item = scan.next().toLowerCase();
                        player.eatItem(item);
                        break;
                    }

                    // End the Method
                    case "flee", "f" -> {
                        if (isInDungeon) {
                            System.out.println("You can't flee from a dungeon!");
                        } else {
                            System.out.println("You escaped");
                            return;
                        }
                    }
                    // Help
                    case "help", "h" -> {
                        System.out.println("'Attack' to attack the enemy");
                        System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
                        System.out.println("'Item' to open your Inventory");
                        System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
                        System.out.println("'Eat' to heal with an item from your inventory");
                        if (!isInDungeon) {
                            System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
                            System.out.println("'Flee' to flee");
                        }
                    }
                    default -> System.out.println("Unknown Command. Try to use 'help', to see all commands.");
                }

            }
            //Set back to false so you can loop again
            contin = false;
            if (enemy.getHealth() > 0) {
                System.out.println(enemy.getName() + " wants to attack you");
                if (player.getStamina() > 0) {
                    System.out.println("do you want to dodge?");
                    System.out.print("》 ");
                    // Loop
                    while (!contin) {
                        switch (scan.next().toLowerCase()) {
                            // PLayer stamina = player stamina - 1
                            case "yes", "y", "dodge" -> {
                                player.setStamina(player.getStamina() - 1);
                                System.out.println("You dodged the attack");
                                contin = true;
                                break;
                            }
                            // Player health = player health - enemy ap
                            case "no", "n" -> {
                                player.setHearts(player.getHearts() - enemy.getAp());
                                System.out.println("You get -" + enemy.getAp() + " hearts");
                                contin = true;
                                break;
                            }
                            default -> System.out.println("I need a yes or a no");
                        }
                    }
                } else {
                    System.out.println("You dont have any stamina left.");
                    player.setHearts(player.getHearts() - enemy.getAp());
                    System.out.println("You get -" + enemy.getAp() + " hearts");
                }

            }
            contin = false;
        }
        if(player.getHearts() <= 0){
            player.setDead(true);
        } else {
            // Add enemy Item to your inventory
            System.out.println("\uD83D\uDDE1 You have defeated the " + enemy.getName() + "!");
            System.out.println("You have received a " + enemy.getItem().getIcon() + enemy.getItem().getName());
            inventory.add(enemy.getItem());
            player.setInventory(inventory);
            enemy.setIsDead(true);
        }
    }
}

package ch.bbw.tloz_zork.cmds;

import ch.bbw.tloz_zork.enemies.BossEnemy;
import ch.bbw.tloz_zork.enemies.Enemy;
import ch.bbw.tloz_zork.game.Player;
import ch.bbw.tloz_zork.game.output.BattleCard;
import ch.bbw.tloz_zork.items.HealingItem;
import ch.bbw.tloz_zork.items.Item;
import ch.bbw.tloz_zork.items.WeaponItem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The CombatCommand class is used to start a combat
 * @author Andy Lam
 */
public class CombatCommand {
    boolean contin = false;
    Scanner scan = new Scanner(System.in);

    /**
     * This method is used to start a combat
     * @param player
     * @param enemy
     * @param isInDungeon
     */
    public void combat(Player player, Enemy enemy, boolean isInDungeon) {
        // New Array List to add enemies Item if defeated
        ArrayList<Item> inventory = player.getInventory();
        BattleCard battleCard = new BattleCard();

        if (!enemy.getIsDead()) {
            System.out.println("You have decided to fight a " + enemy.getName() + "!");
            // This while goes so long, until the enemies health goes to 0
            while (enemy.getHealth() > 0 && player.getHearts() > 0) {
                if (enemy instanceof BossEnemy) {
                    if (((BossEnemy) enemy).getPhase() == 1 && enemy.getHealth() < 15) {
                        ((BossEnemy) enemy).switchPhase();
                        System.out.println(enemy.getName() + " is getting angry! He now has a " + ((BossEnemy) enemy).getWeaponInHand().getName() + "【 +" + ((BossEnemy) enemy).getWeaponInHand().getDamage() + "\uD83D\uDCA5】" + " in hand!");
                    }
                    if (((BossEnemy) enemy).getPhase() == 2 && enemy.getHealth() < 10) {
                        ((BossEnemy) enemy).switchPhase();
                        System.out.println(enemy.getName() + " is getting angrier! He now has a " + ((BossEnemy) enemy).getWeaponInHand().getName() + "【 +" + ((BossEnemy) enemy).getWeaponInHand().getDamage() + "\uD83D\uDCA5】" + " in hand!");
                    }
                    battleCard.printBattleCard(player.getWeaponInHand().getName(), player.getFullAp(), player.getHeartIcons(), player.getStaminaIcons(),enemy.getName(), ((BossEnemy) enemy).getItem().getName(), enemy.getAp(), enemy.getHeartIcons());
                } else {
                    if(player.getWeaponInHand() != null)
                        battleCard.printBattleCard(player.getWeaponInHand().getName(), player.getFullAp(), player.getHeartIcons(), player.getStaminaIcons(), enemy.getName(), enemy.getItem().getName(), enemy.getAp(), enemy.getHeartIcons());
                    else
                        battleCard.printBattleCard("Fists", player.getFullAp(), player.getHeartIcons(), player.getStaminaIcons(), enemy.getName(), enemy.getItem().getName(), enemy.getAp(), enemy.getHeartIcons());
                }

                // Loop
                while (!contin) {
                    System.out.print("》 ");
                    switch (scan.next().toLowerCase()) {
                        // Enemy health = enemy health - player ap
                        case "attack", "a" -> {
                            System.out.println("The enemy gets -" + player.getFullAp() + " hearts");
                            enemy.setHealth(enemy.getHealth() - player.getFullAp());
                            contin = true;
                        }
                        // Show inventory
                        case "item", "i" -> {
                            if (inventory.size() == 0) {
                                System.out.println("\uD83D\uDCBC Your inventory is empty.");
                            } else {
                                System.out.println("\uD83D\uDCBC Your inventory contains:");
                                for (Item item : inventory) {
                                    if(item instanceof HealingItem){
                                        System.out.println("〉" + item.getIcon() + item.getName() + " - " + item.getDescription() + " 【+" + ((HealingItem) item).getHealingAmount() + "♥】");
                                    } else if (item instanceof WeaponItem) {
                                        System.out.println("〉" + item.getIcon() + item.getName() + " - " + item.getDescription() + " 【 +" + ((WeaponItem) item).getDamage() + "\uD83D\uDCA5】");
                                    } else {
                                        System.out.println("〉" + item.getIcon() + item.getName() + " - " + item.getDescription());
                                    }                            }
                            }
                        }
                        case "eat", "e" -> {
                            System.out.println("What do you want to eat?");
                            System.out.print("》 ");
                            String item = scan.next().toLowerCase();
                            player.eatItem(item);
                            break;
                        }
                        case "use", "u" -> {
                            System.out.println("What weapon do you want to equip?");
                            System.out.print("》 ");
                            String weapon = scan.next().toLowerCase();
                            player.useWeapon(weapon);
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
                            System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
                            System.out.println("'Use' to equip a weapon from your inventory");
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
                                    System.out.println("You dodged the attack (" + player.getStaminaIcons() + ")");
                                    contin = true;
                                    break;
                                }
                                // Player health = player health - enemy ap
                                case "no", "n" -> {
                                    player.setHearts(player.getHearts() - enemy.getAp());
                                    System.out.println("You get -" + enemy.getAp() + " hearts (" + player.getHeartIcons() + ")");
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
                if (enemy instanceof BossEnemy) {
                    System.out.println("\uD83D\uDDE1 You have defeated "+ enemy.getName() +" !");
                    enemy.setIsDead(true);
                    player.setHasWon(true);
                    return;
                }
                // Add enemy Item to your inventory
                System.out.println("\uD83D\uDDE1 You have defeated the " + enemy.getName() + "!");
                System.out.println("You have received a " + enemy.getItem().getIcon() + enemy.getItem().getName());
                inventory.add(enemy.getItem());
                player.setInventory(inventory);
                enemy.setIsDead(true);
                player.increaseKills();
            }
        } else {
            System.out.println("You already defeated " + enemy.getName() + "!");
        }

    }
}

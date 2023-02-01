package ch.bbw.tloz_zork.cmds;


import ch.bbw.tloz_zork.game.Player;
import ch.bbw.tloz_zork.items.HealingItem;
import ch.bbw.tloz_zork.items.Item;
import ch.bbw.tloz_zork.items.WeaponItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ItemCommands {
    /** With this method, the player can view his inventory. *
     * @param player
     */
    public void inventory(Player player) {
        double inventoryWeight = player.getInventoryWeight();
        ArrayList<Item> inventory = player.getInventory();
        if (inventory.size() == 0) {
            System.out.println("\uD83D\uDCBC Your inventory is empty.");
        } else {
            if (player.getWeaponInHand() != null) {
                System.out.println("✋ You are holding: " + player.getWeaponInHand().getName() + " +" + player.getWeaponInHand().getDamage() + "\uD83D\uDCA5");
            } else {
                System.out.println("\uD83D\uDCA1 Equip a weapon with 'use <weapon>'.");
            }
            System.out.println("⚖ Weight: " + inventoryWeight + " kg / " + player.getMaxWeight() + " kg");
            System.out.println("\uD83D\uDCBC Your inventory contains:");

            Map<String, Integer> itemCounts = new HashMap<>();
            for (Item item : inventory) {
                itemCounts.put(item.getName(), itemCounts.getOrDefault(item.getName(), 0) + 1);
            }

            for (Map.Entry<String, Integer> entry : itemCounts.entrySet()) {
                String name = entry.getKey();
                int count = entry.getValue();
                Item sampleItem = null;
                for (Item item : inventory) {
                    if (item.getName().equals(name)) {
                        sampleItem = item;
                        break;
                    }
                }
                if (sampleItem instanceof HealingItem) {
                    System.out.println("〉" + count + "x " + sampleItem.getIcon() + sampleItem.getName() + " - " + sampleItem.getDescription() + " 【⚖" + sampleItem.getWeight() + " kg | +" + ((HealingItem) sampleItem).getHealingAmount() + "♥】");
                } else if (sampleItem instanceof WeaponItem) {
                    System.out.println("〉" + count + "x " + sampleItem.getIcon() + sampleItem.getName() + " - " + sampleItem.getDescription() + " 【⚖" + sampleItem.getWeight() + " kg | +" + ((WeaponItem) sampleItem).getDamage() + "\uD83D\uDCA5】");
                } else {
                    System.out.println("〉" + count + "x " + sampleItem.getIcon() + sampleItem.getName() + " - " + sampleItem.getDescription() + " 【⚖" + sampleItem.getWeight() + " kg】");
                }
            }
        }
    }

    /**
     * This method is used to collect an item from the current location.
     *
     * @param player
     */
    public void grab(Player player) {
        ArrayList<Item> roomItems = player.getCurrentLocation().getItems();
        ArrayList<Item> playerItems = player.getInventory();
        double inventoryWeight = player.getInventoryWeight();
        if (roomItems.size() == 0) {
            System.out.println("❌ There is nothing to grab here.");
        }
        else if (roomItems.size() == 1 && !roomItems.isEmpty()){
            if (inventoryWeight + roomItems.get(0).getWeight() <= player.getMaxWeight()) {
                Item item = roomItems.get(0);
                playerItems.add(item);
                roomItems.remove(item);
                System.out.println("You grab the " + item.getIcon() + item.getName() + ".");
            } else {
                System.out.println("❌ You can't carry any more items.");
            }
        } else if (roomItems.size() > 1) {
            System.out.println("You grab the following items:");
            for (int i = 0; i < roomItems.size(); i++) {
                Item item = roomItems.get(i);
                if (inventoryWeight + item.getWeight() <= player.getMaxWeight()) {
                    playerItems.add(item);
                    System.out.println("〉" + item.getIcon() + item.getName() + " - " + item.getDescription() + " 【" + item.getWeight() + " kg】");
                    inventoryWeight += item.getWeight();
                } else {
                    System.out.println("❌ You can't carry any more items.");
                    break;
                }
            }
            for (Item item : playerItems) {
                roomItems.remove(item);
            }
        }
        else {
            System.out.println("There was an error during picking up the item.");
        }
    }
    /**
     * This method is used to collect a specific item from the current location.
     * @param player
     * @param itemName
     */
    public void eat(Player player, String itemName) {
        Item item = player.findItem(itemName);
        if (item != null) {
            player.eatItem(itemName);
        } else {
            System.out.println("❌ You don't have this item in your inventory.");
        }
    }
    public void use(Player player, String itemName) {
        Item item = player.findItem(itemName);
        if (item != null) {
            player.useWeapon(itemName);
        } else {
            System.out.println("❌ You don't have this item in your inventory.");
        }
    }
    /**
     * This method is used to drop a specific item from the current location.
     * @param player
     * @param itemName
     */
    public void drop(Player player, String itemName) {
        Item item = player.findItem(itemName);
        ArrayList<Item> roomItems = player.getCurrentLocation().getItems();
        if (item != null) {
            player.removeItem(item);
            roomItems.add(item);
            System.out.println("\uD83D\uDCA8 You dropped the " + item.getName() + ".");
        } else {
            System.out.println("❌ You don't have this item in your inventory.");
        }
    }
}

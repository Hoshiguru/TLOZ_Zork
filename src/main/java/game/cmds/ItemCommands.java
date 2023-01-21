package game.cmds;

import game.Item;
import game.Player;

import java.util.ArrayList;

public class ItemCommands {
    /** With this method, the player can view his inventory. *
     * @param player
     */
    public void inventory(Player player){
        double inventoryWeight = player.getInventoryWeight();
        ArrayList<Item> inventory = player.getInventory();
        if (inventory.size() == 0) {
            System.out.println("\uD83D\uDCBC Your inventory is empty.");
        } else {
            System.out.println("⚖ Weight: " + inventoryWeight + " kg / " + player.getMaxWeight() + " kg");
            System.out.println("\uD83D\uDCBC Your inventory contains:");

            for (Item item : inventory) {
                System.out.println("〉" + item.getIcon() + item.getName() + " - " + item.getDescription() + " 【" + item.getWeight() + " kg】");
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
    public void drop(Player player, String itemName) {
        Item item = player.findItem(itemName);
        if (item != null) {
            player.removeItem(item);
            System.out.println("\uD83D\uDCA8 You dropped the " + item.getName() + ".");
        } else {
            System.out.println("❌ You don't have this item in your inventory.");
        }
    }
}

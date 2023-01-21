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
                System.out.println(item.getName() + " - " + item.getDescription() + " 【" + item.getWeight() + " kg】");
            }
        }
    }
    /**
     * This method is used to collect an item from the current location.
     *
     * @param player
     */
    // TODO: Bei zu hohem Gewicht, Items nicht mehr aufnehmbar machen
    public void grab(Player player) {
        ArrayList<Item> roomItems = player.getCurrentLocation().getItems();
        ArrayList<Item> playerItems = player.getInventory();
        double inventoryWeight = player.getInventoryWeight();
        if (roomItems.size() == 0) {
            System.out.println("❌ There is nothing to grab here.");
        }
        else if (roomItems.size() == 1){
            System.out.println("You grab the " + roomItems.get(0).getIcon() + roomItems.get(0).getName() + ".");
            playerItems.add(roomItems.get(0));
        }
        else if (roomItems.size() > 1) {
            System.out.println("You grab the following items:");
            for (Item item : roomItems) {
                System.out.println(item.getIcon() + item.getName());
                playerItems.add(item);
            }
            roomItems.clear();
        } else {
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

package game.cmds;

import game.Item;
import game.Player;

import java.util.ArrayList;

public class ItemCommands {
    /**
     * This method is used to collect an item from the current location.
     *
     * @param player
     */
    public void grab(Player player) {
        ArrayList<Item> roomItems = player.getCurrentLocation().getItems();
        ArrayList<Item> playerItems = player.getInventory();
        System.out.println(player.getCurrentLocation());
        System.out.println(player.getCurrentLocation().getItems());
        if (roomItems.size() == 0) {
            System.out.println("There is nothing to grab here.");
        }
        else if (roomItems.size() == 1){
            System.out.println("You grab the " + roomItems.get(0).getName() + ".");
            playerItems.add(roomItems.get(0));
        }
        else if (roomItems.size() > 1) {
            System.out.println("You grab the following items:");
            for (Item item : roomItems) {
                System.out.println(item.getName());
                playerItems.add(item);
            }
            roomItems.clear();
        } else {
            System.out.println("There was an error during picking up the item.");
        }
    }
}

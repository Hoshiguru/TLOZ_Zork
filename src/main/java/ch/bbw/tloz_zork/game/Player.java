package ch.bbw.tloz_zork.game;

import ch.bbw.tloz_zork.items.Item;
import ch.bbw.tloz_zork.locations.Location;

import java.util.ArrayList;

public class Player {
    private int hearts;
    private ArrayList<Item> inventory;
    private double maxWeight; // Maximale Tragkraft von Items
    private Location currentLocation;
    private Location previousLocation;

    public Player(int hearts, ArrayList<Item> inventory, double maxWeight, Location currentLocation) {
        this.hearts = hearts;
        this.inventory = new ArrayList<Item>();
        this.maxWeight = maxWeight;
        this.currentLocation = currentLocation;
        this.previousLocation = null;
    }
    /**
     * Adds an item to the inventory
     * @param item
     */
    public void addItem(Item item) {
        inventory.add(item);
    }
    public void removeItem(Item item) {
        inventory.remove(item);
    }
    /**
     * Returns the item with the given name
     * @param itemName
     * @return
     */
    public Item findItem(String itemName) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }
    /**
     * Returns the weight of all items in the inventory
     * @return
     */
    public double getInventoryWeight() {
        double inventoryWeight = 0;
        for (Item item : inventory) {
            inventoryWeight += item.getWeight();
        }
        return inventoryWeight;
    }


    public int getHearts() {
        return hearts;
    }

    public void setHearts(int hearts) {
        this.hearts = hearts;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Location getPreviousLocation() {
        return previousLocation;
    }

    public void setPreviousLocation(Location previousLocation) {
        this.previousLocation = previousLocation;
    }
}

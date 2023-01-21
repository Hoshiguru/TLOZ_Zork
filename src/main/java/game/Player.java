package game;

import java.util.ArrayList;

public class Player {
    private int hearts; // 10
    private ArrayList<Item> inventory;
    private double maxWeight; // Maximale Tragkraft von Items
    private Location currentLocation;

    public Player(int hearts, ArrayList<Item> inventory, double maxWeight, Location currentLocationName) {
        this.hearts = hearts;
        this.inventory = inventory;
        this.maxWeight = maxWeight;
        this.currentLocation = currentLocation;
    }

    public void addItem(Item item) {
        inventory.add(item);
    }
    // TODO: Muss noch getestet werden, eventuell mit Iterator lösen
    public void removeItem(Item item) {
        inventory.remove(item);
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
}

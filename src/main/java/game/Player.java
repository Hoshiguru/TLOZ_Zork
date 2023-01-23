package game;

import game.Item;
import game.Location;

import java.util.ArrayList;

public class Player {
    private int hearts; // 10
    private int ap;
    private int stamina;
    private ArrayList<Item> inventory;
    private double maxWeight; // Maximale Tragkraft von Items
    private Location currentLocation;

    public Player(int hearts, int ap, int stamina, ArrayList<Item> inventory, double maxWeight, Location currentLocation) {
        this.hearts = hearts;
        this.ap = ap;
        this.stamina = stamina;
        this.inventory = inventory;
        this.maxWeight = maxWeight;
        this.currentLocation = currentLocation;
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

    public int getAp() {
        return ap;
    }

    public void setAp(int ap) {
        this.ap = ap;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }
}

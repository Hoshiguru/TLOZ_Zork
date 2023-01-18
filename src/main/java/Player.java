import java.util.ArrayList;

public class Player {
    private int hearts; // 10
    private ArrayList<Item> inventory;
    private double maxWeight; // Maximale Tragkraft von Items
    private String currentLocationName;

    public Player(int hearts, ArrayList<Item> inventory, double maxWeight, String currentLocationName) {
        this.hearts = hearts;
        this.inventory = inventory;
        this.maxWeight = maxWeight;
        this.currentLocationName = currentLocationName;
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

    public String getCurrentLocationName() {
        return currentLocationName;
    }

    public void setCurrentLocationName(String currentLocationName) {
        this.currentLocationName = currentLocationName;
    }
}

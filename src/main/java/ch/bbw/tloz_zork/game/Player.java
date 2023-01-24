package ch.bbw.tloz_zork.game;

import ch.bbw.tloz_zork.items.HealingItem;
import ch.bbw.tloz_zork.items.Item;
import ch.bbw.tloz_zork.items.WeaponItem;
import ch.bbw.tloz_zork.locations.Location;

import java.util.ArrayList;
import java.util.Iterator;

public class Player {
    private int hearts;
    private int maxHearts;
    private int ap;
    private int stamina;
    private int maxStamina;
    private ArrayList<Item> inventory;
    private WeaponItem weaponInHand; // Weapon which is currently in the players hand
    private double maxWeight; // Maximale Tragkraft von Items
    private Location currentLocation;
    private Location previousLocation;
    private int moves;
    private boolean dead;

    public Player(int hearts, int maxHearts, int ap, int stamina, int maxStagima, ArrayList<Item> inventory, double maxWeight, Location currentLocation, boolean dead) {
        this.hearts = hearts;
        this.maxHearts = maxHearts;
        this.ap = ap;
        this.stamina = stamina;
        this.maxStamina = maxStagima;
        this.inventory = new ArrayList<Item>();
        this.maxWeight = maxWeight;
        this.currentLocation = currentLocation;
        this.weaponInHand = null;
        this.previousLocation = null;
        this.moves = 0;
        this.dead=dead;
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
     * Returns the item with the given name and removes it from the inventory
     * @param itemName
     * @return
     */
    public HealingItem eatItem(String itemName) {
        Iterator<Item> iterator = inventory.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (item.getName().equalsIgnoreCase(itemName) && item instanceof HealingItem) {
                HealingItem healingItem = (HealingItem) item;
                if (hearts + healingItem.getHealingAmount() > maxHearts) {
                    hearts = maxHearts;
                    System.out.println("Your hearts are full!");
                } else {
                    iterator.remove();
                    hearts += healingItem.getHealingAmount();
                    System.out.println("You ate " + healingItem.getIcon() + healingItem.getName() + " 【+" + healingItem.getHealingAmount() + "♥】");
                }
            }
            else if (item.getName().equalsIgnoreCase(itemName) && !(item instanceof HealingItem)) {
                System.out.println("You can't eat that!");
            }
        }
        return null;
    }

    public WeaponItem useWeapon(String weaponName) {
        Iterator<Item> iterator = inventory.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (item.getName().equalsIgnoreCase(weaponName) && item instanceof WeaponItem) {
                WeaponItem weaponItem = (WeaponItem) item;
                if (weaponInHand != null) {
                    System.out.println("You unequipped " + weaponInHand.getIcon() + weaponInHand.getName());
                }
                weaponInHand = weaponItem;
                iterator.remove();
                System.out.println("You equipped " + weaponItem.getIcon() + weaponItem.getName());
            }
            else if (item.getName().equalsIgnoreCase(weaponName) && !(item instanceof WeaponItem)) {
                System.out.println("You can't use that! Try it with a weapon!");
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
    public String getHeartIcons() {
        String hearts = "";
        for (int i = 0; i < this.maxHearts; i++) {
            if (i < this.hearts) {
                hearts += "♥";
            } else {
                hearts += "♡";
            }
        }
        return hearts;
    }
    public String getStaminaIcons() {
        String stamina = "";
        for (int i = 0; i < this.maxStamina; i++) {
            if (i < this.stamina) {
                stamina += "\uD83D\uDD25";
            } else {
                stamina += "\uD83D\uDD26";
            }
        }
        return stamina;
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

    public int getMoves() {
        return moves;
    }

    public void increaseMoves() {
        this.moves = moves + 1;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean playerIsDead) {
        this.dead = playerIsDead;
    }

    public int getMaxHearts() {
        return maxHearts;
    }

    public void increaseMaxHearts() {
        this.maxHearts = maxHearts + 1;
    }

    public int getMaxStamina() {
        return maxStamina;
    }

    public void increaseMaxStamina() {
        this.maxStamina = maxStamina + 1;
    }

    public WeaponItem getWeaponInHand() {
        return weaponInHand;
    }


}

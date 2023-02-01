package ch.bbw.tloz_zork.locations;

import ch.bbw.tloz_zork.enemies.Enemy;
import ch.bbw.tloz_zork.game.Gate;
import ch.bbw.tloz_zork.items.Item;

import java.util.ArrayList;
import java.util.HashMap;

// same as "Room"
public class Location {
    private String name;
    private String quote; // e.g. Is it cold or dark?
    private ArrayList<Item> items; // loot, which you can collect with the command collect
    private String assignedMap;
    private HashMap<String, Gate> directions; // Pattern (north, east, south, west) every game.Location could have 4 Gates, which are the directions you can go to
    private String icon;
    private Enemy enemy;

    // Constructor to init the game.Location
    public Location(String name, String icon, String quote, String assignedMap, Enemy enemy, ArrayList<Item> items) {
        this.name = name;
        this.icon = icon;
        this.quote = quote;
        this.assignedMap = assignedMap;
        this.enemy = enemy;
        this.items = new ArrayList<Item>();
    }
    public Location(String name, String icon, String quote, String assignedMap, Enemy enemy) {
        this.name = name;
        this.icon = icon;
        this.quote = quote;
        this.assignedMap = assignedMap;
        this.enemy = enemy;
        this.items = new ArrayList<Item>();
    }

    public Location(String name, String icon, String quote, String assignedMap, ArrayList<Item> items) {
        this.name = name;
        this.icon = icon;
        this.quote = quote;
        this.items = new ArrayList<Item>();
        this.assignedMap = assignedMap;
        this.directions = new HashMap<>();
    }

    public Location(String name, String icon, String quote, String assignedMap) {
        this.name = name;
        this.icon = icon;
        this.quote = quote;
        this.items = new ArrayList<Item>();
        this.assignedMap = assignedMap;
        this.directions = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * @param item
     * @return true if item was added
     */
    public void addItem(Item item) {
        items.add(item);
    }
    public void removeItem(Item item) {
        items.remove(item);
    }
    /**
     * @param itemName
     * @return item if exists
     */
    public Item findItem(String itemName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    public String getAssignedMap() {
        return assignedMap;
    }

    public void setAssignedMap(String assignedMap) {
        this.assignedMap = assignedMap;
    }

    public HashMap<String, Gate> getDirections() {
        return directions;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    /** Sets the directions of the Location
     * @param north
     * @param east
     * @param south
     * @param west
     */
    public void setDirections(Gate north, Gate east, Gate south, Gate west) {
        if (directions == null)
            directions = new HashMap<String, Gate>();
        directions.put("north", north);
        directions.put("east", east);
        directions.put("south", south);
        directions.put("west", west);
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }
}

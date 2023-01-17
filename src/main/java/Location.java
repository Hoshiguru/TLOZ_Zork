import java.lang.reflect.Array;
import java.util.ArrayList;

// same as "Room"
public class Location {
    private String name;
    private String quote; // e.g. Is it cold or dark?
    private ArrayList<Item> items; // loot, which you can collect with the command collect
    private String assignedMap;


    public Location(String name, String quote, ArrayList<Item> items, String assignedMap) {
        this.name = name;
        this.quote = quote;
        this.items = items;
        this.assignedMap = assignedMap;
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

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public String getAssignedMap() {
        return assignedMap;
    }

    public void setAssignedMap(String assignedMap) {
        this.assignedMap = assignedMap;
    }
}

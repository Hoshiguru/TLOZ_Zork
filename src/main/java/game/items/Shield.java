package game.items;

import game.Item;

public class Shield extends Item {
    private int defense;

    public Shield(String name, String description, double weight, int defense) {
        super(name, description, weight);
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}

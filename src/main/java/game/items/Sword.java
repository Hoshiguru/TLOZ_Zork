package game.items;

import game.Item;

public class Sword extends Item {
    private int damage;

    public Sword(String name, String description, double weight, int damage) {
        super(name, description, weight);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}

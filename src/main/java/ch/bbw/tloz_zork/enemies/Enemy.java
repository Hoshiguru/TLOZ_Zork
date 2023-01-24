package ch.bbw.tloz_zork.enemies;

import ch.bbw.tloz_zork.items.Item;

public class Enemy {
    private String name;
    private int health; // health points
    private int ap; // attack power
    private int crit; // critical hit chance
    private Item item;
    private boolean isDead;

    public Enemy(String name, int health, int ap, int crit, Item item, boolean isDead) {
        this.name = name;
        this.health = health;
        this.ap = ap;
        this.crit = crit;
        this.item = item;
        this.isDead = isDead;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAp() {
        return ap;
    }

    public void setAp(int ap) {
        this.ap = ap;
    }

    public int getCrit() {
        return crit;
    }

    public void setCrit(int crit) {
        this.crit = crit;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public boolean getIsDead(){
        return isDead;
    }

    public void setIsDead(boolean isDead){
        this.isDead = isDead;
    }

    @Override
    public String toString() {
        return "Enemy{" +
                "enemy='" + name + '\'' +
                ", health=" + health +
                ", ap=" + ap +
                ", crit=" + crit +
                ", item=" + item +
                '}';
    }
}

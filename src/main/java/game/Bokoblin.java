package game;

import java.util.ArrayList;

public class Bokoblin {
    private int hearts; // 10
    private int ap; //attack power
    private Item item;

    public Bokoblin(int hearts, int ap, Item item) {
        this.hearts = hearts;
        this.ap = ap;
        this.item = item;
    }

    public int getHearts() {
        return hearts;
    }

    public void setHearts(int hearts) {
        this.hearts = hearts;
    }

    public int getAp() {
        return ap;
    }

    public void setAp(int ap) {
        this.ap = ap;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}

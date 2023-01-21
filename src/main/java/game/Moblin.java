package game;

public class Moblin {
    private int hearts; // 10
    private int ap; //attack power
    private Item item;

    public Moblin(int hearts, int ap, Item item) {
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

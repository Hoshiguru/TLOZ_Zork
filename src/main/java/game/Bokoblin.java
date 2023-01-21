package game;

import java.util.ArrayList;

public class Bokoblin {
    private int hearts; // 10
    private int ap; //attack power
    private Item item;
    private int crit;

    public Bokoblin(int hearts, int ap, Item item, int crit) {
        this.hearts = hearts;
        this.ap = ap;
        this.item = item;
        this.crit = crit;
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

    public int getCrit(){
        return crit;
    }

    public void setCrit(int crit){
        this.crit = crit;
    }

    @Override
    public String toString() {
        return "game.Bokoblin{" +
                "hearts='" + hearts + '\'' +
                ", ap ='" + ap + '\'' +
                ", item =" + item +
                ", crit ='" + crit +
                '}';
    }
}

package game;

public class Moblin {
    private int hearts; // 10
    private int ap; //attack power
    private Item item;
    private int crit;

    public Moblin(int hearts, int ap, Item item, int crit) {
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

    public int getCrit(){
        return crit;
    }

    public void setCrit(int crit){
        this.crit = crit;
    }

    @Override
    public String toString() {
        return "game.Lynel{" +
                "hearts='" + hearts + '\'' +
                ", ap ='" + ap + '\'' +
                ", item =" + item +
                ", crit ='" + crit +
                '}';
    }
}

package ch.bbw.tloz_zork.items;

public class Shield extends Item {
    private int defense;

    public Shield(String name, String description, double weight, String icon, int defense) {
        super(name, description, weight, icon);
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}

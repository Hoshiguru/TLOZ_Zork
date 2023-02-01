package ch.bbw.tloz_zork.items;

/**
 * Entity for the healing items
 * @author Yao Kaiser
 */
public class WeaponItem extends Item{
    private int damage;

    public WeaponItem(String name, String description, double weight, String icon, int damage) {
        super(name, description, weight, icon);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}

package ch.bbw.tloz_zork.items;

/**
 * Entity for the healing items
 * @author Yao Kaiser
 */
public class HealingItem extends Item{
   private int healingAmount;

    public HealingItem(String name, String description, double weight, String icon, int healingAmount) {
        super(name, description, weight, icon);
        this.healingAmount = healingAmount;
    }

    public int getHealingAmount() {
        return healingAmount;
    }

    public void setHealingAmount(int healingAmount) {
        this.healingAmount = healingAmount;
    }
}

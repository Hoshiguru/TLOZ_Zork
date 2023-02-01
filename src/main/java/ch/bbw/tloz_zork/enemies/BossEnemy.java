package ch.bbw.tloz_zork.enemies;

import ch.bbw.tloz_zork.items.WeaponItem;

import java.util.ArrayList;

public class BossEnemy extends Enemy{
    private ArrayList<WeaponItem> weapons;
    private int phase = 1;

    public BossEnemy(String name, int health, int ap, int crit, ArrayList<WeaponItem> weapons) {
        super(name, health, ap, crit, null);
        this.weapons = weapons;
        this.item = weapons.get(0);
        this.phase = phase;
    }
    public void switchPhase() {
        phase++;
        changeWeapon();
    }
    public int getPhase() {
        return phase;
    }
    public void changeWeapon() {
        if(weapons.size() > phase-1)
            this.item = weapons.get(phase-1);
        else
            this.item = null;
    }

    /**
     * @return the weapons
     */
    public WeaponItem getWeaponInHand() {
        return (WeaponItem) this.item;
    }
    @Override
    public int getAp() {
        // Add new logic for calculating AP based on the current phase
        return super.getAp() + ((WeaponItem) this.item).getDamage();
    }
}

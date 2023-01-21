package game;

public class Enemy {
    private String enemy;
    private int health;
    private int ap;
    private int crit;
    private Item item;

    public Enemy(String enemy, int health, int ap, int crit, Item item) {
        this.enemy = enemy;
        this.health = health;
        this.ap = ap;
        this.crit = crit;
        this.item = item;
    }

    public String getEnemy() {
        return enemy;
    }

    public void setEnemy(String enemy) {
        this.enemy = enemy;
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

    @Override
    public String toString() {
        return "Enemy{" +
                "enemy='" + enemy + '\'' +
                ", health=" + health +
                ", ap=" + ap +
                ", crit=" + crit +
                ", item=" + item +
                '}';
    }
}

package ch.bbw.tloz_zork.game.generators;

import ch.bbw.tloz_zork.enemies.Enemy;
import ch.bbw.tloz_zork.items.WeaponItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Random;

public class EnemyGenerator {
    private List<Enemy> enemies;
    private Random random;
    private final String ENEMIES_FILE = "src/main/resources/data/enemies.json";
    public EnemyGenerator() throws Exception {
        Gson gson = new Gson();
        this.enemies = gson.fromJson(new FileReader(ENEMIES_FILE), new TypeToken<List<Enemy>>(){}.getType());
        this.random = new Random();
    }

    /**
     * @return a random enemy from the list of enemies
     */
    public Enemy getRandomEnemy() throws FileNotFoundException {
        ItemGenerator ig = new ItemGenerator();
        WeaponItem weapon = ig.getRandomWeapon();

        int enemyCount = enemies.size();
        if (enemyCount == 0) {
            return null;
        }
        int randomIndex = random.nextInt(enemyCount);
        return new Enemy(enemies.get(randomIndex).getName(), enemies.get(randomIndex).getHealth(),
                enemies.get(randomIndex).getAp(), enemies.get(randomIndex).getCrit(), weapon);
    }
}
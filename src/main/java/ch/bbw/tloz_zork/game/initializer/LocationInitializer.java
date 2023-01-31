package ch.bbw.tloz_zork.game.initializer;

import ch.bbw.tloz_zork.enemies.Enemy;
import ch.bbw.tloz_zork.game.generators.EnemyGenerator;
import ch.bbw.tloz_zork.items.Item;
import ch.bbw.tloz_zork.locations.Location;
import com.google.gson.Gson;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

class LocationInitializer {

    private List<Item> items;

    public LocationInitializer() {
        // Lade die Item-Objekte aus einer JSON-Datei
        try (FileReader reader = new FileReader("data/food.json")) {
            Gson gson = new Gson();
            items = gson.fromJson(reader, ArrayList.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initializeLocations() throws Exception {
        Random random = new Random();
        EnemyGenerator eg = new EnemyGenerator();
        Enemy enemy = eg.getRandomEnemy();

        // Initialisiere die Location-Objekte
        Location castle_ruin = new Location("Castle Ruin", "\uD83C\uDFDB", "A mysterious, crumbling castle awaits exploration, filled with dangerous enemies and valuable treasures. ", "castle_ruin", enemy);
        Location woodland = new Location("Woodland", "\uD83C\uDF33", "A dense forest filled with dangerous enemies and valuable treasures. Location of the master sword.", "woodland", enemy);
        Location castle = new Location("Castle", "\uD83C\uDFF0", "A grand and imposing castle stands at the center of the kingdom, guarded by powerful enemies and holding secrets of ancient power.", "castle", enemy);
        Location cave = new Location("Cave", "\uD83E\uDEA8", "A dark and treacherous cave system winds deep into the earth, filled with dangerous creatures and hidden treasures.", "cave", enemy);
        Location desert = new Location("Desert", "\uD83C\uDFDC️", "A vast and scorching desert stretches as far as the eye can see, with hidden oases, ancient ruins, and deadly sandstorms.", "desert", enemy);
        Location underwater_temple = new Location("Underwater Temple", "\uD83D\uDED5", "A mysterious underwater temple lies beneath the waves, filled with treacherous currents, ancient technology and deadly guardians.", "underwater_temple", enemy);

        // Füge zufällige Anzahl von Item-Objekten zu den Location-Objekten hinzu
        for (Location location : Arrays.asList(castle_ruin, woodland, castle, cave, desert, underwater_temple)) {
            int numberOfItems = random.nextInt(items.size());
            for (int i = 0; i < numberOfItems; i++) {
                location.addItem(items.get(random.nextInt(items.size())));
            }
        }
    }
}

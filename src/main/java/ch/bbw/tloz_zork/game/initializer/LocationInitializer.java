package ch.bbw.tloz_zork.game.initializer;

import ch.bbw.tloz_zork.enemies.BossEnemy;
import ch.bbw.tloz_zork.enemies.Enemy;
import ch.bbw.tloz_zork.game.Gate;
import ch.bbw.tloz_zork.game.generators.EnemyGenerator;
import ch.bbw.tloz_zork.game.generators.ItemGenerator;
import ch.bbw.tloz_zork.items.Item;
import ch.bbw.tloz_zork.items.WeaponItem;
import ch.bbw.tloz_zork.locations.Dungeon;
import ch.bbw.tloz_zork.locations.Location;
import ch.bbw.tloz_zork.riddles.Riddle;
import com.google.gson.Gson;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LocationInitializer {

    private List<Item> items;

    public LocationInitializer() {
        // Lade die Item-Objekte aus einer JSON-Datei
        try (FileReader reader = new FileReader("src/main/resources/data/food.json")) {
            Gson gson = new Gson();
            items = gson.fromJson(reader, ArrayList.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Location> initializeLocations() throws Exception {
        EnemyGenerator eg = new EnemyGenerator();
        ItemGenerator ig = new ItemGenerator();
        ArrayList<Item> items = ig.getRandomItems();
        Enemy enemy = eg.getRandomEnemy();
        List<Location> locations = new ArrayList<>();

        // Initialize BossEnemy
        BossEnemy ganon = new BossEnemy("Ganon", 35, 0, 7, new ArrayList<WeaponItem>(ig.getRandomWeapons(3)));

        // Initialize Locations
        Location castle_ruin = new Location("Castle Ruin", "\uD83C\uDFDB", "A mysterious, crumbling castle awaits exploration, filled with dangerous enemies and valuable treasures. ", "castle_ruin", enemy, ig.getRandomItems());
        Location woodland = new Location("Woodland", "\uD83C\uDF33", "A dense forest filled with dangerous enemies and valuable treasures. Location of the master sword.", "woodland", enemy, items);
        Location castle = new Location("Castle", "\uD83C\uDFF0", "A grand and imposing castle stands at the center of the kingdom, guarded by powerful enemies and holding secrets of ancient power.", "castle", ganon, ig.getRandomItems());
        Location cave = new Location("Cave", "\uD83E\uDEA8", "A dark and treacherous cave system winds deep into the earth, filled with dangerous creatures and hidden treasures.", "cave", enemy, ig.getRandomItems());
        Location desert = new Location("Desert", "\uD83C\uDFDC️", "A vast and scorching desert stretches as far as the eye can see, with hidden oases, ancient ruins, and deadly sandstorms.", "desert", enemy, ig.getRandomItems());
        Location underwater_temple = new Location("Underwater Temple", "\uD83D\uDED5", "A mysterious underwater temple lies beneath the waves, filled with treacherous currents, ancient technology and deadly guardians.", "underwater_temple", enemy, ig.getRandomItems());

        Riddle zelda_name_riddle = new Riddle("What is the name of the princess of Hyrule?", null, "Zelda");
        Riddle master_sword_riddle = new Riddle("How many heart chambers does it take to pull the master sword out of the stone?", null, "13");
        // Initialisation Dungeon
        Dungeon temple_of_time = new Dungeon("Temple of Time", "⌛", "The Temple of Time is an impressive building located in the castle ruin of Hyrule. It is surrounded by a majestic waterfall and has a magnificent architecture reminiscent of ancient temples", "temple_of_time", false, master_sword_riddle);
        Dungeon shadow_dungeon = new Dungeon("Shadow Dungeon", "🕳️", "A mysterious dungeon, between trees in the woodland, right next to the master sword place.", "shadow_dungeon", false, zelda_name_riddle);
        Dungeon spirit_dungeon = new Dungeon("Spirit Dungeon", "\uD83D\uDC7B", "A mysterious temple lies in the underground, hidden in the cave.", "spirit_dungeon", false, enemy);
        Dungeon desert_dungeon = new Dungeon("Desert Dungeon", "\uD83C\uDF35", "An desert dungeon, which is located in the east of the desert.", "desert_dungeon", false, enemy);

        // Initialisation Gates
        Gate gateCastle_ruinWoodland = new Gate(castle_ruin, woodland, false);
        Gate gateWoodlandCastle = new Gate(woodland, castle, true);
        Gate gateCastle_ruinCave = new Gate(castle_ruin, cave, false);
        Gate gateCaveDesert = new Gate(cave, desert, false);
        Gate gateDesertUnderwater_temple = new Gate(desert, underwater_temple, false);

        Gate gateTemple_of_TimeWoodland = new Gate(temple_of_time, woodland, false);
        Gate gateShadow_dungeonWoodland = new Gate(shadow_dungeon, woodland, false);
        Gate gateSpirit_dungeonCave = new Gate(spirit_dungeon, cave, false);
        Gate gateDesert_dungeonDesert = new Gate(desert_dungeon, desert, false);

        // Festlegen von Himmelsrichtungen
        castle_ruin.setDirections(gateCastle_ruinWoodland, gateCastle_ruinCave, null, null);
        woodland.setDirections(gateShadow_dungeonWoodland, gateTemple_of_TimeWoodland, gateCastle_ruinWoodland, gateWoodlandCastle);
        castle.setDirections(null, gateWoodlandCastle, null, null);
        cave.setDirections(gateSpirit_dungeonCave, gateCaveDesert, null, gateCastle_ruinCave);
        desert.setDirections(null, gateDesert_dungeonDesert, gateDesertUnderwater_temple, gateCaveDesert);
        underwater_temple.setDirections(gateDesertUnderwater_temple, null, null, null);

        temple_of_time.setDirections(null, null, null, gateTemple_of_TimeWoodland);
        shadow_dungeon.setDirections(null, null, gateShadow_dungeonWoodland, null);
        spirit_dungeon.setDirections(null, null, gateSpirit_dungeonCave, null);
        desert_dungeon.setDirections(null, null, null, gateDesert_dungeonDesert);



        locations.addAll(Arrays.asList(castle_ruin, woodland, castle, cave, desert, underwater_temple, temple_of_time, shadow_dungeon, spirit_dungeon, desert_dungeon));

        return locations;
    }

}

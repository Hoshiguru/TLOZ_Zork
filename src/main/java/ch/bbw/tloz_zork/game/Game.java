package ch.bbw.tloz_zork.game;

import ch.bbw.tloz_zork.cmds.CommandHandler;
import ch.bbw.tloz_zork.enemies.BossEnemy;
import ch.bbw.tloz_zork.enemies.Enemy;
import ch.bbw.tloz_zork.exceptions.InvalidCommandException;
import ch.bbw.tloz_zork.exceptions.InvalidDirectionException;
import ch.bbw.tloz_zork.items.HealingItem;
import ch.bbw.tloz_zork.items.WeaponItem;
import ch.bbw.tloz_zork.locations.Dungeon;
import ch.bbw.tloz_zork.locations.Location;
import ch.bbw.tloz_zork.riddles.Riddle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Game {
    private Player player;
    private Location castle_ruin, woodland, castle, cave, desert, underwater_temple;
    private CommandHandler commandHandler;

    //private Place places; // oder auch Räume
    public void startGame() {
        player = new Player(3, 3 ,1, 5, 5, null, 20.0, null, false, false);
        commandHandler = new CommandHandler();
        Scanner scanner = new Scanner(System.in);
        String command;
        System.out.println("     /\\");
        System.out.println("    /  \\");
        System.out.println("   /____\\");
        System.out.println("  /\\    /\\");
        System.out.println(" /  \\  /  \\");
        System.out.println("/____\\/____\\");
        System.out.println("Welcome to");
        System.out.println("\"The Legends of Zelda: Zork of the Wild\"");
        System.out.println("");
        System.out.println("Type 'start' to start the game");
        System.out.print("》 ");

        while (!(command = scanner.nextLine()).equalsIgnoreCase("start")) {
            System.out.println("Invalid command. Please type 'start' to begin the game.");
            System.out.print("》 ");
        }
        System.out.println("Is this your first time playing The Legends of Zelda: Zork of the Wild?");
        while (!player.isDead() || !player.isHasWon()) {
            System.out.print("》 ");
            switch (scanner.nextLine().toLowerCase()) {
                case "yes":
                case "y":
                    CombatTutorial combatTutorial = new CombatTutorial();
                    combatTutorial.dummyTutorial();
                case "no":
                case "n":
                    System.out.println("Then let's jump right into your adventure!");
                    initializeGame();
                    System.out.println("");
                    //loading(1000);
                    System.out.print(".");
                    //loading(1000);
                    System.out.print(".");
                    //loading(1000);
                    System.out.print(".");
                    System.out.println("Link, are you awake? You're currently in the castle ruin. You have to find the master sword to defeat Ganon. Good luck!");
                    // Hier startet das Spiel
                    while (!player.isDead()) {
                        System.out.print("》 ");
                        command = scanner.nextLine();
                        try {
                            commandHandler.handleCommand(command, player);
                        } catch (InvalidCommandException | InvalidDirectionException e) {
                            System.out.println(e.getMessage());
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        if (player.isDead()) {
                            System.out.println();
                            System.out.println();
                            System.out.println();
                            System.out.println();
                            System.out.println();
                            System.out.println("You died");
                            System.out.println("Game over!");
                        }
                        else if (player.isHasWon()) {
                            System.out.println();
                            System.out.println();
                            System.out.println();
                            System.out.println();
                            System.out.println();
                            System.out.println("You won");
                            System.out.println("Congratulations!");
                        }
                    }
                    break;
                default:
                    System.out.println("I need a yes or a no");
                    break;
            }
        }

    }

    private void initializeGame() {

        // All HealingItems, which u can use to heal
        HealingItem apple = new HealingItem("Apple", "A healing item used to restore health.", 0.2, "🍎", 1);
        HealingItem banana = new HealingItem("Banana", "A healing item used to restore health.", 0.5, "🍌", 2);
        HealingItem fish = new HealingItem("Fish", "A healing item used to restore health.", 0.8, "🐟", 3);
        HealingItem meat = new HealingItem("Meat", "A healing item used to restore health.", 1.0, "🥩", 4);
        HealingItem steak = new HealingItem("Steak", "A healing item used to restore health.", 1.5, "🥩", 5);
        // All Weapons, which u can use to fight
        WeaponItem sword = new WeaponItem("Sword", "A melee weapon used to defeat enemies and hit close targets.", 1.8, "🗡️", 5);
        WeaponItem hammer = new WeaponItem("Hammer", "A heavy melee weapon used to defeat enemies and break through obstacles.", 5.0, "🔨", 3);
        WeaponItem axe = new WeaponItem("Axe", "A heavy melee weapon used to defeat enemies and chop down trees.", 3.5, "🪓", 4);
        WeaponItem spear = new WeaponItem("Spear", "A long melee weapon used to defeat enemies from a distance.", 2.0, "🗿", 2);
        WeaponItem mace = new WeaponItem("Mace", "A heavy melee weapon used to defeat enemies and crush armor.", 4.0, "🔨", 5);
        WeaponItem scythe = new WeaponItem("Scythe", "A long melee weapon used to defeat enemies and harvest crops.", 2.5, "🌾", 5);
        WeaponItem kunai = new WeaponItem("Kunai", "A short ranged weapon used to defeat enemies and hit distant targets.", 0.5, "🗡️", 6);
        WeaponItem bow = new WeaponItem("Bow", "A ranged weapon used to defeat enemies and hit distant targets.", 1.2, "🏹", 3);
        WeaponItem boomerang = new WeaponItem("Boomerang", "A ranged weapon used to defeat enemies and hit distant targets.", 1.2, "🪃", 1);
        WeaponItem root = new WeaponItem("Root", "A stick. Very light to carry but unfortunately not too strong.", 0.7, "🌲", 1);
        WeaponItem shield = new WeaponItem("Shield", "A defensive item used to protect the player from enemy attacks.", 6.5, "🛡️", 1); //TODO: Eventuell eigene Klasse für defensive Items
        WeaponItem masterSword = new WeaponItem("Master Sword", "The legendary sword of the hero of time. It is said that only the chosen one can wield it.", 10.0, "⚔️", 10);
        // Initialisation Enemy
        Enemy bokoblin = new Enemy("Bokoblin", 5, 1, 10, root, false);
        Enemy moblin = new Enemy("moblin", 3, 1, 10, sword, false);
        Enemy lynel_1 = new Enemy("lynel", 15, 4, 3, mace, false);
        Enemy lynel_2 = new Enemy("lynel", 17, 5, 3, mace, false);
        Enemy stalfos = new Enemy("stalfos", 5, 3, 5, spear, false);
        Enemy darknut = new Enemy("darknut", 4, 2, 3, sword, false);
        BossEnemy ganon = new BossEnemy("Ganon", 25, 0, 7, false, new ArrayList<WeaponItem>(Arrays.asList(axe, scythe, kunai)));

        // Initialisation riddles
        Riddle zelda_name_riddle = new Riddle("What is the name of the princess of Hyrule?", null, "Zelda");
        Riddle master_sword_riddle = new Riddle("How many heart chambers does it take to pull the master sword out of the stone?", null, "13");

        // Initialisation Locations
        castle_ruin = new Location("Castle Ruin", "\uD83C\uDFDB", "A mysterious, crumbling castle awaits exploration, filled with dangerous enemies and valuable treasures. ", "castle_ruin", bokoblin);
        woodland = new Location("Woodland", "\uD83C\uDF33", "A dense forest filled with dangerous enemies and valuable treasures. Location of the master sword.", "woodland", stalfos);
        castle = new Location("Castle", "\uD83C\uDFF0", "A grand and imposing castle stands at the center of the kingdom, guarded by powerful enemies and holding secrets of ancient power.", "castle", ganon);
        cave = new Location("Cave", "\uD83E\uDEA8", "A dark and treacherous cave system winds deep into the earth, filled with dangerous creatures and hidden treasures.", "cave", (Enemy) null);
        desert = new Location("Desert", "\uD83C\uDFDC️", "A vast and scorching desert stretches as far as the eye can see, with hidden oases, ancient ruins, and deadly sandstorms.", "desert", moblin);
        underwater_temple = new Location("Underwater Temple", "\uD83D\uDED5", "A mysterious underwater temple lies beneath the waves, filled with treacherous currents, ancient technology and deadly guardians.", "underwater_temple", lynel_1);

        // Initialisation Dungeon
        Dungeon temple_of_time = new Dungeon("Temple of Time", "⌛", "The Temple of Time is an impressive building located in the castle ruin of Hyrule. It is surrounded by a majestic waterfall and has a magnificent architecture reminiscent of ancient temples", "temple_of_time", false, master_sword_riddle);
        Dungeon shadow_dungeon = new Dungeon("Shadow Dungeon", "🕳️", "A mysterious dungeon, between trees in the woodland, right next to the master sword place.", "shadow_dungeon", false, zelda_name_riddle);
        Dungeon spirit_dungeon = new Dungeon("Spirit Dungeon", "\uD83D\uDC7B", "A mysterious temple lies in the underground, hidden in the cave.", "spirit_dungeon", false, darknut);
        Dungeon desert_dungeon = new Dungeon("Desert Dungeon", "\uD83C\uDF35", "An desert dungeon, which is located in the east of the desert.", "desert_dungeon", false, lynel_2);

        // Initialisation Raum-Items
        //TODO: Eventuell randomizen
        castle_ruin.addItem(bow);
        castle_ruin.addItem(meat);
        woodland.addItem(banana);
        castle.addItem(hammer);
        cave.addItem(apple);
        desert.addItem(steak);
        underwater_temple.addItem(masterSword);
        underwater_temple.addItem(fish);

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

        // Item auffüllen
        player.addItem(apple);
        // Startposition festlegen
        player.setCurrentLocation(castle_ruin);
    }

    // Methode für loading times
    public static void loading(long limit) {

        long startTime = System.currentTimeMillis();
        long elapsedTime = 0L;

        while (elapsedTime < limit) {

            elapsedTime = (new Date()).getTime() - startTime;
        }
    }
}

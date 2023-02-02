package ch.bbw.tloz_zork.cmds;

import ch.bbw.tloz_zork.enemies.Enemy;
import ch.bbw.tloz_zork.game.Gate;
import ch.bbw.tloz_zork.game.Player;
import ch.bbw.tloz_zork.items.Item;
import ch.bbw.tloz_zork.items.WeaponItem;
import ch.bbw.tloz_zork.locations.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MoveCommandTest {
    MoveCommand moveCommand;
    Player player;
    WeaponItem testWeapon;
    Enemy testEnemy;
    Location firstTestLocation;
    Location secondTestLocation;
    Gate firstSecondGate = new Gate(firstTestLocation, secondTestLocation, false);
    Item testItem = new Item("Test Item", "Test Description", 2.0, "🗿");
    @BeforeEach
    public void setUp() {
        moveCommand = new MoveCommand();
        player = new Player(3, 3 ,1, 5, 5, null, 20.0, null, false, false);
        testWeapon = new WeaponItem("Test Weapon", "Test Description", 2.0, "🗿", 2);
        testEnemy = new Enemy("Test Enemy", 5, 3, 5, testWeapon, false);
        firstTestLocation = new Location("First Test Location", "\uD83C\uDF33", "Test Description", "firstTestMap", testEnemy);
        secondTestLocation = new Location("Second Test Location", "\uD83C\uDF33", "Test Description", "secondTestMap", testEnemy);
        player.addItem(testWeapon);
        player.setCurrentLocation(firstTestLocation);
        firstTestLocation.setDirections(firstSecondGate, null, null,null);
        secondTestLocation.setDirections(null, null, firstSecondGate,null);
    }
    @Test
    void testMoveFullDirection() {
        MoveCommand moveCommand = new MoveCommand();
        moveCommand.move(player, "north");
        assertNotNull(firstSecondGate);
    }
    @Test
    void testMoveShortDirection() {
        MoveCommand moveCommand = new MoveCommand();
        moveCommand.move(player, "n");
        assertNotNull(firstSecondGate);
    }

    @Test
    void testCheckEnemyStatus() {
        MoveCommand moveCommand = new MoveCommand();
        Enemy enemy = new Enemy("name", 2, 3, 3, (WeaponItem) testItem, false);
        firstTestLocation.setEnemy(enemy);
        moveCommand.checkEnemyStatus(firstTestLocation);
        assertFalse(enemy.getIsDead());
    }
}
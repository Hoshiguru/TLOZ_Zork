package ch.bbw.tloz_zork.cmds;

import ch.bbw.tloz_zork.exceptions.InvalidCommandException;
import ch.bbw.tloz_zork.exceptions.InvalidDirectionException;
import ch.bbw.tloz_zork.game.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;
public class CommandHandlerTest {
    private CommandHandler commandHandler;
    private Player player;
    @BeforeEach
    public void setUp() {
        commandHandler = new CommandHandler();
        player = new Player(3, 3, 5, 5, 5, null, 10, null, false, false);
    }
    @Test
    public void testMoveCommandValid() throws InvalidCommandException, InvalidDirectionException, IOException {
        String command = "move north";
        commandHandler.handleCommand(command, player);
        // Add your asserts
    }
    @Test
    public void testMoveCommandInvalid() {
        String command = "move up";
        assertThrows(InvalidDirectionException.class, () -> commandHandler.handleCommand(command, player));
    }
    @Test
    public void testHelpCommandValid() throws InvalidCommandException, InvalidDirectionException, IOException {
        String command = "help";
        commandHandler.handleCommand(command, player);
        // Add your asserts
    }
    @Test
    public void testBackCommandValid() throws InvalidCommandException, InvalidDirectionException, IOException {
        String command = "back";
        commandHandler.handleCommand(command, player);
        // Add your asserts
    }
    @Test
    public void testScoreCommandValid() throws InvalidCommandException, InvalidDirectionException, IOException {
        String command = "score";
        commandHandler.handleCommand(command, player);
        // Add your asserts
    }
    @Test
    public void testMapCommandValid() throws InvalidCommandException, InvalidDirectionException, IOException {
        String command = "map";
        commandHandler.handleCommand(command, player);
        // Add your asserts
    }
    @Test
    public void testGrabCommandValid() throws InvalidCommandException, InvalidDirectionException, IOException {
        String command = "grab";
        commandHandler.handleCommand(command, player);
        // Add your asserts
    }
    @Test
    public void testDropCommandValid() throws InvalidCommandException, InvalidDirectionException, IOException {
        String command = "drop Sword";
        commandHandler.handleCommand(command, player);
        // Add your asserts
    }
    @Test
    public void testEatCommandValid() throws InvalidCommandException, InvalidDirectionException, IOException {
        String command = "eat Apple";
        commandHandler.handleCommand(command, player);
        // Add your asserts
    }
    @Test
    public void testUseCommandValid() throws InvalidCommandException, InvalidDirectionException, IOException {
        String command = "use Sword";
        commandHandler.handleCommand(command, player);
        // Add your asserts
    }
    @Test
    public void testInventoryCommandValid() throws InvalidCommandException, InvalidDirectionException, IOException {
        String command = "inventory";
        commandHandler.handleCommand(command, player);
        // Add your asserts
    }
    @Test
    public void testFightCommandValid() throws InvalidCommandException, InvalidDirectionException, IOException {
        String command = "fight";
        commandHandler.handleCommand(command, player);
        // Add your asserts
    }
    @Test
    public void testInvalidCommand() {
        String command = "invalid";
        assertThrows(InvalidCommandException.class, () -> commandHandler.handleCommand(command, player));
    }
}
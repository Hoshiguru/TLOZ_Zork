package game.cmds;

import game.Enemy;
import game.Player;

public class CombatCommand {
    public void combat(Player player, String action, Enemy enemy){
        switch (action){
            case "a" -> action = "attack";
            case "d" -> action = "defend";
            case "f" -> action = "flee";
            default -> {
            }
        }

    }
}

package ch.bbw.tloz_zork.cmds;

import ch.bbw.tloz_zork.enemies.Enemy;
import ch.bbw.tloz_zork.game.Player;
import ch.bbw.tloz_zork.items.Item;

import java.util.ArrayList;

public class CombatCommand {
    public void combat(Player player, String action, Enemy enemy){
        ArrayList<Item> items = player.getInventory();
        switch (action){
            case "a" -> action = "attack";
            case "d" -> action = "defend";
            case "f" -> action = "flee";
            default -> {
            }
        }
        if( enemy.getHealth() > 0){
            System.out.println("");
        } else {
            System.out.println("You have defeated " + enemy.getName());
            items.add(enemy.getItem());
        }
    }
}

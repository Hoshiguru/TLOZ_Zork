package ch.bbw.tloz_zork.cmds;


import game.Player;

public class ScoreCommand {
    private Player player;
    public void score(Player player){
        System.out.println("There is not much to see here yet.");
        // TODO: Show Hearts as Icon instead of text
        System.out.println("Health: " + player.getHearts());
    }
}

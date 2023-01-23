package ch.bbw.tloz_zork.cmds;


import ch.bbw.tloz_zork.game.Player;

public class ScoreCommand {
    private Player player;
    /**
     * Constructor for ScoreCommand
     * @param player
     */
    public void score(Player player){
        System.out.println("Total Moves: " + player.getMoves());
        System.out.println("Health: " + player.getHeartIcons());
    }
}

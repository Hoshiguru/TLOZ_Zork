package ch.bbw.tloz_zork.cmds;


import ch.bbw.tloz_zork.game.Player;

/**
 * Shows the score for the current player
 * @author Andy Lam
 */
public class ScoreCommand {
    private Player player;
    /**
     * Constructor for ScoreCommand
     * @param player
     */
    public void score(Player player){
        System.out.println("\uD83D\uDC63 Moves: " + player.getMoves());
        System.out.println("\uD83D\uDCA5 Kills: " + player.getKills());
        System.out.println("Health: " + player.getHeartIcons());
        System.out.println("Stamina: " + player.getStaminaIcons());
    }
}

package ch.bbw.tloz_zork.cmds;


import ch.bbw.tloz_zork.game.Player;

public class ScoreCommand {
    private Player player;
    // TODO: Move Stats Screen to Player Stats Class
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

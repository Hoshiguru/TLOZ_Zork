package game.cmds;


import game.Player;

public class ScoreCommand {
    private Player player;
    public void score(Player player){
        System.out.println("There is not much to see here yet.");
        System.out.println("Health: " + player.getHearts());
    }
}

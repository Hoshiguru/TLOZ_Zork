package ch.bbw.tloz_zork.game.output;

public class BattleCard {
    /**
     * Prints the battle card
     * @param playerWeapon
     * @param playerAttack
     * @param playerHealth
     * @param playerStamina
     * @param enemyName
     * @param enemyWeapon
     * @param enemyAttack
     * @param enemyHealth
     */
    public static void printBattleCard(String playerWeapon, int playerAttack, String playerHealth, String playerStamina, String enemyName, String enemyWeapon, int enemyAttack, String enemyHealth) {
        System.out.println("╔═══════════════════════════════════════════════╗");
        System.out.println("║                                               ║");
        System.out.println("   \uD83D\uDC67 Player: 🗡️ " + playerWeapon + " (" + playerAttack + " \uD83D\uDCA5)");
        System.out.println("   Health: " + playerHealth);
        System.out.println("   Stamina: " + playerStamina);
        System.out.println("║                                               ║");
        System.out.println("╠═══════════════════════════════════════════════╣");
        System.out.println("║                                               ║");
        System.out.println("   "+ enemyName +": 🗡️ " + enemyWeapon + " (" + enemyAttack + " \uD83D\uDCA5)");
        System.out.println("   Health: " + enemyHealth);
        System.out.println("║                                               ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
        System.out.println("\uD83D\uDDE1️'(a)ttack' • \uD83D\uDCBC'(i)tem' • \uD83D\uDC93'(e)at <item>' • ✋'(u)se <item> • \uD83C\uDFC3'(f)lee'");
    }
}

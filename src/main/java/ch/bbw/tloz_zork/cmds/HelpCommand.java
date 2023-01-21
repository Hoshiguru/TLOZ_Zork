package ch.bbw.tloz_zork.cmds;

public class HelpCommand {
    public void help(){
        System.out.println("『 Move commands 』\nmove <direction>\n(n)orth • (s)outh • (e)ast • (w)est");
        System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
        System.out.println("『 Interaction commands 』\n(m)ap • score");
        System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
        System.out.println("『 Inventory commands 』\n(i)nventory • (g)rab • drop <item>");
    }
}


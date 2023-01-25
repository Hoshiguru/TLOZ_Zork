package ch.bbw.tloz_zork.cmds;

public class HelpCommand {
    public void help(){
        System.out.println("『 Move commands 』\nback • move <direction>\n(n)orth • (s)outh • (e)ast • (w)est");
        System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
        System.out.println("『 Interaction commands 』\n(m)ap • (s)core • (f)ight");
        System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
        System.out.println("『 Item commands 』\n(i)nventory • (g)rab • drop <item> • (e)at <item> • (u)se <item>");
    }
}


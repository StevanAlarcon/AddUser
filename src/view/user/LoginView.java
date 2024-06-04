package view.user;

import java.io.Console;

import tools.MyTool;

public class LoginView {
    public String[] getLogin(){
        Console console = System.console();
        String[] login = new String[2];

        MyTool.header("Meet Your Pet");
        showCover();
        System.out.println("User Login\n");

        login[0] = MyTool.readString("Username ", "Username");
        login[1] = new String(console.readPassword("Password: "));

        return login;
    }

    private void showCover() {
System.out.println("           _,'`-,                                               ");
System.out.println("       _,--'   ,/::.;                                           ");
System.out.println("    ,-'       ,/::,' `---.___        ___,_                      ");
System.out.println("       |       ,:';:/        ;'"+"`--./ ,-^.;--.                  ");
System.out.println("    |:     ,:';,'         '         `.   ;`   `-.               ");
System.out.println("    \\:.,:::/;/ -:.                   `  | `     `-.            ");
System.out.println("     \\:::,'//__.;  ,;  ,  ,  :.`-.   :. |  ;       :.          ");
System.out.println("      \\,',';/O)^. :'  ;  :   '__` `  :::`.       .:' )         ");
System.out.println("      |,'  |\\__,: ;      ;  '/O)`.   :::`;       ' ,'          ");
System.out.println("           |`--''            \\__,' , ::::(       ,'            ");
System.out.println("           `    ,            `--' ,: :::,'\\   ,-'              ");
System.out.println("             | ,;         ,    ,::'  ,:::   |,'                 ");
System.out.println("             |,:        .(          ,:::|   `                   ");
System.out.println("             ::'_   _   ::         ,::/:|                       ");
System.out.println("           ,',' `-' \\   `.      ,:::/,:|                       ");
System.out.println("           | : _  _   |   '     ,::,' :::                       ");
System.out.println("          | \\ O`'O  ,',   ,    :,'   ;::                       ");
System.out.println("           \\ `-'`--',:' ,' , ,,'      ::                       ");
System.out.println("             ``:.:.__   ',-','        ::'                       ");
System.out.println("                `--.__, ,::.         ::'                        ");
System.out.println("                    |:  ::::.       ::'                         ");
    }
}

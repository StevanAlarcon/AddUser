package view;

import tools.Menu;

public class AdminView {

    public int showMenu(String[] options) {
        Menu.clearScreen();
        showCow();
        Menu.showMenu("Administrator menu", options, 1);
        return Menu.getOption(options);
    }

    public static void showCow() {
        System.out.println("   / \\__          ");
        System.out.println("  (    @\\___       ");
        System.out.println("  /         O  _     /\\_/\\ ");
        System.out.println(" /   (_____/ <(.)__ ( o.o ) ");
        System.out.println("/_____/       (___/  > ^ <");
       
    }
    
}

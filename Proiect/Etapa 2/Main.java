import menus.MainMenu;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome!\n");

        MainMenu menu = new MainMenu();
        menu.Menu();
    }
}
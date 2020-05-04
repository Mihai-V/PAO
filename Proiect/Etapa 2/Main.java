import device.*;
import wearable.*;
import menus.MainMenu;
import services.Reader;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        Device device = new Device();
        Wearable wearable = new Wearable();

        Reader reader = new Reader();

        ArrayList<Phone> auxPhone = reader.read_phone();
        if (auxPhone.size() > 0)
            for (Phone item : auxPhone) {
                device.addPhone(item);
                auxPhone.clear();
            }

        ArrayList<Tablet> auxTablet = reader.read_tablet();
        if (auxTablet.size() > 0)
            for (Tablet item : auxTablet) {
                device.addTablet(item);
                auxTablet.clear();
            }

        ArrayList<Laptop> auxLaptop = reader.read_laptop();
        if (auxLaptop.size() > 0)
            for (Laptop item : auxLaptop) {
                device.addLaptop(item);
                auxLaptop.clear();
            }

        ArrayList<SmartBand> auxSmartBand = reader.read_smartBand();
        if (auxLaptop.size() > 0)
            for (SmartBand item : auxSmartBand) {
                wearable.addSmartBand(item);
                auxSmartBand.clear();
            }

        ArrayList<SmartWatch> auxSmartWatch = reader.read_smartWatch();
        if (auxSmartWatch.size() > 0)
            for (SmartWatch item : auxSmartWatch) {
                wearable.addSmartWatch(item);
                auxSmartWatch.clear();
            }

        System.out.println("Welcome!\n");

        MainMenu menu = new MainMenu();
        menu.Menu();
    }
}
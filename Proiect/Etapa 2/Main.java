import device.*;
import services.CSVWriter;
import wearable.*;
import services.*;
import services.CSVReader;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Store store = new Store();
        Audit audit = new Audit();
        CSVReader CSVReader = new CSVReader();

        List<Phone> auxPhone = CSVReader.read_phone();
        if (auxPhone.size() > 0)
            for (Phone item : auxPhone) {
                store.device.addPhone(item);
            }
        auxPhone.clear();

        List<Tablet> auxTablet = CSVReader.read_tablet();
        if (auxTablet.size() > 0)
            for (Tablet item : auxTablet) {
                store.device.addTablet(item);
            }
        auxTablet.clear();

        List<Laptop> auxLaptop = CSVReader.read_laptop();
        if (auxLaptop.size() > 0)
            for (Laptop item : auxLaptop) {
                store.device.addLaptop(item);
            }
        auxLaptop.clear();


        List<SmartBand> auxSmartBand = CSVReader.read_smartBand();
        if (auxSmartBand.size() > 0)
            for (SmartBand item : auxSmartBand) {
                store.wearable.addSmartBand(item);
            }
        auxSmartBand.clear();

        List<SmartWatch> auxSmartWatch = CSVReader.read_smartWatch();
        if (auxSmartWatch.size() > 0)
            for (SmartWatch item : auxSmartWatch) {
                store.wearable.addSmartWatch(item);
            }
        auxSmartWatch.clear();

        System.out.println("Welcome!\n");

        Scanner in = new Scanner(System.in);
        boolean input = true;

        showMenu();

        do {
            System.out.print("Enter your choice: ");
            String choice = in.nextLine();
            System.out.println();

            switch (choice.trim()){
                case "1":
                    store.device.displayPhones();
                    audit.write("Phones Displayed");
                    break;
                case "2":
                    store.device.displayPhonesByNoOfCameras();
                    audit.write("Phones By No Of Cameras Displayed");
                    break;
                case "3":
                    store.device.displayFoldable();
                    audit.write("Foldables Displayed");
                    break;
                case "4":
                    store.device.displayTablets();
                    audit.write("Tablets Displayed");
                    break;
                case "5":
                    store.device.displayLaptops();
                    audit.write("Laptops Displayed");
                    break;
                case "6":
                    store.device.displayLaptopsByRAM();
                    audit.write("Laptops By RAM Displayed");
                    break;
                case "7":
                    store.device.displayLaptopsByStorage();
                    audit.write("Laptops By Storage Displayed");
                    break;
                case "8":
                    store.wearable.displaySmartBands();
                    audit.write("Smart Bands Displayed");
                    break;
                case "9":
                    store.wearable.displaySmartWatches();
                    audit.write("Smart Watches Displayed");
                    break;
                case "10":
                    store.wearable.displaySmartWatchesBySize();
                    audit.write("Smart Watches By Size Displayed");
                    break;
                case "11":
                    store.newDevice();
                    showMenu();
                    break;
                case "12":
                    store.newWearable();
                    showMenu();
                    break;
                case "13":
                    store.removeDevice();
                    showMenu();
                    break;
                case "14":
                    store.removeWearable();
                    showMenu();
                    break;
                case "Q":
                    System.out.println("Have a nice day!");
                    input = false;

                    CSVWriter CSVWriter = new CSVWriter();
                    CSVWriter.write_phone(store.device.getPhones());
                    CSVWriter.write_laptop(store.device.getLaptops());
                    CSVWriter.write_tablet(store.device.getTablets());
                    CSVWriter.write_smartBand(store.wearable.getSmartBands());
                    CSVWriter.write_smartWatch(store.wearable.getSmartWatches());

                    break;
                case "Menu":
                    showMenu();
                    break;
                default:
                    System.out.println("Error! Invalid input.");
            }
        }while (input);
    }

    public static void showMenu() {
        System.out.print("Pick an action: ");
        System.out.println();
        System.out.println("1. Display all phones.");
        System.out.println("2. Display all phones by number of cameras.");
        System.out.println("3. Display foldable phones.");
        System.out.println("4. Display all tablets.");
        System.out.println("5. Display all laptops.");
        System.out.println("6. Display all laptops by RAM.");
        System.out.println("7. Display all laptops by storage.");
        System.out.println("8. Display all smart bands.");
        System.out.println("9. Display all smart watches.");
        System.out.println("10. Display all smart watches by size.");
        System.out.println("11. Add a device.");
        System.out.println("12. Add a wearable.");
        System.out.println("13. Remove a device.");
        System.out.println("14. Remove a wearable.");
        System.out.println();
        System.out.println("To see the menu again type 'Menu'.");
        System.out.println("To exit the menu type 'Q'.");
        System.out.println();
    }
}
package menus;

import device.*;
import services.*;
import wearable.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    private Device device;
    private Wearable wearable;

    public MainMenu() {
        this.device = new Device();
        this.wearable = new Wearable();
    }

    Audit audit = new Audit();

    public void Menu() throws IOException {
        Scanner in = new Scanner(System.in);
        boolean input = true;
        showMenu();

        do {
            System.out.print("Enter your choice: ");
            String choice = in.nextLine();
            System.out.println();

            switch (choice.trim()){
                case "1":
                    displayPhones();
                    audit.write("Phones Displayed");
                    showMenu();
                    break;
                case "2":
                    displayPhonesByNoOfCameras();
                    audit.write("Phones By No Of Cameras Displayed");
                    showMenu();
                    break;
                case "3":
                    displayFoldable();
                    audit.write("Foldables Displayed");
                    showMenu();
                    break;
                case "4":
                    displayTablets();
                    audit.write("Tablets Displayed");
                    showMenu();
                    break;
                case "5":
                    displayLaptops();
                    audit.write("Laptops Displayed");
                    showMenu();
                    break;
                case "6":
                    displayLaptopsByRAM();
                    audit.write("Laptops By RAM Displayed");
                    showMenu();
                    break;
                case "7":
                    displayLaptopsByStorage();
                    audit.write("Laptops By Storage Displayed");
                    showMenu();
                    break;
                case "8":
                    displaySmartBands();
                    audit.write("Smart Bands Displayed");
                    showMenu();
                    break;
                case "9":
                    displaySmartWatches();
                    audit.write("Smart Watches Displayed");
                    showMenu();
                    break;
                case "10":
                    displaySmartWatchesBySize();
                    audit.write("Smart Watches By Size Displayed");
                    showMenu();
                    break;
                case "11":
                    Add deviceAddMenu = new Add(device, wearable);
                    deviceAddMenu.newDevice();
                    showMenu();
                    break;
                case "12":
                    Add wearableAddMenu = new Add(device, wearable);
                    wearableAddMenu.newWearable();
                    showMenu();
                    break;
                case "13":
                    Remove deviceRemoveMenu = new Remove();
                    deviceRemoveMenu.removeDevice();
                    showMenu();
                    break;
                case "14":
                    Remove wearableRemoveMenu = new Remove();
                    wearableRemoveMenu.removeWearable();
                    showMenu();
                    break;
                case "Q":
                    System.out.println("Have a nice day!");
                    input = false;
                    Writer writer = new Writer();
                    writer.write_laptop(device.getLaptops());
                    writer.write_phone(device.getPhones());
                    writer.write_tablet(device.getTablets());
                    writer.write_smartBand(wearable.getSmartBands());
                    writer.write_smartWatch(wearable.getSmartWatches());
                    break;
                case "Menu":
                    showMenu();
                    break;
                default:
                    System.out.println("Error! Invalid input.");
            }
        }while (input);
    }

    private void showMenu() {
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

    private void displayPhones(){
        System.out.println("Phones: \n");
        ArrayList<Phone> phones = device.getPhones();
        for (Phone item : phones){
            item.deviceID();
        }
    }

    private void displayPhonesByNoOfCameras(){
        System.out.println("Phones by number of cameras: \n");
        ArrayList<Phone> phones = device.getPhones();
        phones.sort(new Comparator<Phone>() {
            @Override
            public int compare(Phone phone, Phone t1) {
                return phone.getNoOfCameras() - t1.getNoOfCameras();
            }
        });

        for (Phone item : phones) {
            item.deviceID();
        }
    }

    private void displayFoldable(){
        System.out.println("Foldable phones: \n");
        ArrayList<Phone> phones = device.getPhones();
        for (Phone item : phones){
            if (item.isFoldable() == 1)
                item.deviceID();
        }
    }

    private void displayTablets(){
        System.out.println("Tablets: \n");
        ArrayList<Tablet> tablets = device.getTablets();
        for (Tablet item : tablets){
            item.deviceID();
        }
    }

    private void displayLaptops(){
        System.out.println("Laptops: \n");
        ArrayList<Laptop> laptops = device.getLaptops();
        for (Laptop item : laptops){
            item.deviceID();
        }
    }

    private void displayLaptopsByRAM(){
        System.out.println("Laptops by RAM: \n");
        ArrayList<Laptop> laptops = device.getLaptops();
        laptops.sort(new Comparator<Laptop>() {
            @Override
            public int compare(Laptop laptop, Laptop t1) {
                return laptop.getRAM() - t1.getRAM();
            }
        });

        for (Laptop item : laptops) {
            item.deviceID();
        }
    }

    private void displayLaptopsByStorage(){
        System.out.println("Laptops by storage: \n");
        ArrayList<Laptop> laptops = device.getLaptops();
        laptops.sort(new Comparator<Laptop>() {
            @Override
            public int compare(Laptop laptop, Laptop t1) {
                return laptop.getStorage() - t1.getStorage();
            }
        });

        for (Laptop item : laptops) {
            item.deviceID();
        }
    }

    private void displaySmartBands(){
        System.out.println("SmartBands: \n");
        ArrayList<SmartBand> smartBands = wearable.getSmartBands();
        for (SmartBand item : smartBands){
            item.wearableID();
        }
    }

    private void displaySmartWatches(){
        System.out.println("SmartWatches: \n");
        ArrayList<SmartWatch> smartWatches = wearable.getSmartWatches();
        for (SmartWatch item : smartWatches){
            item.wearableID();
        }
    }

    private void displaySmartWatchesBySize(){
        System.out.println("SmartWatches by size: \n");
        List<SmartWatch> smartWatches = wearable.getSmartWatches();
        smartWatches.sort(new Comparator<SmartWatch>() {
            @Override
            public int compare(SmartWatch smartWatch, SmartWatch t1) {
                return smartWatch.getSize() - t1.getSize();
            }
        });

        for (SmartWatch item : smartWatches){
            item.wearableID();
        }
    }
}

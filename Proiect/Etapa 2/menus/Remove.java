package menus;

import device.Device;
import device.Laptop;
import device.Phone;
import device.Tablet;
import services.Audit;
import services.Writer;
import wearable.SmartBand;
import wearable.SmartWatch;
import wearable.Wearable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Remove {
    private Device device;
    private Wearable wearable;

    Audit audit = new Audit();

    public Remove() {
        this.device = new Device();
        this.wearable = new Wearable();
    }

    public void removeDevice() throws IOException {
        Scanner inDevice = new Scanner(System.in);
        System.out.println("Hello! To remove a device follow these instructions:");
        System.out.println("Choose what device you want to remove.");
        System.out.println();

        boolean input = true;
        displayRemoveDeviceMenu();
        do {
            System.out.print("Enter your choice: ");
            String choice = inDevice.nextLine();

            switch (choice.trim()){
                case "1":
                    removePhone();
                    audit.write("Phone Removed");
                    break;
                case "2":
                    removeTablet();
                    audit.write("Tablet Removed");
                    break;
                case "3":
                    removeLaptop();
                    audit.write("Laptop Removed");
                    break;
                case "S":
                    displayRemoveDeviceMenu();
                    break;
                case "B":
                    System.out.println("You will be taken to the main menu.");
                    input = false;
                    break;
                default:
                    System.out.println("Error! Invalid input.");
            }
        }while (input);
    }

    private void displayRemoveDeviceMenu(){
        System.out.println("1. Remove a phone");
        System.out.println("2. Remove a tablet");
        System.out.println("3. Remove a laptop");
        System.out.println();
        System.out.println("To show the submenu again type'S'.");
        System.out.println("To go to the main menu type 'B'.");
        System.out.println();
    }

    private void removePhone() throws IOException {
        Scanner inPhone = new Scanner(System.in);
        System.out.println("Hello! To remove a phone please enter the following:");

        System.out.print("Manufacturer: ");
        String manufacturer = inPhone.nextLine();

        System.out.print("Model: ");
        String model = inPhone.nextLine();

        ArrayList<Phone> phones = device.getPhones();
        phones.removeIf(item -> (item.getManufacturer().equals(manufacturer)) && (item.getModel().equals(model)));

        Writer addItem = new Writer();
        addItem.write_phone(device.getPhones());

        System.out.println("The phone was removed.");
    }

    private void removeTablet() throws IOException {
        Scanner inTablet = new Scanner(System.in);
        System.out.println("Hello! To remove a tablet please enter the following:");

        System.out.print("Manufacturer: ");
        String manufacturer = inTablet.nextLine();

        System.out.print("Model: ");
        String model = inTablet.nextLine();

        ArrayList<Tablet> tablets = device.getTablets();
        tablets.removeIf(item -> (item.getManufacturer().equals(manufacturer)) && (item.getModel().equals(model)));

        Writer addItem = new Writer();
        addItem.write_tablet(device.getTablets());

        System.out.println("The tablet was removed.");
    }

    private void removeLaptop() throws IOException {
        Scanner inLaptop = new Scanner(System.in);
        System.out.println("Hello! To remove a laptop please enter the following:");

        System.out.print("Manufacturer: ");
        String manufacturer = inLaptop.nextLine();

        System.out.print("Model: ");
        String model = inLaptop.nextLine();

        ArrayList<Laptop> laptops = device.getLaptops();
        laptops.removeIf(item -> (item.getManufacturer().equals(manufacturer)) && (item.getModel().equals(model)));

        Writer addItem = new Writer();
        addItem.write_laptop(device.getLaptops());

        System.out.println("The laptop was removed.");
    }

    public void removeWearable() throws IOException {
        Scanner inWearable = new Scanner(System.in);
        System.out.println("Hello! To remove a wearable follow these instructions:");
        System.out.println("Choose what wearable you want to remove.");

        boolean input = true;
        displayRemoveWearableMenu();

        do {
            System.out.print("Enter your choice: ");
            String choice = inWearable.nextLine();

            switch (choice.trim()){
                case "1":
                    removeSmartBand();
                    audit.write("Smart Band Removed");
                    displayRemoveWearableMenu();
                    break;
                case "2":
                    removeSmartWatch();
                    audit.write("Smart Watch Removed");
                    displayRemoveWearableMenu();
                    break;
                case "S":
                    displayRemoveWearableMenu();
                    break;
                case "B":
                    System.out.println("You will be taken to the main menu.");
                    input = false;
                    break;
                default:
                    System.out.println("Error! Invalid input.");
            }
        }while (input);
    }

    private void displayRemoveWearableMenu(){
        System.out.println("1. Remove a smart band");
        System.out.println("2. Remove a smart watch");
        System.out.println();
        System.out.println("To show the submenu again type 'S'.");
        System.out.println("To go to the main menu type 'B'.");
        System.out.println();
    }

    private void removeSmartBand() throws IOException {
        Scanner inSmartBand = new Scanner(System.in);
        System.out.println("Hello! To remove a smart band please enter the following:");

        System.out.print("Manufacturer:");
        String manufacturer = inSmartBand.nextLine();

        System.out.print("Model: ");
        String model = inSmartBand.nextLine();

        ArrayList<SmartBand> smartBands = wearable.getSmartBands();
        smartBands.removeIf(item -> (item.getManufacturer().equals(manufacturer)) && (item.getModel().equals(model)));

        Writer addItem = new Writer();
        addItem.write_smartBand(wearable.getSmartBands());

        System.out.println("The smart band was removed.");
    }

    private void removeSmartWatch() throws IOException {
        Scanner inSmartWatch = new Scanner(System.in);
        System.out.println("Hello! To remove a smart band please enter the following:");

        System.out.print("Manufacturer:");
        String manufacturer = inSmartWatch.nextLine();

        System.out.print("Model: ");
        String model = inSmartWatch.nextLine();

        ArrayList<SmartWatch> smartWatches = wearable.getSmartWatches();
        smartWatches.removeIf(item -> (item.getManufacturer().equals(manufacturer)) && (item.getModel().equals(model)));

        Writer addItem = new Writer();
        addItem.write_smartWatch(wearable.getSmartWatches());

        System.out.println("The smart watch was removed.");
    }
}

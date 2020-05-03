package menus;

import device.*;
import services.*;
import wearable.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Add {
    private Device device;
    private Wearable wearable;

    Audit audit = new Audit();

    public Add(Device device, Wearable wearable) {
        this.device = new Device();
        this.wearable = new Wearable();
    }

    public void newDevice() throws IOException {
        Scanner inDevice = new Scanner(System.in);
        System.out.println("Hello! To add a new device follow these instructions:");
        System.out.println("Choose what device you want to add.");
        System.out.println();

        boolean input = true;
        displayAddDeviceMenu();
        do {
            System.out.print("Enter your choice: ");
            String choice = inDevice.nextLine();

            switch (choice.trim()){
                case "1":
                    addPhone();
                    audit.write("Phone Added");
                    break;
                case "2":
                    addTablet();
                    audit.write("Tablet Added");
                    break;
                case "3":
                    addLaptop();
                    audit.write("Laptop Added");
                    break;
                case "S":
                    displayAddDeviceMenu();
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

    private void displayAddDeviceMenu(){
        System.out.println("1. Add a phone");
        System.out.println("2. Add a tablet");
        System.out.println("3. Add a laptop");
        System.out.println();
        System.out.println("To show the submenu again type'S'.");
        System.out.println("To go to the main menu type 'B'.");
        System.out.println();
    }

    private void addPhone() throws IOException {
        Scanner inPhone = new Scanner(System.in);
        System.out.println("Hello! To add a new phone please enter the following:");

        System.out.print("Manufacturer: ");
        String manufacturer = inPhone.nextLine();

        System.out.print("Model: ");
        String model = inPhone.nextLine();

        ArrayList<Phone> phones = device.getPhones();
        for (Phone item : phones) {
            if (item.getModel().equals(model)) {
                System.out.println("This phone is already in store. Please enter a different model.");
                System.out.print("Model: ");
                model = inPhone.nextLine();
            }
        }

        System.out.print("Number of cameras: ");
        int noOfCameras = inPhone.nextInt();

        System.out.println("Is it foldable? Type '1' if it is, or '0' otherwise.");
        int foldable = inPhone.nextInt();

        Phone phone = new Phone(manufacturer, model, noOfCameras, foldable);
        device.addPhone(phone);

        Writer addItem = new Writer();
        addItem.write_phone(device.getPhones());

        System.out.println("The phone was added.");
    }

    private void addTablet() throws IOException {
        Scanner inTablet = new Scanner(System.in);
        System.out.println("Hello! To add a new tablet please enter the following:");

        System.out.print("Manufacturer: ");
        String manufacturer = inTablet.nextLine();

        System.out.print("Model: ");
        String model = inTablet.nextLine();

        System.out.print("Connexion Type: ");
        String connexionType = inTablet.nextLine();

        ArrayList<Tablet> tablets = device.getTablets();
        for (Tablet item : tablets) {
            if (item.getConnexionType().equals(connexionType)) {
                System.out.println("This tablet is already in store. Please enter a different connexion type.");
                System.out.print("Connexion Type: ");
                connexionType = inTablet.nextLine();
            }
        }

        Tablet tablet = new Tablet(manufacturer, model, connexionType);
        device.addTablet(tablet);

        Writer addItem = new Writer();
        addItem.write_tablet(device.getTablets());

        System.out.println("The tablet was added.");
    }

    private void addLaptop() throws IOException {
        Scanner inLaptop = new Scanner(System.in);
        System.out.println("Hello! To add a new laptop please enter the following:");

        System.out.print("Manufacturer: ");
        String manufacturer = inLaptop.nextLine();

        System.out.print("Model: ");
        String model = inLaptop.nextLine();

        ArrayList<Laptop> laptops = device.getLaptops();
        for (Laptop item : laptops) {
            if (item.getModel().equals(model)) {
                System.out.println("This laptop is already in store. Please enter a different model.");
                System.out.print("Model: ");
                model = inLaptop.nextLine();
            }
        }

        System.out.print("RAM capacity: ");
        int RAM = inLaptop.nextInt();

        System.out.print("Storage capacity(in GB): ");
        int storage = inLaptop.nextInt();

        Laptop laptop = new Laptop(manufacturer, model, RAM, storage);
        device.addLaptop(laptop);

        Writer addItem = new Writer();
        addItem.write_laptop(device.getLaptops());

        System.out.println("The laptop was added.");
    }

    public void newWearable() throws IOException {
        Scanner inWearable = new Scanner(System.in);
        System.out.println("Hello! To add a new wearable follow these instructions:");
        System.out.println("Choose what wearable you want to add.");

        boolean input = true;
        displayAddWearableMenu();

        do {
            System.out.print("Enter your choice: ");
            String choice = inWearable.nextLine();

            switch (choice.trim()){
                case "1":
                    addSmartBand();
                    audit.write("Smart Band Added");
                    break;
                case "2":
                    addSmartWatch();
                    audit.write("Smart Watch Added");
                    break;
                case "S":
                    displayAddWearableMenu();
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

    private void displayAddWearableMenu(){
        System.out.println("1. Add a smart band");
        System.out.println("2. Add a smart watch");
        System.out.println();
        System.out.println("To show the submenu again type 'S'.");
        System.out.println("To go to the main menu type 'B'.");
        System.out.println();
    }

    private void addSmartBand() throws IOException {
        Scanner inSmartBand = new Scanner(System.in);
        System.out.println("Hello! To add a new smart band please enter the following:");

        System.out.print("Manufacturer:");
        String manufacturer = inSmartBand.nextLine();

        System.out.print("Model: ");
        String model = inSmartBand.nextLine();

        ArrayList<SmartBand> smartBands = wearable.getSmartBands();
        for (SmartBand item : smartBands) {
            if (item.getModel().equals(model)) {
                System.out.println("This smart band is already in store. Please enter a different model.");
                System.out.print("Model: ");
                model = inSmartBand.nextLine();
            }
        }

        System.out.println("Does it have a color display? Type '1' if it has, or '0' otherwise.");
        int displayType = inSmartBand.nextInt();

        SmartBand smartBand = new SmartBand(manufacturer, model, displayType);
        wearable.addSmartBand(smartBand);

        Writer addItem = new Writer();
        addItem.write_smartBand(wearable.getSmartBands());

        System.out.println("The smart band was added.");
    }

    private void addSmartWatch() throws IOException {
        Scanner inSmartWatch = new Scanner(System.in);
        System.out.println("Hello! To add a new smart band please enter the following:");

        System.out.print("Manufacturer:");
        String manufacturer = inSmartWatch.nextLine();

        System.out.print("Model: ");
        String model = inSmartWatch.nextLine();

        ArrayList<SmartWatch> smartWatches = wearable.getSmartWatches();
        for (SmartWatch item : smartWatches) {
            if (item.getModel().equals(model)) {
                System.out.println("This smart watch is already in store. Please enter a different model.");
                System.out.print("Model: ");
                model = inSmartWatch.nextLine();
            }
        }

        System.out.print("Screen size:");
        int size = inSmartWatch.nextInt();

        SmartWatch smartWatch = new SmartWatch(manufacturer, model, size);
        wearable.addSmartWatch(smartWatch);

        Writer addItem = new Writer();
        addItem.write_smartWatch(wearable.getSmartWatches());

        System.out.println("The smart watch was added.");
    }
}

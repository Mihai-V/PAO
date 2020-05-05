import device.*;
import services.Audit;
import services.CSVWriter;
import wearable.*;

import java.util.List;
import java.util.Scanner;

public class Store {
    private static Store single = null;

    public static Store getInstance() {
        if (single == null)
            single = new Store();

        return single;
    }

    public Device device;
    public Wearable wearable;

    Audit audit = new Audit();

    Store() {
        this.device = new Device();
        this.wearable = new Wearable();
    }

    public void newDevice() {
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
                    userAddPhone();
                    audit.write("Phone Added");
                    break;
                case "2":
                    userAddTablet();
                    audit.write("Tablet Added");
                    break;
                case "3":
                    userAddLaptop();
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

    public static void displayAddDeviceMenu(){
        System.out.println("1. Add a phone");
        System.out.println("2. Add a tablet");
        System.out.println("3. Add a laptop");
        System.out.println();
        System.out.println("To show the submenu again type'S'.");
        System.out.println("To go to the main menu type 'B'.");
        System.out.println();
    }

    public void newWearable() {
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
                    userAddSmartBand();
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

    public static void displayAddWearableMenu(){
        System.out.println("1. Add a smart band");
        System.out.println("2. Add a smart watch");
        System.out.println();
        System.out.println("To show the submenu again type 'S'.");
        System.out.println("To go to the main menu type 'B'.");
        System.out.println();
    }

    public void removeDevice() {
        Scanner inDevice = new Scanner(System.in);
        System.out.println("Hello! To remove a device follow these instructions:");
        System.out.println("Choose what device you want to remove.");
        System.out.println();

        Audit audit = new Audit();

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

    public static void displayRemoveDeviceMenu(){
        System.out.println("1. Remove a phone");
        System.out.println("2. Remove a tablet");
        System.out.println("3. Remove a laptop");
        System.out.println();
        System.out.println("To show the submenu again type'S'.");
        System.out.println("To go to the main menu type 'B'.");
        System.out.println();
    }

    public void removeWearable() {
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

    public static void displayRemoveWearableMenu(){
        System.out.println("1. Remove a smart band");
        System.out.println("2. Remove a smart watch");
        System.out.println();
        System.out.println("To show the submenu again type 'S'.");
        System.out.println("To go to the main menu type 'B'.");
        System.out.println();
    }


    public Phone userAddPhone() {
        Scanner inPhone = new Scanner(System.in);
        System.out.println("Hello! To add a new phone please enter the following:");

        System.out.print("Manufacturer: ");
        String manufacturer = inPhone.nextLine();

        System.out.print("Model: ");
        String model = inPhone.nextLine();

        List<Phone> phones = device.getPhones();
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

        CSVWriter addItem = new CSVWriter();
        addItem.write_phone(device.getPhones());

        System.out.println("The phone was added.");

        return phone;
    }

    public void userAddTablet() {
        Scanner inTablet = new Scanner(System.in);
        System.out.println("Hello! To add a new tablet please enter the following:");

        System.out.print("Manufacturer: ");
        String manufacturer = inTablet.nextLine();

        System.out.print("Model: ");
        String model = inTablet.nextLine();

        System.out.print("Connexion Type: ");
        String connexionType = inTablet.nextLine();

        List<Tablet> tablets = device.getTablets();
        for (Tablet item : tablets) {
            if (item.getConnexionType().equals(connexionType)) {
                System.out.println("This tablet is already in store. Please enter a different connexion type.");
                System.out.print("Connexion Type: ");
                connexionType = inTablet.nextLine();
            }
        }

        Tablet tablet = new Tablet(manufacturer, model, connexionType);
        device.addTablet(tablet);

        CSVWriter addItem = new CSVWriter();
        addItem.write_tablet(device.getTablets());

        System.out.println("The tablet was added.");

    }

    public Laptop userAddLaptop() {
        Scanner inLaptop = new Scanner(System.in);
        System.out.println("Hello! To add a new laptop please enter the following:");

        System.out.print("Manufacturer: ");
        String manufacturer = inLaptop.nextLine();

        System.out.print("Model: ");
        String model = inLaptop.nextLine();

        List<Laptop> laptops = device.getLaptops();
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

        CSVWriter addItem = new CSVWriter();
        addItem.write_laptop(device.getLaptops());

        System.out.println("The laptop was added.");

        return laptop;
    }



    public SmartBand userAddSmartBand() {
        Scanner inSmartBand = new Scanner(System.in);
        System.out.println("Hello! To add a new smart band please enter the following:");

        System.out.print("Manufacturer:");
        String manufacturer = inSmartBand.nextLine();

        System.out.print("Model: ");
        String model = inSmartBand.nextLine();

        List<SmartBand> smartBands = wearable.getSmartBands();
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

        CSVWriter addItem = new CSVWriter();
        addItem.write_smartBand(wearable.getSmartBands());

        System.out.println("The smart band was added.");

        return smartBand;
    }

    public SmartWatch addSmartWatch() {
        Scanner inSmartWatch = new Scanner(System.in);
        System.out.println("Hello! To add a new smart band please enter the following:");

        System.out.print("Manufacturer:");
        String manufacturer = inSmartWatch.nextLine();

        System.out.print("Model: ");
        String model = inSmartWatch.nextLine();

        List<SmartWatch> smartWatches = wearable.getSmartWatches();
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

        CSVWriter addItem = new CSVWriter();
        addItem.write_smartWatch(wearable.getSmartWatches());

        System.out.println("The smart watch was added.");

        return smartWatch;
    }

    private void removePhone() {
        Scanner inPhone = new Scanner(System.in);
        System.out.println("Hello! To remove a phone please enter the following:");

        System.out.print("Manufacturer: ");
        String manufacturer = inPhone.nextLine();

        System.out.print("Model: ");
        String model = inPhone.nextLine();

        List<Phone> phones = device.getPhones();
        phones.removeIf(item -> (item.getManufacturer().equals(manufacturer)) && (item.getModel().equals(model)));

        CSVWriter addItem = new CSVWriter();
        addItem.write_phone(device.getPhones());

        System.out.println("The phone was removed.");
    }

    private void removeTablet() {
        Scanner inTablet = new Scanner(System.in);
        System.out.println("Hello! To remove a tablet please enter the following:");

        System.out.print("Manufacturer: ");
        String manufacturer = inTablet.nextLine();

        System.out.print("Model: ");
        String model = inTablet.nextLine();

        List<Tablet> tablets = device.getTablets();
        tablets.removeIf(item -> (item.getManufacturer().equals(manufacturer)) && (item.getModel().equals(model)));

        CSVWriter addItem = new CSVWriter();
        addItem.write_tablet(device.getTablets());

        System.out.println("The tablet was removed.");
    }

    private void removeLaptop() {
        Scanner inLaptop = new Scanner(System.in);
        System.out.println("Hello! To remove a laptop please enter the following:");

        System.out.print("Manufacturer: ");
        String manufacturer = inLaptop.nextLine();

        System.out.print("Model: ");
        String model = inLaptop.nextLine();

        List<Laptop> laptops = device.getLaptops();
        laptops.removeIf(item -> (item.getManufacturer().equals(manufacturer)) && (item.getModel().equals(model)));

        CSVWriter addItem = new CSVWriter();
        addItem.write_laptop(device.getLaptops());

        System.out.println("The laptop was removed.");
    }



    private void removeSmartBand() {
        Scanner inSmartBand = new Scanner(System.in);
        System.out.println("Hello! To remove a smart band please enter the following:");

        System.out.print("Manufacturer:");
        String manufacturer = inSmartBand.nextLine();

        System.out.print("Model: ");
        String model = inSmartBand.nextLine();

        List<SmartBand> smartBands = wearable.getSmartBands();
        smartBands.removeIf(item -> (item.getManufacturer().equals(manufacturer)) && (item.getModel().equals(model)));

        CSVWriter addItem = new CSVWriter();
        addItem.write_smartBand(wearable.getSmartBands());

        System.out.println("The smart band was removed.");
    }

    private void removeSmartWatch() {
        Scanner inSmartWatch = new Scanner(System.in);
        System.out.println("Hello! To remove a smart band please enter the following:");

        System.out.print("Manufacturer:");
        String manufacturer = inSmartWatch.nextLine();

        System.out.print("Model: ");
        String model = inSmartWatch.nextLine();

        List<SmartWatch> smartWatches = wearable.getSmartWatches();
        smartWatches.removeIf(item -> (item.getManufacturer().equals(manufacturer)) && (item.getModel().equals(model)));

        CSVWriter addItem = new CSVWriter();
        addItem.write_smartWatch(wearable.getSmartWatches());

        System.out.println("The smart watch was removed.");
    }
}

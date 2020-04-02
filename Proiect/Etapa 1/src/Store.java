import java.io.*;
import java.util.*;

public class Store {
    private Device device;
    private Wearable wearable;

    protected Store() throws FileNotFoundException {
        this.device = new Device();
        this.wearable = new Wearable();

        File phoneStock = new File("src/phones.txt");
        Scanner phonesInStock = new Scanner(phoneStock);

        while (phonesInStock.hasNextLine()){
            String temp = phonesInStock.nextLine();
            String[] data = temp.split(", ");
            Phone phone = new Phone(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]));
            device.addPhone(phone);
        }
        phonesInStock.close();

        File tabletStock = new File("src/tablets.txt");
        Scanner tabletsInStock = new Scanner(tabletStock);

        while (tabletsInStock.hasNextLine()){
            String temp = tabletsInStock.nextLine();
            String[] data = temp.split(",");
            Tablet tablet = new Tablet(data[0], data[1], data[2]);
            device.addTablet(tablet);
        }
        tabletsInStock.close();

        File laptopStock = new File("src/laptops.txt");
        Scanner laptopsInStock = new Scanner(laptopStock);

        while (laptopsInStock.hasNextLine()){
            String temp = laptopsInStock.nextLine();
            String[] data = temp.split(", ");
            Laptop laptop = new Laptop(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]));
            device.addLaptop(laptop);
        }
        laptopsInStock.close();

        File smartBandStock = new File("src/smartbands.txt");
        Scanner smartBandsInStock = new Scanner(smartBandStock);

        while (smartBandsInStock.hasNextLine()){
            String temp = smartBandsInStock.nextLine();
            String[] data = temp.split(", ");
            SmartBand smartBand = new SmartBand(data[0], data[1], Integer.parseInt(data[2]));
            wearable.addSmartBand(smartBand);
        }
        smartBandsInStock.close();

        File smartWatchStock = new File("src/smartwatches.txt");
        Scanner smartWatchesInStock = new Scanner(smartWatchStock);

        while (smartWatchesInStock.hasNextLine()){
            String temp = smartWatchesInStock.nextLine();
            String[] data = temp.split(", ");
            SmartWatch smartWatch = new SmartWatch(data[0], data[1], Integer.parseInt(data[2]));
            wearable.addSmartWatch(smartWatch);
        }
        smartWatchesInStock.close();
    }

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
                    break;
                case "2":
                    displayPhonesByNoOfCameras();
                    break;
                case "3":
                    displayFoldable();
                    break;
                case "4":
                    displayTablets();
                    break;
                case "5":
                    displayLaptops();
                    break;
                case "6":
                    displayLaptopsByRAM();
                    break;
                case "7":
                    displayLaptopsByStorage();
                    break;
                case "8":
                    displaySmartBands();
                    break;
                case "9":
                    displaySmartWatches();
                    break;
                case "10":
                    displaySmartWatchesBySize();
                    break;
                case "11":
                    newDevice();
                    break;
                case "12":
                    newWearable();
                    break;
                case "13":
                    removeDevice();
                    break;
                case "14":
                    removeWearable();
                    break;
                case "Q":
                    System.out.println("Have a nice day!");
                    input = false;
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
        System.out.println("Welcome!\n");
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

    private void newDevice() throws IOException {
        Scanner inDevice = new Scanner(System.in);
        System.out.println("Hello! To add a new device follow these instructions:");
        System.out.println("Choose what device you want to add.");
        System.out.println();

        boolean input = true;
        displayDeviceMenu();
        do {
            System.out.print("Enter your choice: ");
            String choice = inDevice.nextLine();

            switch (choice.trim()){
                case "1":
                    addPhone();
                    break;
                case "2":
                    addTablet();
                    break;
                case "3":
                    addLaptop();
                    break;
                case "S":
                    displayDeviceMenu();
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

    private void displayDeviceMenu(){
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
        System.out.println("The phone has been added.");

        FileWriter fileWriter = new FileWriter("src/phones.txt");
        for (Phone item : phones) {
            String toWrite = item.getManufacturer() + ", " + item.getModel() + ", " + item.getNoOfCameras() + ", " + item.isFoldable();

            fileWriter.write(toWrite);
            fileWriter.write('\n');
        }
        fileWriter.close();
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
        System.out.println("The tablet has been added.");

        FileWriter fileWriter = new FileWriter("src/tablets.txt");
        for (Tablet item : tablets) {
            String toWrite = item.getManufacturer() + ", " + item.getModel() + ", " + item.getConnexionType();

            fileWriter.write(toWrite);
            fileWriter.write('\n');
        }
        fileWriter.close();
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
        System.out.println("The laptop has been added.");

        FileWriter fileWriter = new FileWriter("src/laptops.txt");
        for (Laptop item : laptops) {
            String toWrite = item.getManufacturer() + ", " + item.getModel() + ", " + item.getRAM() + ", " + item.getStorage();

            fileWriter.write(toWrite);
            fileWriter.write('\n');
        }
        fileWriter.close();
    }

    public void newWearable() throws IOException {
        Scanner inWearable = new Scanner(System.in);
        System.out.println("Hello! To add a new wearable follow these instructions:");
        System.out.println("Choose what wearable you want to add.");

        boolean input = true;
        displayWearableMenu();

        do {
            System.out.print("Enter your choice: ");
            String choice = inWearable.nextLine();

            switch (choice.trim()){
                case "1":
                    addSmartBand();
                    break;
                case "2":
                    addSmartWatch();
                    break;
                case "S":
                    displayWearableMenu();
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

    private void displayWearableMenu(){
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
        System.out.println("The smart band has been added.");

        FileWriter fileWriter = new FileWriter("src/smartbands.txt");
        for (SmartBand item : smartBands) {
            String toWrite = item.getManufacturer() + ", " + item.getModel() + ", " + item.getDisplayType();

            fileWriter.write(toWrite);
            fileWriter.write('\n');
        }
        fileWriter.close();
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
        System.out.println("The smart watch has been added.");

        FileWriter fileWriter = new FileWriter("src/smartwatches.txt");
        for (SmartWatch item : smartWatches) {
            String toWrite = item.getManufacturer() + ", " + item.getModel() + ", " + item.getSize();

            fileWriter.write(toWrite);
            fileWriter.write('\n');
        }
        fileWriter.close();
    }

    private void removeDevice() throws IOException {
        Scanner inDevice = new Scanner(System.in);
        System.out.println("Hello! To remove a device follow these instructions:");
        System.out.println("Choose what device you want to remove.");
        System.out.println();

        boolean input = true;
        displayDeviceMenu();
        do {
            System.out.print("Enter your choice: ");
            String choice = inDevice.nextLine();

            switch (choice.trim()){
                case "1":
                    removePhone();
                    break;
                case "2":
                    removeTablet();
                    break;
                case "3":
                    removeLaptop();
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

        FileWriter fileWriter = new FileWriter("src/phones.txt");
        for (Phone item : phones) {
            String toWrite = item.getManufacturer() + ", " + item.getModel() + ", " + item.getNoOfCameras() + ", " + item.isFoldable();

            fileWriter.write(toWrite);
            fileWriter.write('\n');
        }
        fileWriter.close();
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

        FileWriter fileWriter = new FileWriter("src/tablets.txt");
        for (Tablet item : tablets) {
            String toWrite = item.getManufacturer() + ", " + item.getModel() + ", " + item.getConnexionType();

            fileWriter.write(toWrite);
            fileWriter.write('\n');
        }
        fileWriter.close();
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

        FileWriter fileWriter = new FileWriter("src/laptops.txt");
        for (Laptop item : laptops) {
            String toWrite = item.getManufacturer() + ", " + item.getModel() + ", " + item.getRAM() + ", " + item.getStorage();

            fileWriter.write(toWrite);
            fileWriter.write('\n');
        }
        fileWriter.close();
    }

    public void removeWearable() throws IOException {
        Scanner inWearable = new Scanner(System.in);
        System.out.println("Hello! To remove a wearable follow these instructions:");
        System.out.println("Choose what wearable you want to remove.");

        boolean input = true;
        displayWearableMenu();

        do {
            System.out.print("Enter your choice: ");
            String choice = inWearable.nextLine();

            switch (choice.trim()){
                case "1":
                    removeSmartBand();
                    break;
                case "2":
                    removeSmartWatch();
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

        FileWriter fileWriter = new FileWriter("src/smartbands.txt");
        for (SmartBand item : smartBands) {
            String toWrite = item.getManufacturer() + ", " + item.getModel() + ", " + item.getDisplayType();

            fileWriter.write(toWrite);
            fileWriter.write('\n');
        }
        fileWriter.close();
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

        FileWriter fileWriter = new FileWriter("src/smartwatches.txt");
        for (SmartWatch item : smartWatches) {
            String toWrite = item.getManufacturer() + ", " + item.getModel() + ", " + item.getSize();

            fileWriter.write(toWrite);
            fileWriter.write('\n');
        }
        fileWriter.close();
    }
}

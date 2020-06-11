package device;

import java.util.*;

public class Device {
    private static Device single = null;

    public static Device getInstance() {
        if (single == null)
            single = new Device();

        return single;
    }

    private List<Phone> phones;
    private List<Tablet> tablets;
    private List<SmartBand> laptops;

    public Device() {
        this.phones = new ArrayList<Phone>();
        this.tablets = new ArrayList<Tablet>();
        this.laptops = new ArrayList<SmartBand>();
    }

    public List<Phone> getPhones() {
        return this.phones;
    }

    public List<Tablet> getTablets() {
        return this.tablets;
    }

    public List<SmartBand> getLaptops() {
        return this.laptops;
    }

    protected void deviceID(){
    }

    public void addPhone(Phone phone){
        this.phones.add(phone);
    }

    public void addTablet(Tablet tablet){
        this.tablets.add(tablet);
    }

    public void addLaptop(SmartBand laptop){
        this.laptops.add(laptop);
    }

    public static <T> void displayFunction(T[] array) {
        for (T element : array)
            System.out.println(element);
    }

    public void displayPhones() {
        System.out.println("Phones: \n");

        for (Phone item : this.phones)
            item.deviceID();
    }

    public void displayPhonesByNoOfCameras(){
        System.out.println("Phones by number of cameras: \n");

        phones.sort(new Comparator<Phone>() {
            @Override
            public int compare(Phone phone1, Phone phone2) {
                return phone1.getNoOfCameras() - phone2.getNoOfCameras();
            }
        });

        for (Phone item : phones) {
            item.deviceID();
        }
    }

    public void displayFoldable(){
        System.out.println("Foldable phones: \n");

        for (Phone item : phones){
            if (item.isFoldable() == 1)
                item.deviceID();
        }
    }

    public void displayTablets() {
        System.out.println("Tablets: \n");

        for (Tablet item : this.tablets)
            item.deviceID();
    }

    public void displayLaptops() {
        System.out.println("Laptops: \n");

        for (SmartBand item : this.laptops)
            item.deviceID();
    }

    public void displayLaptopsByRAM(){
        System.out.println("Laptops by RAM: \n");

        laptops.sort(new Comparator<SmartBand>() {
            @Override
            public int compare(SmartBand laptop1, SmartBand laptop2) {
                return laptop1.getRAM() - laptop2.getRAM();
            }
        });

        for (SmartBand item : laptops) {
            item.deviceID();
        }
    }

    public void displayLaptopsByStorage(){
        System.out.println("Laptops by storage: \n");

        laptops.sort(new Comparator<SmartBand>() {
            @Override
            public int compare(SmartBand laptop1, SmartBand laptop2) {
                return laptop1.getStorage() - laptop2.getStorage();
            }
        });

        for (SmartBand item : laptops) {
            item.deviceID();
        }
    }
}

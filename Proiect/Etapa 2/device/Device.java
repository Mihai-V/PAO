package device;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Device {
    private static Device single = null;

    public static Device getInstance() {
        if (single == null)
            single = new Device();

        return single;
    }

    private List<Phone> phones;
    private List<Tablet> tablets;
    private List<Laptop> laptops;

    public Device() {
        this.phones = new ArrayList<Phone>();
        this.tablets = new ArrayList<Tablet>();
        this.laptops = new ArrayList<Laptop>();
    }

    public List<Phone> getPhones() {
        return this.phones;
    }

    public List<Tablet> getTablets() {
        return this.tablets;
    }

    public List<Laptop> getLaptops() {
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

    public void addLaptop(Laptop laptop){
        this.laptops.add(laptop);
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
            public int compare(Phone phone, Phone t1) {
                return phone.getNoOfCameras() - t1.getNoOfCameras();
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

        for (Laptop item : this.laptops)
            item.deviceID();
    }

    public void displayLaptopsByRAM(){
        System.out.println("Laptops by RAM: \n");

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

    public void displayLaptopsByStorage(){
        System.out.println("Laptops by storage: \n");

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
}


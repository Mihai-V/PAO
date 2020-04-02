import java.util.ArrayList;

public class Device {
    private ArrayList<Phone> phones;
    private ArrayList<Tablet> tablets;
    private ArrayList<Laptop> laptops;

    public Device() {
        this.phones = new ArrayList<Phone>();
        this.tablets = new ArrayList<Tablet>();
        this.laptops = new ArrayList<Laptop>();
    }

    public ArrayList<Phone> getPhones() {
        return phones;
    }

    public ArrayList<Tablet> getTablets() {
        return tablets;
    }

    public ArrayList<Laptop> getLaptops() {
        return laptops;
    }

    protected void deviceID(){
    }

    public void addPhone(Phone phone){
        phones.add(phone);
    }

    public void addTablet(Tablet tablet){
        tablets.add(tablet);
    }

    public void addLaptop(Laptop laptop){
        laptops.add(laptop);
    }
}


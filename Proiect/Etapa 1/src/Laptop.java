public class Laptop extends Device {
    private String manufacturer;
    private String model;
    private int RAM;
    private int storage;

    public Laptop(String manufacturer, String model, int RAM, int storage){
        this.manufacturer = manufacturer;
        this.model = model;
        this.RAM = RAM;
        this.storage = storage;
    }

    @Override
    protected void deviceID() {
        System.out.println("Laptop: " + this.getManufacturer() + " " + this.getModel());
        System.out.println("RAM: " + this.RAM + "GB");
        System.out.print("Storage: ");
        if (this.storage < 1024)
            System.out.println(this.storage + "GB");
        else
            System.out.println(this.storage/1024 + "TB");
        System.out.println();
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getRAM() {
        return RAM;
    }

    public int getStorage() {
        return storage;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }
}

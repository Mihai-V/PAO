public class SmartWatch extends Wearable {
    private String manufacturer;
    private String model;
    private int size;

    public SmartWatch(String manufacturer, String model, int size){
        this.manufacturer = manufacturer;
        this.model = model;
        this.size = size;
    }

    @Override
    protected void wearableID() {
        System.out.println("Smartwatch: " + this.getManufacturer() + " " + this.getModel());
        System.out.println("Size: " + this.size + "mm");
        System.out.println();
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getSize() {
        return size;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

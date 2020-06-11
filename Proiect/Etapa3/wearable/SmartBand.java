package wearable;

public class SmartBand extends Wearable {
    private String manufacturer;
    private String model;
    private int displayType;

    public SmartBand(String manufacturer, String model, int displayType){
        this.manufacturer = manufacturer;
        this.model = model;
        this.displayType = displayType;
    }

    @Override
    public void wearableID() {
        System.out.println("Smartwatch: " + this.getManufacturer() + " " + this.getModel());
        System.out.print("Display type: ");
        if (displayType == 1)
            System.out.println("Color");
        else
            System.out.println("Monochrome");
        System.out.println();
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getDisplayType() {
        return displayType;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setDisplayType(int displayType) {
        this.displayType = displayType;
    }
}

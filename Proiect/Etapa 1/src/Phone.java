public class Phone extends Device {
    private String manufacturer;
    private String model;
    private int noOfCameras;
    private int foldable;

    public Phone(String manufacturer, String model, int noOfCameras, int foldable) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.noOfCameras = noOfCameras;
        this.foldable = foldable;
    }

    @Override
    protected void deviceID() {
        System.out.println("Phone: " + this.getManufacturer() + " " + this.getModel());
        System.out.println("Cameras: " + this.getNoOfCameras());
        System.out.print("Foldable: ");
        if (this.isFoldable() == 1)
            System.out.println("Yes");
        else
            System.out.println("No");
        System.out.println();
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getNoOfCameras() {
        return noOfCameras;
    }

    public int isFoldable() {
        return foldable;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setNoOfCameras(int noOfCameras) {
        this.noOfCameras = noOfCameras;
    }

    public void setFoldable(int foldable) {
        this.foldable = foldable;
    }
}

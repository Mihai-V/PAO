package device;

public class Tablet extends Device {
    private String manufacturer;
    private String model;
    private String connexionType;

    public Tablet(String manufacturer, String model, String connexionType){
        this.manufacturer = manufacturer;
        this.model = model;
        this.connexionType = connexionType;
    }

    @Override
    public void deviceID() {
        System.out.println("device.Tablet: " + this.getManufacturer() + " " + this.getModel());
        System.out.println("Connexion type: " + this.connexionType);
        System.out.println();
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public String getConnexionType() {
        return connexionType;
    }

    public void setConnexionType(String connexionType) {
        this.connexionType = connexionType;
    }
}

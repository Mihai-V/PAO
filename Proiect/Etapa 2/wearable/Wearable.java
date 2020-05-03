package wearable;

import java.util.ArrayList;

public class Wearable {
    private ArrayList<SmartBand> smartBands;
    private ArrayList<SmartWatch> smartWatches;

    public Wearable() {
        this.smartBands = new ArrayList<SmartBand>();
        this.smartWatches = new ArrayList<SmartWatch>();
    }

    public ArrayList<SmartBand> getSmartBands() {
        return smartBands;
    }

    public ArrayList<SmartWatch> getSmartWatches() {
        return smartWatches;
    }

    protected void wearableID(){}

    public void setSmartBands(ArrayList<SmartBand> smartBands) {
        this.smartBands = smartBands;
    }

    public void setSmartWatches(ArrayList<SmartWatch> smartWatches) {
        this.smartWatches = smartWatches;
    }

    public void addSmartBand(SmartBand smartBand){
        smartBands.add(smartBand);
    }

    public void addSmartWatch(SmartWatch smartWatch){
        smartWatches.add(smartWatch);
    }
}

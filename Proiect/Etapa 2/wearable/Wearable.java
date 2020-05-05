package wearable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Wearable {
    private List<SmartBand> smartBands;
    private List<SmartWatch> smartWatches;

    public Wearable() {
        this.smartBands = new ArrayList<SmartBand>();
        this.smartWatches = new ArrayList<SmartWatch>();
    }

    public List<SmartBand> getSmartBands() {
        return smartBands;
    }

    public List<SmartWatch> getSmartWatches() {
        return smartWatches;
    }

    protected void wearableID() {}

    public void setSmartBands(List<SmartBand> smartBands) {
        this.smartBands = smartBands;
    }

    public void setSmartWatches(List<SmartWatch> smartWatches) {
        this.smartWatches = smartWatches;
    }

    public void addSmartBand(SmartBand smartBand) {
        smartBands.add(smartBand);
    }

    public void addSmartWatch(SmartWatch smartWatch) {
        smartWatches.add(smartWatch);
    }

    public void displaySmartBands(){
        System.out.println("SmartBands: \n");

        for (SmartBand item : smartBands){
            item.wearableID();
        }
    }

    public void displaySmartWatches(){
        System.out.println("SmartWatches: \n");

        for (SmartWatch item : smartWatches){
            item.wearableID();
        }
    }

    public void displaySmartWatchesBySize(){
        System.out.println("SmartWatches by size: \n");

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
}

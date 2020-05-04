package services;

import device.*;
import wearable.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Writer {
    private static Writer writer_instance = null;

    public static Writer getInstance() {
        if (writer_instance == null)
            writer_instance = new Writer();

        return writer_instance;
    }

    public void write_phone(ArrayList<Phone> phones) {
        try {
            File inPhone = new File("src/files/phones.csv");
            inPhone.createNewFile();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        try {
            FileWriter writer = new FileWriter("src/files/phones.csv");
            writer.write("\n");

            for (Phone item : phones)
                writer.write(item.getManufacturer() + ", " + item.getModel() + ", " + item.getNoOfCameras() + ", " + item.isFoldable());

            writer.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void write_tablet (ArrayList<Tablet> tablets) {
        try {
            File inTablet = new File("src/files/tablets.csv");
            inTablet.createNewFile();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }

        try {
            FileWriter writer = new FileWriter("src/files/tablets.csv");
            writer.write("\n");

            for (Tablet item : tablets)
                writer.write(item.getManufacturer() + ", " + item.getModel() + ", " + item.getConnexionType());

            writer.close();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void write_laptop (ArrayList<Laptop> laptops) {
        try {
            File inTablet = new File("src/files/laptops.csv");
            inTablet.createNewFile();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }

        try {
            FileWriter writer = new FileWriter("src/files/laptops.csv");
            writer.write("\n");

            for (Laptop item : laptops)
                writer.write(item.getManufacturer() + ", " + item.getModel() + ", " + item.getRAM() + ", " + item.getStorage());

            writer.close();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void write_smartBand (ArrayList<SmartBand> smartBands) {
        try {
            File inTablet = new File("src/files/smartbands.csv");
            inTablet.createNewFile();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }

        try {
            FileWriter writer = new FileWriter("src/files/smartbands.csv");
            writer.write("\n");

            for (SmartBand item : smartBands)
                writer.write(item.getManufacturer() + ", " + item.getModel() + ", " + item.getDisplayType());

            writer.close();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void write_smartWatch (ArrayList<SmartWatch> smartWatches) {
        try {
            File inTablet = new File("src/files/smartwatches.csv");
            inTablet.createNewFile();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }

        try {
            FileWriter writer = new FileWriter("src/files/smartwatches.csv");
            writer.write("\n");

            for (SmartWatch item : smartWatches)
                writer.write(item.getManufacturer() + ", " + item.getModel() + ", " + item.getSize());

            writer.close();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}

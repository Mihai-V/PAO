package services;

import device.*;
import wearable.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CSVWriter {
    private static CSVWriter CSVWriter_instance = null;

    public static CSVWriter getInstance() {
        if (CSVWriter_instance == null)
            CSVWriter_instance = new CSVWriter();

        return CSVWriter_instance;
    }

    public void write_phone(List<Phone> phones) {
        try {
            File inPhone = new File("src/files/phones.csv");
            inPhone.createNewFile();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        try {
            java.io.FileWriter fileWriter = new java.io.FileWriter("src/files/phones.csv");

            for (Phone item : phones)
                fileWriter.write(item.getManufacturer() + ", " + item.getModel() + ", " + item.getNoOfCameras() + ", " + item.isFoldable() + "\n");

            fileWriter.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void write_tablet (List<Tablet> tablets) {
        try {
            File inTablet = new File("src/files/tablets.csv");
            inTablet.createNewFile();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }

        try {
            java.io.FileWriter fileWriter = new java.io.FileWriter("src/files/tablets.csv");

            for (Tablet item : tablets)
                fileWriter.write(item.getManufacturer() + ", " + item.getModel() + ", " + item.getConnexionType() + "\n");

            fileWriter.close();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void write_laptop (List<Laptop> laptops) {
        try {
            File inTablet = new File("src/files/laptops.csv");
            inTablet.createNewFile();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }

        try {
            java.io.FileWriter fileWriter = new java.io.FileWriter("src/files/laptops.csv");

            for (Laptop item : laptops)
                fileWriter.write(item.getManufacturer() + ", " + item.getModel() + ", " + item.getRAM() + ", " + item.getStorage() + "\n");

            fileWriter.close();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void write_smartBand (List<SmartBand> smartBands) {
        try {
            File inTablet = new File("src/files/smartbands.csv");
            inTablet.createNewFile();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }

        try {
            java.io.FileWriter fileWriter = new java.io.FileWriter("src/files/smartbands.csv");

            for (SmartBand item : smartBands)
                fileWriter.write(item.getManufacturer() + ", " + item.getModel() + ", " + item.getDisplayType() + "\n");

            fileWriter.close();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void write_smartWatch (List<SmartWatch> smartWatches) {
        try {
            File inTablet = new File("src/files/smartwatches.csv");
            inTablet.createNewFile();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }

        try {
            java.io.FileWriter fileWriter = new java.io.FileWriter("src/files/smartwatches.csv");

            for (SmartWatch item : smartWatches)
                fileWriter.write(item.getManufacturer() + ", " + item.getModel() + ", " + item.getSize() + "\n");

            fileWriter.close();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}

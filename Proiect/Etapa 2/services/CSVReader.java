package services;

import device.*;
import wearable.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    private static CSVReader CSVReader_instance = null;

    public static CSVReader getInstance() {
        if (CSVReader_instance == null)
            CSVReader_instance = new CSVReader();

        return CSVReader_instance;
    }

    public List<Phone> read_phone() {
        List<Phone> phones = new ArrayList<Phone>();

        try {
            RandomAccessFile phoneStock = new RandomAccessFile("src/files/phones.csv", "r");
            String phonesInStock;

            while ((phonesInStock = phoneStock.readLine()) != null){
                String[] data = phonesInStock.split(", ");
                Phone phone = new Phone(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]));
                phones.add(phone);
            }
            phoneStock.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return phones;
    }

    public List<Tablet> read_tablet() {
        List<Tablet> tablets = new ArrayList<Tablet>();

        try{
            RandomAccessFile tabletStock = new RandomAccessFile("src/files/tablets.csv", "r");
            String tabletsInStock;

            while ((tabletsInStock = tabletStock.readLine()) != null){
                String[] data = tabletsInStock.split(", ");
                Tablet tablet = new Tablet(data[0], data[1], data[2]);
                tablets.add(tablet);
            }
            tabletStock.close();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }

        return tablets;
    }

    public List<Laptop> read_laptop() {
        List<Laptop> laptops = new ArrayList<Laptop>();

        try {
            RandomAccessFile laptopStock = new RandomAccessFile("src/files/laptops.csv", "r");
            String laptopsInStock;

            while ((laptopsInStock = laptopStock.readLine()) != null) {
                String[] data = laptopsInStock.split(", ");
                Laptop laptop = new Laptop(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]));
                laptops.add(laptop);
            }
            laptopStock.close();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }

        return laptops;
    }

    public List<SmartBand> read_smartBand() {
        List<SmartBand> smartBands = new ArrayList<SmartBand>();

        try {
            RandomAccessFile smartBandStock = new RandomAccessFile("src/files/smartbands.csv", "r");
            String smartBandsInStock;

            while ((smartBandsInStock = smartBandStock.readLine()) != null){
                String[] data = smartBandsInStock.split(", ");
                SmartBand smartBand = new SmartBand(data[0], data[1], Integer.parseInt(data[2]));
                smartBands.add(smartBand);
            }
            smartBandStock.close();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }

        return smartBands;
    }

    public List<SmartWatch> read_smartWatch() {
        List<SmartWatch> smartWatches = new ArrayList<SmartWatch>();

        try {
            RandomAccessFile smartWatchStock = new RandomAccessFile("src/files/smartwatches.csv", "r");
            String smartWatchesInStock;

            while ((smartWatchesInStock = smartWatchStock.readLine()) != null){
                String[] data = smartWatchesInStock.split(", ");
                SmartWatch smartWatch = new SmartWatch(data[0], data[1], Integer.parseInt(data[2]));
                smartWatches.add(smartWatch);
            }
            smartWatchStock.close();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }

        return smartWatches;
    }
}

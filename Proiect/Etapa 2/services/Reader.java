package services;

import device.*;
import wearable.*;

import java.io.*;
import java.util.ArrayList;
import java.util.RandomAccess;
import java.util.Scanner;
import java.util.SplittableRandom;

public class Reader {
    private static Reader reader_instance = null;

    public static Reader getInstance() {
        if (reader_instance == null)
            reader_instance = new Reader();

        return reader_instance;
    }

    public ArrayList<Phone> read_phone() {
        ArrayList<Phone> phones = new ArrayList<Phone>();

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

    public ArrayList<Tablet> read_tablet() {
        ArrayList<Tablet> tablets = new ArrayList<Tablet>();

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

    public ArrayList<Laptop> read_laptop() {
        ArrayList<Laptop> laptops = new ArrayList<Laptop>();

        try {
            RandomAccessFile laptopStock = new RandomAccessFile("src/files/laptops.csv", "r");
            String laptopsInStock;

            while ((laptopsInStock = laptopStock.readLine()) != null){
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

    public ArrayList<SmartBand> read_smartBand() {
        ArrayList<SmartBand> smartBands = new ArrayList<SmartBand>();

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

    public ArrayList<SmartWatch> read_smartWatch() {
        ArrayList<SmartWatch> smartWatches = new ArrayList<SmartWatch>();

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

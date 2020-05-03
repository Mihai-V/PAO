package services;

import device.*;
import wearable.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

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
            File phoneStock = new File("src/files/phones.csv");
            Scanner phonesInStock = new Scanner(phoneStock);

            while (phonesInStock.hasNextLine()){
                String temp = phonesInStock.nextLine();
                String[] data = temp.split(", ");
                Phone phone = new Phone(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]));
                phones.add(phone);
            }
            phonesInStock.close();
        }
        catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }

        return phones;
    }

    public ArrayList<Tablet> read_tablet() {
        ArrayList<Tablet> tablets = new ArrayList<Tablet>();

        try{
            File tabletStock = new File("src/files/tablets.csv");
            Scanner tabletsInStock = new Scanner(tabletStock);

            while (tabletsInStock.hasNextLine()){
                String temp = tabletsInStock.nextLine();
                String[] data = temp.split(",");
                Tablet tablet = new Tablet(data[0], data[1], data[2]);
                tablets.add(tablet);
            }
            tabletsInStock.close();
        }
        catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }

        return tablets;
    }

    public ArrayList<Laptop> read_laptop() {
        ArrayList<Laptop> laptops = new ArrayList<Laptop>();

        try {
            File laptopStock = new File("src/files/laptops.csv");
            Scanner laptopsInStock = new Scanner(laptopStock);

            while (laptopsInStock.hasNextLine()){
                String temp = laptopsInStock.nextLine();
                String[] data = temp.split(", ");
                Laptop laptop = new Laptop(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]));
                laptops.add(laptop);
            }
            laptopsInStock.close();
        }
        catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }

        return laptops;
    }

    public ArrayList<SmartBand> read_smartBand() {
        ArrayList<SmartBand> smartBands = new ArrayList<SmartBand>();

        try {
            File smartBandStock = new File("src/files/smartbands.csv");
            Scanner smartBandsInStock = new Scanner(smartBandStock);

            while (smartBandsInStock.hasNextLine()){
                String temp = smartBandsInStock.nextLine();
                String[] data = temp.split(", ");
                SmartBand smartBand = new SmartBand(data[0], data[1], Integer.parseInt(data[2]));
                smartBands.add(smartBand);
            }
            smartBandsInStock.close();
        }
        catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }

        return smartBands;
    }

    public ArrayList<SmartWatch> read_smartWatch() {
        ArrayList<SmartWatch> smartWatches = new ArrayList<SmartWatch>();

        try {
            File smartWatchStock = new File("src/files/smartwatches.csv");
            Scanner smartWatchesInStock = new Scanner(smartWatchStock);

            while (smartWatchesInStock.hasNextLine()){
                String temp = smartWatchesInStock.nextLine();
                String[] data = temp.split(", ");
                SmartWatch smartWatch = new SmartWatch(data[0], data[1], Integer.parseInt(data[2]));
                smartWatches.add(smartWatch);
            }
            smartWatchesInStock.close();
        }
        catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }

        return smartWatches;
    }
}

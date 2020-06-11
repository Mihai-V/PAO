package gui;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Date;

public class AuditGUI implements Runnable {
    private static AuditGUI instance;

    public void run(){
        try {
            Files.write(Paths.get("auditGUI.csv"), (Thread.currentThread().getName() + "\n").getBytes(), StandardOpenOption.APPEND);
        }
        catch (IOException exception){
            exception.getMessage();
        }
    }

    public AuditGUI(){}

    public static AuditGUI getInstance(){
        if (instance == null)
            instance = new AuditGUI();

        return instance;
    }

    public static void fileWriter(Thread thread){
        System.out.println(Thread.currentThread().getName()+ "\n");
    }

    public void fileWriter(int choice){
        String s = "";

        switch (choice){
            case 1:
                s = "Display phones from database";
                break;
            case 2:
                s = "Display phones by number of cameras from database";
                break;
            case 3:
                s = "Display foldable phones from database";
                break;
            case 4:
                s = "Display tablets from database";
                break;
            case 5:
                s = "Display laptops from database";
                break;
            case 6:
                s = "Display laptps by RAM from database";
                break;
            case 7:
                s = "Display laptops by storage from database";
                break;
            case 8:
                s = "Display SmartBands from database";
                break;
            case 9:
                s = "Display SmartWatches from database";
                break;
            case 10:
                s = "Display SmartWatches by size from database";
                break;
            case 11:
                s = "Add device to database";
                break;
            case 12:
                s = "Add wearable to database";
                break;
            case 13:
                s = "Remove device from database";
                break;
            case 14:
                s = "Remove wearable from database";
                break;
        }

        Date date = new Date();

        try {
            File file = new File("auditGUI.csv");
            file.createNewFile();
        }
        catch (IOException exception){
            exception.getMessage();
        }

        try {
            Files.write(Paths.get("auditGUI.csv"), (s + ", " + date + "\n").getBytes(), StandardOpenOption.APPEND);
        }
        catch (IOException exception){
            exception.getMessage();
        }
    }
}

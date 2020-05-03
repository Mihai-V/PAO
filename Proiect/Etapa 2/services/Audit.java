package services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;

public class Audit {
    private static Audit instance = null;

    public static Audit getInstance(){
        if (instance == null)
            instance = new Audit();
        return instance;
    }

    private static PrintWriter printWriter;
    private static final String LOG = "src/files/audit.csv";

    public Audit() {
        try {
            printWriter = new PrintWriter(new File(LOG));
        }
        catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                close();
            }
        });
    }

    public void write (String message) {
        Date date = new Date();
        printWriter.println(message + "," + date);
    }

    public void close() {
        printWriter.flush();
        printWriter.close();
    }
}

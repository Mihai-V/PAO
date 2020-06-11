package DBservices;

import wearable.SmartWatch;

import java.sql.*;

public class SmartWatchDB {
    public void createTable(){
        try {
            Class.forName("apache.Driver");
        }
        catch (Exception exception){
            exception.getMessage();
        }

        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clients?autoReconnect=true&useSSL=false", "root", "");
            Statement statement = null;
            statement = connection.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS laptop("
                    + "id INT NOT NULL,"
                    + "manufacturer VARCHAR(30) NOT NULL,"
                    + "model VARCHAR(30) NOT NULL,"
                    + "size INT NOT NULL,"
                    + "PRIMARY KEY (id)) ";

            statement.execute(sql);
            connection.close();
        }
        catch (SQLException exception){
            System.out.println("SQL Exception: " + exception.getMessage());
            System.out.println("SQL State: " + exception.getSQLState());
            System.out.println("Vendor Error: " + exception.getErrorCode());
        }
    }

    public void addSmartWatch(SmartWatch smartWatch){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (Exception exception){
            exception.getMessage();
        }

        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clients?autoReconnect=true&useSSL=false", "root", "");
            Statement statement = null;
            statement = connection.createStatement();
            String sql = "INSERT INTO smartwatch (manufacturer, model, size) VALUES ("+
                    smartWatch.getManufacturer()+","+
                    smartWatch.getModel()+","+
                    smartWatch.getSize()+");";
            statement.execute(sql);
            connection.close();
        }
        catch (SQLException exception){
            System.out.println("SQL Exception: " + exception.getMessage());
            System.out.println("SQL State: " + exception.getSQLState());
            System.out.println("Vendor Error: " + exception.getErrorCode());
        }
    }

    public void removesmartWatch(SmartWatch smartWatch){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (Exception exception){
            exception.getMessage();
        }

        Connection connection = null;

        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clients?autoReconnect=true&useSSL=false", "root", "");
            Statement statement = null;
            statement = connection.createStatement();
            String sql = "DELETE FROM smartwatch WHERE model = '" + smartWatch.getModel() + "';create table smartwatch(	model int);";
            statement.execute(sql);
            connection.close();
        }
        catch (SQLException exception){
            System.out.println("SQL Exception: " + exception.getMessage());
            System.out.println("SQL State: " + exception.getSQLState());
            System.out.println("Vendor Error: " + exception.getErrorCode());
        }
    }

    public void displaySmartWatch(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (Exception exception){
            exception.getMessage();
        }

        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clients?autoReconnect=true&useSSL=false", "root", "");
            Statement statement = null;
            statement = connection.createStatement();
            String sql = "SELECT * FROM smartwatch";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String manufacturer = resultSet.getString("manufacturer");
                String model = resultSet.getString("model");
                int size = resultSet.getInt("size");

                System.out.println("Laptop:\n" + manufacturer + " " + model + "\n" + "Size: " + size + "\n\n");
            }

            resultSet.close();
            connection.close();
        }
        catch (SQLException exception){
            System.out.println("SQL Exception: " + exception.getMessage());
            System.out.println("SQL State: " + exception.getSQLState());
            System.out.println("Vendor Error: " + exception.getErrorCode());
        }
    }

    public void updateSmartWatch(SmartWatch smartWatch){
        try{
            Class.forName("");
        }
        catch (Exception exception){
            exception.getMessage();
        }

        Connection connection = null;

        try{
            connection = DriverManager.getConnection("", "", "");
            Statement statement = null;
            statement = connection.createStatement();
            String sql = "UPDATE smartwatch" + "SET size = 40 WHERE model ='" + smartWatch.getModel() + "';";
            statement.execute(sql);
            connection.close();
        }
        catch (SQLException exception){
            System.out.println("SQL Exception: " + exception.getMessage());
            System.out.println("SQL State: " + exception.getSQLState());
            System.out.println("Vendor Error: " + exception.getErrorCode());
        }
    }
}

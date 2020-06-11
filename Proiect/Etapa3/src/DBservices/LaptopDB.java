package DBservices;

import device.SmartBand;

import java.sql.*;

public class LaptopDB {
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
                    + "RAM INT NOT NULL,"
                    + "storage INT NOT NULL,"
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

    public void addLaptop(SmartBand laptop){
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
            String sql = "INSERT INTO laptop (ID, manufacturer, model, RAM, storage) VALUES ("+
                    laptop.getManufacturer()+","+
                    laptop.getModel()+","+
                    laptop.getRAM()+","+
                    laptop.getStorage()+");";
            statement.execute(sql);
            connection.close();
        }
        catch (SQLException exception){
            System.out.println("SQL Exception: " + exception.getMessage());
            System.out.println("SQL State: " + exception.getSQLState());
            System.out.println("Vendor Error: " + exception.getErrorCode());
        }
    }

    public void removeLaptop(SmartBand laptop){
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
            String sql = "DELETE FROM laptop WHERE model = '" + laptop.getModel() + "';";
            statement.execute(sql);
            connection.close();
        }
        catch (SQLException exception){
            System.out.println("SQL Exception: " + exception.getMessage());
            System.out.println("SQL State: " + exception.getSQLState());
            System.out.println("Vendor Error: " + exception.getErrorCode());
        }
    }

    public void displayLaptop(){
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
            String sql = "SELECT * FROM laptop";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String manufacturer = resultSet.getString("manufacturer");
                String model = resultSet.getString("model");
                int RAM = resultSet.getInt("RAM");
                int storage = resultSet.getInt("storage");

                System.out.println("Laptop:\n" + manufacturer + " " + model + "\n" + "RAM: " + RAM + "\n" + "Storage: " + storage + "\n\n");
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

    public void updateLaptop(SmartBand laptop){
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
            String sql = "UPDATE laptop" + "SET storage = 2049 WHERE model ='" + laptop.getModel() + "';";
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

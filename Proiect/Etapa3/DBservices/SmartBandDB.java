package DBservices;

import device.SmartBand;

import java.sql.*;

public class SmartBandDB {
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
                    + "display_type INT NOT NULL,"
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

    public void addSmartBand(SmartBand smartBand){
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
            String sql = "INSERT INTO smartBand (manufacturer, model, display_type) VALUES ("+
                    smartBand.getManufacturer()+","+
                    smartBand.getModel()+","+
                    smartBand.getRAM()+","+
                    smartBand.getStorage()+");";
            statement.execute(sql);
            connection.close();
        }
        catch (SQLException exception){
            System.out.println("SQL Exception: " + exception.getMessage());
            System.out.println("SQL State: " + exception.getSQLState());
            System.out.println("Vendor Error: " + exception.getErrorCode());
        }
    }

    public void removeSmartBand(SmartBand smartBand){
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
            String sql = "DELETE FROM smartband WHERE model = '" + smartBand.getModel() + "';";
            statement.execute(sql);
            connection.close();
        }
        catch (SQLException exception){
            System.out.println("SQL Exception: " + exception.getMessage());
            System.out.println("SQL State: " + exception.getSQLState());
            System.out.println("Vendor Error: " + exception.getErrorCode());
        }
    }

    public void displaySmartBand(){
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
            String sql = "SELECT * FROM smartband";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String manufacturer = resultSet.getString("manufacturer");
                String model = resultSet.getString("model");
                int display_type = resultSet.getInt("display_type");

                System.out.println("Smart Band:\n" + manufacturer + " " + model + "\n" + "Display Type: " + display_type + "\n\n");
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

    public void updateSmartBand(SmartBand smartBand){
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
            String sql = "UPDATE smartband" + "SET display_type = 0 WHERE model ='" + smartBand.getModel() + "';";
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

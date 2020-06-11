package DBservices;

import device.Phone;

import java.sql.*;

public class PhoneDB {
    public void createTable(){
        try {
            Class.forName("sqlite.Driver");
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
                    + "no_cameras INT NOT NULL,"
                    + "foldable INT NOT NULL,"
                    + "PRIMARY KEY (id))";

            statement.execute(sql);
            connection.close();
        }
        catch (SQLException exception){
            System.out.println("SQL Exception: " + exception.getMessage());
            System.out.println("SQL State: " + exception.getSQLState());
            System.out.println("Vendor Error: " + exception.getErrorCode());
        }
    }

    public void addPhone(Phone phone){
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
            String sql = "INSERT INTO laptop (manufacturer, model, RAM, storage) VALUES ("+
                    phone.getManufacturer()+","+
                    phone.getModel()+","+
                    phone.getNoOfCameras()+","+
                    phone.isFoldable()+");";
            statement.execute(sql);
            connection.close();
        }
        catch (SQLException exception){
            System.out.println("SQL Exception: " + exception.getMessage());
            System.out.println("SQL State: " + exception.getSQLState());
            System.out.println("Vendor Error: " + exception.getErrorCode());
        }
    }

    public void removePhone(Phone phone){
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
            String sql = "DELETE FROM laptop WHERE model = '" + phone.getModel() + "';";
            statement.execute(sql);
            connection.close();
        }
        catch (SQLException exception){
            System.out.println("SQL Exception: " + exception.getMessage());
            System.out.println("SQL State: " + exception.getSQLState());
            System.out.println("Vendor Error: " + exception.getErrorCode());
        }
    }

    public void displayPhone(){
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
            String sql = "SELECT * FROM phone";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String manufacturer = resultSet.getString("manufacturer");
                String model = resultSet.getString("model");
                int cameras = resultSet.getInt("cameras");
                int foldable = resultSet.getInt("foldable");

                System.out.println("Phone:\n" + manufacturer + " " + model + "\n" + "No of Cameras: " + cameras + "\n" + "Foldable: " + foldable + "\n\n");
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

    public void updatePhone(Phone phone){
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
            String sql = "UPDATE phone" + "SET foldable = 1 WHERE model ='" + phone.getModel() + "';";
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

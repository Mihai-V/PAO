package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;

public class DisplayPhones extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    JLabel label, label1, label2, label3, label4, label5;
    JButton button, button1;
    JTextField textField1, textField2, textField3, textField4;
    JComboBox comboBox;
    String string;

    DisplayPhones(){
        setVisible(true);
        setSize(1000, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Display Phones");

        label = new JLabel("Select Manufacturer:");
        label.setBounds(20, 20, 200, 20);

        button = new JButton("Search");
        button.setBounds(50, 50, 150, 30);

        button1 = new JButton("Back");
        button1.setBounds(200, 50, 150, 30);

        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();

        add(label);
        add(button);
        add(button1);

        textField1.setEditable(false);
        textField2.setEditable(false);
        textField3.setEditable(false);
        textField4.setEditable(false);

        button.addActionListener(this);
        button1.addActionListener(new DisplayPhones.ButtonListener());
        button1.setActionCommand("back");

        try{
            Class.forName("");
        }
        catch (Exception exception){
            exception.getMessage();
        }

        try{
            Connection connection = DriverManager.getConnection("jdbc:Driver");

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT manufacturer from phones");

            ResultSet resultSet = preparedStatement.executeQuery();

            Vector<String> vector = new Vector();

            while (resultSet.next()){
                String s = resultSet.getString(1);

                vector.add(s);
            }

            comboBox = new JComboBox(vector);
            comboBox.setBounds(240, 20, 200, 20);
            add(comboBox);
        }
        catch (Exception exception){
            System.out.println(exception);
        }
    }

    public void actionPerformed(ActionEvent event){
        showData();
    }

    public void showData(){
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setTitle("Display Phones");

        label5 = new JLabel("Displaying Phones:");
        label5.setForeground(Color.green);
        label5.setFont(new Font("Serif", Font.BOLD, 20));

        label1 = new JLabel("Manufacturer:");
        label2 = new JLabel("Model:");
        label3 = new JLabel("Number of Cameras:");
        label4 = new JLabel("Foldable:");

        label5.setBounds(100, 50, 300, 30);
        label1.setBounds(20, 110, 200, 20);
        label2.setBounds(20, 140, 200, 20);
        label3.setBounds(20, 170, 200, 20);
        label4.setBounds(20, 200, 200, 20);

        textField1.setBounds(240, 110, 200, 20);
        textField2.setBounds(240, 140, 200, 20);
        textField3.setBounds(240, 170, 200, 20);
        textField4.setBounds(240, 200, 200, 20);

        add(label5);

        add(label1);
        add(textField1);

        add(label2);
        add(textField2);

        add(label3);
        add(textField3);

        add(label4);
        add(textField4);

        string = (String) comboBox.getSelectedItem();

        try{
            Class.forName("mysql.jdbc.Driver");
        }
        catch (Exception exception){
            exception.getMessage();
        }

        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clients?autoReconnect=true&useSSL=false", "root", "");

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from phones where manufacturer=?");
            preparedStatement.setString(1, string);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                textField1.setText(resultSet.getString(1));
                textField2.setText(resultSet.getString(5));
                textField3.setText(resultSet.getString(6));
                textField4.setText(resultSet.getString(4));
            }
        }
        catch (Exception exception){
            System.out.println(exception);
        }
    }

    private class ButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("back")){
                dispose();
                AuditGUI auditGUI = AuditGUI.getInstance();
                Thread thread = new Thread(auditGUI);
                thread.start();
                auditGUI.fileWriter(1);
                thread.interrupt();
                new MainMenu();
            }
        }
    }
}

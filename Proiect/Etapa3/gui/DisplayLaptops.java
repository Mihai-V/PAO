package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class DisplayLaptops extends JFrame implements ActionListener {
    JLabel label, label1, label2, label3, label4, label5;
    JButton button, button1;
    JTextField textField1, textField2, textField3, textField4;
    JComboBox comboBox;
    String string;

    DisplayLaptops(){
        setVisible(true);
        setSize(1000, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Display Laptops");

        label = new JLabel("Select Manufacturer");
        label.setBounds(12, 20, 200, 20);

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

        button1.addActionListener(new DisplayLaptops.ButtonListener());
        button1.setActionCommand("back");

        try{
            Class.forName("");
        }
        catch (Exception exception){
            exception.getMessage();
        }

        try{
            Connection connection = DriverManager.getConnection("", "", "");
            PreparedStatement statement = connection.prepareStatement("select manufacturer from laptop");
            ResultSet set = statement.executeQuery();

            Vector<String> vector = new Vector();

            while (set.next()){
                String s = set.getString(1);

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

    public void actionPerformed(ActionEvent e) {
        showData();
    }

    public void showData(){
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setName("Display Laptops");

        label5 = new JLabel("Displaying Laptops");
        label5.setForeground(Color.green);
        label5.setFont(new Font("Serif", Font.BOLD, 20));
        label5.setBounds(100, 50, 200, 30);

        label1 = new JLabel("Manufacturer:");
        label1.setBounds(20, 110, 200, 20);

        label2 = new JLabel("Model:");
        label2.setBounds(20, 140, 200, 20);

        label3 = new JLabel("RAM:");
        label3.setBounds(20, 170, 200, 20);

        label4 = new JLabel("Storage:");
        label4.setBounds(20, 200, 200, 20);

        textField1.setBounds(240, 110, 200, 20);
        textField2.setBounds(240, 140, 200, 20);
        textField3.setBounds(240, 170, 200, 20);
        textField4.setBounds(240, 200, 200, 20);

        frame.add(label5);

        frame.add(label1);
        frame.add(textField1);

        frame.add(label2);
        frame.add(textField2);

        frame.add(label3);
        frame.add(textField3);

        frame.add(label4);
        frame.add(textField4);

        string = (String) comboBox.getSelectedItem();

        try{
            Class.forName("");
        }
        catch (Exception exception){
            exception.getMessage();
        }

        try{
            Connection connection = DriverManager.getConnection("", "", "");

            PreparedStatement statement = connection.prepareStatement("select * from laptop where manufacturer=?");
            statement.setString(1, string);

            ResultSet set = statement.executeQuery();

            while (set.next()){
                textField1.setText(set.getString(1));
                textField2.setText(set.getString(5));
                textField3.setText(set.getString(6));
                textField4.setText(set.getString(4));
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

            if(command.equals("back")){
                dispose();
                AuditGUI auditGUI = AuditGUI.getInstance();
                Thread thread = new Thread(auditGUI);
                thread.start();
                auditGUI.fileWriter(3);
                thread.interrupt();
                new MainMenu();
            }
        }
    }
}

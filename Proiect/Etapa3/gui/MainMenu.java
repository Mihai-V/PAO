package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu implements ActionListener {
    JFrame frame;
    JButton button1, button2, button3, button4, button5, button6, button7, button8, button9;
    JPanel panel;
    JLabel label;

    public MainMenu(){
        AuditGUI auditGUI = AuditGUI.getInstance();
        Thread thread = new Thread(auditGUI);

        thread.start();
        auditGUI.fileWriter(0);
        thread.interrupt();

        frame = new JFrame();
        button1 = new JButton("Display Phones");
        button2 = new JButton("Display Tablets");
        button3 = new JButton("Display Laptops");
        button4 = new JButton("Display SmartBands");
        button5 = new JButton("Display SmartWatches");
        panel= new JPanel();
        label = new JLabel("Welcome to TechShop!");

        button1.addActionListener(this);
        button2.addActionListener(new Button2());
        button3.addActionListener(new Button3());
        button4.addActionListener(new Button4());
        button5.addActionListener(new Button5());

        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(label);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("TechShop");
        frame.pack();
        frame.setVisible(true);
        frame.setSize(1000, 500);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.dispose();
        new DisplayPhones();
    }

    private class Button2 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            new DisplayTablets();
        }
    }

    private class Button3 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            new DisplayLaptops();
        }
    }

    private class Button4 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            new DisplaySmartBands();
        }
    }

    private class Button5 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            new DisplaySmartWatches();
        }
    }
}

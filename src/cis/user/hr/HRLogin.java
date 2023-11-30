package cis.user.hr;

import cis.data.databaseConnectivity.DatabaseConnectivity;
import cis.user.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class HRLogin extends JFrame implements ActionListener {

    JTextField userNameArea, passwordArea;

    public static void main(String[] args) {

        new HRLogin();
    }

    public HRLogin() {

        setTitle("HR Executive Login");

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon imageOne = new ImageIcon(ClassLoader.getSystemResource("cis/data/pictures/LoginBackground.jpg"));
        Image imageTwo = imageOne.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon imageThree = new ImageIcon(imageTwo);
        JLabel hrImage = new JLabel(imageThree);
        hrImage.setBounds(0,0,600,300);
        add(hrImage);

        JLabel programUserName = new JLabel("Enter the Username");
        programUserName.setBounds(40,20,500,30);
        hrImage.add(programUserName);

        userNameArea = new JTextField();
        userNameArea.setBounds(250,20,150,30);
        hrImage.add(userNameArea);

        JLabel programPassword = new JLabel("Enter the Password");
        programPassword.setBounds(40,70,500,30);
        hrImage.add(programPassword);

        passwordArea = new JTextField();
        passwordArea.setBounds(250,70,150,30);
        hrImage.add(passwordArea);

        JButton Login =  new JButton("Login");
        Login.setBounds(150,140,150,30);
        Login.setBackground(Color.WHITE);
        Login.setForeground(Color.BLUE);
        Login.addActionListener(this);
        hrImage.add(Login);

        ImageIcon imageFour = new ImageIcon(ClassLoader.getSystemResource("cis/data/pictures/login.jpg"));
        Image imageFive = imageFour.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageSix = new ImageIcon(imageFive);
        JLabel loginImage = new JLabel(imageSix);
        loginImage.setBounds(400,-20,200,200);
        add(loginImage);

        setSize(600,300);
        setLocation(450,200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        try {
            String UserName = userNameArea.getText();
            String Password = passwordArea.getText();

            DatabaseConnectivity dbConnection = new DatabaseConnectivity();
            String query = "select * from hrlogins where UserName = '"+UserName+"' and Password = '"+Password+"'";

            ResultSet resultsSet = dbConnection.dbStatement.executeQuery(query);

            if (resultsSet.next()) {
                setVisible(false);
                new HRHome();
            } else {
                JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                setVisible(false);
                new Main();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

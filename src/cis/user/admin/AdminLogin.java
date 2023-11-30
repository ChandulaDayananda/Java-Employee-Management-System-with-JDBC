package cis.user.admin;

import cis.user.Main;
import cis.user.hr.HRLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminLogin extends JFrame implements ActionListener {

    JTextField userNameArea, passwordArea;

    public static void main(String[] args) {
        new HRLogin();
    }

    public AdminLogin() {

        setTitle("Administrator Login");

        setLayout(null);

        ImageIcon imageOne = new ImageIcon(ClassLoader.getSystemResource("cis/data/pictures/LoginBackground.jpg"));
        Image imageTwo = imageOne.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon imageThree = new ImageIcon(imageTwo);
        JLabel adminImage = new JLabel(imageThree);
        adminImage.setBounds(0,0,600,300);
        add(adminImage);

        JLabel programUserName = new JLabel("Enter the Username");
        programUserName.setBounds(40, 20, 500, 30);
        adminImage.add(programUserName);

        userNameArea = new JTextField();
        userNameArea.setBounds(250, 20, 150, 30);
        adminImage.add(userNameArea);

        JLabel programPassword = new JLabel("Enter the Password");
        programPassword.setBounds(40, 70, 500, 30);
        adminImage.add(programPassword);

        passwordArea = new JTextField();
        passwordArea.setBounds(250, 70, 150, 30);
        adminImage.add(passwordArea);

        JButton Login = new JButton("Login");
        Login.setBounds(150, 140, 150, 30);
        Login.setBackground(Color.WHITE);
        Login.setForeground(Color.BLUE);
        Login.addActionListener(this);
        adminImage.add(Login);

        ImageIcon imageFour = new ImageIcon(ClassLoader.getSystemResource("cis/data/pictures/login.jpg"));
        Image imageFive = imageFour.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imageSix = new ImageIcon(imageFive);
        JLabel loginImage = new JLabel(imageSix);
        loginImage.setBounds(400, -20, 200, 200);
        add(loginImage);

        setSize(600, 300);
        setLocation(450, 200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        String userName = userNameArea.getText();
        String password = passwordArea.getText();

        // Hardcoded admin username and password
        String adminUserName = "admin";
        String adminPassword = "admin";

        if (userName.equals(adminUserName) && password.equals(adminPassword)) {
            setVisible(false);
            new AdminHome();
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Username or Password");
            setVisible(false);
            new Main();
        }
    }
}

package cis.user;

import cis.user.admin.AdminLogin;
import cis.user.hr.HRLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener {
    JButton hrLogin,adminLogin;
    public static void main(String[] args) {

        new Main();

    }

    public Main() {

        setTitle("Colombo Institute of Studies");

        setLayout(null);

        ImageIcon imageOne = new ImageIcon(ClassLoader.getSystemResource("cis/data/pictures/home.jpg"));
        Image imageTwo = imageOne.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon imageThree = new ImageIcon(imageTwo);
        JLabel introImage = new JLabel(imageThree);
        introImage.setBounds(0,0,1120,630);
        add(introImage);

        JLabel introHeading  = new JLabel("Colombo Institute of Studies");
        introHeading .setBounds(620,10,400,40);
        introHeading .setFont(new Font("Times New Roman", Font.BOLD,25));
        introImage.add(introHeading);

        adminLogin =  new JButton("Admin Login");
        adminLogin.setBounds(650,500,150,40);
        adminLogin.setBackground(Color.WHITE);
        adminLogin.setForeground(Color.BLUE);
        adminLogin.addActionListener(this);
        introImage.add(adminLogin);

        hrLogin =  new JButton("HR Login");
        hrLogin.setBounds(850,500,150,40);
        hrLogin.setBackground(Color.WHITE);
        hrLogin.setForeground(Color.BLUE);
        hrLogin.addActionListener(this);
        introImage.add(hrLogin);

        setSize(1120, 630);
        setLocation(250,100);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == hrLogin){
            setVisible(false);
            new HRLogin();
        } else {
            setVisible(false);
            new AdminLogin();
        }

    }
}

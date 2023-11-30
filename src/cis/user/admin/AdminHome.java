package cis.user.admin;

import cis.business.hr.AddHRPeople;
import cis.business.hr.DeleteHRPeople;
import cis.user.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminHome extends JFrame implements ActionListener {

    JButton addHR, deleteHR,backToMain;

    public static void main(String[] args) {

        new AdminHome();
    }

    public AdminHome() {

        setTitle("Administrator Dashboard");

        setLayout(null);

        ImageIcon imageSeven = new ImageIcon(ClassLoader.getSystemResource("cis/data/pictures/AdminHome.jpg"));
        Image imageEight = imageSeven.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon imageNine = new ImageIcon(imageEight);
        JLabel homeImage = new JLabel(imageNine);
        homeImage.setBounds(0,0,1120,630);
        add(homeImage);

        JLabel homeHeading = new JLabel("Administrator Dashboard");
        homeHeading.setBounds(670,20,400,40);
        homeHeading.setFont(new Font("Times New Roman", Font.BOLD,25));
        homeImage.add(homeHeading);

        addHR = new JButton("Add  HR People");
        addHR.setBounds(650,80,150,40);
        addHR.addActionListener(this);
        homeImage.add(addHR);

        deleteHR = new JButton("Delete HR People");
        deleteHR.setBounds(820,80,150,40);
        deleteHR.addActionListener(this);
        homeImage.add(deleteHR);

        backToMain = new JButton("Back to Home");
        backToMain.setBounds(820,540,150,40);
        backToMain.addActionListener(this);
        homeImage.add(backToMain);

        setSize(1120,630);
        setLocation(250,100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if (actionEvent.getSource() == addHR) {
            setVisible(false);
            new AddHRPeople();
        } else if (actionEvent.getSource() == deleteHR) {
            setVisible(false);
            new DeleteHRPeople();
        } else {
            setVisible(false);
            new Main();
        }
    }
}

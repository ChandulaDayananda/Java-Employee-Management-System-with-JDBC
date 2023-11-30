package cis.business.hr;

import cis.data.databaseConnectivity.DatabaseConnectivity;
import cis.user.admin.AdminHome;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class DeleteHRPeople extends JFrame implements ActionListener {

    Choice hrUserNameChoice;

    JButton delete,back;

    public static void main(String[] args) {

        new DeleteHRPeople();
    }

    public DeleteHRPeople() {

        setLayout(null);

        JLabel hrUserNameLabel = new JLabel("HR Username");
        hrUserNameLabel.setBounds(50,50,100,30);
        add(hrUserNameLabel);

        hrUserNameChoice = new Choice();
        hrUserNameChoice.setBounds(200,50,150,30);
        add(hrUserNameChoice);

        try {
            DatabaseConnectivity dbConnection = new DatabaseConnectivity();
            String query = "select * from hrlogins";
            ResultSet resultSet = dbConnection.dbStatement.executeQuery(query);
            while (resultSet.next()) {
                hrUserNameChoice.add(resultSet.getString("UserName"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel hrUserName = new JLabel("Username");
        hrUserName.setBounds(50,100,100,30);
        add(hrUserName);

        JLabel hrUserNameLBL = new JLabel();
        hrUserNameLBL.setBounds(200,100,100,30);
        add(hrUserNameLBL);

        try {
            DatabaseConnectivity dbConnection = new DatabaseConnectivity();
            String query = "select * from hrlogins where UserName = '"+hrUserNameChoice.getSelectedItem()+"'";
            ResultSet resultSet = dbConnection.dbStatement.executeQuery(query);
            while (resultSet.next()) {
                hrUserNameLBL.setText(resultSet.getString("UserName"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        hrUserNameChoice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {

                try {
                    DatabaseConnectivity dbConnection = new DatabaseConnectivity();
                    String query = "select * from hrlogins where UserName = '"+hrUserNameChoice.getSelectedItem()+"'";
                    ResultSet resultSet = dbConnection.dbStatement.executeQuery(query);
                    while (resultSet.next()) {
                        hrUserNameLBL.setText(resultSet.getString("UserName"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        delete = new JButton("Delete");
        delete.setBounds(80,300,100,30);
        delete.setBackground(Color.WHITE);
        delete.setForeground(Color.BLUE);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("Back");
        back.setBounds(220,300,100,30);
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLUE);
        back.addActionListener(this);
        add(back);

        ImageIcon imageOne = new ImageIcon(ClassLoader.getSystemResource("cis/data/pictures/delete.png"));
        Image imageTwo = imageOne.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
        ImageIcon imageThree = new ImageIcon(imageTwo);
        JLabel image = new JLabel(imageThree);
        image.setBounds(450,0,600,400);
        add(image);

        setSize(1000,400);
        setLocation(300,150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete) {
            try {
                DatabaseConnectivity dbConnection = new DatabaseConnectivity();
                String query = "delete from hrlogins where UserName = '"+hrUserNameChoice.getSelectedItem()+"'";
                dbConnection.dbStatement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"HR User Deleted Successfully!");
                setVisible(false);
                new AdminHome();
            } catch (Exception e){
                e.printStackTrace();
            }
        }else {
            setVisible(false);
            new AdminHome();
        }
    }
}

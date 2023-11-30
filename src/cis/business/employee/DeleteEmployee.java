package cis.business.employee;

import cis.data.databaseConnectivity.DatabaseConnectivity;
import cis.user.hr.HRHome;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class DeleteEmployee extends JFrame implements ActionListener {

    Choice employeeIDChoice;

    JButton delete, back;

    public static void main(String[] args) {
        new DeleteEmployee();
    }

    public DeleteEmployee() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel employeeIDLabel = new JLabel("Employee ID");
        employeeIDLabel.setBounds(50,50,100,30);
        add(employeeIDLabel);

        employeeIDChoice = new Choice();
        employeeIDChoice.setBounds(200,50,150,30);
        add(employeeIDChoice);

        try {
            DatabaseConnectivity dbConnection = new DatabaseConnectivity();
            String query = "select * from employees";
            ResultSet resultSet = dbConnection.dbStatement.executeQuery(query);
            while (resultSet.next()) {
                employeeIDChoice.add(resultSet.getString("employeeID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel employeeFirstName = new JLabel("First Name");
        employeeFirstName.setBounds(50,100,100,30);
        add(employeeFirstName);

        JLabel employeeFirstNameLabel = new JLabel();
        employeeFirstNameLabel.setBounds(200,100,100,30);
        add(employeeFirstNameLabel);

        JLabel employeeLastName = new JLabel("Last Name");
        employeeLastName.setBounds(50,150,100,30);
        add(employeeLastName);

        JLabel employeeLastNameLabel = new JLabel();
        employeeLastNameLabel.setBounds(200,150,100,30);
        add(employeeLastNameLabel);

        JLabel employeeEmail = new JLabel("Email");
        employeeEmail.setBounds(50,200,100,30);
        add(employeeEmail);

        JLabel employeeEmailLabel = new JLabel();
        employeeEmailLabel.setBounds(200,200,250,30);
        add(employeeEmailLabel);

        try {
            DatabaseConnectivity dbConnection = new DatabaseConnectivity();
            String query = "select * from employees where employeeID = '"+employeeIDChoice.getSelectedItem()+"'";
            ResultSet resultSet = dbConnection.dbStatement.executeQuery(query);
            while (resultSet.next()) {
                employeeFirstNameLabel.setText(resultSet.getString("employeeFirstName"));
                employeeLastNameLabel.setText(resultSet.getString("employeeLastName"));
                employeeEmailLabel.setText(resultSet.getString("employeeEmail"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        employeeIDChoice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {

                try {
                    DatabaseConnectivity dbConnection = new DatabaseConnectivity();
                    String query = "select * from employees where employeeID = '"+employeeIDChoice.getSelectedItem()+"'";
                    ResultSet resultSet = dbConnection.dbStatement.executeQuery(query);
                    while (resultSet.next()) {
                        employeeFirstNameLabel.setText(resultSet.getString("employeeFirstName"));
                        employeeLastNameLabel.setText(resultSet.getString("employeeLastName"));
                        employeeEmailLabel.setText(resultSet.getString("employeeEmail"));
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
                String query = "delete from employees where employeeID = '"+employeeIDChoice.getSelectedItem()+"'";
                dbConnection.dbStatement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Employee Deleted Successfully!");
                setVisible(false);
                new HRHome();
            } catch (Exception e){
                e.printStackTrace();
            }
        }else {
            setVisible(false);
            new HRHome();
        }
    }
}

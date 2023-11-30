package cis.business.employee;

import cis.data.databaseConnectivity.DatabaseConnectivity;
import cis.user.hr.HRHome;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewEmployee extends JFrame implements ActionListener {

    JTable employeeTable;

    Choice employeeIDChoice;

    JButton search,print,update,back;

    public static void main(String[] args) {

        new ViewEmployee();
    }

    public ViewEmployee() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon imageOne = new ImageIcon(ClassLoader.getSystemResource("cis/data/pictures/ViewEmployee.jpg"));
        Image imageTwo = imageOne.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon imageThree = new ImageIcon(imageTwo);
        JLabel viewEMPImage = new JLabel(imageThree);
        viewEMPImage.setBounds(0,0,1120,630);
        add(viewEMPImage);

        JLabel searchEmployee = new JLabel("Search by Employee ID");
        searchEmployee.setBounds(20,20,150,20);
        viewEMPImage.add(searchEmployee);

        employeeIDChoice = new Choice();
        employeeIDChoice.setBounds(180,20,150,20);
        viewEMPImage.add(employeeIDChoice);

        try {
            DatabaseConnectivity dbConnection = new DatabaseConnectivity();
            ResultSet resultSet = dbConnection.dbStatement.executeQuery("select * from employees");

            while (resultSet.next()) {
                employeeIDChoice.add(resultSet.getString("employeeID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        employeeTable = new JTable();

        try {
            DatabaseConnectivity dbConnection = new DatabaseConnectivity();
            ResultSet resultSet = dbConnection.dbStatement.executeQuery("select * from employees");
            employeeTable.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jScrollPaneViewEmployee = new JScrollPane(employeeTable);
        jScrollPaneViewEmployee.setBounds(0,100,900,600);
        viewEMPImage.add(jScrollPaneViewEmployee);

        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        viewEMPImage.add(search);

        print = new JButton("Print");
        print.setBounds(220,70,80,20);
        print.addActionListener(this);
        viewEMPImage.add(print);

        back = new JButton("Back");
        back.setBounds(320,70,80,20);
        back.addActionListener(this);
        viewEMPImage.add(back);

        update = new JButton("Update");
        update.setBounds(120,70,80,20);
        update.addActionListener(this);
        viewEMPImage.add(update);

        setSize(900,700);
        setLocation(0,100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == search) {
                String query = "select * from employees where employeeID = '"+employeeIDChoice.getSelectedItem()+"'";
                try {
                    DatabaseConnectivity dbConnection = new DatabaseConnectivity();
                    ResultSet resultSet = dbConnection.dbStatement.executeQuery(query);
                    employeeTable.setModel(DbUtils.resultSetToTableModel(resultSet));
                } catch (Exception e) {
                    e.printStackTrace();
                }
        } else if (ae.getSource() == print) {
                try {
                    employeeTable.print();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        } else if (ae.getSource() == update) {
            setVisible(false);
            new UpdateEmployee(employeeIDChoice.getSelectedItem());
        } else {
            setVisible(false);
            new HRHome();
        }
    }
}

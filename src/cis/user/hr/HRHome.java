package cis.user.hr;

import cis.business.employee.AddEmployee;
import cis.business.employee.DeleteEmployee;
import cis.business.employee.ViewEmployee;
import cis.user.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HRHome extends JFrame implements ActionListener {

    JButton addEmployee, viewEmployee, updateEmployee, deleteEmployee,backToMain;

    public static void main(String[] args) {

        new HRHome();
    }

    public HRHome() {

        setTitle("HR Executive  Dashboard");

        setLayout(null);

        ImageIcon imageSeven = new ImageIcon(ClassLoader.getSystemResource("cis/data/pictures/HRHome.jpg"));
        Image imageEight = imageSeven.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon imageNine = new ImageIcon(imageEight);
        JLabel homeImage = new JLabel(imageNine);
        homeImage.setBounds(0,0,1120,630);
        add(homeImage);

        JLabel homeHeading = new JLabel("HR Executive  Dashboard");
        homeHeading.setBounds(620,20,400,40);
        homeHeading.setFont(new Font("Times New Roman", Font.BOLD,25));
        homeImage.add(homeHeading);

        addEmployee = new JButton("Add  Employee");
        addEmployee.setBounds(650,80,150,40);
        addEmployee.addActionListener(this);
        homeImage.add(addEmployee);

        viewEmployee = new JButton("View Employees");
        viewEmployee.setBounds(820,80,150,40);
        viewEmployee.addActionListener(this);
        homeImage.add(viewEmployee);

        deleteEmployee = new JButton("Delete Employee");
        deleteEmployee.setBounds(735,140,150,40);
        deleteEmployee.addActionListener(this);
        homeImage.add(deleteEmployee);

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

        if (actionEvent.getSource() == addEmployee) {
            setVisible(false);
            new AddEmployee();
        } else if (actionEvent.getSource() == viewEmployee) {
            setVisible(false);
            new ViewEmployee();
        } else if (actionEvent.getSource() == updateEmployee) {
            setVisible(false);
            new ViewEmployee();
        } else if (actionEvent.getSource() == deleteEmployee){
            setVisible(false);
            new DeleteEmployee();
        } else {
            setVisible(false);
            new Main();
        }
    }
}

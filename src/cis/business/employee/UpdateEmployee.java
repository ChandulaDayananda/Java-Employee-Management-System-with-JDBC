package cis.business.employee;

import cis.data.databaseConnectivity.DatabaseConnectivity;
import cis.user.hr.HRHome;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateEmployee extends JFrame implements ActionListener {


    String employeeID;

    JTextField employeeSalaryTextField, employeeAddressTextField,employeePhoneTextField,employeeEmailTextField,
            employeeDesignationTextField, employeeHighestEducationTextField, employeeDepartmentTextField;

    JLabel employeeIDLabel;

    JButton updateEmployeeDetails,backToHome;

    public static void main(String[] args) {

        new UpdateEmployee("");
    }

    public UpdateEmployee(String employeeID) {

        this.employeeID = employeeID;

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon imageOne = new ImageIcon(ClassLoader.getSystemResource("cis/data/pictures/UpdateEmployee.jpg"));
        Image imageTwo = imageOne.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon imageThree = new ImageIcon(imageTwo);
        JLabel updateEMPImage = new JLabel(imageThree);
        updateEMPImage.setBounds(0,0,1120,630);
        add(updateEMPImage);

        JLabel addEmployeeHeading = new JLabel("Update Employee");
        addEmployeeHeading.setBounds(320,30,500,50);
        addEmployeeHeading.setFont(new Font("Times New Roman", Font.BOLD,20));
        updateEMPImage.add(addEmployeeHeading);

        JLabel employeeFirstNameLBL = new JLabel("First Name");
        employeeFirstNameLBL.setBounds(50,150,150,30);
        employeeFirstNameLBL.setFont(new Font("Times New Roman", Font.BOLD,20));
        updateEMPImage.add(employeeFirstNameLBL);

        JLabel employeeFirstNameLabel = new JLabel();
        employeeFirstNameLabel.setBounds(200,150,150,30);
        updateEMPImage.add(employeeFirstNameLabel);

        JLabel employeeLastNameLBL = new JLabel("Last  Name");
        employeeLastNameLBL.setBounds(400,150,150,30);
        employeeLastNameLBL.setFont(new Font("Times New Roman", Font.BOLD,20));
        updateEMPImage.add(employeeLastNameLBL);

        JLabel employeeLastNameLabel = new JLabel();
        employeeLastNameLabel.setBounds(600,150,150,30);
        updateEMPImage.add(employeeLastNameLabel);

        JLabel employeeDOBLBL = new JLabel("Date of Birth");
        employeeDOBLBL.setBounds(50,200,150,30);
        employeeDOBLBL.setFont(new Font("Times New Roman", Font.BOLD,20));
        updateEMPImage.add(employeeDOBLBL);

        JLabel employeeDOBLabel = new JLabel();
        employeeDOBLabel.setBounds(200,200,150,30);
        updateEMPImage.add(employeeDOBLabel);

        JLabel employeeSalaryLBL = new JLabel("Salary");
        employeeSalaryLBL.setBounds(400,200,150,30);
        employeeSalaryLBL.setFont(new Font("Times New Roman", Font.BOLD,20));
        updateEMPImage.add(employeeSalaryLBL);

        employeeSalaryTextField = new JTextField();
        employeeSalaryTextField.setBounds(600,200,150,30);
        updateEMPImage.add(employeeSalaryTextField);

        JLabel employeeAddressLBL = new JLabel("Address");
        employeeAddressLBL.setBounds(50,250,150,30);
        employeeAddressLBL.setFont(new Font("Times New Roman", Font.BOLD,20));
        updateEMPImage.add(employeeAddressLBL);

        employeeAddressTextField = new JTextField();
        employeeAddressTextField.setBounds(200,250,150,30);
        updateEMPImage.add(employeeAddressTextField);

        JLabel employeePhoneLBL = new JLabel("Phone Number");
        employeePhoneLBL.setBounds(400,250,150,30);
        employeePhoneLBL.setFont(new Font("Times New Roman", Font.BOLD,20));
        updateEMPImage.add(employeePhoneLBL);

        employeePhoneTextField = new JTextField();
        employeePhoneTextField.setBounds(600,250,150,30);
        updateEMPImage.add(employeePhoneTextField);

        JLabel employeeEmailLBL = new JLabel("Email Address");
        employeeEmailLBL.setBounds(50,300,150,30);
        employeeEmailLBL.setFont(new Font("Times New Roman", Font.BOLD,20));
        updateEMPImage.add(employeeEmailLBL);

        employeeEmailTextField = new JTextField();
        employeeEmailTextField.setBounds(200,300,150,30);
        updateEMPImage.add(employeeEmailTextField);

        JLabel employeeNICLBL = new JLabel("NIC Number");
        employeeNICLBL.setBounds(400,300,150,30);
        employeeNICLBL.setFont(new Font("Times New Roman", Font.BOLD,20));
        updateEMPImage.add(employeeNICLBL);

        JLabel employeeNICLabel = new JLabel();
        employeeNICLabel.setBounds(600,300,150,30);
        updateEMPImage.add(employeeNICLabel);

        JLabel employeeIDLBL = new JLabel("EmployeeID");
        employeeIDLBL.setBounds(50,350,150,30);
        employeeIDLBL.setFont(new Font("Times New Roman", Font.BOLD,20));
        updateEMPImage.add(employeeIDLBL);

        JLabel employeeIDLabel = new JLabel();
        employeeIDLabel.setBounds(200,350,150,30);
        employeeIDLabel.setFont(new Font("Times New Roman", Font.BOLD,20));
        updateEMPImage.add(employeeIDLabel);

        JLabel employeeDepartmentLBL = new JLabel("Department");
        employeeDepartmentLBL.setBounds(400,350,150,30);
        employeeDepartmentLBL.setFont(new Font("Times New Roman", Font.BOLD,20));
        updateEMPImage.add(employeeDepartmentLBL);

        employeeDepartmentTextField = new JTextField();
        employeeDepartmentTextField.setBounds(600,350,150,30);
        updateEMPImage.add(employeeDepartmentTextField);

        JLabel employeeDesignationLBL = new JLabel("Designation");
        employeeDesignationLBL.setBounds(50,400,150,30);
        employeeDesignationLBL.setFont(new Font("Times New Roman", Font.BOLD,20));
        updateEMPImage.add(employeeDesignationLBL);

        employeeDesignationTextField = new JTextField();
        employeeDesignationTextField.setBounds(200,400,150,30);
        updateEMPImage.add(employeeDesignationTextField);

        JLabel employeeEPFNumberLBL = new JLabel("EPF Number");
        employeeEPFNumberLBL.setBounds(400,400,150,30);
        employeeEPFNumberLBL.setFont(new Font("Times New Roman", Font.BOLD,20));
        updateEMPImage.add(employeeEPFNumberLBL);

        JLabel employeeEPFNumberLabel = new JLabel();
        employeeEPFNumberLabel.setBounds(600,400,150,30);
        updateEMPImage.add(employeeEPFNumberLabel);

        JLabel employeeHighestEducationLBL = new JLabel("Highest Education");
        employeeHighestEducationLBL.setBounds(250,450,200,30);
        employeeHighestEducationLBL.setFont(new Font("Times New Roman", Font.BOLD,20));
        updateEMPImage.add(employeeHighestEducationLBL);

        employeeHighestEducationTextField = new JTextField();
        employeeHighestEducationTextField.setBounds(450,450,150,30);
        updateEMPImage.add(employeeHighestEducationTextField);

        try {
            DatabaseConnectivity dbConnection = new DatabaseConnectivity();
            String query = "select * from employees where employeeID = '"+employeeID+"'";
            ResultSet resultSet = dbConnection.dbStatement.executeQuery(query);

            while (resultSet.next()) {
                employeeFirstNameLabel.setText(resultSet.getString("employeeFirstName"));
                employeeLastNameLabel.setText(resultSet.getString("employeeLastName"));
                employeeDOBLabel.setText(resultSet.getString("employeeDOB"));
                employeeSalaryTextField.setText(resultSet.getString("employeeSalary"));
                employeeAddressTextField.setText(resultSet.getString("employeeAddress"));
                employeePhoneTextField.setText(resultSet.getString("employeePhone"));
                employeeEmailTextField.setText(resultSet.getString("employeeEmail"));
                employeeNICLabel.setText(resultSet.getString("employeeNIC"));
                employeeIDLabel.setText(resultSet.getString("employeeID"));
                employeeDepartmentTextField.setText(resultSet.getString("employeeDepartment"));
                employeeDesignationTextField.setText(resultSet.getString("employeeDesignation"));
                employeeEPFNumberLabel.setText(resultSet.getString("employeeEPFNumber"));
                employeeHighestEducationTextField.setText(resultSet.getString("employeeHighestEducation"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        updateEmployeeDetails = new JButton("Update  Details");
        updateEmployeeDetails.setBounds(200,550,150,40);
        updateEmployeeDetails.addActionListener(this);
        updateEmployeeDetails.setBackground(Color.WHITE);
        updateEmployeeDetails.setForeground(Color.BLACK);
        updateEMPImage.add(updateEmployeeDetails);

        backToHome = new JButton("Back");
        backToHome.setBounds(500,550,150,40);
        backToHome.addActionListener(this);
        backToHome.setBackground(Color.WHITE);
        backToHome.setForeground(Color.BLACK);
        updateEMPImage.add(backToHome);

        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == updateEmployeeDetails) {
            String employeeSalary = employeeSalaryTextField.getText();
            String employeeAddress = employeeAddressTextField.getText();
            String employeePhone = employeePhoneTextField.getText();
            String employeeEmail = employeeEmailTextField.getText();
            String employeeDepartment = employeeDepartmentTextField.getText();
            String employeeDesignation = employeeDesignationTextField.getText();
            String employeeHighestEducation = employeeHighestEducationTextField.getText();

            try {
                DatabaseConnectivity dbConnection = new DatabaseConnectivity();
                String query = "update employees set employeeSalary = '"+employeeSalary+"',employeeAddress = '"+employeeAddress+"',employeePhone = '"+employeePhone+"',employeeEmail = '"+employeeEmail+"',employeeDepartment = '"+employeeDepartment+"',employeeDesignation = '"+employeeDesignation+"',employeeHighestEducation = '"+employeeHighestEducation+"'  where employeeID = '"+employeeID+"'";
                dbConnection.dbStatement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Updated Successfully");
                setVisible(false);
                new HRHome();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new HRHome();
        }
    }
}

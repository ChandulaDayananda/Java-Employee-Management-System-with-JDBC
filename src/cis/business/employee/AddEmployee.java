package cis.business.employee;

import cis.data.databaseConnectivity.DatabaseConnectivity;
import cis.user.hr.HRHome;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {

    Random random = new Random();
    int number = random.nextInt(1000);

    JTextField employeeFirstNameTextField,employeeLastNameTextField,employeeSalaryTextField,
            employeeAddressTextField,employeePhoneTextField,employeeEmailTextField,
            employeeNICTextField,employeeDesignationTextField,
            employeeEPFNumberTextField;

    JDateChooser employeeDOBDateChooser;

    JComboBox employeeHighestEducationComboBox,employeeDepartmentComboBox;

    JLabel employeeIDLabel;

    JButton addEmployeeDetails,backToHome;

    public static void main(String[] args) {

        new AddEmployee();
    }

    public AddEmployee() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon imageOne = new ImageIcon(ClassLoader.getSystemResource("cis/data/pictures/AddEmployee.jpg"));
        Image imageTwo = imageOne.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon imageThree = new ImageIcon(imageTwo);
        JLabel addEMPImage = new JLabel(imageThree);
        addEMPImage.setBounds(0,0,1120,630);
        add(addEMPImage);

        JLabel addEmployeeHeading = new JLabel("Add New Employee");
        addEmployeeHeading.setBounds(320,30,500,50);
        addEmployeeHeading.setFont(new Font("Times New Roman", Font.BOLD,20));
        addEMPImage.add(addEmployeeHeading);

        JLabel employeeFirstName = new JLabel("First Name");
        employeeFirstName.setBounds(50,150,150,30);
        employeeFirstName.setFont(new Font("Times New Roman", Font.BOLD,20));
        addEMPImage.add(employeeFirstName);

        employeeFirstNameTextField = new JTextField();
        employeeFirstNameTextField.setBounds(200,150,150,30);
        addEMPImage.add(employeeFirstNameTextField);

        JLabel employeeLastName = new JLabel("Last  Name");
        employeeLastName.setBounds(400,150,150,30);
        employeeLastName.setFont(new Font("Times New Roman", Font.BOLD,20));
        addEMPImage.add(employeeLastName);

        employeeLastNameTextField = new JTextField();
        employeeLastNameTextField.setBounds(600,150,150,30);
        addEMPImage.add(employeeLastNameTextField);

        JLabel employeeDOB = new JLabel("Date of Birth");
        employeeDOB.setBounds(50,200,150,30);
        employeeDOB.setFont(new Font("Times New Roman", Font.BOLD,20));
        addEMPImage.add(employeeDOB);

        employeeDOBDateChooser = new JDateChooser();
        employeeDOBDateChooser.setBounds(200,200,150,30);
        addEMPImage.add(employeeDOBDateChooser);

        JLabel employeeSalary = new JLabel("Salary");
        employeeSalary.setBounds(400,200,150,30);
        employeeSalary.setFont(new Font("Times New Roman", Font.BOLD,20));
        addEMPImage.add(employeeSalary);

        employeeSalaryTextField = new JTextField();
        employeeSalaryTextField.setBounds(600,200,150,30);
        addEMPImage.add(employeeSalaryTextField);

        JLabel employeeAddress = new JLabel("Address");
        employeeAddress.setBounds(50,250,150,30);
        employeeAddress.setFont(new Font("Times New Roman", Font.BOLD,20));
        addEMPImage.add(employeeAddress);

        employeeAddressTextField = new JTextField();
        employeeAddressTextField.setBounds(200,250,150,30);
        addEMPImage.add(employeeAddressTextField);

        JLabel employeePhone = new JLabel("Phone Number");
        employeePhone.setBounds(400,250,150,30);
        employeePhone.setFont(new Font("Times New Roman", Font.BOLD,20));
        addEMPImage.add(employeePhone);

        employeePhoneTextField = new JTextField();
        employeePhoneTextField.setBounds(600,250,150,30);
        addEMPImage.add(employeePhoneTextField);

        JLabel employeeEmail = new JLabel("Email Address");
        employeeEmail.setBounds(50,300,150,30);
        employeeEmail.setFont(new Font("Times New Roman", Font.BOLD,20));
        addEMPImage.add(employeeEmail);

        employeeEmailTextField = new JTextField();
        employeeEmailTextField.setBounds(200,300,150,30);
        addEMPImage.add(employeeEmailTextField);

        JLabel employeeNIC = new JLabel("NIC Number");
        employeeNIC.setBounds(400,300,150,30);
        employeeNIC.setFont(new Font("Times New Roman", Font.BOLD,20));
        addEMPImage.add(employeeNIC);

        employeeNICTextField = new JTextField();
        employeeNICTextField.setBounds(600,300,150,30);
        addEMPImage.add(employeeNICTextField);

        JLabel employeeID = new JLabel("EmployeeID");
        employeeID.setBounds(50,350,150,30);
        employeeID.setFont(new Font("Times New Roman", Font.BOLD,20));
        addEMPImage.add(employeeID);

        employeeIDLabel = new JLabel("" + number);
        employeeIDLabel.setBounds(200,350,150,30);
        employeeIDLabel.setFont(new Font("Times New Roman", Font.BOLD,20));
        addEMPImage.add(employeeIDLabel);

        JLabel employeeDepartment = new JLabel("Department");
        employeeDepartment.setBounds(400,350,150,30);
        employeeDepartment.setFont(new Font("Times New Roman", Font.BOLD,20));
        addEMPImage.add(employeeDepartment);

        String[] Department = {"IT","Marketing","Academic","Maintenance","Cleaning","Security","HR"};

        employeeDepartmentComboBox = new JComboBox(Department);
        employeeDepartmentComboBox.setBounds(600,350,150,30);
        addEMPImage.add(employeeDepartmentComboBox);

        JLabel employeeDesignation = new JLabel("Designation");
        employeeDesignation.setBounds(50,400,150,30);
        employeeDesignation.setFont(new Font("Times New Roman", Font.BOLD,20));
        addEMPImage.add(employeeDesignation);

        employeeDesignationTextField = new JTextField();
        employeeDesignationTextField.setBounds(200,400,150,30);
        addEMPImage.add(employeeDesignationTextField);

        JLabel employeeEPFNumber = new JLabel("EPF Number");
        employeeEPFNumber.setBounds(400,400,150,30);
        employeeEPFNumber.setFont(new Font("Times New Roman", Font.BOLD,20));
        addEMPImage.add(employeeEPFNumber);

        employeeEPFNumberTextField = new JTextField();
        employeeEPFNumberTextField.setBounds(600,400,150,30);
        addEMPImage.add(employeeEPFNumberTextField);

        JLabel employeeHighestEducation = new JLabel("Highest Education");
        employeeHighestEducation.setBounds(250,450,200,30);
        employeeHighestEducation.setFont(new Font("Times New Roman", Font.BOLD,20));
        addEMPImage.add(employeeHighestEducation);

        String[] Education = {"GCE O/L","GCE A/L","Diploma","Bachelor","Master","PhD"};

        employeeHighestEducationComboBox = new JComboBox(Education);
        employeeHighestEducationComboBox.setBounds(450,450,150,30);
        addEMPImage.add(employeeHighestEducationComboBox);

        addEmployeeDetails = new JButton("Add  Details");
        addEmployeeDetails.setBounds(200,550,150,40);
        addEmployeeDetails.addActionListener(this);
        addEmployeeDetails.setBackground(Color.WHITE);
        addEmployeeDetails.setForeground(Color.BLACK);
        addEMPImage.add(addEmployeeDetails);

        backToHome = new JButton("Back");
        backToHome.setBounds(500,550,150,40);
        backToHome.addActionListener(this);
        backToHome.setBackground(Color.WHITE);
        backToHome.setForeground(Color.BLACK);
        addEMPImage.add(backToHome);

        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if (actionEvent.getSource() == addEmployeeDetails) {
            String employeeFirstName = employeeFirstNameTextField.getText();
            String employeeLastName = employeeLastNameTextField.getText();
            String employeeDOB = ((JTextField) employeeDOBDateChooser.getDateEditor().getUiComponent()).getText();
            String employeeSalary = employeeSalaryTextField.getText();
            String employeeAddress = employeeAddressTextField.getText();
            String employeePhone = employeePhoneTextField.getText();
            String employeeEmail = employeeEmailTextField.getText();
            String employeeNIC = employeeNICTextField.getText();
            String employeeID = employeeIDLabel.getText();
            String employeeDepartment = (String) employeeDepartmentComboBox.getSelectedItem();
            String employeeDesignation = employeeDesignationTextField.getText();
            String employeeEPFNumber = employeeEPFNumberTextField.getText();
            String employeeHighestEducation = (String) employeeHighestEducationComboBox.getSelectedItem();

            try {
                DatabaseConnectivity dbConnection = new DatabaseConnectivity();
                String query = "insert into employees values ('"+employeeFirstName+"','"+employeeLastName+"','"+employeeDOB+"','"+employeeSalary+"','"+employeeAddress+"','"+employeePhone+"','"+employeeEmail+"','"+employeeNIC+"','"+employeeID+"','"+employeeDepartment+"','"+employeeDesignation+"','"+employeeEPFNumber+"','"+employeeHighestEducation+"')";
                dbConnection.dbStatement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Added Successfully");
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

package cis.business.hr;

import cis.data.databaseConnectivity.DatabaseConnectivity;
import cis.user.admin.AdminHome;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddHRPeople extends JFrame implements ActionListener {

    JTextField hrUserNameTextField, hrUserPasswordTextField;

    JButton addHR,backToHome;

    public static void main(String[] args) {

        new AddHRPeople();
    }

    public AddHRPeople(){

        setTitle("Add Human Resource Executives");

        setLayout(null);


        ImageIcon imageOne = new ImageIcon(ClassLoader.getSystemResource("cis/data/pictures/AddHRPeople.jpg"));
        Image imageTwo = imageOne.getImage().getScaledInstance(900,500,Image.SCALE_DEFAULT);
        ImageIcon imageThree = new ImageIcon(imageTwo);
        JLabel addHRPeople = new JLabel(imageThree);
        addHRPeople.setBounds(0,0,900,500);
        add(addHRPeople);

        JLabel addEmployeeHeading = new JLabel("Add New HR Executive");
        addEmployeeHeading.setBounds(225,30,500,50);
        addEmployeeHeading.setFont(new Font("Times New Roman", Font.BOLD,20));
        addHRPeople.add(addEmployeeHeading);

        JLabel hrUserName = new JLabel("Username");
        hrUserName.setBounds(50,150,150,30);
        hrUserName.setFont(new Font("Times New Roman", Font.BOLD,20));
        addHRPeople.add(hrUserName);

        hrUserNameTextField = new JTextField();
        hrUserNameTextField.setBounds(200,150,150,30);
        addHRPeople.add(hrUserNameTextField);

        JLabel hrUserPassword = new JLabel("Password");
        hrUserPassword.setBounds(400,150,150,30);
        hrUserPassword.setFont(new Font("Times New Roman", Font.BOLD,20));
        addHRPeople.add(hrUserPassword);

        hrUserPasswordTextField = new JTextField();
        hrUserPasswordTextField.setBounds(600,150,150,30);
        addHRPeople.add(hrUserPasswordTextField);

        addHR = new JButton("Add  Details");
        addHR.setBounds(200,300,150,40);
        addHR.addActionListener(this);
        addHR.setBackground(Color.WHITE);
        addHR.setForeground(Color.BLACK);
        addHRPeople.add(addHR);

        backToHome = new JButton("Back");
        backToHome.setBounds(450,300,150,40);
        backToHome.addActionListener(this);
        backToHome.setBackground(Color.WHITE);
        backToHome.setForeground(Color.BLACK);
        addHRPeople.add(backToHome);

        setSize(900,500);
        setLocation(450,200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == addHR) {
            String UserName = hrUserNameTextField.getText();
            String Password = hrUserPasswordTextField.getText();

            try {
                DatabaseConnectivity dbConnection = new DatabaseConnectivity();
                String query = "insert into hrlogins values ('"+UserName+"','"+Password+"')";
                dbConnection.dbStatement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Added Successfully");
                setVisible(false);
                new AdminHome();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new AdminHome();
        }
    }
}

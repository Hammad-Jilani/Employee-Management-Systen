import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.Date;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {
    JButton add,back;
    JTextField tfName,tfFatherName,tfPhone,tfEmail,tfAddress,tfDesignation,tfCNIC,tfSalary;
    JDateChooser dcdob;
    JLabel lblID;
    JComboBox cbEducation;
    public AddEmployee(){

        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(400,20,400,40);
        heading.setFont(new Font("serif",Font.BOLD,40));
        add(heading);

        JLabel name = new JLabel("Name :");
        name.setBounds(30,100,150,40);
        name.setFont(new Font("Roboto",Font.PLAIN,30));
        add(name);

        tfName = new JTextField();
        tfName.setBounds(250,100,300,40);
        tfName.setFont(new Font("Roboto",Font.PLAIN,30));
        add(tfName);

        JLabel fatherName = new JLabel("Father Name :");
        fatherName.setBounds(600,100,200,40);
        fatherName.setFont(new Font("Roboto",Font.PLAIN,30));
        add(fatherName);

        tfFatherName = new JTextField();
        tfFatherName.setBounds(800,100,300,40);
        tfFatherName.setFont(new Font("Roboto",Font.PLAIN,30));
        add(tfFatherName);

        JLabel dob = new JLabel("Date Of Birth:");
        dob.setBounds(30,150,200,40);
        dob.setFont(new Font("Roboto",Font.PLAIN,30));
        add(dob);

        dcdob = new JDateChooser();
        dcdob.setBounds(250,150,300,40);
        add(dcdob);

        JLabel Salary = new JLabel("Salary :");
        Salary.setBounds(600,150,200,40);
        Salary.setFont(new Font("Roboto",Font.PLAIN,30));
        add(Salary);

        tfSalary = new JTextField();
        tfSalary.setBounds(800,150,300,40);
        tfSalary.setFont(new Font("Roboto",Font.PLAIN,30));
        add(tfSalary);

        JLabel Address = new JLabel("Address :");
        Address.setBounds(30,200,200,40);
        Address.setFont(new Font("Roboto",Font.PLAIN,30));
        add(Address);

        tfAddress = new JTextField();
        tfAddress.setBounds(250,200,300,40);
        tfAddress.setFont(new Font("Roboto",Font.PLAIN,30));
        add(tfAddress);

        JLabel Email = new JLabel("Email :");
        Email.setBounds(30,250,200,40);
        Email.setFont(new Font("Roboto",Font.PLAIN,30));
        add(Email);

        tfEmail = new JTextField();
        tfEmail.setBounds(250,250,300,40);
        tfEmail.setFont(new Font("Roboto",Font.PLAIN,30));
        add(tfEmail);

        JLabel phone = new JLabel("Phone :");
        phone.setBounds(600,200,200,40);
        phone.setFont(new Font("Roboto",Font.PLAIN,30));
        add(phone);

        tfPhone = new JTextField();
        tfPhone.setBounds(800,200,300,40);
        tfPhone.setFont(new Font("Roboto",Font.PLAIN,30));
        add(tfPhone);

        JLabel education = new JLabel("Education :");
        education.setBounds(600,250,200,40);
        education.setFont(new Font("Roboto",Font.PLAIN,30));
        add(education);

        String components[] = {"BS","MS","MBA","MBBS","CA","phD"};
        cbEducation = new JComboBox(components);
        cbEducation.setBounds(800,250,300,30);
//        OR
//        cbEducation.addItem("BS");
//        cbEducation.addItem("MS");
//        cbEducation.addItem("phD");
        add(cbEducation);



        JLabel designation = new JLabel("Designation :");
        designation.setBounds(30,300,200,40);
        designation.setFont(new Font("Roboto",Font.PLAIN,30));
        add(designation);

        tfDesignation = new JTextField();
        tfDesignation.setBounds(250,300,300,40);
        tfDesignation.setFont(new Font("Roboto",Font.PLAIN,30));
        add(tfDesignation);

        JLabel CNIC = new JLabel("CNIC :");
        CNIC.setBounds(600,300,200,40);
        CNIC.setFont(new Font("Roboto",Font.PLAIN,30));
        add(CNIC);

        tfCNIC = new JTextField();
        tfCNIC.setBounds(800,300,300,40);
        tfCNIC.setFont(new Font("Roboto",Font.PLAIN,30));
        add(tfCNIC);

        Random rand = new Random();
        int num = rand.nextInt(999999);

        JLabel employeeID = new JLabel("ID :");
        employeeID.setBounds(30,350,200,40);
        employeeID.setFont(new Font("Roboto",Font.PLAIN,30));
        add(employeeID);

        lblID = new JLabel(String.valueOf(num));
        lblID.setBounds(250,350,200,40);
        lblID.setFont(new Font("Roboto",Font.PLAIN,30));
        add(lblID);

        add = new JButton("ADD");
        add.setBounds(350,450,200,40);
        add.setFont(new Font("Roboto",Font.PLAIN,30));
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.addActionListener(this);
        back.setBounds(650,450,200,40);
        back.setFont(new Font("Roboto",Font.PLAIN,30));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);

        setSize(1200,650);
        setVisible(true);
        setLocation(25,25);
        setResizable(false);
        setTitle("Add Employee Details");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    public static void main(String[] args) {
        new AddEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add){
            String name = tfName.getText();
            String Father = tfFatherName.getText();
            String Salary = tfSalary.getText();
            String CNIC = tfCNIC.getText();
            String designation = tfDesignation.getText();
            String Address = tfAddress.getText();
            String Email = tfEmail.getText();
            String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String Education = (String)(cbEducation.getSelectedItem());
            String empID = lblID.getText();
            String phone = tfPhone.getText();
            try{
                Connect connection = new Connect();
                String query = "insert into employee values ('"+name+"','"+Father+"', '"+dob+"','"+Salary+"','"+Address+"','"+phone+"','"+Email+"','"+Education+"','"+designation+"','"+CNIC+"','"+empID+"' ) ";
                connection.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Added successfully");

            }catch (Exception error){
                error.printStackTrace();
            }
        }else if(e.getSource() == back){
            setVisible(false);
            new Home();
        }
    }
}

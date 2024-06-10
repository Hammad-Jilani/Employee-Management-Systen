import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateEmployee extends JFrame implements ActionListener {
    JButton add,back;
    JTextField tfEducation  ,tfFatherName,tfPhone,tfEmail,tfAddress,tfDesignation,tfCNIC,tfSalary;
    String EmployeeID;
    JLabel lblID,lblName;

    public UpdateEmployee(String EmployeeID){
        this.EmployeeID = EmployeeID;
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading = new JLabel("Update Employee Details");
        heading.setBounds(400,20,600,40);
        heading.setFont(new Font("serif",Font.BOLD,40));
        add(heading);

        JLabel name = new JLabel("Name :");
        name.setBounds(30,100,150,40);
        name.setFont(new Font("Roboto",Font.PLAIN,30));
        add(name);

        lblName = new JLabel();
        lblName.setBounds(250,100,300,40);
        lblName.setFont(new Font("Roboto",Font.PLAIN,30));
        add(lblName);

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

        JLabel lbldob = new JLabel();
        lbldob.setBounds(250,150,300,40);
        add(lbldob);

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

        tfEducation = new JTextField();
        tfEducation.setBounds(800,250,300,30);
        tfEducation.setFont(new Font("Roboto",Font.PLAIN,30));
//        OR
//        cbEducation.addItem("BS");
//        cbEducation.addItem("MS");
//        cbEducation.addItem("phD");
        add(tfEducation);



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

        JLabel lblCNIC = new JLabel();
        lblCNIC.setBounds(800,300,300,40);
        lblCNIC.setFont(new Font("Roboto",Font.PLAIN,30));
        add(lblCNIC);

        JLabel employeeID = new JLabel("ID :");
        employeeID.setBounds(30,350,200,40);
        employeeID.setFont(new Font("Roboto",Font.PLAIN,30));
        add(employeeID);

        lblID = new JLabel();
        lblID.setBounds(250,350,200,40);
        lblID.setFont(new Font("Roboto",Font.PLAIN,30));
        add(lblID);

        try{
            Connect con = new Connect();
            String query = "select * from employee where empID = '"+EmployeeID+"'";
            ResultSet set = con.s.executeQuery(query);
            if(set.next()){
                lblName.setText(set.getString("name"));
                tfFatherName.setText(set.getString("fname"));
                lblCNIC.setText(set.getString("cnic"));
                tfEmail.setText(set.getString("email"));
                lbldob.setText(set.getString("dob"));
                lblID.setText(set.getString("empID"));
                tfDesignation.setText(set.getString("designation"));
                tfPhone.setText(set.getString("phone"));
                tfSalary.setText(set.getString("salary"));
                tfAddress.setText(set.getString("address"));
                tfEducation.setText(set.getString("education"));
            }
        }catch (Exception exception){

        }

        add = new JButton("UPDATE");
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
        new UpdateEmployee("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add){
            String Father = tfFatherName.getText();
            String Salary = tfSalary.getText();
            String designation = tfDesignation.getText();
            String Address = tfAddress.getText();
            String Email = tfEmail.getText();
            String Education = tfEducation.getText();
            String phone = tfPhone.getText();
            try{
                Connect connection = new Connect();
                String query = "update employee set fname ='"+Father+"', salary ='"+Salary+"',address = '"+Address+"',phone = '"+phone+"',email = '"+Email+"',education = '"+Education+"',designation = '"+designation+"' where empID = '"+EmployeeID+"' ";
                connection.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Updated successfully");

            }catch (Exception error){
                error.printStackTrace();
            }
        }else if(e.getSource() == back){
            setVisible(false);
            new Home();
        }
    }
}

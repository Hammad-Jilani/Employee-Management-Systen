import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class RemoveEmployee extends JFrame implements ActionListener {
    Choice empID;
    JButton delete,back;

    public RemoveEmployee(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading = new JLabel("Employee ID");
        heading.setBounds(100,20,100,40);
        add(heading);

        empID = new Choice();
        empID.setBounds(200,25,150,40);
        add(empID);

        try{
            Connect c = new Connect();
            String query = "select * from employee";
            ResultSet set = c.s.executeQuery(query);
            while (set.next()){
                empID.add(set.getString("empID"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel labelName = new JLabel("Name");
        labelName.setBounds(100,80,100,40);
        add(labelName);

        JLabel lblName = new JLabel();
        lblName.setBounds(200,80,100,40);
        add(lblName);

        JLabel labelPhone = new JLabel("Phone");
        labelPhone.setBounds(100,160,100,40);
        add(labelPhone);

        JLabel lblPhone = new JLabel();
        lblPhone.setBounds(200,160,100,40);
        add(lblPhone);

        JLabel labelEmail = new JLabel("Email");
        labelEmail.setBounds(100,240,100,40);
        add(labelEmail);

        JLabel lblEmail = new JLabel();
        lblEmail.setBounds(200,240,100,40);
        add(lblEmail);


        try{
            Connect c = new Connect();
            String query = "select * from employee where empID = '"+empID.getSelectedItem()+"' ";
            ResultSet set = c.s.executeQuery(query);
            while (set.next()){
                lblName.setText(set.getString("name"));
                lblPhone.setText(set.getString("phone"));
                lblEmail.setText(set.getString("email"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        empID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    Connect c = new Connect();
                    String query = "select * from employee where empID = '"+empID.getSelectedItem()+"' ";
                    ResultSet set = c.s.executeQuery(query);
                    while (set.next()){
                        lblName.setText(set.getString("name"));
                        lblPhone.setText(set.getString("phone"));
                        lblEmail.setText(set.getString("email"));
                    }
                }catch(Exception exception){
                    exception.printStackTrace();
                }
            }
        });

        delete = new JButton("DELETE");
        delete.setBounds(350,400,150,50);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("BACK");
        back.setBounds(600,400,150,50);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(450,350,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,0,450,350);
        add(image);

        setSize(1200,650);
        setTitle("Employee Management System");
        setFocusable(true);
        setResizable(false);
        setLocation(25,25);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new RemoveEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back){
            new Home();
            setVisible(false);
        }else{
            try{
                Connect c = new Connect();
                String query = "delete from employee where empID = '"+empID.getSelectedItem()+"' ";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Record Deleted");
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
    }
}

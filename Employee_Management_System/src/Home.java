import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {
    JButton add,view,Remove,Update;
    public Home(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200, 630,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1200,600);
        add(image);

        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(700,20,1200,40);
        heading.setFont(new Font("serif",Font.PLAIN,30));
        image.add(heading);

        add = new JButton("Add Employee");
        add.setBounds(700,100,150,30);
        add.addActionListener(this);
        image.add(add);

        view = new JButton("View Employee");
        view.setBounds(900,100,150,30);
        view.addActionListener(this);
        image.add(view);

        Update = new JButton("Update Employee");
        Update.setBounds(700,150,150,30);
        Update.addActionListener(this);
        image.add(Update);

        Remove = new JButton("Remove Employee");
        Remove.setBounds(900,150,150,30);
        Remove.addActionListener(this);
        image.add(Remove);

        setSize(1200,650);
        setVisible(true);
        setLocation(25,25);
        setResizable(false);
        setTitle("Employee Management System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    public static void main(String[] args) {
        new Home();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        if(e.getSource() == add){
            setVisible(false);
            new AddEmployee();
        }else if(e.getSource() == view){
            setVisible(false);
            new ViewEmployee();
        }else if(e.getSource() == Update){
            setVisible(false);
            new ViewEmployee();
        }else{
            new RemoveEmployee();
            setVisible(false);
        }
    }
}

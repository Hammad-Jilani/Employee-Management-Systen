import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class Login extends JFrame implements ActionListener {
    JTextField tfUsername;
    JPasswordField tfPassword;
    Login(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel username = new JLabel("Username : ");
        username.setBounds(100,50,150,50);
        username.setFont(new Font("serif",Font.PLAIN,25));
        add(username);

        tfUsername = new JTextField();
        tfUsername.setBounds(230,50,300,40);
        tfUsername.setFont(new Font("serif",Font.PLAIN,20));
        add(tfUsername);

        JLabel password = new JLabel("Password : ");
        password.setBounds(100,100,300,50);
        password.setFont(new Font("serif",Font.PLAIN,25));
        add(password);

        tfPassword = new JPasswordField();
        tfPassword.setBounds(230,100,300,40);
        tfPassword.setFont(new Font("serif",Font.PLAIN,20));
        add(tfPassword);

        JButton login = new JButton("Login");
        login.setBounds(300,200,200,50);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(700,20,400,400);
        add(image);

        setSize(1250,650);
        setVisible(true);
        setLocation(25,25);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String username = tfUsername.getText();
            String password = tfPassword.getText();

            Connect c = new Connect();
            String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
            ResultSet rs = c.s.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                new Home();
            }else{
                JOptionPane.showMessageDialog(null,"Invalid Username or Password");
            }
        }catch (Exception E){
            E.printStackTrace();
        }
    }
}

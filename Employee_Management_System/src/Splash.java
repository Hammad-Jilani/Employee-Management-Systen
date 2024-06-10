import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Splash extends JFrame implements ActionListener {
    Splash(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(300,30,1200,60);
        heading.setFont(new Font("serif",Font.PLAIN,50));
        heading.setForeground(Color.red);
        add(heading);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50,100,1100,500);
        add(image);

        JButton continued = new JButton("Click here to continue");
        continued.setBounds(400,400,300,70);
        continued.setBackground(Color.black);
        continued.setForeground(Color.white);
        continued.addActionListener(this);
        image.add(continued);

        setSize(1250,650);
        setVisible(true);
        setLocation(25,25);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        while (true){
            heading.setVisible(false);
            try{
                Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }
            heading.setVisible(true);

            try{
                Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new Splash();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login();
    }
}

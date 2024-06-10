import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewEmployee extends JFrame implements ActionListener {
    JTable table;
    Choice employeeID;
    JButton Search,back,update,print;
    public ViewEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel search = new JLabel("Search by Employee ID");
        search.setBounds(20,20,150,20);
        add(search);

        employeeID = new Choice();
        employeeID.setBounds(180,20,150,20);
//        employeeID.add("Hammad");
        add(employeeID);

        table = new JTable();
        TableColumn column;

        Search = new JButton("Search");
        Search.setBounds(50,50,100,30);
        Search.addActionListener(this);
        add(Search);

        print = new JButton("Print");
        print.setBounds(350,50,100,30);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(500,50,100,30);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(200,50,100,30);
        back.addActionListener(this);
        back.addActionListener(this);
        add(back);

        try{
            Connect c = new Connect();
            ResultSet set = c.s.executeQuery("select * from employee");
            while (set.next()) {
                employeeID.add(set.getString("empID"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            Connect c = new Connect();
            ResultSet set = c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(set));
            for (int i = 0; i < table.getColumnCount(); i++) {
                column = table.getColumnModel().getColumn(i);
                column.setPreferredWidth(180);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,1200,500);
        add(jsp);

        setSize(1200,650);
        setLocation(50,25);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        add(employeeID);
    }
    public static void main(String[] args) {
        new ViewEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Search){
            try{
                Connect c = new Connect();
                String s = (String)(employeeID.getSelectedItem());
                String query = "select * from employee where empID = '"+s+"'";
                ResultSet set = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(set));

            }catch (Exception exception){
                exception.printStackTrace();
            }
        } else if (e.getSource() == back) {
            setVisible(false);
            new Home();
        } else if (e.getSource() == print) {
            try{
                table.print();
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }else{
            setVisible(false);
            new UpdateEmployee(employeeID.getSelectedItem());

        }
    }
}

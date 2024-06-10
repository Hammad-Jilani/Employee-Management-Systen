import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connect {
    Connection c;
    Statement s;
    public Connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///employeemanagementsystem","root","Hammad@10");
            s = c.createStatement();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

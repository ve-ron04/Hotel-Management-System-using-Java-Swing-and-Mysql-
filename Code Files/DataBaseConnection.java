import java.sql.DriverManager;
import java.sql.*;
import java.lang.ClassNotFoundException;

public class DataBaseConnection {

    Connection c;
    Statement s;


    String url = "jdbc:mysql://localhost:3306/hotelManagementSystem";
    String UName = "root";
    String passwordd = "varun@VK04";

    DataBaseConnection()  {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection(url,UName,passwordd);
            s = c.createStatement();

        }catch (SQLException | ClassNotFoundException e){
            System.out.println("SQLException or ClassNotFoundException");
        }
    }

}

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

  static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    static final String USER = "root";
    static final String PASSWORD = "8056765866";

    public static Connection getConnection() {

        try {

            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Database Connected");

            return con;

        } catch (Exception e) {

            System.out.println(e);

        }

        return null;
    }
}
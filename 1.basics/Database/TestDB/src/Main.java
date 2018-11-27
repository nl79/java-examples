import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
        try {
            //Connection conn = DriverManager.getConnection("jdbc:sqlite:D:\\databases\\testjava.db");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/nazarlesiv/Git/java-examples/1.basics/Database/TestDB/testjava.db");

        } catch(SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
package com.company;

import javax.xml.transform.Result;
import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try {
            // Older Way of loading the driver
//            Class.forName("org.sql.JDBC");

//            Connection conn = DriverManager.getConnection("jdbv:sqlite:D:\\databases\\testjava.db");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/xbbnwln/Projects/java-examples/1.basics/Database/TestDB2/testjava.db");
//            conn.setAutoCommit(false);

            // Datasource objects.
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS contacts (name TEXT, phone INTEGER, email TEXT)");

//            statement.execute("INSERT INTO contacts (name, phone, email) VALUES('Joe', 123, 'qwe@anywhere.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email) VALUES('qwe', 345, 'wer@anywhere.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email) VALUES('rty', 567, 'ert@anywhere.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email) VALUES('uio', 689, 'rty@anywhere.com')");

//
//            statement.execute("UPDATE contacts SET phone=23423 WHERE name='Joe'");
//
//            statement.execute("DELETE FROM contacts WHERE name='Joe'");

            statement.execute("SELECT * FROM contacts");
            ResultSet results = statement.getResultSet();

            while(results.next()) {
                System.out.println(results.getString("name") + " " + results.getInt("phone") + " " + results.getString("email"));
            }

            statement.close();
            conn.close();


        } catch(SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
//
//        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/xbbnwln/Projects/java-examples/1.basics/Database/TestDB2/testjava.db");
//            Statement statement = conn.createStatement()) {
//            statement.execute("CREATE TABLE contacts (name TEXT, phone INTEGER, email TEXT)");
//        } catch(SQLException e) {
//            System.out.println("Something went wrong: " + e.getMessage());
//        }
    }
}

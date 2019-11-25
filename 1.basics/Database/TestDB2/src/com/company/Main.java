package com.company;

import javax.xml.transform.Result;
import java.sql.*;

public class Main {

    public static final String DB_NAME = "testjava.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:/Users/nazarlesiv/Projects/java-examples/1.basics/Database/TestDB2/" + DB_NAME;
    public static final String TABLE_CONTACTS = "contacts";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";

    public static void main(String[] args) {
        try {
            // Older Way of loading the driver
//            Class.forName("org.sql.JDBC");

            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
//            conn.setAutoCommit(false);

            // Datasource objects.
            Statement statement = conn.createStatement();
            statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS + " (name TEXT, phone INTEGER, email TEXT)");

            statement.execute("INSERT INTO contacts (name, phone, email) VALUES('Joe', 123, 'qwe@anywhere.com')");
            statement.execute("INSERT INTO contacts (name, phone, email) VALUES('qwe', 345, 'wer@anywhere.com')");
            statement.execute("INSERT INTO contacts (name, phone, email) VALUES('rty', 567, 'ert@anywhere.com')");
            statement.execute("INSERT INTO contacts (name, phone, email) VALUES('uio', 689, 'rty@anywhere.com')");

//
//            statement.execute("UPDATE contacts SET phone=23423 WHERE name='Joe'");
//
//            statement.execute("DELETE FROM contacts WHERE name='Joe'");
//
//            statement.execute("SELECT * FROM contacts");
//            ResultSet results = statement.getResultSet();
            String query = "SELECT * FROM contacts WHERE name = ?";
            PreparedStatement prepExample;
            prepExample = conn.prepareStatement(query);
            prepExample.setString(1, "Joe");

            ResultSet results = prepExample.executeQuery();


            while(results.next()) {
                System.out.println(results.getString("name") + " " + results.getInt("phone") + " " + results.getString("email"));
            }

            prepExample.close();
            statement.close();
            conn.close();


        } catch(SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
            e.printStackTrace();
        }
//
//        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/xbbnwln/Projects/java-examples/1.basics/Database/TestDB2/testjava.db");
//            Statement statement = conn.createStatement()) {
//            statement.execute("CREATE TABLE contacts (name TEXT, phone INTEGER, email TEXT)");
//        } catch(SQLException e) {
//            System.out.println("Something went wrong: " + e.getMessage());
//        }
    }

    private static void insertContact(Statement statement, String name, int phone, String email) throws SQLException {

    }
}

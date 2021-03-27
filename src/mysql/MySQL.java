package mysql;

import java.sql.*;

public class MySQL {

    // Database URL
    static final String DB_NAME = "my_db";
    static final String DB_URL = "jdbc:mysql://localhost/" + DB_NAME + "?useTimezone=true&serverTimezone=UTC";

    //  Database credentials
    static final String USER = "user";
    static final String PASSWORD = "password";


    public static Connection connect() throws Exception {
        Connection con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        System.out.println("Connected to database ----> " + con.toString());
        return con;
    }

    public static void close_connection(Connection con) throws Exception{
        con.close();
    }

    public static void main(String[] args) {
        try {
            Connection con = connect();
            Statement stmt = con.createStatement();
            // Create table pet if pet doesn't already exist
            String sql = "CREATE TABLE IF NOT EXISTS pet" +
                    "( name VARCHAR(20), " +
                    " owner VARCHAR(20), " +
                    " species VARCHAR(20), " +
                    " sex CHAR(1))";
            stmt.executeUpdate(sql);
            System.out.println("Table pet found (created)");
            close_connection(con);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        show_records();
    }

    // Select all records from table
    public static void show_records() {
        try {
            Connection con = connect();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from pet");
            while (rs.next()) {
                System.out.println("row: "+rs.getString(1)+", "+ rs.getString(2)+", "+rs.getString(3));
            }
            close_connection(con);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Insert a record
    public static void insert(String name, String owner,String species, Character sex) {
        try {
            Connection con = connect();
            Statement stmt = con.createStatement();
            System.out.println("Insert new record -----> " + name + ", " + owner + ", " + species + ", " + sex);
            stmt.executeUpdate("INSERT INTO pet(name, owner, species, sex)" +
                    " VALUES ('"+name+"','"+owner+"','"+species+"','"+sex+"')");
            close_connection(con);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Delete a record based on the given criterion
    public static void delete(String key, String value) {
        try {
            Connection con = connect();
            Statement stmt = con.createStatement();
            System.out.println("DELETE FROM pet WHERE " + key + "='" + value + "'");
            stmt.executeUpdate("DELETE FROM pet WHERE " + key + "='" + value + "'");
            close_connection(con);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}

package com.company;

import java.io.PrintStream;
import java.sql.*;

public class Main {

    public static void main(String[] args) {

        final String DB_URL = "jdbc:mysql://localhost:3306/titanicmanifest";
        final String DB_USER = "Julio";
        final String DB_PASSWORD = "gurthang.1";

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            Statement stmt = con.createStatement();
            String sqlQuery = "SELECT * FROM titanicmanifest.titanic;";

            ResultSet rs = stmt.executeQuery(sqlQuery);

            ResultSetMetaData metaData = rs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            for(int i = 1; i <= numberOfColumns; i++) {
                System.out.printf("%-8s\t", metaData.getColumnName(i));
            }
            System.out.println();

            while(rs.next()) {
                PrintStream var10000 = System.out;
                int var10001 = rs.getInt(1);
                var10000.println(var10001 + " " + rs.getInt(2) + " " + rs.getInt(3)
                        + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getInt(6)
                        + " " + rs.getInt(7) + " " + rs.getInt(8) + " " + rs.getString(9)
                        + " " + rs.getString(10) + " " + rs.getString(11) + " " + rs.getString(12));
            }

        }
        catch (SQLException e) {
            System.out.println(e.toString());
        } catch (Exception e) {

        } finally {
            System.out.println("END OF QUERY");
        }

    }
}

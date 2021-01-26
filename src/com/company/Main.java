package com.company;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/titanicmanifest", "Julio", "gurthang.1");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM PASSENGERS;");
            System.out.println("before while");

            while(rs.next()) {
                PrintStream var10000 = System.out;
                int var10001 = rs.getInt(1);
                var10000.println(var10001 + " " + rs.getString(2) + " " + rs.getString(3)
                        + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6)
                        + " " + rs.getString(7) + " " + rs.getString(8) + " " + rs.getString(9)
                        + " " + rs.getString(10) + " " + rs.getString(11));
            }

            System.out.println("after while");
            con.close();
        } catch (Exception var7) {
            System.out.println(var7.toString());
        } finally {
            System.out.println("inside");
        }

    }
}

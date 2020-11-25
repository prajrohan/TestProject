package com.test.tt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class LanguagesTest {


	
	public static void main(String[] args){

		try {
			Statement stmt;
			ResultSet rs;
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/hindi_test?useUnicode=true&connectionCollation=utf8_general_ci&characterSetResults=utf8";
			Connection con = (Connection) DriverManager.getConnection(url, "root", "moviesForYou");
			    stmt = (Statement) con.createStatement();
			    stmt.executeQuery("SET NAMES 'UTF8'");
			    stmt.executeQuery("SET CHARACTER SET 'UTF8'");
			    String greekname = "κωνσταντίνα";
			    stmt.executeUpdate("INSERT INTO hindi(data) VALUES (N'ರಾಜಜಿನಗರ')");
			    System.out.println("Statement-->"+stmt.toString());
			    con.close();
			} catch (Exception e) {
			    System.out.println("problem during the connection with the database!"+e);
			}
		
	}
	
}

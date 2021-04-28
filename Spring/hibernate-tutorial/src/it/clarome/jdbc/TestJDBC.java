package it.clarome.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;


public class TestJDBC {
	
	public static void main(String[] args) {
		
		final String jdbcURL = 
				"jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		final String user = "hbstudent";
		final String pass = "hbstudent";
		
		try {
			System.out.println("Connecting to: "+jdbcURL);
			
			Connection conn = DriverManager.getConnection(jdbcURL, user, pass);
			
			System.out.println("Connection successfull");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

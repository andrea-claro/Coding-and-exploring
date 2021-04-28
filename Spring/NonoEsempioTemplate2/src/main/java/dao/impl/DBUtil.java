package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	private final String URL = "jdbc:postgresql://127.0.0.1:5432/corsomarzo";
	private final String USN = "postgres";
	private final String PWD = "admin";
	
	public Connection getConnection() throws SQLException{
		Connection conn = DriverManager.getConnection(URL, USN, PWD);
		return conn;
	}
	
}

package labs.ReverseEngineering;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class dbconnect {
	private static final String URL = "jdbc:mysql://localhost/sakila";
	private static final String user ="root";
	private static final String password = "root";
	private Connection con;
	
	public dbconnect() {
		try {
			con = (Connection) DriverManager.getConnection(URL,user,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection() {
		return con;
	}
}

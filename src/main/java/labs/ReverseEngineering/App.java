package labs.ReverseEngineering;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class App {
	public static void main(String[] args) {
		Connection con = new dbconnect().getConnection();
		System.out.println(getDatabaseTablesNames(con));
	}

	public static LinkedList<String> getDatabaseTablesNames(Connection con) {
		LinkedList<String> tableNames = new LinkedList<String>();
		String[] types = { "TABLE" };

		try {
			DatabaseMetaData dbmd = con.getMetaData();
			ResultSet rs = dbmd.getTables(null, null, "%", types);
			while (rs.next()) {
				tableNames.add(rs.getString("TABLE_NAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tableNames;
	}
}

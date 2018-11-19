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
		System.out.println(getDatabaseTableColumns(con,"actor"));
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

	
	public static Map<String, Integer> getDatabaseTableColumns(Connection con, String table) {
		Map<String, Integer> infos  = new HashMap<String, Integer>();
		try {
			DatabaseMetaData dbmd = con.getMetaData();
			ResultSet rs = dbmd.getColumns(null, null, table, null);
			while (rs.next()) {
				infos.put(rs.getString("COLUMN_NAME"), rs.getInt("DATA_TYPE"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return infos;
	}
	
	public static Map<String,String,String,String,String> getKeys (Connection con,String table) {
		try {
			DatabaseMetaData dbmd = con.getMetaData();
			ResultSet rs = dbmd.getImportedKeys(null, null, table);
			while (rs.next()) {
				infos.put(rs.getString("COLUMN_NAME"), rs.getInt("DATA_TYPE"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return infos;
		
	}
	
	
	
	
	
	
	
}

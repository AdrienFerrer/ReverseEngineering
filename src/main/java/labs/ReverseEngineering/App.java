package labs.ReverseEngineering;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class App {
	public static void main(String[] args) {
		Connection con = new dbConnect().getConnection();
		
		// EXAMPLE OF TABLE CREATION
		//dbTable test = new dbTable();
		//test.getTable(con, "actor");
		//System.out.println(test.getTABLE_NAME());
		//
		
		
		// TESTING MAPTABLES CREATION
		System.out.println(makeMapTables (con).get("actor").TABLE_NAME);
	}
	
	public static HashMap<String,dbTable> makeMapTables (Connection con){
		List<String> tableNames = new ArrayList<String>();
		HashMap<String,dbTable> tablesMap = new HashMap<String,dbTable>();
		try {
			DatabaseMetaData dbmd = con.getMetaData();
			String[] types = { "TABLE" };
			ResultSet rs = dbmd.getTables(null, "%", "%", types);
			while (rs.next()) {
				tableNames.add(rs.getString("TABLE_NAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for(String name:tableNames) {
			dbTable Table = new dbTable(con, name);
        	tablesMap.put(name, Table);
		}
		return tablesMap;
	}
}

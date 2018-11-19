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


public class dbTable {
	protected static String TABLE_SCHEMA;
	protected static String TABLE_NAME;
	protected static int TABLE_TYPE;
	protected static String TYPE_NAME;
	
	public dbTable() {
		super();	
	}
	
	public void getTable(Connection con) {
		
		try {
			DatabaseMetaData dbmd = con.getMetaData();
			String[] types = { "TABLE" };
			ResultSet rs = dbmd.getTables(null, null, "%", types);
			while (rs.next()) {
				this.TABLE_SCHEMA = rs.getString("TABLE_SCHEMA");
				this.TABLE_NAME = rs.getString("TABLE_NAME");
				this.TABLE_TYPE = rs.getInt("TABLE_TYPE");
				this.TYPE_NAME = rs.getString("TYPE_NAME");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	public static String getTABLE_SCHEMA() {
		return TABLE_SCHEMA;
	}

	public static void setTABLE_SCHEMA(String tABLE_SCHEMA) {
		TABLE_SCHEMA = tABLE_SCHEMA;
	}

	public static String getTABLE_NAME() {
		return TABLE_NAME;
	}

	public static void setTABLE_NAME(String tABLE_NAME) {
		TABLE_NAME = tABLE_NAME;
	}

	public static int getTABLE_TYPE() {
		return TABLE_TYPE;
	}

	public static void setTABLE_TYPE(int tABLE_TYPE) {
		TABLE_TYPE = tABLE_TYPE;
	}

	public static String getTYPE_NAME() {
		return TYPE_NAME;
	}

	public static void setTYPE_NAME(String tYPE_NAME) {
		TYPE_NAME = tYPE_NAME;
	}
}
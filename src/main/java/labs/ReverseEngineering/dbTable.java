package labs.ReverseEngineering;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class dbTable {
	protected String TABLE_SCHEMA=null;
	protected String TABLE_NAME=null;
	protected int TABLE_TYPE=0;
	protected String TYPE_NAME;

	public dbTable(Connection con, String TABLE_NAME) {
		super();
		try {
			DatabaseMetaData dbmd = con.getMetaData();
			String[] types = { "TABLE" };
			ResultSet rs = dbmd.getTables(null, "%", TABLE_NAME, types);
			while (rs.next()) {
				//this.TABLE_SCHEMA = rs.getString("TABLE_SCHEMA");
				this.TABLE_NAME = rs.getString("TABLE_NAME");
				//this.TABLE_TYPE = rs.getInt("TABLE_TYPE");
				//this.TYPE_NAME = rs.getString("TYPE_NAME");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public String getTABLE_SCHEMA() {
		return TABLE_SCHEMA;
	}

	public void setTABLE_SCHEMA(String TABLE_SCHEMA) {
		TABLE_SCHEMA = TABLE_SCHEMA;
	}

	public String getTABLE_NAME() {
		return TABLE_NAME;
	}

	public void setTABLE_NAME(String TABLE_NAME) {
		TABLE_NAME = TABLE_NAME;
	}

	public int getTABLE_TYPE() {
		return TABLE_TYPE;
	}

	public void setTABLE_TYPE(int TABLE_TYPE) {
		TABLE_TYPE = TABLE_TYPE;
	}

	public String getTYPE_NAME() {
		return TYPE_NAME;
	}

	public void setTYPE_NAME(String TYPE_NAME) {
		TYPE_NAME = TYPE_NAME;
	}
}
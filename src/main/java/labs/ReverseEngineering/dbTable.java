package labs.ReverseEngineering;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class dbTable {
	protected String TABLE_SCHEMA;
	protected String TABLE_NAME;
	protected int TABLE_TYPE;
	protected String TYPE_NAME;

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
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getTABLE_SCHEMA() {
		return TABLE_SCHEMA;
	}

	public void setTABLE_SCHEMA(String tABLE_SCHEMA) {
		TABLE_SCHEMA = tABLE_SCHEMA;
	}

	public String getTABLE_NAME() {
		return TABLE_NAME;
	}

	public void setTABLE_NAME(String tABLE_NAME) {
		TABLE_NAME = tABLE_NAME;
	}

	public int getTABLE_TYPE() {
		return TABLE_TYPE;
	}

	public void setTABLE_TYPE(int tABLE_TYPE) {
		TABLE_TYPE = tABLE_TYPE;
	}

	public String getTYPE_NAME() {
		return TYPE_NAME;
	}

	public void setTYPE_NAME(String tYPE_NAME) {
		TYPE_NAME = tYPE_NAME;
	}
}
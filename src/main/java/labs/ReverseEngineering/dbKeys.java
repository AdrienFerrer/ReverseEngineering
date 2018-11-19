package labs.ReverseEngineering;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class dbKeys {
	private dbTable table;
	private String pkColumnName;
	private String pkName;
	private String pkTableName;
	private String fkColumnName;

	private String fkName;
	private String fkTableName;

	public void getColumns(Connection con) {
		try {
			DatabaseMetaData dbmd = con.getMetaData();
			ResultSet rs = dbmd.getPrimaryKeys(null, null, table.getTABLE_NAME());
			while (rs.next()) {
				pkColumnName = rs.getString("PKCOLUMN_NAME");
				pkName = rs.getString("PK_NAME");
				pkTableName = rs.getString("PKTABLE_NAME");
				fkColumnName = rs.getString("FKCOLUMN_NAME");
				fkName = rs.getString("FK_NAME");
				fkTableName = rs.getString("FKTABLE_NAME");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public dbKeys(dbTable table) {
		super();
		this.table = table;
	}

	public dbTable getTable() {
		return table;
	}

	public void setTable(dbTable table) {
		this.table = table;
	}

	public String getColumnName() {
		return pkColumnName;
	}

	public void setColumnName(String columnName) {
		this.pkColumnName = columnName;
	}

	public String getPkName() {
		return pkName;
	}

	public void setPkName(String pkName) {
		this.pkName = pkName;
	}

	public String getPkColumnName() {
		return pkColumnName;
	}

	public void setPkColumnName(String pkColumnName) {
		this.pkColumnName = pkColumnName;
	}

	public String getPkTableName() {
		return pkTableName;
	}

	public void setPkTableName(String pkTableName) {
		this.pkTableName = pkTableName;
	}

	public String getFkColumnName() {
		return fkColumnName;
	}

	public void setFkColumnName(String fkColumnName) {
		this.fkColumnName = fkColumnName;
	}

	public String getFkName() {
		return fkName;
	}

	public void setFkName(String fkName) {
		this.fkName = fkName;
	}

	public String getFkTableName() {
		return fkTableName;
	}

	public void setFkTableName(String fkTableName) {
		this.fkTableName = fkTableName;
	}

}

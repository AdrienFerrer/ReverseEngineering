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




	public dbKeys(dbTable table, String pkColumnName, String pkName, String pkTableName, String fkColumnName,
			String fkName, String fkTableName) {
		super();
		this.table = table;
		this.pkColumnName = pkColumnName;
		this.pkName = pkName;
		this.pkTableName = pkTableName;
		this.fkColumnName = fkColumnName;
		this.fkName = fkName;
		this.fkTableName = fkTableName;
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

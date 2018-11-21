package labs.ReverseEngineering;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class dbTables {
	private List<String> tableNames = new ArrayList<String>();
	private List<dbTable> tables = new ArrayList<dbTable>();
	private int size=0;

	public dbTables(Connection con) {
		super();
		try {
			DatabaseMetaData dbmd = con.getMetaData();
			String[] types = {"TABLE"};
			ResultSet rs = dbmd.getTables(null, null, "%",  types);
			while (rs.next()) {
				this.tableNames.add(rs.getString("TABLE_NAME"));
				this.tables.add(new dbTable(con,rs.getString("TABLE_NAME")));
				this.size++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public List<String> getTableNames() {
		return tableNames;
	}

	public void setTableNames(List<String> tableNames) {
		this.tableNames = tableNames;
	}

	public List<dbTable> getTables() {
		return tables;
	}

	public void setTables(List<dbTable> tables) {
		this.tables = tables;
	}



}
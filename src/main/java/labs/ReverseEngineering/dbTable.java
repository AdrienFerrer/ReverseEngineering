package labs.ReverseEngineering;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class dbTable {
	private String tableName="";
	private List<dbColumn>allColumns = new ArrayList<dbColumn>();
	private int size=0;

	public dbTable(Connection con,String tableName) {
		this.tableName=tableName;
		
		try {
			DatabaseMetaData dbmd = con.getMetaData();
			ResultSet rs = dbmd.getColumns(null, null, tableName, null);
			while (rs.next()) {
				dbColumn Column = new dbColumn(rs.getString("COLUMN_NAME"),rs.getInt("DATA_TYPE"),rs.getString("TYPE_NAME"),rs.getInt("COLUMN_SIZE"),rs.getInt("ORDINAL_POSITION"));
				allColumns.add(Column);
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


	public String getTableName() {
		return tableName;
	}


	public void setTableName(String tableName) {
		this.tableName = tableName;
	}


	public List<dbColumn> getAllColumns() {
		return allColumns;
	}


	public void setAllColumns(List<dbColumn> allColumns) {
		this.allColumns = allColumns;
	}



}

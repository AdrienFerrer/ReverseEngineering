package labs.ReverseEngineering;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class dbTable {
	private String tableName = "";
	private List<dbColumn> allColumns = new ArrayList<dbColumn>();
	private List<dbKeys> listKeys = new ArrayList<dbKeys>();
	private List<dbIndex> listIndex = new ArrayList<dbIndex>();
	private int size = 0;

	public dbTable(Connection con, String tableName) {
		this.tableName = tableName;
		try {
			DatabaseMetaData dbmd = con.getMetaData();
			ResultSet rs = dbmd.getColumns(null, null, tableName, null);
			while (rs.next()) {
				dbColumn Column = new dbColumn(rs.getString("COLUMN_NAME"), rs.getInt("DATA_TYPE"),
						rs.getString("TYPE_NAME"), rs.getInt("COLUMN_SIZE"), rs.getInt("ORDINAL_POSITION"));
				allColumns.add(Column);
				this.size++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			DatabaseMetaData dbmd = con.getMetaData();
			ResultSet rs = dbmd.getImportedKeys(null, null, tableName);
			while (rs.next()) {
				listKeys.add(
						new dbKeys(rs.getString("PKCOLUMN_NAME"), rs.getString("PK_NAME"), rs.getString("PKTABLE_NAME"),
								rs.getString("FKCOLUMN_NAME"), rs.getString("FK_NAME"), rs.getString("FKTABLE_NAME")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			DatabaseMetaData dbmd = con.getMetaData();
			ResultSet rs = dbmd.getIndexInfo(null, null, tableName, false, false);
			while (rs.next()) {
				listIndex.add(new dbIndex(rs.getBoolean("NON_UNIQUE"),
						rs.getString("INDEX_NAME"),rs.getString("COLUMN_NAME")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<dbKeys> getListKeys() {
		return listKeys;
	}

	public void setListKeys(List<dbKeys> listKeys) {
		this.listKeys = listKeys;
	}

	public List<dbIndex> getListIndex() {
		return listIndex;
	}

	public void setListIndex(List<dbIndex> listIndex) {
		this.listIndex = listIndex;
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

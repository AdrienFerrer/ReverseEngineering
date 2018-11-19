package labs.ReverseEngineering;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class dbColumns {
	private dbTable table;
	private String columnName;
	private int dataType;
	private String typeName;
	private int columnSize;
	private int ordinalPosition;

	public dbColumns(dbTable table) {
		super();
		this.setTable(table);
	}

	public void getColumns(Connection con) {
		try {
			DatabaseMetaData dbmd = con.getMetaData();
			ResultSet rs = dbmd.getColumns(null, null, null, table.getTABLE_NAME());
			while (rs.next()) {
				columnName = rs.getString("COLUMN_NAME");
				dataType = rs.getInt("DATA_TYPE");
				typeName = rs.getString("TYPE_NAME");
				columnSize = rs.getInt("COLUMN_SIZE");
				ordinalPosition = rs.getInt("ORDINAL_POSITION");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public int getDataType() {
		return dataType;
	}

	public void setDataType(int dataType) {
		this.dataType = dataType;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public int getColumnSize() {
		return columnSize;
	}

	public void setColumnSize(int columnSize) {
		this.columnSize = columnSize;
	}

	public int getOrdinalPosition() {
		return ordinalPosition;
	}

	public void setOrdinalPosition(int ordinalPosition) {
		this.ordinalPosition = ordinalPosition;
	}

	public dbTable getTable() {
		return table;
	}

	public void setTable(dbTable table) {
		this.table = table;
	}

}

package labs.ReverseEngineering;

public class dbColumn {
	private String columnName;
	private int dataType;
	private String typeName;
	private int columnSize;
	private int ordinalPosition;

	public dbColumn(String columnName, int dataType, String typeName, int columnSize,
			int ordinalPosition) {
		super();
		this.columnName = columnName;
		this.dataType = dataType;
		this.typeName = typeName;
		this.columnSize = columnSize;
		this.ordinalPosition = ordinalPosition;
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
}

package labs.ReverseEngineering;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class dbIndex {
	private dbTable table;
	private boolean nonUnique;
	private String indexQualifier;
	private String indexName;
	private short type;
	private short ordinalPosition;
	private String columnName;
	private String ascOrDesc;
	private int cardinality;
	private int pages;
	private String filterCondition;

	public dbIndex(dbTable table) {
		super();
		this.table = table;
	}

	public void getIndex(Connection con) {
		try {
			DatabaseMetaData dbmd = con.getMetaData();
			ResultSet rs = dbmd.getIndexInfo(null, null, table.getTableName(), false, false);
			while (rs.next()) {
				nonUnique = rs.getBoolean("NON_UNIQUE");
				indexQualifier = rs.getString("QUALIFIER");
				indexName = rs.getString("INDEX_NAME");
				type = rs.getShort("TYPE");
				ordinalPosition = rs.getShort("ORDINAL_POSITION");
				columnName = rs.getString("COLUMN_NAME");
				ascOrDesc = rs.getString("ASC_OR_DESC");
				cardinality = rs.getInt("CARDINALITY");
				pages = rs.getInt("PAGES");
				filterCondition = rs.getString("FILTER_CONDITION");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public dbTable getTable() {
		return table;
	}

	public void setTable(dbTable table) {
		this.table = table;
	}

	public boolean isNonUnique() {
		return nonUnique;
	}

	public void setNonUnique(boolean nonUnique) {
		this.nonUnique = nonUnique;
	}

	public String getIndexQualifier() {
		return indexQualifier;
	}

	public void setIndexQualifier(String indexQualifier) {
		this.indexQualifier = indexQualifier;
	}

	public String getIndexName() {
		return indexName;
	}

	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}

	public short getType() {
		return type;
	}

	public void setType(short type) {
		this.type = type;
	}

	public short getOrdinalPosition() {
		return ordinalPosition;
	}

	public void setOrdinalPosition(short ordinalPosition) {
		this.ordinalPosition = ordinalPosition;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getAscOrDesc() {
		return ascOrDesc;
	}

	public void setAscOrDesc(String ascOrDesc) {
		this.ascOrDesc = ascOrDesc;
	}

	public int getCardinality() {
		return cardinality;
	}

	public void setCardinality(int cardinality) {
		this.cardinality = cardinality;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getFilterCondition() {
		return filterCondition;
	}

	public void setFilterCondition(String filterCondition) {
		this.filterCondition = filterCondition;
	}
}

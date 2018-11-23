package labs.ReverseEngineering;
public class dbIndex {
	private boolean nonUnique;
	private String indexName;
	private String columnName;

	public dbIndex(boolean nonUnique, String indexName, String columnName) {
		super();
		this.nonUnique = nonUnique;
		this.indexName = indexName;
		this.columnName = columnName;

	}

	public boolean isNonUnique() {
		return nonUnique;
	}

	public void setNonUnique(boolean nonUnique) {
		this.nonUnique = nonUnique;
	}

	public String getIndexName() {
		return indexName;
	}

	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
}

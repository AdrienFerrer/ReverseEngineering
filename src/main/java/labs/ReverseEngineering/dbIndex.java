package labs.ReverseEngineering;
public class dbIndex {
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

	public dbIndex(boolean nonUnique, String indexQualifier, String indexName, short type, short ordinalPosition,
			String columnName, String ascOrDesc, int cardinality, int pages, String filterCondition) {
		super();
		this.nonUnique = nonUnique;
		this.indexQualifier = indexQualifier;
		this.indexName = indexName;
		this.type = type;
		this.ordinalPosition = ordinalPosition;
		this.columnName = columnName;
		this.ascOrDesc = ascOrDesc;
		this.cardinality = cardinality;
		this.pages = pages;
		this.filterCondition = filterCondition;
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

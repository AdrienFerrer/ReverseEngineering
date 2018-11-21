package labs.ReverseEngineering;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class App {
	public static void main(String[] args) {
		Connection con = new dbConnect().getConnection();

		dbTables Tables=new dbTables(con);
		
		sqlQuery(Tables);
		
		//TESTING TABLES
		System.out.println(Tables.getTables().get(0).getAllColumns().get(1).getColumnName());
		//System.out.println();
	}
	
	public static String sqlQuery (dbTables Tables) {
		for(int i=0;i<Tables.getSize();i++) {
			for(int j=0;j<Tables.getTables().size();j++) {
				for(int k=0;j<Tables.getTables().get(j).getSize();j++) {
					System.out.println(Tables.getTables().get(j).getAllColumns().get(k).getColumnName());
				}

			}
			
		}
		
		return "";
	}
	/*
	public static List<dbKeys> makeListKeys(Connection con, List<dbTable> tablesMap) {
		List<dbKeys> listKeys = new ArrayList<dbKeys>();
		for (dbTable str : tablesMap) {
			try {
				DatabaseMetaData dbmd = con.getMetaData();
				ResultSet rs = dbmd.getPrimaryKeys(null, null, str.getTableName());
				while (rs.next()) {
					listKeys.add(new dbKeys(str, rs.getString("PKCOLUMN_NAME"), rs.getString("PK_NAME"),
							rs.getString("PKTABLE_NAME"), rs.getString("FKCOLUMN_NAME"), rs.getString("FK_NAME"),
							rs.getString("FKTABLE_NAME")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listKeys;
	}

	public static List<dbIndex> makeListIndex(Connection con, List<dbTable> tablesMap) {
		List<dbIndex> listIndex = new ArrayList<dbIndex>();
		for (dbTable str : tablesMap) {
			try {
				DatabaseMetaData dbmd = con.getMetaData();
				ResultSet rs = dbmd.getIndexInfo(null, null, str.getTableName(), false, false);
				while (rs.next()) {
					listIndex.add(new dbIndex(str, rs.getBoolean("NON_UNIQUE"), rs.getString("QUALIFIER"),
							rs.getString("INDEX_NAME"), rs.getShort("TYPE"), rs.getShort("ORDINAL_POSITION"),
							rs.getString("COLUMN_NAME"), rs.getString("ASC_OR_DESC"), rs.getInt("CARDINALITY"),
							rs.getInt("PAGES"), rs.getString("FILTER_CONDITION")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listIndex;
	}
	
	
	
/*
	public static List<dbTable> makeMapTables(Connection con) {
		List<dbTable> tablesMap = new ArrayList<dbTable>();
		try {
			DatabaseMetaData dbmd = con.getMetaData();
			String[] types = { "TABLE" };
			ResultSet rs = dbmd.getTables(null, "%", "%", types);
			while (rs.next()) {
				tablesMap.add(new dbTable(rs.getString("TABLE_SCHEM"), rs.getString("TABLE_NAME"),
						rs.getString("TABLE_TYPE")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tablesMap;
	}

	


	
	/*
	public static List<dbColumns> makeMapColumn(Connection con, List<dbTable> tablesMap) {
		List<dbColumns> listColumn = new ArrayList<dbColumns>();
		for (dbTable str : tablesMap) {
			try {
				DatabaseMetaData dbmd = con.getMetaData();
				ResultSet rs = dbmd.getColumns(null, null, str.getTableName(), null);
				while (rs.next()) {
					listColumn.add(new dbColumns(str, rs.getString("COLUMN_NAME"), rs.getInt("DATA_TYPE"),
							rs.getString("TYPE_NAME"), rs.getInt("COLUMN_SIZE"), rs.getInt("ORDINAL_POSITION")));
					//System.out.println(
					//		rs.getString("COLUMN_NAME") + rs.getInt("COLUMN_SIZE") + rs.getInt("ORDINAL_POSITION"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listColumn;
	}*/

}

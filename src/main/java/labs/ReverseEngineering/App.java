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

		// EXAMPLE OF TABLE CREATION
		// dbTable test = new dbTable();
		// test.getTable(con, "actor");
		// System.out.println(test.getTABLE_NAME());
		//

		// TESTING MAPTABLES CREATION
		List<dbTable> tablesMap = new ArrayList<dbTable>();
		tablesMap = makeMapTables(con);
		/*
		 * for (int i = 0; i < tablesMap.size(); i++) {
		 * System.out.println(tablesMap.get(i).getTableName()); }
		 */
		// Map<dbTable, dbColumns> tableColumn = new HashMap<dbTable, dbColumns>();
		List<dbColumns> listColumn = new ArrayList<dbColumns>();
		listColumn = makeMapColumn(con, tablesMap);
		// System.out.println(tableColumn.get(tableColumn.get(tablesMap.get(1)).getColumnName()));
	}

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

	public static List<dbColumns> makeMapColumn(Connection con, List<dbTable> tablesMap) {
		List<dbColumns> listColumn = new ArrayList<dbColumns>();
		for (int i = 0; i < tablesMap.size(); i++) {
			try {
				DatabaseMetaData dbmd = con.getMetaData();
				ResultSet rs = dbmd.getColumns(null, null, null, tablesMap.get(i).getTableName());
				while (rs.next()) {
					listColumn.add(new dbColumns(tablesMap.get(i), rs.getString("COLUMN_NAME"), rs.getInt("DATA_TYPE"),
							rs.getString("TYPE_NAME"), rs.getInt("COLUMN_SIZE"), rs.getInt("ORDINAL_POSITION")));
					System.out.println(
							rs.getString("COLUMN_NAME") + rs.getInt("COLUMN_SIZE") + rs.getInt("ORDINAL_POSITION"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listColumn;
	}

}

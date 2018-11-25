package labs.ReverseEngineering;

import java.sql.Connection;

public class App {
	public static void main(String[] args) {
		Connection con = new dbConnect().getConnection();
		dbTables Tables = new dbTables(con);
		System.out.println(sqlStructureQuery(Tables));
		System.out.println(sqlIndexQuery(Tables));
		System.out.println(sqlKeysQuery(Tables));
		//Create Query
		String fullquery = sqlStructureQuery(Tables) + sqlIndexQuery(Tables) + sqlKeysQuery(Tables);
		//Generate File
		WriteSqlFile file = new WriteSqlFile(fullquery, "CreateSchema", ".sql");
		file.generateFile();

	}

	public static String sqlKeysQuery(dbTables Tables) {
		String query = "";
		for (int i = 0; i < Tables.getSize(); i++) {
			for (int j = 0; j < Tables.getTables().size(); j++) {
				for (int k = 0; k < Tables.getTables().get(j).getListKeys().size(); k++) {
					if (Tables.getTables().get(j).getListKeys().get(k).getPkTableName().isEmpty()) {
						query += "ALTER TABLE";
						query += " " + Tables.getTables().get(j).getListKeys().get(k).getPkTableName();
						query += " ADD CONSTRAINT " + Tables.getTables().get(j).getListKeys().get(k).getPkName();
						query += " PRIMARY KEY (" + Tables.getTables().get(j).getListKeys().get(k).getPkColumnName()
								+ " );";
					} else {
						query += "ALTER TABLE";
						query += " " + Tables.getTables().get(j).getListKeys().get(k).getFkTableName();
						query += " ADD CONSTRAINT " + Tables.getTables().get(j).getListKeys().get(k).getFkName();
						query += " PRIMARY KEY (" + Tables.getTables().get(j).getListKeys().get(k).getFkColumnName()
								+ " );";
					}
				}
			}
		}

		return query;
	}

	public static String sqlIndexQuery(dbTables Tables) {
		String query = "";
		for (int i = 0; i < Tables.getSize(); i++) {
			for (int j = 0; j < Tables.getTables().size(); j++) {
				for (int k = 0; k < Tables.getTables().get(j).getListIndex().size(); k++) {
					query += "CREATE UNIQUE INDEX ";
					query += Tables.getTables().get(j).getListIndex().get(k).getIndexName();
					query += " ON " + Tables.getTables().get(j).getTableName() + " ( ";
					query += Tables.getTables().get(j).getListIndex().get(k).getColumnName();
					query += " );";
				}
			}
		}
		return query;
	}

	public static String sqlStructureQuery(dbTables Tables) {

		String query = "";
		for (int i = 0; i < Tables.getSize(); i++) {
			for (int j = 0; j < Tables.getTables().size(); j++) {
				query = query + "CREATE TABLE " + Tables.getTables().get(j).getTableName() + "(";
				for (int k = 0; k < Tables.getTables().get(j).getSize(); k++) {
					query = query + Tables.getTables().get(j).getAllColumns().get(k).getColumnName() + " "
							+ Tables.getTables().get(j).getAllColumns().get(k).getDataType() + ",";
					// System.out.println(Tables.getTables().get(j).getAllColumns().get(k).getColumnName());
				}
				query = query + ");";
			}
		}
		return query;
	}
}

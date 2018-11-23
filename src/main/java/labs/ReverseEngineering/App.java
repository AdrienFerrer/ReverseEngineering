package labs.ReverseEngineering;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;


public class App {
	public static void main(String[] args) {
		Connection con = new dbConnect().getConnection();
		dbTables Tables=new dbTables(con);
		//System.out.println(sqlStructureQuery(Tables));
		//System.out.println(sqlIndexQuery(Tables));
		
		
		//A DECOMMENTER AVANT D'ENVOYER => C'est la génération du fichier
		//String fullquery = sqlStructureQuery(Tables)+sqlIndexQuery(Tables);
		//WriteSqlFile file = new WriteSqlFile(fullquery, "", "");
	
	}
	
	public static String sqlKeysQuery (dbTables Tables) {
		String query="";
		
		
		return query;
	}
	

	public static String sqlIndexQuery (dbTables Tables) {
		String query="";
		for(int i=0;i<Tables.getSize();i++) {
			for(int j=0;j<Tables.getTables().size();j++) {
				for(int k=0;k<Tables.getTables().get(j).getListIndex().size();k++) {
					query+="CREATE UNIQUE INDEX ";
					query+=Tables.getTables().get(j).getListIndex().get(k).getIndexName();
					query+=" ON "+Tables.getTables().get(j).getTableName()+" ( ";
					query+=Tables.getTables().get(j).getListIndex().get(k).getColumnName();
					query+=" );";
				}
			}
		}
		return query;
	}
	
	public static String sqlStructureQuery (dbTables Tables) {
		
		String query="";
		for(int i=0;i<Tables.getSize();i++) {
			for(int j=0;j<Tables.getTables().size();j++) {
				query=query+"CREATE TABLE "+Tables.getTables().get(j).getTableName()+"(";
				for(int k=0;k<Tables.getTables().get(j).getSize();k++) {
					query=query+Tables.getTables().get(j).getAllColumns().get(k).getColumnName()+" "+Tables.getTables().get(j).getAllColumns().get(k).getDataType()+",";
					//System.out.println(Tables.getTables().get(j).getAllColumns().get(k).getColumnName());
				}
				query=query+");";
			}
		}
		return query;
	}
}

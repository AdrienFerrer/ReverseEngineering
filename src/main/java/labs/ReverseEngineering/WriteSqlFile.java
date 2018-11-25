package labs.ReverseEngineering;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteSqlFile {
	private String query;
	private String fileName;
	private String extension;

	public WriteSqlFile(String query, String pathFile, String extension) {
		super();
		this.query = query;
		this.fileName = pathFile;
		this.extension = extension;
	}

	public void generateFile() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + extension));
			writer.write(query);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getPathFile() {
		return fileName;
	}

	public void setPathFile(String pathFile) {
		this.fileName = pathFile;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

}

package day2.examples;

import java.util.Date;

public class Files {
	private int fileno;
	private String filename;
	private Date filedate;
	
	public Files() {}

	public Files(int fileno, String filename, Date filedate) {
		super();
		this.fileno = fileno;
		this.filename = filename;
		this.filedate = filedate;
	}

	public int getFileno() {
		return fileno;
	}

	public void setFileno(int fileno) {
		this.fileno = fileno;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Date getFiledate() {
		return filedate;
	}

	public void setFiledate(Date filedate) {
		this.filedate = filedate;
	}

	@Override
	public String toString() {
		return "Files [fileno=" + fileno + ", filename=" + filename + ", filedate=" + filedate + "]";
	}
	
	
}

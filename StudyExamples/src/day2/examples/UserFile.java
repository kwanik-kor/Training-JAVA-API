package day2.examples;

import java.util.Date;

public class UserFile extends Files {
	private int fileno;
	private int userno;
	private String filename;
	private Date filedate;
	
	public UserFile() {}
	
	
	public UserFile(int fileno, int userno, String filename, Date filedate) {
		super();
		this.fileno = fileno;
		this.userno = userno;
		this.filename = filename;
		this.filedate = filedate;
	}


	public int getFileno() {
		return fileno;
	}

	public void setFileno(int fileno) {
		this.fileno = fileno;
	}

	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
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
		return "UserFile [fileno=" + fileno + ", userno=" + userno + ", filename=" + filename + ", filedate=" + filedate
				+ "]";
	}

	
}

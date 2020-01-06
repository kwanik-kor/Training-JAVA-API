package day2.examples;

import java.util.Date;

public class ProjectFile extends Files{
	private int fileno;
	private int projectno;
	private String filename;
	private Date filedate;
	
	public ProjectFile() {}

	public ProjectFile(int fileno, int projectno, String filename, Date filedate) {
		super();
		this.fileno = fileno;
		this.projectno = projectno;
		this.filename = filename;
		this.filedate = filedate;
	}

	public int getFileno() {
		return fileno;
	}

	public void setFileno(int fileno) {
		this.fileno = fileno;
	}

	public int getProjectno() {
		return projectno;
	}

	public void setProjectno(int projectno) {
		this.projectno = projectno;
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
		return "ProjectFile [fileno=" + fileno + ", projectno=" + projectno + ", filename=" + filename + ", filedate="
				+ filedate + "]";
	}

	
}

package day2.examples;

public class A {
	private String id;
	private int fileno;
	private String content;
	public A(String id, int fileno, String content) {
		super();
		this.id = id;
		this.fileno = fileno;
		this.content = content;
	}
	
	public A() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getFileno() {
		return fileno;
	}

	public void setFileno(int fileno) {
		this.fileno = fileno;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "A [id=" + id + ", fileno=" + fileno + ", content=" + content + "]";
	}
	
}

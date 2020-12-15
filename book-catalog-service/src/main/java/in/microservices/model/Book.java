package in.microservices.model;

public class Book {
	
	private String bookId;
	
	private String name;

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Book(String bookId, String name) {
		super();
		this.bookId = bookId;
		this.name = name;
	}
	
	public Book() {
		
	}
	

}

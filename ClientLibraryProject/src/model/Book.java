package model;

public class Book {
	private String title;
	private String bookID;
	private int quantity;
	private String author;
	private String departureYear;
	
	public Book(String title, String bookID, int quantity, String author, String departureYear) {
		super();
		this.title = title;
		this.bookID = bookID;
		this.quantity = quantity;
		this.author = author;
		this.departureYear = departureYear;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBookID() {
		return bookID;
	}
	public void setBookID(String bookID) {
		this.bookID = bookID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDepartureYear() {
		return departureYear;
	}
	public void setDepartureYear(String departureYear) {
		this.departureYear = departureYear;
	}
	
}

package model;

public class Book {
	private String title;
	private int bookID;
	private int quantity;
	private String author;
	private String departureYear;
	private String description;
	private String pathImage;
	private String actPathImage;
	
	public Book(String title, int bookID, int quantity, String author, String departureYear, String description, String pathImage) {
		super();
		this.title = title;
		this.bookID = bookID;
		this.quantity = quantity;
		this.author = author;
		this.departureYear = departureYear;
		this.description = description;
		this.pathImage = pathImage;
	}
	
	private void selectPathImage() {
		if(quantity == 0) {
			actPathImage = "data\\frontPages\\agotado.jpg";
		}else {
			actPathImage = pathImage;
		}
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getBookID() {
		return bookID;
	}
	
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
		selectPathImage();
	}
	
	public String getActPathImage() {
		return actPathImage;
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
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getPathImage() {
		return pathImage;
	}
	
	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}
}

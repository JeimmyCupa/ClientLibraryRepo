package model;

public class CopyBook {
	private Book rentedBook;
	private int userID;

	public CopyBook(Book rentedBook, int userID) {
		this.rentedBook = rentedBook;
		this.userID = userID;
	}

	public int getUserID() {
		return userID;
	}
	
	public Book getRentedBook() {
		return this.rentedBook;
	}
}

package model;

public class CopyBook {
	private Book rentedBook;
	
	public CopyBook(Book rentedBook) {
		this.rentedBook = rentedBook;
	}

	public Book getRentedBook() {
		return this.rentedBook;
	}
}

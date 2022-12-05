package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;
import javax.swing.text.IconView;

import model.Book;
import model.CopyBook;
import view.MainWindow;

public class ClientController implements ActionListener{
	private MainWindow window;
	public ClientController() {
		window = new MainWindow(this,obtainBookSet());
		window.setVisible(true);
	}
	
	public static void main(String[] args) {
		new ClientController();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String event = e.getActionCommand();
		switch(event) {
		case "LOGIN":
			String user = window.obtainUser();
			window.initComponentsUser();//Prueba
			break;
		case "CREATEACCOUNT":
			break;
		case "REGISTER":
			window.initRegisterPanel();
			break;
		case "SHOWPROFILE":
			window.initProfile("Juan","juansito@gmail.com","18","2");
			break;
		case "SEARCHBOOKS":
			window.initSearchBooks(this.obtainBookSet());
			break;
		case "RENTBOOK":
			
			break;
		case "MYBOOKS":
			window.initRentedBooks(this.obtainRentedBooks());
			break;
		case "CANCELAR":
			window.closeDialog();
			break;
		case "SINGOUT":
			window.initLoginPanel();
			break;
		case "BACK":
			window.initLoginPanel();
			break;
		case "EXIT":
			window.dispose();
			break;
		
		}
		
	}
	private ArrayList<CopyBook> obtainRentedBooks(){
		ArrayList<CopyBook> bookSet = new ArrayList<>();
		bookSet.add(new CopyBook(new Book("Principito", 1, 19, "Pepito", "2005", "", ""), 1));
		bookSet.add(new CopyBook(new Book("100 Años de soledad", 2, 19, "Pepito", "2005", "", ""), 2));
		bookSet.add(new CopyBook(new Book("Principal", 3, 19, "Pepito", "2005", "", ""), 3));
		bookSet.add(new CopyBook(new Book("Pedro", 4, 19, "Pepito", "2005", "", ""), 4));
		bookSet.add(new CopyBook(new Book("A donde vas", 5, 19, "Pepito", "2005", "", ""), 5));
		bookSet.add(new CopyBook(new Book("No se que mas poner", 6, 19, "Pepito", "2005", "", ""), 6));
		bookSet.add(new CopyBook(new Book("Libro", 7, 19, "Pepito", "2005", "", ""), 7));
		bookSet.add(new CopyBook(new Book("Principito", 1, 19, "Pepito", "2005", "", ""), 1));
		bookSet.add(new CopyBook(new Book("100 Años de soledad", 2, 19, "Pepito", "2005", "", ""), 2));
		bookSet.add(new CopyBook(new Book("Principal", 3, 19, "Pepito", "2005", "", ""), 3));
		bookSet.add(new CopyBook(new Book("Pedro", 4, 19, "Pepito", "2005", "", ""), 4));
		bookSet.add(new CopyBook(new Book("A donde vas", 5, 19, "Pepito", "2005", "", ""), 5));
		bookSet.add(new CopyBook(new Book("No se que mas poner", 6, 19, "Pepito", "2005", "", ""), 6));
		bookSet.add(new CopyBook(new Book("Libro", 7, 19, "Pepito", "2005", "", ""), 7));
		bookSet.add(new CopyBook(new Book("Principito", 1, 19, "Pepito", "2005", "", ""), 1));
		bookSet.add(new CopyBook(new Book("100 Años de soledad", 2, 19, "Pepito", "2005", "", ""), 2));
		bookSet.add(new CopyBook(new Book("Principal", 3, 19, "Pepito", "2005", "", ""), 3));
		bookSet.add(new CopyBook(new Book("Pedro", 4, 19, "Pepito", "2005", "", ""), 4));
		bookSet.add(new CopyBook(new Book("A donde vas", 5, 19, "Pepito", "2005", "", ""), 5));
		bookSet.add(new CopyBook(new Book("No se que mas poner", 6, 19, "Pepito", "2005", "", ""), 6));
		bookSet.add(new CopyBook(new Book("Libro", 7, 19, "Pepito", "2005", "", ""), 7));
		return bookSet;
	}
	private ArrayList<Book> obtainBookSet() {
		ArrayList<Book> bookSet = new ArrayList<Book>();
		bookSet.add(new Book("Principito", 1, 19, "Pepito", "2005", "", ""));
		bookSet.add(new Book("100 Años de soledad", 2, 19, "Ana", "2010", "", ""));
		bookSet.add(new Book("Principal", 3, 19, "Pepito", "2005", "", ""));
		bookSet.add(new Book("Pedro", 4, 19, "Pepito", "2005", "", ""));
		bookSet.add(new Book("A donde vas", 5, 19, "Jeimmy", "2003", "", ""));
		bookSet.add(new Book("No se que mas poner", 6, 19, "Pepito", "2005", "", ""));
		bookSet.add(new Book("Libro", 7, 19, "Pepito", "2005", "", ""));
		bookSet.add(new Book("Principito", 1, 19, "Pepito", "2005", "", ""));
		bookSet.add(new Book("100 Años de soledad", 2, 19, "Sara", "2002", "", ""));
		bookSet.add(new Book("Principal", 3, 19, "Pepito", "2005", "", ""));
		bookSet.add(new Book("Pedro", 4, 19, "Jeimmy", "2005", "", ""));
		bookSet.add(new Book("A donde vas", 5, 19, "Pepito", "2003", "", ""));
		bookSet.add(new Book("No se que mas poner", 6, 19, "Pepito", "2005", "", ""));
		bookSet.add(new Book("Libro", 7, 19, "Pepito", "2005", "", ""));
		bookSet.add(new Book("Principito", 1, 19, "Ana", "2005", "", ""));
		bookSet.add(new Book("100 Años de soledad", 2, 19, "Pepito", "2005", "", ""));
		bookSet.add(new Book("Principal", 3, 19, "Pepito", "2005", "", ""));
		bookSet.add(new Book("Pedro", 4, 19, "Sara", "2005", "", ""));
		bookSet.add(new Book("A donde vas", 5, 19, "Pepito", "2005", "", ""));
		bookSet.add(new Book("No se que mas poner", 6, 19, "Pepito", "2005", "", ""));
		bookSet.add(new Book("Libro", 7, 19, "Jeimmy", "2003", "", ""));
		
		return bookSet;
	}
}

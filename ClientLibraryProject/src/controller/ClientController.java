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
		System.out.println("Prueba");
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
			window.initRentedBooks(this.obtainRentedBooks());
			break;
		case "MYBOOKS":
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
		bookSet.add(new CopyBook(new Book("Principito", 1, 19, "Pepito", "2005")));
		bookSet.add(new CopyBook(new Book("100 Años de soledad", 2, 19, "Pepito", "2005")));
		bookSet.add(new CopyBook(new Book("Principal", 3, 19, "Pepito", "2005")));
		bookSet.add(new CopyBook(new Book("Pedro", 4, 19, "Pepito", "2005")));
		bookSet.add(new CopyBook(new Book("A donde vas", 5, 19, "Pepito", "2005")));
		bookSet.add(new CopyBook(new Book("No se que mas poner", 6, 19, "Pepito", "2005")));
		bookSet.add(new CopyBook(new Book("Libro", 7, 19, "Pepito", "2005")));
		return bookSet;
	}
	private ArrayList<Book> obtainBookSet() {
		ArrayList<Book> bookSet = new ArrayList<Book>();
		char aux = 65;
		for(int i = 0; i <= 20;i++) {
			aux += i;
			bookSet.add(new Book(i+"",2,i,"",""));
		}
		bookSet.add(new Book(21+"",3,3,"",""));
		return bookSet;
	}
}

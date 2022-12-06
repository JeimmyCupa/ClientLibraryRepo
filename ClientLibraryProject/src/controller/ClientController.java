package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;
import javax.swing.text.IconView;

import model.Book;
import model.CopyBook;
import view.MainWindow;

public class ClientController implements ActionListener{
	private static final int PORT = 11961;
	private static final String HOST = "localhost";
	private Socket socket;
	private Net net;
	private MainWindow window;
	public ClientController() throws UnknownHostException, IOException {
		window = new MainWindow(this,obtainBookSet());
		/**this.socket = new Socket(HOST, PORT);
		this.net = new Net(socket);**/
		this.init();
	}
	private void init() {
		window.setVisible(true);
	}
	public static void main(String[] args) {
		try {
			new ClientController();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String event = e.getActionCommand();
		try {
			//net.getOutput().writeUTF(event);

			switch (event) {
			case "LOGIN_USER":
				this.loginUser();
				
				//window.initComponentsUser();
				break;
			case "CREATE_ACCOUNT_USER":
				
				break;
			case "REGISTER_USER":
				window.initRegisterPanel();
				break;
			case "SHOW_PROFILE":
				window.initProfile("Juan", "juansito@gmail.com", "18", "2");
				break;
			case "SEARCH_BOOKS":
				window.initSearchBooks(this.obtainBookSet());
				break;
			case "RENT_BOOK":

				break;
			case "MY_BOOKS":
				window.initRentedBooks(this.obtainRentedBooks());
				break;
			case "CANCEL":
				window.closeDialog();
				break;
			case "LOGOUT":
				window.initLoginPanel();
				break;
			case "BACK_TO_LOGIN":
				window.initLoginPanel();
				break;
			case "EXIT":
				window.dispose();
				break;
			case "MIN":
				window.setExtendedState(JFrame.ICONIFIED);
				break;

			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	
	private void loginUser() throws IOException {
		net.getOutput().writeUTF(window.obtainUser());
		net.getOutput().writeUTF(window.obtainPassword());
		
		if(net.getInput().readBoolean()) {
			window.initComponentsUser();
		}else {
			//Crear el JDialog
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

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

import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;


import model.Book;
import model.CopyBook;
import model.Person;
import view.MainWindow;
import view.Utilities;

public class ClientController implements ActionListener,Utilities{
	private static final int PORT = 11961;
	private static final String HOST = "localhost";
	private Socket socket;
	private Net net;
	private MainWindow window;
	public ClientController() throws UnknownHostException, IOException {
		window = new MainWindow(this);
		this.socket = new Socket(HOST, PORT);
		this.net = new Net(socket);
		this.init();
	}
	private void init() {
		window.setVisible(true);
	}
	public static void main(String[] args) {
		try {
			new ClientController();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String event = e.getActionCommand();
		try {
			net.getOutput().writeUTF(event);

			switch (event) {
			case "LOGIN_USER":
				this.loginUser();
				break;
			case "CREATE_ACCOUNT_USER":
				this.createAccountUser();
				break;
			case "REGISTER_USER":
				window.initRegisterPanel();
				break;
			case "SHOW_PROFILE":
				window.putVisibilityProfile();
				break;
			case "SEARCH_BOOKS":
				window.putVisibilitySearchBook();
				break;
			case "MY_BOOKS":
				window.putVisibilityRentedBooks();
				break;
			case "RENT_BOOK":
				this.rentBook();
				break;
			case "CANCEL_RENT_BOOK":
				window.closeDialogRentedBook();
				break;
			case "LOGOUT":
				window.initLoginPanel();
				break;
			case "BACK_TO_LOGIN":
				window.initLoginPanel();
				break;
			case "ACCEPT_MESSAGE":
				window.closeMessageDialog();
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
			if(!net.getInput().readBoolean()) {
				this.initializeUserView();
			}else {
				window.showMessageDialog(SESSION_IS_ACTIVE);
				window.clearFieldsLogin();
			}
		}else {
			window.showMessageDialog(USER_NO_REGISTER);
			window.clearFieldsLogin();
		}
	}
	
	private void initializeUserView() throws JsonSyntaxException, IOException {
		window.setBookSet(this.obtainBookSet());
		window.setBooksRented(this.obtainRentedBooks());
		window.setProfile(this.obtainUser());
		window.initComponentsUser();
	}
	
	private void createAccountUser() throws IOException {
		Person newUser = window.obtainNewUser();
		net.getOutput().writeUTF(net.getMyGson().toJson(newUser));
		if(!net.getInput().readBoolean()) {
			window.showMessageDialog(USER_CREATED);
			window.initLoginPanel();
		}else {
			window.showMessageDialog(USER_IS_CREATED);
			window.clearFieldsRegister();
		}
	}
	
	private void rentBook() throws IOException {
		net.getOutput().writeUTF( net.getMyGson().toJson(window.obtainRentBook()));
		window.showMessageDialog(BOOK_RENTED_SUCCEFULLY);
		window.closeDialogRentedBook();
	}
	
	private ArrayList<Book> obtainBookSet() throws JsonSyntaxException, IOException{
		ArrayList<Book> bookSet = net.getMyGson().fromJson(net.getInput().readUTF(),new TypeToken<ArrayList<Book>>() {}.getType());
		for (int i = 0; i < bookSet.size(); i++) {
			int size = net.getInput().readInt();
			byte [] bytesImage = new byte[size];
			net.getInput().read(bytesImage);
			bookSet.get(i).setBytesImage(bytesImage);
		}
		return bookSet;
	}
	
	private ArrayList<CopyBook> obtainRentedBooks() throws JsonSyntaxException, IOException{
		ArrayList<CopyBook> booksRented = net.getMyGson().fromJson(net.getInput().readUTF(),new TypeToken<ArrayList<CopyBook>>() {}.getType());
		for (int i = 0; i < booksRented.size(); i++) {
			int size = net.getInput().readInt();
			byte [] bytesImage = new byte[size];
			net.getInput().read(bytesImage);
			booksRented.get(i).getRentedBook().setBytesImage(bytesImage);;
		}
		return booksRented;
	}
	
	private Person obtainUser() throws JsonSyntaxException, IOException {
		return net.getMyGson().fromJson(net.getInput().readUTF(), Person.class);
	}
	/*
	private ArrayList<CopyBook> obtainRentedBooks(){
		ArrayList<CopyBook> bookSet = new ArrayList<>();
		/**bookSet.add(new CopyBook(new Book("Principito", 1, 19, "Pepito", "2005", "", ""), 1));
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
		return new ArrayList<>();
	}*/
/*
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
	*/
}

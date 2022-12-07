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

public class ClientController implements ActionListener{
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
			// TODO Auto-generated catch block
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
				window.putVisibilitySearchBook();;
				break;
			case "MY_BOOKS":
				window.putVisibilityRentedBooks();;
				break;
			case "RENT_BOOK":
				this.rentBook();
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
			if(!net.getInput().readBoolean()) {
				this.initializeUserView();
			}else {
				//Ya inició sesión
			}
		}else {
			//Crear el JDialog el usuario no se encuentra registrado
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
		if(net.getInput().readBoolean()) {
			//Dialog usuario creado exitosamente
			window.initLoginPanel();
			
		}else {
			//Dialog usuario ya se encuentra registrado
		}
	}
	
	private void rentBook() {
		net.getMyGson().toJson(window.obtainRentBook());
	}
	
	private ArrayList<Book> obtainBookSet() throws JsonSyntaxException, IOException{
		ArrayList<Book> bookSet = net.getMyGson().fromJson(net.getInput().readUTF(),new TypeToken<ArrayList<Book>>() {}.getType());
		return bookSet;
	}
	
	private ArrayList<CopyBook> obtainRentedBooks() throws JsonSyntaxException, IOException{
		ArrayList<CopyBook> bookSet = net.getMyGson().fromJson(net.getInput().readUTF(),new TypeToken<ArrayList<Book>>() {}.getType());
		return bookSet;
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

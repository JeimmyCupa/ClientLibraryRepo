package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import javax.swing.JFrame;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import structure.Book;
import structure.CopyBook;
import structure.Person;
import structure.ReadConfigs;
import structure.Request;
import structure.Response;
import view.MainWindow;
import view.Utilities;

public class ClientController implements ActionListener,Utilities{
	private Socket socket;
	private Net net;
	private MainWindow window;
	private ReadConfigs readConfigs;
	private boolean isSessionActive;
	private boolean isActive;
	
	
	public ClientController() throws UnknownHostException, IOException {
		window = new MainWindow(this);
		isSessionActive = false;
		isActive = true;
		this.readConfigs = new ReadConfigs();
		this.socket = new Socket(readConfigs.obtainHOST(),readConfigs.obtainPort());
		this.net = new Net(socket);
		this.net.getOutput().writeInt(0);
		Thread thread = new Thread(){
			public void run() {
				while (isActive) {
					verify();
				}
			}
		};
		thread.start();
		this.init();
	}
	
	private void verify() {
		try {
			if(isActive) {
				if(net.getInput().available() > 0) {
<<<<<<< HEAD
					Response response = new Response();
					response = net.getMyGson().fromJson(net.getInput().readUTF(), response.getClass());
					if(response.isNotify()) {
						if(isSessionActive) {
							initializeUserView(response.getBooks(), response.getBooksRented(), response.getProfile());
=======
					
					if(net.getInput().readInt() == 0) {
						if(isSessionActive) {
							System.out.println(net.getInput().readUTF());
							//initializeUserView();
>>>>>>> a2192ed54464ff3d0161d7ccc5de901aa18db88f
						}
					} else {
						protocol(response);
					}
				}
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void init() {
		window.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String event = e.getActionCommand();
		try {
			switch (event) {
			case "LOGIN_USER":
				this.loginUser(event);
				break;
			case "CREATE_ACCOUNT_USER":
				this.createAccountUser(event);
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
				this.rentBook(event);
				break;
			case "CANCEL_RENT_BOOK":
				window.closeDialogRentedBook();
				break;
			case "LOGOUT":
				isSessionActive = false;
				window.initLoginPanel();
				break;
			case "BACK_TO_LOGIN":
				window.initLoginPanel();
				break;
			case "ACCEPT_MESSAGE":
				window.closeMessageDialog();
			break;
			case "EXIT":
				isActive = false;
				isSessionActive = false;
				window.dispose();
				break;
			case "MIN":
				window.setExtendedState(JFrame.ICONIFIED);
				break;

			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}
	
	private void protocol(Response response) throws IOException {
		switch (response.getOption()) {
		case "LOGIN_USER":
			if(response.isValid()) {
				Response newResponse = net.getMyGson().fromJson(net.getInput().readUTF(), Response.class);
				if(!newResponse.isValid()) {
					this.initializeUserView(newResponse.getBooks(), newResponse.getBooksRented(), newResponse.getProfile());
				}else {
					window.showMessageDialog(SESSION_IS_ACTIVE);
					window.clearFieldsLogin();
				}
			}else {
				window.showMessageDialog(ADMIN_NO_REGISTER);
				window.clearFieldsLogin();
			}
			break;
		case "CREATE_ACCOUNT_USER":
			if(!response.isValid()) {
				window.showMessageDialog(USER_CREATED);
				window.initLoginPanel();
			}else {
				window.showMessageDialog(USER_IS_CREATED);
				window.clearFieldsRegister();
			}
			break;
		case "LOGOUT":
			isSessionActive = false;
			break;
		case "RENT_BOOK":
			window.showMessageDialog(BOOK_RENTED_SUCCEFULLY);
			window.closeDialogRentedBook();
			break;
		case "EXIT":
			isActive = false;
			isSessionActive = false;
			break;
		}
	}
	
	private void loginUser(String option) throws IOException {
		Request request = new Request();
		request.setAppOption(option);
		request.setUserID(window.obtainUser());
		request.setPassword(window.obtainPassword());
		net.getOutput().writeUTF(net.getMyGson().toJson(request));
	}
	
	private void initializeUserView(ArrayList<Book> books, ArrayList<CopyBook> rentedBooks, Person user) throws JsonSyntaxException, IOException {
		window.setVisible(false);
		window = new MainWindow(this);
		window.setBookSet(books);
		window.setBooksRented(rentedBooks);
		if(!isSessionActive) {
			window.setProfile(user);
		}
		window.initComponentsUser();
		init();
	}
	
	private void createAccountUser(String option) throws IOException {
		Request request = new Request();
		request.setAppOption(option);
		request.setPerson(window.obtainNewUser());
		net.getOutput().writeUTF(net.getMyGson().toJson(request));
	}
	
	private void rentBook(String option) throws IOException {
		Request request = new Request();
		net.getOutput().writeUTF(net.getMyGson().toJson(request));
	}
	
<<<<<<< HEAD
=======
	private ArrayList<Book> obtainBookSet() throws JsonSyntaxException, IOException{
		String json = net.getInput().readUTF();
		System.out.println(json);
		ArrayList<Book> bookSet = net.getMyGson().fromJson(json,new TypeToken<ArrayList<Book>>() {}.getType());
		for (int i = 0; i < bookSet.size(); i++) {
			int size = net.getInput().readInt();
			byte [] bytesImage = new byte[size];
			System.out.println("Clase Respuesta: " + net.getInput().getClass());
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
>>>>>>> a2192ed54464ff3d0161d7ccc5de901aa18db88f
	
	public static void main(String[] args) {
		try {
			new ClientController();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

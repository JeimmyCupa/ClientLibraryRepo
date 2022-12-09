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
					
					if(net.getInput().readInt() == 0) {
						if(isSessionActive) {
							System.out.println(net.getInput().readUTF());
							//initializeUserView();
						}
						
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
	
	private void loginUser() throws IOException {
		net.getOutput().writeUTF(window.obtainUser());
		net.getOutput().writeUTF(window.obtainPassword());
		if(net.getInput().readBoolean()) {
			if(!net.getInput().readBoolean()) {
				this.initializeUserView();
				isSessionActive = true;
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
		if(!isSessionActive) {
			window.setProfile(this.obtainUser());
		}
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
		net.getOutput().writeUTF(net.getMyGson().toJson(window.obtainRentBook()));//quitar lo bytes de la imagen en rented
		window.showMessageDialog(BOOK_RENTED_SUCCEFULLY);
		window.closeDialogRentedBook();
	}
	
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
	
	public static void main(String[] args) {
		try {
			new ClientController();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

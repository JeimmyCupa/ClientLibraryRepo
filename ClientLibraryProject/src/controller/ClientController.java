package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;
import javax.swing.text.IconView;

import model.Book;
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
			break;
		case "SEARCHBOOKS":
			window.initSearchBooks(this.obtainBookSet());
			break;
		case "RENTBOOK":
			break;
		case "MYBOOKS":
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

	private ArrayList<Book> obtainBookSet() {
		ArrayList<Book> bookSet = new ArrayList<Book>();
		char aux = 65;
		for(int i = 0; i <= 20;i++) {
			aux += i;
			bookSet.add(new Book(i+"",String.valueOf(aux),i,"",""));
		}
		bookSet.add(new Book(21+"","7",3,"",""));
		return bookSet;
	}
}

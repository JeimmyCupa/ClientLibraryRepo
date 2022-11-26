package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;
import javax.swing.text.IconView;

import view.WindowMain;

public class ClientController implements ActionListener{
	private WindowMain window;
	public ClientController() {
		window = new WindowMain(this);
		window.setVisible(true);
		System.out.println("Funciona");
	}
	
	public static void main(String[] args) {
		new ClientController();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String event = e.getActionCommand();
		switch(event) {
		case "LOGIN":
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
			window.initSearchBooks();
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
		case "MIN":
			
			break;
		}
		
	}
}

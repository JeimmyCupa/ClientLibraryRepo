package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.WindowMain;

public class ClientController implements ActionListener{
	private WindowMain window;
	public ClientController() {
		window = new WindowMain(this);
		window.setVisible(true);
		System.out.println("Funciono");
		System.out.println("Funciono v2 | Ahora Siuuuuu");
		System.out.println("Funciono v3 | Ahora Siuuuuuuuuuuuuuuuuu");
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
		case "SHOWPROFILE":
			break;
		case "SEARCHBOOKS":
			window.initSearchBooks();
			break;
		case "REGISTER":
			break;
		case "MYBOOKS":
			break;
			
		case "SINGOUT":
			break;
		case "EXIT":
			window.dispose();
			break;
		}
		
	}
}

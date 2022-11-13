package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class LoginPanel extends JPanel {

	private JPanel panelImage, panelLogin; 
	private JTextField user;
	private JPasswordField password;
	private JButton btnLogin,btnRegister;
	public LoginPanel(ActionListener listener) {
		setSize(1200, 635);
		initComponents(listener);
	}
	public void initComponents(ActionListener listener) {
		setLayout(null);
		panelImage = new JPanel();
		panelImage.setBounds(0, 0, 452, 635);
		panelImage.setBackground(WindowMain.colorFirst);
		add(panelImage);
		
		panelLogin = new JPanel();
		panelLogin.setLayout(null);
		panelLogin.setBounds(452, 0, 748, 635);
		panelLogin.setBackground(WindowMain.colorSecond);
		
		//Componentes del panelLogin
		JLabel lblTitle = new JLabel("Login");
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblTitle.setForeground(WindowMain.colorWhite);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(328,93,200,50);
		panelLogin.add(lblTitle);
		
		user = new JTextField();
		user.setText("User");
		user.setBounds(247,249,365,37);
		user.setForeground(WindowMain.colorWhite);
		user.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		user.setBackground(WindowMain.colorSecond);
		user.setBorder(new MatteBorder(0, 0, 2, 0, WindowMain.colorLight));
		user.addMouseListener(this.mousePressed());
		panelLogin.add(user);
		
		password = new JPasswordField();
		password.setText("Usuario");
		password.setBorder(new MatteBorder(0, 0, 2, 0, WindowMain.colorLight));
		password.setBounds(247,321,365,37);
		password.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		password.setForeground(WindowMain.colorWhite);
		password.setBackground(WindowMain.colorSecond);
		password.addMouseListener(this.mousePressed());
		panelLogin.add(password);
	
		
		btnLogin = new JButton("Ingresar");
		btnLogin.setBorder(null);
		btnLogin.setBounds(247, 454, 365, 42);
		btnLogin.setBackground(WindowMain.colorFirst);
		btnLogin.setForeground(WindowMain.colorLight);
		btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 23));
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.addActionListener(listener);
		btnLogin.setActionCommand("LOGIN");
		btnLogin.addMouseListener(this.mouseEntered());
		btnLogin.addMouseListener(this.mouseExited());
		panelLogin.add(btnLogin);
		
		JLabel iconUser = new JLabel();
		iconUser.setIcon(new ImageIcon("data\\icons\\iconUser.png"));
		iconUser.setBounds(622, 235, 57, 51);
		panelLogin.add(iconUser);
		JLabel iconPassword = new JLabel();
		iconPassword.setIcon(new ImageIcon("data\\icons\\iconPassword.png"));
		iconPassword.setBounds(622, 307, 57, 51);
		panelLogin.add(iconPassword);
		
		btnRegister = new JButton("Registrarse");
		btnRegister.setHorizontalAlignment(SwingConstants.CENTER);
		btnRegister.setBounds(342, 525, 166, 27);
		btnRegister.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnRegister.setForeground(WindowMain.colorWhite);
		btnRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegister.addActionListener(listener);
		btnRegister.setActionCommand("REGISTER");
		btnRegister.addMouseListener(this.mouseEntered());
		btnRegister.addMouseListener(this.mouseExited());
		panelLogin.add(btnRegister);
		
		add(panelLogin);
	}
	//GETTERS AND SETTERS
	public JTextField getUser() {
		return user;
	}
	public void setUser(JTextField user) {
		this.user = user;
	}
	public JPasswordField getPassword() {
		return password;
	}
	public void setPassword(JPasswordField password) {
		this.password = password;
	}
	//Metodos para obtener los objetos de la Clase MouseAdapter
	public MouseAdapter mousePressed() {
		return new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getSource().equals(user))
					txtUserMousePressed(e);
				else if(e.getSource().equals(user))
					txtPassMousePressed(e);
			}
		};
	}
	public MouseAdapter mouseEntered() {
		return new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMouseEntered(e);//Llama el metodo creado en la clase para cambiar el color al pasar sobre el boton.
			}
		};
	}
	public MouseAdapter mouseExited() {
		return new MouseAdapter() {
			@Override 
			public void mouseExited(MouseEvent event) {
				btnMouseExited(event);//Llama al metodo de la clase MenuPanel para volver al color original del boton.
			}
		};
	}
	//Metodos para manejar el efecto Hover
	private void btnMouseEntered(MouseEvent event) {
		JButton btnEvent = (JButton)event.getSource(); 
		if(btnEvent.equals(btnRegister)) {
			btnRegister.setBackground(WindowMain.colorFirst);
		}else if(btnEvent.equals(btnLogin)) {
			btnLogin.setBackground(WindowMain.colorSecond);;
		}
	}
	private void btnMouseExited(MouseEvent event) {
		JButton btnEvent = (JButton)event.getSource(); 
		if(btnEvent.equals(btnRegister)) {
			btnRegister.setBackground(WindowMain.colorSecond);
		}else if(btnEvent.equals(btnLogin)) {
			btnLogin.setBackground(WindowMain.colorFirst);;
		}	
	}
	
	private void txtUserMousePressed(MouseEvent e) {
		if(user.getText().equals("Usuario")) {
			user.setText("");
			user.setForeground(WindowMain.colorWhite);
		}
		if(String.valueOf(password.getPassword()).isEmpty()) {
			password.setText("*********");
			password.setForeground(WindowMain.colorLight);
		}
	}
	private void txtPassMousePressed(MouseEvent e) {
		if(String.valueOf(password.getPassword()).equals("*********")) {
			user.setText("");
			user.setForeground(WindowMain.colorWhite);
		}
		if(user.getText().isEmpty()) {
			password.setText("Usuario");
			password.setForeground(WindowMain.colorLight);
		}
	}
}

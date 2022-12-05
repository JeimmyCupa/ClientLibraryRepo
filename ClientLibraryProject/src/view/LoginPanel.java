package view;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class LoginPanel extends JPanel {

	//private JPanel panelImage, panelLogin; 
	private JTextField user;
	private JPasswordField password;
	private JButton btnLogin,btnRegister;

	public LoginPanel(ActionListener actionListener,MouseListener mouseListener) {
		setSize(1200, 635);
		initComponents(actionListener,mouseListener);
	}
	private void initComponents(ActionListener actionListener,MouseListener mouseListener) {
		setLayout(null);
		JPanel  panelImage = new JPanel();
		panelImage.setLayout(null);
		panelImage.setBounds(0, 0, 452, 635);
		panelImage.setBackground(MainWindow.MAINCOLOR);
		JLabel lblImage = new JLabel();
		lblImage.setBounds(0,0, 452, 635);
		Image image =new ImageIcon("data\\icons\\Imagen3.png").getImage();
		Icon icon = new ImageIcon(image.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH));
		lblImage.setIcon(icon);
		panelImage.add(lblImage);
		add(panelImage);
		
		JPanel  panelLogin = new JPanel();
		panelLogin.setLayout(null);
		panelLogin.setBounds(452, 0, 748, 635);
		panelLogin.setBackground(MainWindow.WHITECOLOR);
		
		//Componentes del panelLogin
		JLabel lblTitle = new JLabel("Login");
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblTitle.setForeground(MainWindow.MAINCOLOR);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(255,75,200,50);
		panelLogin.add(lblTitle);
		
		user = new JTextField();
		user.setText("Usuario");
		user.setBounds(173,233,365,37);
		user.setForeground(MainWindow.STRONGBLACK);
		user.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		user.setBackground(MainWindow.WHITECOLOR);
		user.setBorder(new MatteBorder(0, 0, 2, 0, MainWindow.LIGHTGRAY));
		user.addMouseListener(this.mousePressed());
		panelLogin.add(user);
		
		password = new JPasswordField();
		password.setText("*********");
		password.setBorder(new MatteBorder(0, 0, 2, 0, MainWindow.LIGHTGRAY));
		password.setBounds(173,305,365,37);
		password.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		password.setForeground(MainWindow.STRONGBLACK);
		password.setBackground(MainWindow.WHITECOLOR);
		password.addMouseListener(this.mousePressed());
		panelLogin.add(password);
	
		
		btnLogin = new JButton("Ingresar");
		btnLogin.setBorder(null);
		btnLogin.setBounds(173, 438, 365, 42);
		btnLogin.setBackground(MainWindow.MAINCOLOR);
		btnLogin.setForeground(MainWindow.WHITECOLOR);
		btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 23));
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.addActionListener(actionListener);
		btnLogin.setActionCommand("LOGIN");
		btnLogin.addMouseListener(mouseListener);
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
		btnRegister.setBorder(new MatteBorder(0, 0, 2, 0, MainWindow.WHITECOLOR));
		btnRegister.setBounds(268, 509, 166, 27);
		btnRegister.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnRegister.setForeground(MainWindow.GRAY);
		btnRegister.setBackground(MainWindow.WHITECOLOR);
		btnRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegister.addActionListener(actionListener);
		btnRegister.setActionCommand("REGISTER");
		btnRegister.addMouseListener(mouseListener);
		panelLogin.add(btnRegister);
		
		add(panelLogin);
	}
	//GETTERS AND SETTERS
	public String getUser() {
		return user.getText();
	}
	public void setUser(String user) {
		this.user.setText(user);
	}
	public String getPassword() {
		return String.valueOf(password.getPassword());
	}
	public void setPassword(String password) {
		this.password.setText(password);
	}
	
	
	public JButton getBtnLogin() {
		return btnLogin;
	}
	public JButton getBtnRegister() {
		return btnRegister;
	}
	
	//Metodos para obtener los objetos de la Clase MouseAdapter
	public MouseAdapter mousePressed() {
		return new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getSource().equals(user))
					txtUserMousePressed(e);
				else if(e.getSource().equals(password))
					txtPassMousePressed(e);
			}
		};
	}

	
	private void txtUserMousePressed(java.awt.event.MouseEvent e) {
		if(user.getText().equals("Usuario")) {
			user.setText("");
			user.setForeground(MainWindow.STRONGGRAY);
		}
		if(String.valueOf(password.getPassword()).isEmpty()) {
			password.setText("*********");
			password.setForeground(MainWindow.GRAY);
		}
	}
	private void txtPassMousePressed(java.awt.event.MouseEvent e) {
		
		if(String.valueOf(password.getPassword()).equals("*********")) {
			password.setText("");
			password.setForeground(MainWindow.GRAY);
		}
		if(user.getText().isEmpty()) {
			user.setText("Usuario");
			user.setForeground(MainWindow.STRONGGRAY);
		}
	}
	
}

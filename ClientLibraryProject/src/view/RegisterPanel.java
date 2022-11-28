package view;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;

public class RegisterPanel extends JPanel {
	private JPanel panelImage, panelLogin;
	private JTextField name,user;
	private JPasswordField password;
	private JButton btnCreateAccount,btnBack;
	private JTextField id;
	private JTextField lastName;
	private JTextField email;
	private JLabel lblId;
	private JLabel lblLastName;
	private JLabel lblEmail;
	private JLabel lblCrearCredenciales;
	public RegisterPanel(ActionListener actionListener,MouseListener mouseListener) {
		setSize(1200, 635);
		initComponents(actionListener,mouseListener);
	}
	private void initComponents(ActionListener listener,MouseListener mouseListener) {
		setLayout(null);
		panelImage = new JPanel();
		panelImage.setBounds(0, 0, 452, 635);
		panelImage.setBackground(MainWindow.MAINCOLOR);
		add(panelImage);
		
		panelLogin = new JPanel();
		panelLogin.setLayout(null);
		panelLogin.setBounds(452, 0, 748, 635);
		panelLogin.setBackground(MainWindow.WHITECOLOR);
		
		//Componentes del panelRegistro
		JLabel lblTitle = new JLabel("Registro al sistema");
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblTitle.setForeground(MainWindow.STRONGBLACK);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(257,61,317,50);
		panelLogin.add(lblTitle);
		add(panelLogin);
		//Panel con informacion del usuario y contraseña a crear
		JPanel credentialsData = new JPanel();
		credentialsData.setBounds(103, 360, 609, 235);
		credentialsData.setBackground(MainWindow.WHITECOLOR);
		panelLogin.add(credentialsData);
		credentialsData.setLayout(null);
		
		JLabel lblUser = new JLabel("Usuario");
		lblUser.setBounds(23, 37, 77, 18);
		lblUser.setForeground(MainWindow.MAINCOLOR);
		lblUser.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		lblUser.setBackground(MainWindow.WHITECOLOR);
		credentialsData.add(lblUser);
		
		user = new JTextField();
		user.setBounds(142, 22, 365, 33);
		user.setForeground(MainWindow.STRONGBLACK);
		user.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		user.setBackground(MainWindow.WHITECOLOR);
		user.setBorder(new MatteBorder(0, 0, 2, 0, MainWindow.LIGHTGRAY));
		credentialsData.add(user);
		
		JLabel lblPassword = new JLabel("Contraseña");
		lblPassword.setBounds(20, 85, 103, 18);
		lblPassword.setForeground(MainWindow.MAINCOLOR);
		lblPassword.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		lblPassword.setBackground(MainWindow.WHITECOLOR);
		credentialsData.add(lblPassword);
		
		password = new JPasswordField();
		password.setBounds(142, 66, 365, 37);
		password.setBorder(new MatteBorder(0, 0, 2, 0, MainWindow.LIGHTGRAY));
		password.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		password.setForeground(MainWindow.STRONGBLACK);
		password.setBackground(MainWindow.WHITECOLOR);
		credentialsData.add(password);
			
		btnCreateAccount = new JButton("Crear cuenta");
		btnCreateAccount.setBounds(118, 182, 365, 42);
		credentialsData.add(btnCreateAccount);
		btnCreateAccount.setBorder(null);
		btnCreateAccount.setBackground(MainWindow.MAINCOLOR);
		btnCreateAccount.setForeground(MainWindow.WHITECOLOR);
		btnCreateAccount.setFont(new Font("Segoe UI", Font.BOLD, 23));
		btnCreateAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCreateAccount.addActionListener(listener);
		btnCreateAccount.setActionCommand("CREATEACCOUNT");
		btnCreateAccount.addMouseListener(mouseListener);
		
		lblCrearCredenciales = new JLabel("Crear credenciales");
		lblCrearCredenciales.setForeground(MainWindow.MAINCOLOR);
		lblCrearCredenciales.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblCrearCredenciales.setBackground(MainWindow.WHITECOLOR);
		lblCrearCredenciales.setBounds(0, 0, 165, 18);
		credentialsData.add(lblCrearCredenciales);
		
		btnBack = new JButton();
		btnBack.setIcon(new ImageIcon("data\\icons\\iconBack.png"));
		btnBack.setFont(new Font("Segoe UI", Font.BOLD, 23));
		btnBack.setBorder(null);
		btnBack.setBackground(MainWindow.MAINCOLOR);
		btnBack.addActionListener(listener);
		btnBack.setActionCommand("BACK");
		btnBack.addMouseListener(mouseListener);
		btnBack.setBounds(26, 182, 54, 42);
		credentialsData.add(btnBack);
		
		initComponentsPersonalData();
	}
	private void initComponentsPersonalData() {
		JPanel personalData = new JPanel();
		personalData.setBorder(new TitledBorder(null, "Datos personales", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		personalData.setBounds(103, 130, 609, 219);
		personalData.setBackground(MainWindow.MAINCOLOR);
		panelLogin.add(personalData);
		personalData.setLayout(null);
		
		name = new JTextField();
		name.setBounds(118, 62, 357, 29);
		personalData.add(name);
		name.setForeground(MainWindow.WHITECOLOR);
		name.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		name.setBackground(MainWindow.MAINCOLOR);
		name.setBorder(new MatteBorder(0, 0, 2, 0, MainWindow.LIGHTGRAY));
		
		JLabel lblName = new JLabel("Nombre");
		lblName.setBounds(10, 71, 77, 18);
		lblName.setForeground(MainWindow.WHITECOLOR);
		lblName.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		lblName.setBackground(MainWindow.MAINCOLOR);
		personalData.add(lblName);
	
		id = new JTextField();
		id.setForeground(MainWindow.WHITECOLOR);
		id.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		id.setBorder(new MatteBorder(0, 0, 2, 0, MainWindow.LIGHTGRAY));
		id.setBackground(MainWindow.MAINCOLOR);
		id.setBounds(118, 11, 357, 29);
		personalData.add(id);
		
		lastName = new JTextField();
		lastName.setForeground(Color.WHITE);
		lastName.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lastName.setBorder(new MatteBorder(0, 0, 2, 0, MainWindow.LIGHTGRAY));
		lastName.setBackground(MainWindow.MAINCOLOR);
		lastName.setBounds(118, 113, 357, 29);
		personalData.add(lastName);
		
		email = new JTextField();
		email.setForeground(MainWindow.WHITECOLOR);
		email.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		email.setBorder(new MatteBorder(0, 0, 2, 0, MainWindow.LIGHTGRAY));
		email.setBackground(MainWindow.MAINCOLOR);
		email.setBounds(118, 163, 357, 29);
		personalData.add(email);
		
		lblId = new JLabel("ID");
		lblId.setForeground(MainWindow.WHITECOLOR);
		lblId.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		lblId.setBackground(MainWindow.MAINCOLOR);
		lblId.setBounds(10, 22, 77, 18);
		personalData.add(lblId);
		
		lblLastName = new JLabel("Apellido");
		lblLastName.setForeground(MainWindow.WHITECOLOR);
		lblLastName.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		lblLastName.setBackground(MainWindow.MAINCOLOR);
		lblLastName.setBounds(10, 124, 98, 18);
		personalData.add(lblLastName);
		
		lblEmail = new JLabel("Correo");
		lblEmail.setForeground(MainWindow.WHITECOLOR);
		lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		lblEmail.setBackground(MainWindow.MAINCOLOR);
		lblEmail.setBounds(10, 174, 98, 18);
		personalData.add(lblEmail);
		
	}
	//GETTERS
	public String getName() {
		return name.getText();
	}

	public String getUser() {
		return user.getText();
	}
	
	public String getPassword() {
		return String.valueOf(password.getPassword());
	}
	
	public String getLastName() {
		return lastName.getText();
	}
	
	public String getEmail() {
		return email.getText();
	}
	public JButton getBtnBack() {
		return btnBack;
	}
	public JButton getBtnCreateAccount() {
		return btnCreateAccount;
	}
}

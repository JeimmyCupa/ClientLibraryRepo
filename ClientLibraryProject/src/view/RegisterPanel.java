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
		panelImage.setBackground(MainWindow.mainColor);
		add(panelImage);
		
		panelLogin = new JPanel();
		panelLogin.setLayout(null);
		panelLogin.setBounds(452, 0, 748, 635);
		panelLogin.setBackground(MainWindow.whiteColor);
		
		//Componentes del panelRegistro
		JLabel lblTitle = new JLabel("Registro al sistema");
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblTitle.setForeground(MainWindow.strongBlack);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(257,61,317,50);
		panelLogin.add(lblTitle);
		add(panelLogin);
		//Panel con informacion del usuario y contraseña a crear
		JPanel credentialsData = new JPanel();
		credentialsData.setBounds(103, 360, 609, 235);
		credentialsData.setBackground(MainWindow.beige);
		panelLogin.add(credentialsData);
		credentialsData.setLayout(null);
		
		user = new JTextField();
		user.setBounds(118, 22, 365, 33);
		user.setText("Usuario");
		user.setForeground(MainWindow.strongBlack);
		user.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		user.setBackground(MainWindow.whiteColor);
		user.setBorder(new MatteBorder(0, 0, 2, 0, MainWindow.lightGray));
		credentialsData.add(user);
		
		password = new JPasswordField();
		password.setBounds(118, 66, 365, 37);
		password.setText("*********");
		password.setBorder(new MatteBorder(0, 0, 2, 0, MainWindow.lightGray));
		password.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		password.setForeground(MainWindow.strongBlack);
		password.setBackground(MainWindow.whiteColor);
		//password.addMouseListener(this.mousePressed());
		credentialsData.add(password);
			
		btnCreateAccount = new JButton("Crear cuenta");
		btnCreateAccount.setBounds(118, 182, 365, 42);
		credentialsData.add(btnCreateAccount);
		btnCreateAccount.setBorder(null);
		btnCreateAccount.setBackground(MainWindow.mainColor);
		btnCreateAccount.setForeground(MainWindow.whiteColor);
		btnCreateAccount.setFont(new Font("Segoe UI", Font.BOLD, 23));
		btnCreateAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCreateAccount.addActionListener(listener);
		btnCreateAccount.setActionCommand("CREATEACCOUNT");
		btnCreateAccount.addMouseListener(mouseListener);
		
		lblCrearCredenciales = new JLabel("Crear credenciales");
		lblCrearCredenciales.setForeground(Color.WHITE);
		lblCrearCredenciales.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblCrearCredenciales.setBackground(MainWindow.whiteColor);
		lblCrearCredenciales.setBounds(0, 0, 165, 18);
		credentialsData.add(lblCrearCredenciales);
		
		btnBack = new JButton();
		btnBack.setIcon(new ImageIcon("data\\icons\\iconBack.png"));
		btnBack.setFont(new Font("Segoe UI", Font.BOLD, 23));
		btnBack.setBorder(null);
		btnBack.setBackground(MainWindow.mainColor);
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
		personalData.setBackground(MainWindow.mainColor);
		panelLogin.add(personalData);
		personalData.setLayout(null);
		
		name = new JTextField();
		name.setBounds(118, 62, 357, 29);
		personalData.add(name);
		name.setForeground(MainWindow.whiteColor);
		name.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		name.setBackground(MainWindow.mainColor);
		name.setBorder(new MatteBorder(0, 0, 2, 0, MainWindow.lightGray));
		
		JLabel lblName = new JLabel("Nombre");
		lblName.setBounds(10, 71, 77, 18);
		lblName.setForeground(MainWindow.whiteColor);
		lblName.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		lblName.setBackground(MainWindow.mainColor);
		personalData.add(lblName);
	
		id = new JTextField();
		id.setForeground(MainWindow.whiteColor);
		id.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		id.setBorder(new MatteBorder(0, 0, 2, 0, MainWindow.lightGray));
		id.setBackground(MainWindow.mainColor);
		id.setBounds(118, 11, 357, 29);
		personalData.add(id);
		
		lastName = new JTextField();
		lastName.setForeground(Color.WHITE);
		lastName.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lastName.setBorder(new MatteBorder(0, 0, 2, 0, MainWindow.lightGray));
		lastName.setBackground(MainWindow.mainColor);
		lastName.setBounds(118, 113, 357, 29);
		personalData.add(lastName);
		
		email = new JTextField();
		email.setForeground(MainWindow.whiteColor);
		email.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		email.setBorder(new MatteBorder(0, 0, 2, 0, MainWindow.lightGray));
		email.setBackground(MainWindow.mainColor);
		email.setBounds(118, 163, 357, 29);
		personalData.add(email);
		
		lblId = new JLabel("ID");
		lblId.setForeground(MainWindow.whiteColor);
		lblId.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		lblId.setBackground(MainWindow.mainColor);
		lblId.setBounds(10, 22, 77, 18);
		personalData.add(lblId);
		
		lblLastName = new JLabel("Apellido");
		lblLastName.setForeground(MainWindow.whiteColor);
		lblLastName.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		lblLastName.setBackground(MainWindow.mainColor);
		lblLastName.setBounds(10, 124, 98, 18);
		personalData.add(lblLastName);
		
		lblEmail = new JLabel("Correo");
		lblEmail.setForeground(MainWindow.whiteColor);
		lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		lblEmail.setBackground(MainWindow.mainColor);
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

package view;

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
	public RegisterPanel(ActionListener listener) {
		setSize(1200, 635);
		initComponents(listener);
	}
	private void initComponents(ActionListener listener) {
		setLayout(null);
		panelImage = new JPanel();
		panelImage.setBounds(0, 0, 452, 635);
		panelImage.setBackground(WindowMain.colorFirst);
		add(panelImage);
		
		panelLogin = new JPanel();
		panelLogin.setLayout(null);
		panelLogin.setBounds(452, 0, 748, 635);
		panelLogin.setBackground(WindowMain.colorSecond);
		
		//Componentes del panelRegistro
		JLabel lblTitle = new JLabel("Registro al sistema");
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblTitle.setForeground(WindowMain.colorWhite);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(257,61,317,50);
		panelLogin.add(lblTitle);
		add(panelLogin);
		//Panel con informacion del usuario y contraseña a crear
		JPanel credentialsData = new JPanel();
		credentialsData.setBounds(103, 360, 609, 235);
		credentialsData.setBackground(WindowMain.colorSecond);
		panelLogin.add(credentialsData);
		credentialsData.setLayout(null);
		
		user = new JTextField();
		user.setBounds(118, 22, 365, 33);
		user.setText("Usuario");
		user.setForeground(WindowMain.colorWhite);
		user.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		user.setBackground(WindowMain.colorSecond);
		user.setBorder(new MatteBorder(0, 0, 2, 0, WindowMain.colorLight));
		credentialsData.add(user);
		
		password = new JPasswordField();
		password.setBounds(118, 66, 365, 37);
		password.setText("*********");
		password.setBorder(new MatteBorder(0, 0, 2, 0, WindowMain.colorLight));
		password.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		password.setForeground(WindowMain.colorWhite);
		password.setBackground(WindowMain.colorSecond);
		password.addMouseListener(this.mousePressed());
		credentialsData.add(password);
			
		btnCreateAccount = new JButton("Crear cuenta");
		btnCreateAccount.setBounds(118, 182, 365, 42);
		credentialsData.add(btnCreateAccount);
		btnCreateAccount.setBorder(null);
		btnCreateAccount.setBackground(WindowMain.colorFirst);
		btnCreateAccount.setForeground(WindowMain.colorLight);
		btnCreateAccount.setFont(new Font("Segoe UI", Font.BOLD, 23));
		btnCreateAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCreateAccount.addActionListener(listener);
		btnCreateAccount.setActionCommand("CREATEACCOUNT");
		btnCreateAccount.addMouseListener(this.mouseEntered());
		btnCreateAccount.addMouseListener(this.mouseExited());
		
		lblCrearCredenciales = new JLabel("Crear credenciales");
		lblCrearCredenciales.setForeground(Color.WHITE);
		lblCrearCredenciales.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblCrearCredenciales.setBackground(WindowMain.colorSecond);
		lblCrearCredenciales.setBounds(0, 0, 165, 18);
		credentialsData.add(lblCrearCredenciales);
		
		btnBack = new JButton();
		btnBack.setIcon(new ImageIcon("data\\icons\\iconBack.png"));
		btnBack.setFont(new Font("Segoe UI", Font.BOLD, 23));
		btnBack.setBorder(null);
		btnBack.setBackground(WindowMain.colorSecond);
		btnBack.addActionListener(listener);
		btnBack.setActionCommand("BACK");
		btnBack.setBounds(26, 182, 54, 42);
		credentialsData.add(btnBack);
		
		initComponentsPersonalData();
	}
	private void initComponentsPersonalData() {
		JPanel personalData = new JPanel();
		personalData.setBorder(new TitledBorder(null, "Datos personales", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		personalData.setBounds(103, 130, 609, 219);
		personalData.setBackground(WindowMain.colorSecond);
		panelLogin.add(personalData);
		personalData.setLayout(null);
		
		name = new JTextField();
		name.setBounds(118, 62, 357, 29);
		personalData.add(name);
		name.setForeground(WindowMain.colorWhite);
		name.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		name.setBackground(WindowMain.colorSecond);
		name.setBorder(new MatteBorder(0, 0, 2, 0, WindowMain.colorLight));
		
		JLabel lblName = new JLabel("Nombre");
		lblName.setBounds(10, 71, 77, 18);
		lblName.setForeground(WindowMain.colorWhite);
		lblName.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		lblName.setBackground(WindowMain.colorSecond);
		personalData.add(lblName);
	
		id = new JTextField();
		id.setForeground(Color.WHITE);
		id.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		id.setBorder(new MatteBorder(0, 0, 2, 0, WindowMain.colorLight));
		id.setBackground(new Color(217, 95, 95));
		id.setBounds(118, 11, 357, 29);
		personalData.add(id);
		
		lastName = new JTextField();
		lastName.setForeground(Color.WHITE);
		lastName.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lastName.setBorder(new MatteBorder(0, 0, 2, 0, WindowMain.colorLight));
		lastName.setBackground(WindowMain.colorSecond);
		lastName.setBounds(118, 113, 357, 29);
		personalData.add(lastName);
		
		email = new JTextField();
		email.setForeground(Color.WHITE);
		email.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		email.setBorder(new MatteBorder(0, 0, 2, 0, WindowMain.colorLight));
		email.setBackground(WindowMain.colorSecond);
		email.setBounds(118, 163, 357, 29);
		personalData.add(email);
		
		lblId = new JLabel("ID");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		lblId.setBackground(WindowMain.colorSecond);
		lblId.setBounds(10, 22, 77, 18);
		personalData.add(lblId);
		
		lblLastName = new JLabel("Apellido");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		lblLastName.setBackground(WindowMain.colorSecond);
		lblLastName.setBounds(10, 124, 98, 18);
		personalData.add(lblLastName);
		
		lblEmail = new JLabel("Correo");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		lblEmail.setBackground(WindowMain.colorSecond);
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
	
	//Metodos para obtener los objetos de la Clase MouseAdapter
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
	//Metodos para manejar el efecto Hover
		private void btnMouseEntered(MouseEvent event) {
			JButton btnEvent = (JButton)event.getSource(); 
			if(btnEvent.equals(btnBack)) {
				btnBack.setBackground(WindowMain.colorFirst);
			}
		}
		private void btnMouseExited(MouseEvent event) {
			JButton btnEvent = (JButton)event.getSource(); 
			if(btnEvent.equals(btnBack)) {
				btnBack.setBackground(WindowMain.colorSecond);
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

package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;

public class LoginPanel extends JPanel {
	private ActionListener listener;
	private JPanel panelImage, panelLogin; 
	private JTextField user;
	private JPasswordField password;
	
	public LoginPanel(ActionListener listener) {
		setSize( 1200, 680);
		setLayout(null);
		this.listener = listener;
		this.initComponents();
	}
	public void initComponents() {
		panelImage = new JPanel();
		panelImage.setBounds(0, 44, 378, 636);
		panelImage.setBackground(WindowMain.colorFirst);
		add(panelImage);
		
		this.initComponentsLoginPanel();
	}
	public void initComponentsLoginPanel() {
		panelLogin = new JPanel();
		panelLogin.setLayout(null);
		panelLogin.setBounds(377, 44, 759, 636);
		panelLogin.setBackground(WindowMain.colorSecond);
		
		
		JLabel lblTitle = new JLabel("Login");
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(328,93,200,50);
		panelLogin.add(lblTitle);
		
		user = new JTextField();
		user.setBounds(247,342,365,37);
		panelLogin.add(user);
		
		password = new JPasswordField();
		password.setBounds(247,259,365,37);
		panelLogin.add(password);
	
		
		add(panelLogin);
	}
	public void paint(Graphics graphics) {
		setLayout(null);
		setFont(new Font("Segoe UI", Font.BOLD, 30));
		setForeground(WindowMain.colorWhite);
		//setHorizontalAlignment(SwingConstants.CENTER);
		//setForeground();
	}
}

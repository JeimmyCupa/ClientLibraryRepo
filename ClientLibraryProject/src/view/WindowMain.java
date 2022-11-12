package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class WindowMain extends JFrame {
	public final static Color colorFirst = new Color(22,44,64);
	public final static Color colorSecond = new Color(217,95,95);
	public final static Color colorDark = new Color(64,64,64);
	public final static Color colorGray = new Color(128,128,128);
	public final static Color colorLight = new Color(230,230,230);
	public final static Color colorWhite = new Color(255,255,255);
	
	
	private ActionListener listener;
	private JPanel contentPane,loginPanel;
	private JPanel header;
	private JButton btnExit;
	
	
	public WindowMain(ActionListener listener) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 1200, 680);
		contentPane = new JPanel();
	
		setContentPane(contentPane);
		
		this.initComponents();
	}
	public void initComponents() {
		contentPane.setLayout(null);
		header = new JPanel();
		header.setBounds(0, 0, 1200, 43);
		header.setLayout(null);
		btnExit = new JButton();
		btnExit.setText("X");
		btnExit.setBounds(1157,0,43,43);
		header.add(btnExit);
		
		JLabel image = new JLabel();
		image.setBounds(0,40,580,640);
		getContentPane().add(image);
		
		
		contentPane.add(header);
	}
	
	@Override
	public void paint(Graphics graphics) {
		getContentPane().setLayout(null);
		setBackground(colorWhite);
		
	}
	
}

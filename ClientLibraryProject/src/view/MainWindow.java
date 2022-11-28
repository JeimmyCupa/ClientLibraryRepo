package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Book;

import java.awt.Insets;

public class MainWindow extends JFrame implements MouseListener{
	public final static Color mainColor = new Color(46,55,100);
    public final static Color whiteColor = new Color(235,236,240);
    public final static Color strongBlack = new Color(14,29,38);
    public final static Color strongGray = new Color(38,38,38);
    public final static Color gray = new Color(89,89,89);
    public final static Color lightGray = new Color(166,166,166);
    public final static Color beige = new Color(242,242,199);
    public final static Color hoverColor = new Color(74,87,120);
	
    private ArrayList<Book> bookSet;
    private JPanel contentPane;//Panel principal de la ventana
	private JPanel contentData,header,menuPanel,dataPanel;//Paneles para dividir el contenido en la ventana
	private JButton btnExit,btnMin;
	
	private LoginPanel loginPanel;
	private RegisterPanel registerPanel;
	private MenuPanel menu;
	private SearchBookPanel searchBookPanel;
	private ActionListener listener;
	private int xMouse, yMouse;//atributos para controlar el desplazamiento de la ventana
	
	public MainWindow(ActionListener listener,ArrayList<Book> bookSet) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setUndecorated(true);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setBounds(10,10,1200,680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		this.listener = listener;
		this.bookSet = bookSet;
		menu = new MenuPanel(listener, this);
		initComponents();
		initLoginPanel();
	}
	//Metodo para inciar componentes generales de la GUI(Cabecera y un panel para el contenido en contentPane)
	public void initComponents() {

		header = new JPanel();
		header.setBounds(0, 0, 1200, 45);
		header.setLayout(null);
		header.setBackground(whiteColor);
		header.addMouseMotionListener(this.panelMouseDragged());
		header.addMouseListener(this.panelMousePressed());
		
		btnExit = new JButton();
		btnExit.setText("X");
		btnExit.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		btnExit.setForeground(whiteColor);
		btnExit.setBackground(mainColor);
		btnExit.setBounds(1157,0,43,43);
		btnExit.setBorderPainted(false);
		btnExit.setMargin(new Insets(1, 1, 1, 1));;
		btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExit.addActionListener(listener);
		btnExit.setActionCommand("EXIT");
		btnExit.addMouseListener(this);
		header.add(btnExit);
		getContentPane().add(header);
		
		btnMin = new JButton();
		btnMin.setText("-");
		btnMin.setMargin(new Insets(1, 1, 1, 1));
		btnMin.setForeground(new Color(22, 44, 64));
		btnMin.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		btnMin.setBorderPainted(false);
		btnMin.setBackground(new Color(217, 95, 95));
		btnMin.setActionCommand("MIN");
		btnMin.setBounds(1114, 0, 43, 43);
		header.add(btnMin);
		
		contentData = new JPanel();
		contentData.setBounds(0,43,1200,637);
		contentData.setLayout(null);
		contentPane.add(contentData);
	}
	//Metodo para iniciar componente del Login
	public void initLoginPanel() {
		loginPanel = new LoginPanel(listener,this);
		loginPanel.setSize(1200, 635);
		loginPanel.setLocation(0, 0);
		showPanel(contentData, loginPanel);
	}
	/**
	 * Metodo para iniciar panel de registro de nuevo usuario
	 */
	public void initRegisterPanel() {
		registerPanel = new RegisterPanel(listener,this);
		showPanel(contentData, registerPanel);
	}
	/**Metodo que inicia la interfaz de usuario (Menu y un panel lateral para el contenido)
	*Este metodo se debe llamar siempre el login sea exitoso.
	*/
	public void initComponentsUser() {
		dataPanel = new JPanel();//Panel que se actualiza de acuerdo a la opcion del menu selecionada
		dataPanel.setBounds(286,1,914,635);
		dataPanel.setLayout(null);
		showPanel(contentData,dataPanel);
		contentData.add(dataPanel);
		
		menuPanel = new JPanel();
		menuPanel.setSize(285,636);
		menuPanel.setLayout(null);
		contentData.add(menuPanel);
		
		menu = new MenuPanel(listener,this);
		menu.setSize(285, 636);
		menu.setLocation(0, 0);
		showPanel(menuPanel,menu);
		
		initSearchBooks(this.bookSet);
	}
	//Metodo para pintar el panel SearchBooks(){
	public void initSearchBooks(ArrayList<Book> bookSet) {
		searchBookPanel = new SearchBookPanel(listener,bookSet);
		searchBookPanel.setLocation(0,0);
		dataPanel.add(searchBookPanel);
		showPanel(dataPanel,searchBookPanel);
	}
	/*Metodo encargado de repintar un panel, recibe como parametro el panel en donde se quiere
	 * pintar un segundo panel.
	*/
	public void showPanel(JPanel contentPanel,JPanel panel) {
		contentPanel.removeAll();
		contentPanel.add(panel);
		contentPanel.revalidate();
		contentPanel.repaint();
	}

	public String obtainUser() {
		return loginPanel.getUser();
	}
	
	//Metodos para el desplazamiento de la ventana
	@SuppressWarnings("unchecked")
	private void btnMoveMousePressed(MouseEvent event) {
		xMouse = event.getX();
		yMouse = event.getY();
	}
	private void btnMoveMouseDragged(MouseEvent event) {
		int x = event.getXOnScreen();
		int y = event.getYOnScreen();
		this.setLocation(x-xMouse,y-yMouse);
	}
	/*
	 * Metodo que retorna un objeto MouseAdapter necesario para agregar al panel eventos de tipo MousePressed
	 * Invoca a un metodo propio de la clase WindowMain*/
	private MouseAdapter panelMousePressed() {
		return new MouseAdapter() {
			public void mousePressed(MouseEvent event) {
				btnMoveMousePressed(event);
			}
		};
	}
	
	/*Metodo que retorna un objeto MouseMotionListener necesario para agregar al panel eventos de tipo MousePressed*/
	public MouseMotionListener panelMouseDragged() {
		return new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent evt) {
				btnMoveMouseDragged(evt);
			}
		};
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		JButton btnChangeColor = new JButton();
		if(e.getSource().equals(btnExit)) {
			btnExit.setBackground(hoverColor);
		}else if(e.getSource().equals(loginPanel.getBtnLogin())) {
			loginPanel.getBtnLogin().setBackground(hoverColor);
		}else if(e.getSource().equals(loginPanel.getBtnRegister())) {
			loginPanel.getBtnRegister().setForeground(mainColor);
		}
		else if(e.getSource().equals(menu.getBtnProfile())) {
			btnChangeColor = menu.getBtnProfile();
		}else if(e.getSource().equals(menu.getBtnSearchBooks())) {
			btnChangeColor =menu.getBtnSearchBooks();
		}else if(e.getSource().equals(menu.getBtnMyBooks())) {
			btnChangeColor = menu.getBtnMyBooks();
		}else if(e.getSource().equals(menu.getBtnSingOut())) {
			btnChangeColor = menu.getBtnSingOut();
		}else if(e.getSource().equals(registerPanel.getBtnCreateAccount())) {
			btnChangeColor = registerPanel.getBtnCreateAccount();
		}else if(e.getSource().equals(registerPanel.getBtnBack())) {
			btnChangeColor = registerPanel.getBtnBack();
		}
		btnChangeColor.setBackground(hoverColor);
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		JButton btnChangeColor = new JButton();
		
		if(e.getSource().equals(btnExit)) {
			btnChangeColor = btnExit;
		}else if(e.getSource().equals(loginPanel.getBtnLogin())) {
			btnChangeColor = loginPanel.getBtnLogin();
		}else if(e.getSource().equals(loginPanel.getBtnRegister())) {
			loginPanel.getBtnRegister().setForeground(gray);
		}else if(e.getSource().equals(menu.getBtnProfile())) {
			btnChangeColor = menu.getBtnProfile();
		}else if(e.getSource().equals(menu.getBtnSearchBooks())) {
			btnChangeColor =menu.getBtnSearchBooks();
		}else if(e.getSource().equals(menu.getBtnMyBooks())) {
			btnChangeColor = menu.getBtnMyBooks();
		}else if(e.getSource().equals(menu.getBtnSingOut())) {
			btnChangeColor = menu.getBtnSingOut();
		}else if(e.getSource().equals(registerPanel.getBtnCreateAccount())) {
			btnChangeColor = registerPanel.getBtnCreateAccount();
			
		}else if(e.getSource().equals(registerPanel.getBtnBack())) {
			btnChangeColor = registerPanel.getBtnBack();
		}
		btnChangeColor.setBackground(mainColor);
	}
}
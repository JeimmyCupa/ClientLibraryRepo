package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Insets;

public class WindowMain extends JFrame {
	public final static Color colorFirst = new Color(22,44,64);
	public final static Color colorSecond = new Color(217,95,95);
	public final static Color colorDark = new Color(64,64,64);
	public final static Color colorGray = new Color(128,128,128);
	public final static Color colorLight = new Color(230,230,230);
	public final static Color colorWhite = new Color(255,255,255);
	private JPanel contentPane;//Panel principal de la ventana
	private JPanel contentData,header,menuPanel,dataPanel;
	private JButton btnExit;
	
	private LoginPanel loginPanel;
	private MenuPanel menu;
	private SearchBookPanel searchBookPanel;
	private ActionListener listener;
	
	private int xMouse, yMouse;//atributos para controlar el desplazamiento de la ventana
	
	public WindowMain(ActionListener listener) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setBounds(10,10,1200,680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		this.listener = listener;
		initComponents();
		//initLoginPanel();
		initComponentsUser();
	}
	//Metodo para inciar componentes generales de la GUI(Cabecera y un panel para el contenido en contentPane)
	public void initComponents() {

		header = new JPanel();
		header.setBounds(0, 0, 1200, 45);
		header.setLayout(null);
		header.setBackground(colorWhite);
		header.addMouseMotionListener(this.panelMouseDragged());
		header.addMouseListener(this.panelMousePressed());
		
		btnExit = new JButton();
		btnExit.setText("X");
		btnExit.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		btnExit.setForeground(colorFirst);
		btnExit.setBackground(colorWhite);
		btnExit.setBounds(1150,0,43,43);
		btnExit.setBorderPainted(false);
		btnExit.setMargin(new Insets(1, 1, 1, 1));;
		btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExit.addActionListener(listener);
		btnExit.setActionCommand("EXIT");
		btnExit.addMouseListener(this.mouseEntered());
		btnExit.addMouseListener(this.mouseExited());
		header.add(btnExit);
		getContentPane().add(header);
		
		contentData = new JPanel();
		contentData.setBounds(0,43,1200,637);
		contentPane.add(contentData);
		contentData.setLayout(null);
	}
	//Metodo para iniciar componente del Login
	public void initLoginPanel() {
		loginPanel = new LoginPanel(listener);
		loginPanel.setSize(1200, 635);
		loginPanel.setLocation(0, 43);
		showPanel(contentData, loginPanel);
	}
	/**Metodo que inicia la interfaz de usuario (Menu y un panel lateral para el contenido)
	*Este metodo se debe llamar siempre el login sea exitoso.
	*/
	public void initComponentsUser() {
		dataPanel = new JPanel();//Panel que se actualiza de acuerdo a la opcion del menu selecionada
		dataPanel.setBounds(286,1,914,635);
		dataPanel.setLayout(null);
		contentData.add(dataPanel);
		
		menuPanel = new JPanel();
		menuPanel.setSize(285,636);
		menuPanel.setLayout(null);
		contentData.add(menuPanel);
		
		menu = new MenuPanel(listener);
		menu.setSize(285, 636);
		menu.setLocation(0, 0);
		showPanel(menuPanel,menu);
		
		initSearchBooks();
		
	}
	//Metodo para pintar el panel SearchBooks(){
	public void initSearchBooks() {
		searchBookPanel = new SearchBookPanel(listener);
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
	//Metodos para manejar el efecto Hover del boton exit
		private void btnMouseEntered(MouseEvent event) {
			JButton btnEvent = (JButton)event.getSource(); 
			if(btnEvent.equals(btnExit)) {
				btnExit.setBackground(WindowMain.colorFirst);
				btnExit.setForeground(WindowMain.colorWhite);
			}
		}
		private void btnMouseExited(MouseEvent event) {
			JButton btnEvent = (JButton)event.getSource(); 
			if(btnEvent.equals(btnExit)) {
				btnExit.setBackground(WindowMain.colorSecond);
			}
		}
	/*Metodo que retorna un objeto MouseMotionListener necesario para agregar al panel eventos de tipo MousePressed*/
	public MouseMotionListener panelMouseDragged() {
		return new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent evt) {
				btnMoveMouseDragged(evt);
			}
		};
	}
	
}

package view;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.SwingConstants;
import java.awt.Insets;
import java.awt.event.MouseAdapter;

public class MenuPanel extends JPanel {
	private ActionListener listener;
	private JButton btnProfile,btnMyBooks,btnSearchBooks,btnSingOut;
	
	public MenuPanel(ActionListener listener) {
		setSize(285, 636);
		setLayout(null);
		setBackground(WindowMain.colorFirst);
		this.listener = listener;
		initComponents();
	}
	//Metodo que inicializa todos los botones del menu
	public void initComponents() {
		btnProfile = new JButton();
		btnProfile.setIconTextGap(6);
		btnProfile.setMargin(new Insets(2, 30, 2, 4));
		btnProfile.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnProfile.setText("Mi perfil");
		btnProfile.setIcon(new ImageIcon("data\\icons\\iconUserCircle.png"));
		btnProfile.setBorder(new MatteBorder(0, 0, 2, 0, WindowMain.colorLight));
		btnProfile.setBounds(0, 136, 285, 53);
		btnProfile.setBackground(WindowMain.colorFirst);
		btnProfile.setForeground(Color.white);
		btnProfile.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnProfile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnProfile.addActionListener(listener);//Evento relacionado con la accion de mostrar panerl del perfil de usuario.
		btnProfile.setActionCommand("SHOWPROFILE");
		//Evento hover para el boton, necesita como parametro un objeto de MouseAdapter
		btnProfile.addMouseListener(this.mouseEntered());
		btnProfile.addMouseListener(this.mouseExited());
		add(btnProfile);
		
		btnSearchBooks = new JButton();
		btnSearchBooks.setText("Buscar libros");
		btnSearchBooks.setIcon(new ImageIcon("data\\icons\\iconSearch.png"));
		btnSearchBooks.setMargin(new Insets(2, 30, 2, 4));
		btnSearchBooks.setIconTextGap(6);
		btnSearchBooks.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnSearchBooks.setForeground(Color.WHITE);
		btnSearchBooks.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnSearchBooks.setBorder(new MatteBorder(0, 0, 2, 0, WindowMain.colorLight));
		btnSearchBooks.setBackground(new Color(22, 44, 64));
		btnSearchBooks.setBounds(0, 192, 285, 53);
		btnSearchBooks.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearchBooks.addActionListener(listener);
		btnSearchBooks.setActionCommand("SEARCHBOOKS");
		btnSearchBooks.addMouseListener(this.mouseEntered());
		btnSearchBooks.addMouseListener(this.mouseExited());
		add(btnSearchBooks);
		
		btnMyBooks = new JButton();
		btnMyBooks.setText("Mis libros");
		btnMyBooks.setIcon(new ImageIcon("data\\icons\\iconBook.png"));
		btnMyBooks.setMargin(new Insets(2, 30, 2, 4));
		btnMyBooks.setIconTextGap(6);
		btnMyBooks.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnMyBooks.setForeground(Color.WHITE);
		btnMyBooks.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnMyBooks.setBorder(new MatteBorder(0, 0, 2, 0, WindowMain.colorLight));
		btnMyBooks.setBackground(new Color(22, 44, 64));
		btnMyBooks.setBounds(0, 247, 285, 53);
		btnMyBooks.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMyBooks.addActionListener(listener);
		btnMyBooks.setActionCommand("SEARCHBOOKS");
		btnMyBooks.addMouseListener(this.mouseEntered());
		btnMyBooks.addMouseListener(this.mouseExited());
		add(btnMyBooks);
		
		btnSingOut = new JButton();
		btnSingOut.setText("Cerrar sesi\u00F3n");
		btnSingOut.setIcon(new ImageIcon("data\\icons\\iconSingOut.png"));
		btnSingOut.setMargin(new Insets(2, 30, 2, 4));
		btnSingOut.setIconTextGap(6);
		btnSingOut.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnSingOut.setForeground(Color.WHITE);
		btnSingOut.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnSingOut.setBorder(new MatteBorder(0, 0, 2, 0, WindowMain.colorLight));
		btnSingOut.setBackground(new Color(22, 44, 64));
		btnSingOut.setBounds(0, 302, 285, 53);
		btnSingOut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSingOut.addActionListener(listener);
		btnSingOut.setActionCommand("SEARCHBOOKS");
		btnSingOut.addMouseListener(this.mouseEntered());
		btnSingOut.addMouseListener(this.mouseExited());
		add(btnSingOut);
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
	//Metodos propios de la clase para el efecto Hover
	
	public void btnMouseEntered(MouseEvent event) {
		JButton btnEvent = (JButton)event.getSource(); 
		JButton btnChangeColor = null;
		if(btnEvent.equals(btnProfile)) {
			btnChangeColor = btnProfile;
		}else if(btnEvent.equals(btnSearchBooks)) {
			btnChangeColor = btnSearchBooks;
		}else if(btnEvent.equals(btnMyBooks)) {
			btnChangeColor = btnMyBooks;
		}else if(btnEvent.equals(btnSingOut)) {
			btnChangeColor = btnSingOut;
		}
		btnChangeColor.setBackground(WindowMain.colorSecond);
	}
	public void btnMouseExited(MouseEvent event) {
		JButton btnEvent = (JButton)event.getSource(); 
		JButton btnChangeColor = null;
		if(btnEvent.equals(btnProfile)) {
			btnChangeColor = btnProfile;
		}else if(btnEvent.equals(btnSearchBooks)) {
			btnChangeColor = btnSearchBooks;
		}else if(btnEvent.equals(btnMyBooks)) {
			btnChangeColor = btnMyBooks;
		}else if(btnEvent.equals(btnSingOut)) {
			btnChangeColor = btnSingOut;
		}
		btnChangeColor.setBackground(WindowMain.colorFirst);
	}
}

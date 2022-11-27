package view;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
	private JButton btnProfile,btnMyBooks,btnSearchBooks,btnSingOut;
	
	public MenuPanel(ActionListener actionListener,MouseListener mouseListener) {
		setSize(285, 636);
		setLayout(null);
		setBackground(MainWindow.mainColor);
		initComponents(actionListener,mouseListener);
	}
	//Metodo que inicializa todos los botones del menu
	public void initComponents(ActionListener listener,MouseListener mouseListener) {
		btnProfile = new JButton();
		propertiesBtn(btnProfile);
		btnProfile.setText("Mi perfil");
		btnProfile.setIcon(new ImageIcon("data\\icons\\iconUserCircle.png"));
		btnProfile.setBounds(0, 136, 285, 53);
		btnProfile.addActionListener(listener);
		btnProfile.setActionCommand("SHOWPROFILE");
        //Evento hover para el boton, necesita como parametro un objeto de MouseAdapter
        btnProfile.addMouseListener(mouseListener);
		add(btnProfile);
		
		btnSearchBooks = new JButton();
        propertiesBtn(btnSearchBooks);
        btnSearchBooks.setText("Buscar libros");
        btnSearchBooks.setIcon(new ImageIcon("data\\icons\\iconSearch.png"));
        btnSearchBooks.setBounds(0, 192, 285, 53);
        btnSearchBooks.addActionListener(listener);
        btnSearchBooks.setActionCommand("SEARCHBOOKS");
        btnSearchBooks.addMouseListener(mouseListener);
        add(btnSearchBooks);

        btnMyBooks = new JButton();
        propertiesBtn(btnMyBooks);
        btnMyBooks.setText("Mis libros");
        btnMyBooks.setIcon(new ImageIcon("data\\icons\\iconBook.png"));
        btnMyBooks.setBounds(0, 247, 285, 53);
        btnMyBooks.addActionListener(listener);
        btnMyBooks.setActionCommand("SEARCHBOOKS");
        btnMyBooks.addMouseListener(mouseListener);
        add(btnMyBooks);
		
		btnSingOut = new JButton();
		propertiesBtn(btnSingOut);
		btnSingOut.setText("Cerrar sesi\u00F3n");
		btnSingOut.setIcon(new ImageIcon("data\\icons\\iconSingOut.png"));
		btnSingOut.setBounds(0, 302, 285, 53);
		btnSingOut.addActionListener(listener);
		btnSingOut.setActionCommand("SINGOUT");
        btnSingOut.addMouseListener(mouseListener);
		add(btnSingOut);
	}
	public void propertiesBtn(JButton buttonToApply) {
		buttonToApply.setIconTextGap(6);
        buttonToApply.setMargin(new Insets(2, 30, 2, 4));
        buttonToApply.setHorizontalTextPosition(SwingConstants.RIGHT);
        buttonToApply.setBorder(new MatteBorder(0, 0, 2, 0, MainWindow.lightGray));
        buttonToApply.setForeground(Color.white);
        buttonToApply.setFont(new Font("Segoe UI", Font.BOLD, 20));
        buttonToApply.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buttonToApply.setBackground(MainWindow.mainColor);
	}
	public JButton getBtnProfile() {
		return btnProfile;
	}
	public JButton getBtnMyBooks() {
		return btnMyBooks;
	}
	public JButton getBtnSearchBooks() {
		return btnSearchBooks;
	}
	public JButton getBtnSingOut() {
		return btnSingOut;
	}
	
	/*
	public void setBackgroundBtn(JButton btn) {
		JButton btnChangeColor = new JButton();
		if(btn.equals(btnProfile)) {
			btnChangeColor = btnProfile;
		}else if(btn.equals(btnSearchBooks)) {
			btnChangeColor = btnSearchBooks;
		}else if(btn.equals(btnMyBooks)) {
			btnChangeColor = btnMyBooks;
		}else if(btn.equals(btnSingOut)) {
			btnChangeColor = btnSingOut;
		}
		btnChangeColor.setBackground(MainWindow.hoverColor);
	}*/
}

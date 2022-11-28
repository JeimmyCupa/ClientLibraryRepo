package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BookDialog extends JDialog {
	private JPanel header,bookPanel;
	private JButton btnRentBook,btnExit,btnMin,btnCancel;
	private int xMouse,yMouse;
	/**
	 * Metodo constructor del dialogo para mostrar el libro con el boton de rentar.
	 * @param frame Indica la ventana padre del dialogo
	 * @param mode
	 * @param listener Recibe un objeto ActionListener de ClientController
	 * @param item Recibe como parámetro un objeto Item, que hereda de JPanel, del libro a mostrar
	 */
	public BookDialog(boolean mode,JFrame frame,ActionListener actionListener,MouseListener mouseListener, JPanel item) {
		super(frame,mode);
		this.bookPanel = item;
		setSize(300,350);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new BoxLayout(getContentPane(),BoxLayout.X_AXIS));
		initComponents(mouseListener);
		btnRentBook = new JButton("Rentar");
		btnRentBook.setAlignmentX(CENTER_ALIGNMENT);
		btnRentBook.setBackground(MainWindow.MAINCOLOR);
		btnRentBook.addActionListener(actionListener);
		btnRentBook.setActionCommand("RENTBOOK");
		btnRentBook.addMouseListener(mouseListener);
		btnRentBook.setAlignmentX(BOTTOM_ALIGNMENT);
		
		btnCancel = new JButton("Cancelar");
		btnCancel.setAlignmentX(CENTER_ALIGNMENT);
		btnCancel.setBackground(MainWindow.MAINCOLOR);
		btnCancel.addActionListener(actionListener);
		btnCancel.setActionCommand("CANCELAR");
		btnCancel.addMouseListener(mouseListener);
		btnCancel.setAlignmentX(BOTTOM_ALIGNMENT);
		
		bookPanel.setAlignmentX(CENTER_ALIGNMENT);
		getContentPane().add(header);
		getContentPane().add(bookPanel);
		getContentPane().add(btnRentBook);
		getContentPane().add(btnCancel);
	}
	public void initComponents(MouseListener mouseListener) {
		header = new JPanel();
		header.setBounds(0, 0, 1200, 45);
		header.setLayout(null);
		header.setBackground(MainWindow.WHITECOLOR);
		//header.addMouseMotionListener(mouseListener);
		header.setAlignmentX(TOP_ALIGNMENT);
		
		btnExit = new JButton();
		btnExit.setText("X");
		btnExit.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		btnExit.setForeground(MainWindow.WHITECOLOR);
		btnExit.setBackground(MainWindow.MAINCOLOR);
		btnExit.setBounds(1157,0,43,43);
		btnExit.setBorderPainted(false);
		btnExit.setMargin(new Insets(1, 1, 1, 1));;
		btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		//btnExit.addActionListener(this);
		btnExit.setActionCommand("EXITDIALOG");
		btnExit.addMouseListener(mouseListener);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		header.add(btnExit);
		
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
		
		getContentPane().add(header);
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
	


}

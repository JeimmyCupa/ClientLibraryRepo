package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

public class RentedBookDialog extends JDialog implements ActionListener{
	private JPanel header,bookPanel;
	private JButton btnRentBook,btnExit,btnMin;
	private int xMouse,yMouse;
	/**
	 * Metodo constructor del dailogo para mostrar el libro con el boton de rentar.
	 * @param frame Indica la ventana padre del dialogo
	 * @param mode
	 * @param listener Recibe un objeto ActionListener de ClientController
	 * @param item Recibe como parámetro un objeto Item, que hereda de JPanel, del libro a mostrar
	 */
	public RentedBookDialog(boolean mode,ActionListener listener, JPanel item) {
		//super(frame,mode);
		this.bookPanel = item;
		setSize(300,350);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new BoxLayout(getContentPane(),BoxLayout.X_AXIS));
		initComponents();
		btnRentBook = new JButton("Rentar");
		btnRentBook.setAlignmentX(CENTER_ALIGNMENT);
		btnRentBook.setBackground(WindowMain.colorFirst);
		btnRentBook.addActionListener(listener);
		btnRentBook.setActionCommand("RENTBOOK");
		btnRentBook.addMouseListener(this.mouseEntered());
		btnRentBook.addMouseListener(this.mouseExited());
		btnRentBook.setAlignmentX(BOTTOM_ALIGNMENT);
		
		bookPanel.setAlignmentX(CENTER_ALIGNMENT);
		getContentPane().add(header);
		getContentPane().add(bookPanel);
		getContentPane().add(btnRentBook);
	}
	public void initComponents() {
		header = new JPanel();
		header.setBounds(0, 0, 1200, 45);
		header.setLayout(null);
		header.setBackground(WindowMain.colorWhite);
		header.addMouseMotionListener(this.panelMouseDragged());
		header.addMouseListener(this.panelMousePressed());
		header.setAlignmentX(TOP_ALIGNMENT);
		
		btnExit = new JButton();
		btnExit.setText("X");
		btnExit.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		btnExit.setForeground(WindowMain.colorFirst);
		btnExit.setBackground(WindowMain.colorSecond);
		btnExit.setBounds(1157,0,43,43);
		btnExit.setBorderPainted(false);
		btnExit.setMargin(new Insets(1, 1, 1, 1));;
		btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExit.addActionListener(this);
		btnExit.setActionCommand("EXITDIALOG");
		btnExit.addMouseListener(this.mouseEntered());
		btnExit.addMouseListener(this.mouseExited());
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
		/*Metodo que retorna un objeto MouseMotionListener necesario para agregar al panel eventos de tipo MousePressed*/
		public MouseMotionListener panelMouseDragged() {
			return new MouseMotionAdapter() {
				public void mouseDragged(MouseEvent evt) {
					btnMoveMouseDragged(evt);
				}
			};
		}
		private MouseAdapter panelMousePressed() {
			return new MouseAdapter() {
				public void mousePressed(MouseEvent event) {
					btnMoveMousePressed(event);
				}
			};
		}
		
	/**
	 * Metodos para crear el eventos de mouse en el boton rentar y exit
	 * @return objeto de la clase MouseAdapter
	 */
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
			if(btnEvent.equals(btnRentBook)) {
				btnRentBook.setBackground(WindowMain.colorSecond);
				btnRentBook.setForeground(WindowMain.colorWhite);
			}
		}
		private void btnMouseExited(MouseEvent event) {
			JButton btnEvent = (JButton)event.getSource(); 
			if(btnEvent.equals(btnRentBook)) {
				btnRentBook.setBackground(WindowMain.colorFirst);
			}
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			String event = e.getActionCommand();
			if(event.equals("EXITDIALOG")) {
				this.dispose();
			}
		}
}

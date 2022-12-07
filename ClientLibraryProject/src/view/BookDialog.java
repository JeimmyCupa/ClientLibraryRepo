package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.Book;

import javax.swing.JLabel;
import javax.swing.JTextArea;

public class BookDialog extends JDialog {
	private JPanel bookPanel;
	private JButton btnRentBook,btnCancel;

	/**
	 * Metodo constructor del dialogo para mostrar el libro con el boton de rentar.
	 * @param frame Indica la ventana padre del dialogo
	 * @param mode
	 * @param listener Recibe un objeto ActionListener de ClientController
	 * @param item Recibe como parámetro un objeto Item, que hereda de JPanel, del libro a mostrar
	 */
	public BookDialog(boolean mode,JFrame frame,ActionListener actionListener, Book book) {
		super(frame,mode);
		
		setSize(478,345);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		initComponents(actionListener,book);
		getContentPane().add(bookPanel);
		bookPanel.setLayout(null);
		
	}
	public void initComponents(ActionListener actionListener,Book book) {
		
		getContentPane().setLayout(null);
		this.bookPanel = new JPanel();
		bookPanel.setBounds(0,0,462,256);
		JLabel lblTitle = new JLabel();
		lblTitle.setText(book.getTitle());
		lblTitle.setBounds(205, 11, 226, 31);
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblTitle.setForeground(MainWindow.MAINCOLOR);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		bookPanel.add(lblTitle);
		
		JLabel lblImage = new JLabel();
		lblImage.setBounds(10, 11, 160, 234);
		lblImage.setIcon(new ImageIcon(book.getPathImage()));//Crear metodo para asignar imagenes
		bookPanel.add(lblImage);
		
		JLabel lblAuthor = new JLabel(book.getAuthor());
		lblAuthor.setBounds(271, 53, 94, 20);
		lblAuthor.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblAuthor.setForeground(MainWindow.MAINCOLOR);
		lblAuthor.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblYear = new JLabel(book.getDepartureYear());
		lblYear.setBounds(271, 74, 94, 20);
		lblYear.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblYear.setForeground(MainWindow.MAINCOLOR);
		lblYear.setHorizontalAlignment(SwingConstants.CENTER);
		
		JTextArea textArea = new JTextArea();
		textArea.setText(book.getDescription());
		textArea.setBounds(180, 105, 272, 67);
		textArea.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		textArea.setEnabled(false);
		textArea.setForeground(MainWindow.STRONGBLACK);
		textArea.setBackground(MainWindow.WHITECOLOR);
		
		btnRentBook = new JButton("Rentar");
		btnRentBook.setBounds(179, 206, 125, 39);
		btnRentBook.setAlignmentX(CENTER_ALIGNMENT);
		btnRentBook.setForeground(MainWindow.WHITECOLOR);
		btnRentBook.setBackground(MainWindow.MAINCOLOR);
		btnRentBook.addActionListener(actionListener);
		btnRentBook.addMouseListener(new  MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(e.getSource().equals(btnRentBook)){
					JButton btn = (JButton)e.getSource();
					btn.setBackground(MainWindow.HOVERCOLOR);
					btn.setForeground(MainWindow.STRONGBLACK);
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(MainWindow.MAINCOLOR);
				if(e.getSource().equals(btnRentBook)){
					JButton btn = (JButton)e.getSource();
					btn.setBackground(MainWindow.MAINCOLOR);
					btn.setForeground(MainWindow.WHITECOLOR);
				}
			}
		});
		btnRentBook.setActionCommand("RENT_BOOK");
		btnRentBook.setAlignmentX(BOTTOM_ALIGNMENT);
		
		btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(327, 206, 125, 39);
		btnCancel.setAlignmentX(CENTER_ALIGNMENT);
		btnCancel.setForeground(MainWindow.WHITECOLOR);
		btnCancel.setBackground(MainWindow.MAINCOLOR);
		btnCancel.addMouseListener(this.mouseClicked());
		btnCancel.addMouseListener(new  MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(e.getSource().equals(btnRentBook)){
					JButton btn = (JButton)e.getSource();
					btn.setBackground(MainWindow.HOVERCOLOR);
					btn.setForeground(MainWindow.STRONGBLACK);
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(MainWindow.MAINCOLOR);
				if(e.getSource().equals(btnRentBook)){
					JButton btn = (JButton)e.getSource();
					btn.setBackground(MainWindow.MAINCOLOR);
					btn.setForeground(MainWindow.STRONGBLACK);
				}
			}
		});
		
		bookPanel.add(lblAuthor);
		bookPanel.add(textArea);
		bookPanel.add(lblYear);
		bookPanel.add(btnRentBook);
		bookPanel.add(btnCancel);
		
		getContentPane().add(bookPanel);
	}
	private MouseAdapter mouseClicked() {
		return new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			}
			
		};
	}
	
}

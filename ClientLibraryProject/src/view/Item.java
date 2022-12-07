package view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import model.Book;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Item extends JPanel {
	private Book book;
	private ActionListener listener;
	public Item(Book book,ActionListener listener,JFrame mainWindow) {
		this.listener = listener;
		this.book= book;
		addMouseListener(this.mouseEntered());
		addMouseListener(this.mouseExited());
		addMouseListener(this.mouseClicked(mainWindow));
		setBackground(MainWindow.WHITECOLOR);
		setBorder(new MatteBorder(1,1,1,1,MainWindow.LIGHTGRAY));
		setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();//GridBagLayout constraints es la clase que define las restricciones para un componente de GridBagLayout.
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(5,5,5,5);//Establece el espacio entre componentes
		
		JLabel frontPage = new JLabel();
		frontPage.setIcon(new ImageIcon(book.getPathImage()));
		
		//frontPage.setBorder(new MatteBorder(5,5,5,5));
		frontPage.setBackground(MainWindow.WHITECOLOR);
		//frontPage.addMouseListener(mouseListener);
		add(frontPage,c);//Se añade el elemento junto con la ubicacion establecida en el objeto GridBagConstraints 
		
		GridBagConstraints c1 = new GridBagConstraints();
		c1.gridx = 0;
		c1.gridy = 1;
		c1.insets = new Insets(5,5,5,5);
		JLabel lblID = new JLabel();
		lblID.setText(String.valueOf(book.getBookID()));
		lblID.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblID.setForeground(MainWindow.MAINCOLOR);
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblID,c1);
		
		GridBagConstraints c2 = new GridBagConstraints();
		c2.gridx = 0;
		c2.gridy = 2;
		c2.insets = new Insets(5,5,5,5);
		
		JLabel lblTitle = new JLabel();
		lblTitle.setText(book.getTitle());
		lblTitle.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblTitle.setForeground(MainWindow.MAINCOLOR);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		//lblTitle.addMouseListener(mouseclicked);
		add(lblTitle,c2);
		
		GridBagConstraints c3 = new GridBagConstraints();
		c3.gridx = 0;
		c3.gridy = 3;
		c3.insets = new Insets(5,5,5,5);
		
		JLabel lblAuthor = new JLabel();
		lblAuthor.setText(book.getAuthor());
		lblAuthor.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblAuthor.setForeground(MainWindow.MAINCOLOR);
		lblAuthor.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblAuthor,c3);
		
		GridBagConstraints c4 = new GridBagConstraints();
		c4.gridx = 0;
		c4.gridy = 4;
		c4.insets = new Insets(5,5,5,5);
		JLabel lblYear = new JLabel();
		lblYear.setText(book.getDepartureYear());
		lblYear.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblYear.setForeground(MainWindow.MAINCOLOR);
		lblYear.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblYear,c4);

	}
	//Setters y getters
	public Book obtainBook() {
		return this.book;
	}
	//Metodos efecto hover
	private MouseAdapter mouseEntered() {
		return new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMouseEntered(e);
			}
		};
	}

	private MouseAdapter mouseExited() {
		return new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btnMouseExited(e);
			}
		};
	}

	// Metodos para manejar el efecto Hover
	private void btnMouseEntered(MouseEvent event) {
		setBackground(MainWindow.BEIGE);
		setBorder(new MatteBorder(1, 1, 1, 1, MainWindow.MAINCOLOR));
	}

	private void btnMouseExited(MouseEvent event) {
		setBackground(MainWindow.WHITECOLOR);
		setBorder(new MatteBorder(1, 1, 1, 1, MainWindow.GRAY));
	}
	
	private MouseAdapter mouseClicked(JFrame mainWindow) {
		return new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				showDialogRentedBook(mainWindow,(Item)e.getSource());
			}
		};
	}
	
	private void showDialogRentedBook(JFrame mainWindow,Item item) {
		BookDialog bookDialog = new BookDialog(true,mainWindow, listener, item.obtainBook());
		bookDialog.setVisible(true);
		bookDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}

}

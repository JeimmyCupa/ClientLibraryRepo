package tabletest;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Book;
import model.CopyBook;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private RentedBooks rentedBooks;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ArrayList<CopyBook> bookSet = new ArrayList<>();
		bookSet.add(new CopyBook(new Book("Principito", 1, 19, "Pepito", "2005")));
		bookSet.add(new CopyBook(new Book("100 Años de soledad", 2, 19, "Pepito", "2005")));
		bookSet.add(new CopyBook(new Book("Principal", 3, 19, "Pepito", "2005")));
		bookSet.add(new CopyBook(new Book("Pedro", 4, 19, "Pepito", "2005")));
		bookSet.add(new CopyBook(new Book("A donde vas", 5, 19, "Pepito", "2005")));
		bookSet.add(new CopyBook(new Book("No se que mas poner", 6, 19, "Pepito", "2005")));
		bookSet.add(new CopyBook(new Book("Libro", 7, 19, "Pepito", "2005")));
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow(bookSet);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow(ArrayList<CopyBook> personSet) {
		rentedBooks = new RentedBooks(personSet);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(914,635);
		setLocationRelativeTo(null);
		setContentPane(rentedBooks);
	}

}

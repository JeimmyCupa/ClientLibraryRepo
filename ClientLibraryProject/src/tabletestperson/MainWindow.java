package tabletestperson;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private RentedBooks rentedBooks;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ArrayList<Person> personSet = new ArrayList<>();
		personSet.add(new Person("Pedro", "Arnoldo", 1));
		personSet.add(new Person("Luis", "Arnoldo", 2));
		personSet.add(new Person("Carlos", "Arnoldo", 3));
		personSet.add(new Person("Mariana", "Arnoldo", 4));
		personSet.add(new Person("Veronica", "Arnoldo", 5));
		personSet.add(new Person("Jeimmy", "Arnoldo", 6));
		personSet.add(new Person("El Brayan", "Arnoldo", 7));
		personSet.add(new Person("Los Oscares", "Arnoldo", 8));
		personSet.add(new Person("Los Oscares", "Arnoldo", 8));
		personSet.add(new Person("Los Oscares", "Arnoldo", 8));
		personSet.add(new Person("Los Oscares", "Arnoldo", 8));
		personSet.add(new Person("Los Oscares", "Arnoldo", 8));
		personSet.add(new Person("Los Oscares", "Arnoldo", 8));
		personSet.add(new Person("Los Oscares", "Arnoldo", 8));
		personSet.add(new Person("Los Oscares", "Arnoldo", 8));
		personSet.add(new Person("Los Oscares", "Arnoldo", 8));
		personSet.add(new Person("Los Oscares", "Arnoldo", 8));
		personSet.add(new Person("Los Oscares", "Arnoldo", 8));
		personSet.add(new Person("Los Oscares", "Arnoldo", 8));
		personSet.add(new Person("Los Oscares", "Arnoldo", 8));
		personSet.add(new Person("Veronica", "Arnoldo", 5));
		personSet.add(new Person("Jeimmy", "Arnoldo", 6));
		personSet.add(new Person("El Brayan", "Arnoldo", 7));
		personSet.add(new Person("Los Oscares", "Arnoldo", 8));
		personSet.add(new Person("Laura", "Arnoldo", 8));
		personSet.add(new Person("Los Oscares", "Arnoldo", 8));
		personSet.add(new Person("Veranio", "Arnoldo", 8));
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow(personSet);
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
	public MainWindow(ArrayList<Person> personSet) {
		rentedBooks = new RentedBooks(personSet);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(914,635);
		setLocationRelativeTo(null);
		setContentPane(rentedBooks);
	}

}

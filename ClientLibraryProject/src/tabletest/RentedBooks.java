package tabletest;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JTextPane;
import javax.swing.JTable;

public class RentedBooks extends JPanel {
	private JPanel queryPanel;
	private ArrayList<Person> personSet;
	public final static Color mainColor = new Color(46,55,100);
	public final static Color whiteColor = new Color(235,236,240);//217,95,95
	public final static Color strongBlack = new Color(14,29,38);
	public final static Color strongGray = new Color(38,38,38);
	public final static Color gray = new Color(89,89,89);
	public final static Color lightGray = new Color(166,166,166);
	public final static Color beige = new Color(242,242,199);
	public final static Color hoverColor = new Color(74,87,120);
	private JTable table;
	private JTextField textField;
	
	public RentedBooks(ArrayList<Person> personSet) {
		setBorder(new LineBorder(Color.BLACK));
		setSize(914,635);
		setBackground(whiteColor);
		setLayout(null);
		this.personSet = personSet;
		initComponents();
	}
	
	private void initComponents() {
		JLabel title_1 = new JLabel("Libros Alquilados");
		title_1.setFont(new Font("SansSerif", Font.BOLD, 30));
		title_1.setForeground(mainColor);
		title_1.setBounds(315, 67, 257, 39);
		add(title_1);
		
		
		table = new JTable(showPersons(personSet));
		table.setBounds(85, 249, 717, 334);
		table.setGridColor(mainColor);
		table.setEnabled(false);
		add(table);
		
		JScrollPane tableScroll = new JScrollPane(table);
		tableScroll.setBorder(new MatteBorder(2, 2, 2, 2, mainColor));
		tableScroll.setBounds(90, 214, 717, 334);
		tableScroll.setVisible(true);
		add(tableScroll);
		
		textField = new JTextField();
		textField.setBorder(new MatteBorder(1, 1, 1, 1, mainColor));
		textField.setBackground(whiteColor);
		textField.setBounds(191, 136, 532, 47);
		textField.setColumns(10);
		add(textField);
		textField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldKeyReleased(evt);
            }
        });
	}
	
	private DefaultTableModel showPersons(ArrayList<Person> personSet) {
		String[] columns = {"Nombre", "Apellido", "ID"};
		String[] registers = new String[3];
		DefaultTableModel model = new DefaultTableModel(null, columns);
		for (int i = 0; i < personSet.size(); i++) {
			registers[0] = personSet.get(i).getName();
			registers[1] = personSet.get(i).getLastName();
			registers[2] = String.valueOf(personSet.get(i).getId());
			model.addRow(registers);
		}
		
		return model;
	}
	
	public ArrayList<Person> searchPersons(ArrayList<Person> personSet, String searchText){
		ArrayList<Person> personsFound = new ArrayList<>();
		char[] textChars = searchText.toCharArray();
		if(textChars.length != 0) {
			for (int i = 0; i < personSet.size(); i++) {
				String personName = personSet.get(i).getName();
				boolean areEquals = true;
				for (int j = 0; j < textChars.length && areEquals; j++) {
					if(personName.length() >= textChars.length) {
						String actChar = String.valueOf(personName.charAt(j));
						if(actChar.compareToIgnoreCase(String.valueOf(textChars[j])) != 0) {
							areEquals = false; 
						}
					}else {
						areEquals = false;
					}
				}
				if (areEquals) {
					personsFound.add(personSet.get(i));
				}
			}			
		}else {
			return personSet;
		}
		return personsFound;
	}
	
	private void updateTable(String searchText) {
		DefaultTableModel model = showPersons(searchPersons(personSet, searchText));
		table.setModel(model);
	}
	
	private void textFieldKeyReleased(java.awt.event.KeyEvent evt) {
		updateTable(textField.getText());
    }
	
	
	
	public static void main(String[] args) {
		/**ArrayList<Person> personSet = new ArrayList<>();
		personSet.add(new Person("Pedro", "Arnoldo", 1));
		personSet.add(new Person("Luis", "Arnoldo", 2));
		personSet.add(new Person("Carlos", "Arnoldo", 3));
		personSet.add(new Person("Mariana", "Arnoldo", 4));
		personSet.add(new Person("Veronica", "Arnoldo", 5));
		personSet.add(new Person("Jeimmy", "Arnoldo", 6));
		personSet.add(new Person("El Brayan", "Arnoldo", 7));
		personSet.add(new Person("Los Oscares", "Arnoldo", 8));
		personSet.add(new Person("Laura", "Arnoldo", 8));
		personSet.add(new Person("Los Oscares", "Arnoldo", 8));
		personSet.add(new Person("Veranio", "Arnoldo", 8));
		RentedBooks rented = new RentedBooks(personSet);
		ArrayList<Person> personsFound = rented.searchPersons(personSet, "");
		System.out.println(personsFound.size());
		System.out.println("Comparando Caracteres: " + "v".compareToIgnoreCase("V"));
		for (int i = 0; i < personsFound.size(); i++) {
			System.out.println(personsFound.get(i).getName() + " | " + personsFound.get(i).getId());
		}**/
	}
}

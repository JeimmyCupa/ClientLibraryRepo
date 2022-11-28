package tabletest;

import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTable;
import model.CopyBook;

public class RentedBooks extends JPanel {
	private ArrayList<CopyBook> bookSet;
	public final static Color mainColor = new Color(46,55,100);
	public final static Color whiteColor = new Color(235,236,240);//217,95,95
	public final static Color strongBlack = new Color(14,29,38);
	public final static Color strongGray = new Color(38,38,38);
	public final static Color gray = new Color(89,89,89);
	public final static Color lightGray = new Color(166,166,166);
	public final static Color beige = new Color(242,242,199);
	public final static Color hoverColor = new Color(74,87,120);
	public final static Color tableBackground = new Color(222,224,229);
	private JTable table;
	private JTextField txtIngreseElNombre;
	
	public RentedBooks(ArrayList<CopyBook> bookSet) {
		setBorder(new LineBorder(Color.BLACK));
		setSize(914,635);
		setBackground(whiteColor);
		setLayout(null);
		this.bookSet = bookSet;
		initComponents();
	}
	
	private void initComponents() {
		JLabel title_1 = new JLabel("Libros Alquilados");
		title_1.setFont(new Font("SansSerif", Font.BOLD, 30));
		title_1.setForeground(mainColor);
		title_1.setBounds(315, 67, 257, 39);
		add(title_1);
		
		
		table = new JTable(showBooks(bookSet));
		table.setBounds(85, 249, 717, 334);
		table.setGridColor(mainColor);
		table.setBackground(beige);
		table.setForeground(strongBlack);
		table.setEnabled(false);
		add(table);
		
		JScrollPane tableScroll = new JScrollPane(table);
		tableScroll.setBorder(new MatteBorder(2, 2, 2, 2, mainColor));
		tableScroll.setBounds(97, 213, 717, 334);
		tableScroll.setVisible(true);
		add(tableScroll);
		
		txtIngreseElNombre = new JTextField();
		txtIngreseElNombre.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 16));
		txtIngreseElNombre.setText("INGRESE EL NOMBRE DE UN LIBRO");
		txtIngreseElNombre.setBorder(new MatteBorder(1, 1, 1, 1, mainColor));
		txtIngreseElNombre.setBackground(beige);
		txtIngreseElNombre.setForeground(strongBlack);
		txtIngreseElNombre.setBounds(231, 149, 532, 34);
		txtIngreseElNombre.setColumns(10);
		add(txtIngreseElNombre);
		
		JLabel title_1_1 = new JLabel("Buscar:");
		title_1_1.setForeground(new Color(46, 55, 100));
		title_1_1.setFont(new Font("SansSerif", Font.BOLD, 23));
		title_1_1.setBounds(129, 145, 92, 39);
		add(title_1_1);
		txtIngreseElNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldKeyReleased(evt);
            }
        });
	}
	
	private DefaultTableModel showBooks(ArrayList<CopyBook> bookSet) {
		String[] columns = {"Titulo", "ID", "Autor", "Año"};
		String[] registers = new String[4];
		DefaultTableModel model = new DefaultTableModel(null, columns);
		for (int i = 0; i < bookSet.size(); i++) {
			registers[0] = bookSet.get(i).getRentedBook().getTitle();
			registers[1] = String.valueOf(bookSet.get(i).getRentedBook().getBookID());
			registers[2] = bookSet.get(i).getRentedBook().getAuthor();
			registers[3] = bookSet.get(i).getRentedBook().getDepartureYear();
			model.addRow(registers);
		}
		
		return model;
	}
	
	public ArrayList<CopyBook> searchPersons(ArrayList<CopyBook> bookSet, String searchText){
		ArrayList<CopyBook> booksFound = new ArrayList<>();
		char[] textChars = searchText.toCharArray();
		if(textChars.length != 0) {
			for (int i = 0; i < bookSet.size(); i++) {
				String bookTitle = bookSet.get(i).getRentedBook().getTitle();
				boolean areEquals = true;
				for (int j = 0; j < textChars.length && areEquals; j++) {
					if(bookTitle.length() >= textChars.length) {
						String actChar = String.valueOf(bookTitle.charAt(j));
						if(actChar.compareToIgnoreCase(String.valueOf(textChars[j])) != 0) {
							areEquals = false; 
						}
					}else {
						areEquals = false;
					}
				}
				if (areEquals) {
					booksFound.add(bookSet.get(i));
				}
			}			
		}else {
			return bookSet;
		}
		return booksFound;
	}
	
	private void updateTable(String searchText) {
		DefaultTableModel model = showBooks(searchPersons(bookSet, searchText));
		table.setModel(model);
	}
	
	private void textFieldKeyReleased(java.awt.event.KeyEvent evt) {
		updateTable(txtIngreseElNombre.getText());
    }
}

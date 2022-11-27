package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import model.Book;
import tabletest.Person;

public class SearchBookPanel extends JPanel {

	private JPanel queryPanel;
	private BooksPanel booksPanel;
	private JTextField title,author,year;
	private ArrayList<Book> bookSet;
	private ActionListener listener;
	public SearchBookPanel(ActionListener listener,ArrayList<Book> bookSet) {
		this.listener = listener;
		this.bookSet = bookSet;
		setSize(914,635);
		setBackground(Color.green);
		setLayout(null);
		initQueryPanel();
		initBooksPanel(this.bookSet);
	}
	
	private void initQueryPanel() {
		queryPanel = new JPanel();
		queryPanel.setBounds(31, 11, 857, 173);
		queryPanel.setLayout(null);
		
		JLabel lblTitle = new JLabel();
		lblTitle.setText("Sistema de B\u00FAsqueda de Libros");
		lblTitle.setBounds(148, 11, 487, 40);
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblTitle.setForeground(MainWindow.mainColor);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		queryPanel.add(lblTitle);

		add(queryPanel);
		
		title = new JTextField();
		title.setColumns(10);
		title.setBounds(275, 62, 227, 25);
		title.setForeground(MainWindow.strongGray);
		title.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		title.setBackground(MainWindow.whiteColor);
		title.setBorder(new MatteBorder(0, 0, 2, 0, MainWindow.lightGray));
		title.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldKeyReleased(evt);
            }
        });
		queryPanel.add(title);
		
		author = new JTextField();
		author.setColumns(10);
		author.setBounds(275, 98, 227, 25);
		author.setForeground(MainWindow.strongGray);
		author.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		author.setBackground(MainWindow.whiteColor);
		author.setBorder(new MatteBorder(0, 0, 2, 0, MainWindow.lightGray));
		queryPanel.add(author);
		
		year = new JTextField();
		year.setColumns(10);
		year.setBounds(275, 134, 227, 25);
		year.setForeground(MainWindow.strongGray);
		year.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		year.setBackground(MainWindow.whiteColor);
		year.setBorder(new MatteBorder(0, 0, 2, 0, MainWindow.lightGray));
		queryPanel.add(year);
		
		JLabel lblTtitle = new JLabel("Titulo del libro");
		lblTtitle.setBounds(158, 62, 118, 25);
		lblTtitle.setForeground(MainWindow.strongBlack);
		lblTtitle.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblTtitle.setHorizontalTextPosition(SwingConstants.RIGHT);
		queryPanel.add(lblTtitle);
		
		JLabel lblAuthor = new JLabel("Autor");
		lblAuthor.setBounds(158, 103, 107, 25);
		lblAuthor.setForeground(MainWindow.strongBlack);
		lblAuthor.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblAuthor.setHorizontalTextPosition(SwingConstants.RIGHT);
		queryPanel.add(lblAuthor);
		
		JLabel lblYear = new JLabel("A\u00F1o");
		lblYear.setBounds(158, 139, 107, 25);
		lblYear.setForeground(MainWindow.strongBlack);
		lblYear.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblYear.setHorizontalTextPosition(SwingConstants.RIGHT);
		queryPanel.add(lblYear);
	}
	private void initBooksPanel(ArrayList<Book> bookSet) {
		booksPanel = new BooksPanel(listener,bookSet);
		booksPanel.setBounds(31, 231, 855, 374);
		setLocation(286,1);
		
		JScrollPane scrollPane = new JScrollPane(booksPanel);
		scrollPane.setBounds(31, 231, 855, 374);
		add(scrollPane);
	}
	//Metodo para el filtro con eventos de teclado busqueda de libros por titulo
	private void textFieldKeyReleased(java.awt.event.KeyEvent evt) {
		update(this.title.getText());
    }
	private void update(String searchText) {
		ArrayList<Book> auxBookSet = this.searchBooks(bookSet,searchText );
		initBooksPanel(auxBookSet);
	}
	public ArrayList<Book> searchBooks(ArrayList<Book> bookSet, String searchText){
		ArrayList<Book> booksFound = new ArrayList<>();
		char[] textChars = searchText.toCharArray();
		if(textChars.length != 0) {
			for (int i = 0; i < bookSet.size(); i++) {
				String bookTitle = bookSet.get(i).getTitle();
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
	
}

package view;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;

public class SearchBookPanel extends JPanel {

	private JPanel queryPanel;
	private BooksPanel booksPanel;
	private JTextField title,author,year;
	public SearchBookPanel(ActionListener listener) {
		setSize(914,635);
		setBackground(WindowMain.colorWhite);
		setLayout(null);
		initQueryPanel(listener);
		initBooksPanel(listener);
	}
	
	public void initQueryPanel(ActionListener listener) {
		queryPanel = new JPanel();
		queryPanel.setBounds(31, 11, 857, 173);
		queryPanel.setLayout(null);
		
		JLabel lblTitle = new JLabel();
		lblTitle.setText("Sistema de B\u00FAsqueda de Libros");
		lblTitle.setBounds(148, 11, 487, 40);
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblTitle.setForeground(WindowMain.colorFirst);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		queryPanel.add(lblTitle);

		add(queryPanel);
		
		title = new JTextField();
		title.setColumns(10);
		title.setBounds(275, 62, 227, 25);
		title.setForeground(WindowMain.colorWhite);
		title.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		title.setBackground(WindowMain.colorSecond);
		title.setBorder(new MatteBorder(0, 0, 2, 0, WindowMain.colorLight));
		queryPanel.add(title);
		
		author = new JTextField();
		author.setColumns(10);
		author.setBounds(275, 98, 227, 25);
		author.setForeground(WindowMain.colorWhite);
		author.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		author.setBackground(WindowMain.colorSecond);
		author.setBorder(new MatteBorder(0, 0, 2, 0, WindowMain.colorLight));
		queryPanel.add(author);
		
		year = new JTextField();
		year.setColumns(10);
		year.setBounds(275, 134, 227, 25);
		year.setForeground(WindowMain.colorWhite);
		year.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		year.setBackground(WindowMain.colorSecond);
		year.setBorder(new MatteBorder(0, 0, 2, 0, WindowMain.colorLight));
		queryPanel.add(year);
		
		JLabel lblTtitle = new JLabel("Titulo del libro");
		lblTtitle.setBounds(158, 62, 118, 25);
		lblTtitle.setForeground(WindowMain.colorDark);
		lblTtitle.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblTtitle.setHorizontalTextPosition(SwingConstants.RIGHT);
		queryPanel.add(lblTtitle);
		
		JLabel lblAuthor = new JLabel("Autor");
		lblAuthor.setBounds(158, 103, 107, 25);
		lblAuthor.setForeground(WindowMain.colorDark);
		lblAuthor.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblAuthor.setHorizontalTextPosition(SwingConstants.RIGHT);
		queryPanel.add(lblAuthor);
		
		JLabel lblYear = new JLabel("A\u00F1o");
		lblYear.setBounds(158, 139, 107, 25);
		lblYear.setForeground(WindowMain.colorDark);
		lblYear.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblYear.setHorizontalTextPosition(SwingConstants.RIGHT);
		queryPanel.add(lblYear);
	}
	public void initBooksPanel(ActionListener listener) {
		booksPanel = new BooksPanel(listener);
		booksPanel.setBounds(31, 231, 855, 374);
		setLocation(286,1);
		
		JScrollPane scrollPane = new JScrollPane(booksPanel);
		scrollPane.setBounds(31, 231, 855, 374);
		add(scrollPane);
	}
}

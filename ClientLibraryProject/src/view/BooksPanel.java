package view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.Book;

public class BooksPanel extends JPanel {
	private ArrayList<Item> items;
	public BooksPanel(ActionListener listener,ArrayList<Book> bookSet) {
		setSize(855, 440);
		setBackground(MainWindow.whiteColor);
		items = new ArrayList<Item>();
		GridLayout layout = new GridLayout();//Layout tipo Grid con estructura de matriz
		layout.setColumns(3);
		layout.setHgap(13);//Establece la separacion entre columnas
		layout.setVgap(13);//Establece la separacion entre filas;
		filBooksPanel(layout,listener,bookSet);
		setLayout(layout);
	}

	private void filBooksPanel(GridLayout layout,ActionListener listener,ArrayList<Book> bookSet) {
		int count= 0; //Se encarga de controlar el numero de elementos por fila
		for(int i = 0;i<bookSet.size();i++) {//Numero de items a crear
			if(count == layout.getColumns()) {
				layout.setRows(layout.getRows()+1);
				count = 0;
			}
			Item item = new Item(bookSet.get(i).getBookID(),bookSet.get(i).getTitle(),bookSet.get(i).getAuthor(),bookSet.get(i).getDepartureYear(),"data/icons/iconUser.png",mouseClicked(listener));
			
			items.add(item);
			add(item);
			count++;
		}
	}
	private MouseAdapter mouseClicked(ActionListener listener) {
		return new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnMouseClicked(e,listener);
			}
		};
	}
	/**
	 * De acuerdo con el id del libro que este en el panel que genero el evento se  
	 * @param event
	 */
	private void btnMouseClicked(MouseEvent event,ActionListener listener) {
		JPanel item = (JPanel)event.getSource();
		//RentedBookDialog bookdialog = new RentedBookDialog(true, listener,item);
		//bookdialog.setVisible(true);
	}

}

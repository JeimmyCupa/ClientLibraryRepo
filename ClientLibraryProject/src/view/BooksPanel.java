package view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

public class BooksPanel extends JPanel {
	private ArrayList<Item> items;
	private ActionListener listener;
	public BooksPanel(ActionListener listener) {
		this.listener = listener;
		setSize(855, 440);
		setBackground(WindowMain.colorWhite);
		items = new ArrayList<Item>();
		GridLayout layout = new GridLayout();//Layout tipo Grid con estructura de matriz
		layout.setColumns(3);
		layout.setHgap(13);//Establece la separacion entre columnas
		layout.setVgap(13);//Establece la separacion entre filas;
		filBooksPanel(layout,listener);
		setLayout(layout);
	}

	private void filBooksPanel(GridLayout layout,ActionListener listener) {
		int count= 0; //Se encarga de controlar el numero de elementos por fila
		for(int i = 0;i<20;i++) {//Numero de items a crear
			if(count == layout.getColumns()) {
				layout.setRows(layout.getRows()+1);
				count = 0;
			}
			Item item = new Item(i+"A","Titulo"+i,"Autor"+i,"A�o"+i,"data/icons/iconUser.png",mouseClicked());
			//item.addMouseListener(null);
			items.add(item);
			add(item);
			count++;
		}
	}
	private MouseAdapter mouseClicked() {
		return new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnMouseClicked(e);
			}
		};
	}
	/**
	 * De acuerso con el id del libro que este en el panel que genero el evento se  
	 * @param event
	 */
	private void btnMouseClicked(MouseEvent event) {
		JPanel item = (JPanel)event.getSource();
		RentedBookDialog bookdialog = new RentedBookDialog(true, listener,item);
		bookdialog.setVisible(true);
	}

}
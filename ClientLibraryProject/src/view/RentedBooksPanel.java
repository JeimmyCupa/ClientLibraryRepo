package view;

import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;

public class RentedBooksPanel extends JPanel {
	private JTable table;

	public RentedBooksPanel(ActionListener listener) {
		setSize(914,635);
		setBackground(MainWindow.whiteColor);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(28, 11, 876, 158);
		add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(28, 188, 876, 299);
		add(panel_1);
		panel_1.setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(10, 11, 856, 277);
		panel_1.add(scrollBar);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Titulo", "Autor", "A\u00F1o", "Fecha prestamo", "Fecha devoloci\u00F3n"
			}
		));
		table.setBounds(10, 287, 856, -282);
		panel_1.add(table);
	}
}

package view;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Item extends JPanel {
	private JLabel frontPage,lblID,lblTitle,lblAuthor,lblYear;
	public Item(String id,String title,String author, String year, String image,ActionListener listener) {
		addMouseListener(this.mouseEntered());
		addMouseListener(this.mouseExited());
		lblID = new JLabel(id);
		setBackground(WindowMain.colorWhite);
		setBorder(new MatteBorder(1,1,1,1,WindowMain.colorGray));
		setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();//GridBagLayout constraints es la clase que define las restricciones para un componente de GridBagLayout.
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(5,5,5,5);//Establece el espacio entre componentes
	
		frontPage = new JLabel();
		frontPage.setIcon(new ImageIcon(image));
		//frontPage.setBorder(new MatteBorder(5,5,5,5));
		frontPage.setBackground(WindowMain.colorWhite);
		add(frontPage,c);//Se añade el elemento junto con la ubicacion establecida en el objeto GridBagConstraints 
		GridBagConstraints c1 = new GridBagConstraints();
		c1.gridx = 0;
		c1.gridy = 1;
		c1.insets = new Insets(5,5,5,5);
		
		lblTitle = new JLabel(title);
		lblTitle.setText(title);
		lblTitle.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblTitle.setForeground(WindowMain.colorFirst);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTitle,c1);
		
		GridBagConstraints c2 = new GridBagConstraints();
		c2.gridx = 0;
		c2.gridy = 2;
		c2.insets = new Insets(5,5,5,5);
		
		lblAuthor = new JLabel();
		lblAuthor.setText(author);
		lblAuthor.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblAuthor.setForeground(WindowMain.colorFirst);
		lblAuthor.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblAuthor,c2);
		
		GridBagConstraints c3 = new GridBagConstraints();
		c3.gridx = 0;
		c3.gridy = 3;
		c3.insets = new Insets(5,5,5,5);
		lblYear = new JLabel();
		lblYear.setText(year);
		lblYear.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblYear.setForeground(WindowMain.colorFirst);
		lblYear.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblYear,c3);
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
	//Metodos para manejar el efecto Hover
		private void btnMouseEntered(MouseEvent event) {
			setBackground(WindowMain.colorLight);
			setBorder(new MatteBorder(2,2,2,2,WindowMain.colorFirst));
		}
		private void btnMouseExited(MouseEvent event) {
			setBackground(WindowMain.colorWhite);
			setBorder(new MatteBorder(1,1,1,1,WindowMain.colorGray));
		}
	

}

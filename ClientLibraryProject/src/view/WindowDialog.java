package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.Book;

public class WindowDialog extends JDialog {
	private JPanel contentPanel;
	private JButton acceptBtn;
	
	public WindowDialog(boolean mode, JFrame frame, ActionListener actionListener, String message) {
		super(frame,mode);
		setSize(449,320);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		setBackground(Utilities.GRAY);
		initComponents(actionListener, message);
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
	}

	public void initComponents(ActionListener actionListener, String message) {
		getContentPane().setLayout(null);
		this.contentPanel= new JPanel();
		contentPanel.setBounds(0, 0, 462, 256);
		JLabel lblTitle = new JLabel();
		lblTitle.setText(message);
		lblTitle.setBounds(10, 82, 419, 31);
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblTitle.setForeground(MainWindow.MAINCOLOR);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblTitle);
		
		acceptBtn = new JButton("Aceptar");
		acceptBtn.setBounds(157, 170, 125, 39);
		acceptBtn.setAlignmentX(CENTER_ALIGNMENT);
		acceptBtn.setForeground(MainWindow.WHITECOLOR);
		acceptBtn.setBackground(MainWindow.MAINCOLOR);
		acceptBtn.addActionListener(actionListener);
		acceptBtn.addMouseListener(new  MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (e.getSource().equals(acceptBtn)) {
					JButton btn = (JButton) e.getSource();
					btn.setBackground(MainWindow.HOVERCOLOR);
					btn.setForeground(MainWindow.STRONGBLACK);
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(MainWindow.MAINCOLOR);
				if (e.getSource().equals(acceptBtn)) {
					JButton btn = (JButton) e.getSource();
					btn.setBackground(MainWindow.MAINCOLOR);
					btn.setForeground(MainWindow.WHITECOLOR);
				}
			}
		});
		acceptBtn.setActionCommand("ACCEPT_MESSAGE");
		acceptBtn.setAlignmentX(BOTTOM_ALIGNMENT);
		contentPanel.add(acceptBtn);
	}

	public static void main(String[] args) {
		try {
			JFrame test = new JFrame();
			WindowDialog dialog = new WindowDialog(true, test, new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
			}, MainWindow. SESSIONISACTIVE);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

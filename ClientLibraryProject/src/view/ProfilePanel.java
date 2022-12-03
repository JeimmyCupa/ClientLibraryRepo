package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;

public class ProfilePanel extends JPanel {
	private JLabel userName, userEmail, userAge, userID;
	
	public ProfilePanel(String strUserName, String strUserEmail, String strUserAge, String strUserID) {
		setBorder(new LineBorder(Color.BLACK));
		setSize(914,635);
		setBackground(MainWindow.WHITECOLOR);
		setLayout(null);
		initComponents(strUserName, strUserAge, strUserEmail, strUserID);
	}

	public void initComponents(String strUserName, String strUserAge, String strUserEmail, String strUserID) {
		JLabel title = new JLabel("Mi Perfil");
		title.setFont(new Font("SansSerif", Font.BOLD, 38));
		title.setForeground(MainWindow.MAINCOLOR);
		title.setBounds(362, 47, 159, 49);
		add(title);
		
		JLabel userNameLabel = new JLabel("Nombre");
		userNameLabel.setForeground(new Color(46, 55, 100));
		userNameLabel.setFont(new Font("SansSerif", Font.PLAIN, 32));
		userNameLabel.setBounds(159, 151, 159, 49);
		add(userNameLabel);
		
		JLabel userEmailLabel = new JLabel("Correo Electronico");
		userEmailLabel.setForeground(new Color(46, 55, 100));
		userEmailLabel.setFont(new Font("SansSerif", Font.PLAIN, 32));
		userEmailLabel.setBounds(537, 151, 399, 49);
		add(userEmailLabel);
		
		JLabel userAgeLabel = new JLabel("Edad");
		userAgeLabel.setForeground(new Color(46, 55, 100));
		userAgeLabel.setFont(new Font("SansSerif", Font.PLAIN, 32));
		userAgeLabel.setBounds(177, 349, 159, 49);
		add(userAgeLabel);
		
		JLabel userIDLabel = new JLabel("ID");
		userIDLabel.setForeground(new Color(46, 55, 100));
		userIDLabel.setFont(new Font("SansSerif", Font.PLAIN, 32));
		userIDLabel.setBounds(660, 349, 159, 49);
		add(userIDLabel);
		
		userName = new JLabel();
		userName.setText(strUserName);
		userName.setBorder(new MatteBorder(1, 1, 1, 1, MainWindow.MAINCOLOR));
		userName.setForeground(MainWindow.STRONGBLACK);
		userName.setHorizontalAlignment(JLabel.CENTER);
		userName.setFont(new Font("SansSerif", Font.ITALIC, 20));
		userName.setBackground(MainWindow.BEIGE);
		userName.setBounds(64, 236, 309, 34);
		userName.setOpaque(true);
		add(userName);
		
		userEmail = new JLabel();
		userEmail.setText(strUserEmail);
		userEmail.setOpaque(true);
		userEmail.setHorizontalAlignment(SwingConstants.CENTER);
		userEmail.setForeground(new Color(14, 29, 38));
		userEmail.setFont(new Font("SansSerif", Font.ITALIC, 20));
		userEmail.setBorder(new MatteBorder(1, 1, 1, 1, MainWindow.MAINCOLOR));
		userEmail.setBackground(new Color(242, 242, 199));
		userEmail.setBounds(527, 236, 309, 34);
		add(userEmail);
		
		userAge = new JLabel();
		userAge.setText(strUserAge);
		userAge.setOpaque(true);
		userAge.setHorizontalAlignment(SwingConstants.CENTER);
		userAge.setForeground(new Color(14, 29, 38));
		userAge.setFont(new Font("SansSerif", Font.ITALIC, 20));
		userAge.setBorder(new MatteBorder(1, 1, 1, 1, MainWindow.MAINCOLOR));
		userAge.setBackground(new Color(242, 242, 199));
		userAge.setBounds(64, 419, 309, 34);
		add(userAge);
		
		userID = new JLabel();
		userID.setText(strUserID);
		userID.setOpaque(true);
		userID.setHorizontalAlignment(SwingConstants.CENTER);
		userID.setForeground(new Color(14, 29, 38));
		userID.setFont(new Font("SansSerif", Font.ITALIC, 20));
		userID.setBorder(new MatteBorder(1, 1, 1, 1, MainWindow.MAINCOLOR));
		userID.setBackground(new Color(242, 242, 199));
		userID.setBounds(527, 419, 309, 34);
		add(userID);
	}
	
	public static void main(String[] args) {
		ProfilePanel profile = new ProfilePanel("Juan","juansito@gmail.com","18","2");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new JFrame();
					frame.setContentPane(profile);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setSize(914,635);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

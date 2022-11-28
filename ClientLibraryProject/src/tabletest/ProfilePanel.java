package tabletest;

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
	public final static Color mainColor = new Color(46,55,100);
	public final static Color whiteColor = new Color(235,236,240);//217,95,95
	public final static Color strongBlack = new Color(14,29,38);
	public final static Color strongGray = new Color(38,38,38);
	public final static Color gray = new Color(89,89,89);
	public final static Color lightGray = new Color(166,166,166);
	public final static Color beige = new Color(242,242,199);
	public final static Color hoverColor = new Color(74,87,120);
	public final static Color tableBackground = new Color(222,224,229);
	private JLabel userName, userEmail, userAge, userID;
	
	public ProfilePanel(String strUserName, String strUserEmail, String strUserAge, String strUserID) {
		setBorder(new LineBorder(Color.BLACK));
		setSize(914,635);
		setBackground(whiteColor);
		setLayout(null);
		initComponents(strUserName, strUserAge, strUserEmail, strUserID);
	}

	public void initComponents(String strUserName, String strUserAge, String strUserEmail, String strUserID) {
		JLabel title_1 = new JLabel("Mi Perfil");
		title_1.setFont(new Font("SansSerif", Font.BOLD, 38));
		title_1.setForeground(mainColor);
		title_1.setBounds(362, 47, 159, 49);
		add(title_1);
		
		JLabel title_1_1 = new JLabel("Nombre");
		title_1_1.setForeground(new Color(46, 55, 100));
		title_1_1.setFont(new Font("SansSerif", Font.PLAIN, 32));
		title_1_1.setBounds(159, 151, 159, 49);
		add(title_1_1);
		
		JLabel title_1_2 = new JLabel("Correo Electronico");
		title_1_2.setForeground(new Color(46, 55, 100));
		title_1_2.setFont(new Font("SansSerif", Font.PLAIN, 32));
		title_1_2.setBounds(537, 151, 399, 49);
		add(title_1_2);
		
		JLabel title_1_1_1 = new JLabel("Edad");
		title_1_1_1.setForeground(new Color(46, 55, 100));
		title_1_1_1.setFont(new Font("SansSerif", Font.PLAIN, 32));
		title_1_1_1.setBounds(177, 349, 159, 49);
		add(title_1_1_1);
		
		JLabel title_1_1_2 = new JLabel("ID");
		title_1_1_2.setForeground(new Color(46, 55, 100));
		title_1_1_2.setFont(new Font("SansSerif", Font.PLAIN, 32));
		title_1_1_2.setBounds(660, 349, 159, 49);
		add(title_1_1_2);
		
		userName = new JLabel();
		userName.setText(strUserName);
		userName.setBorder(new MatteBorder(1, 1, 1, 1, mainColor));
		userName.setForeground(strongBlack);
		userName.setHorizontalAlignment(JLabel.CENTER);
		userName.setFont(new Font("SansSerif", Font.ITALIC, 20));
		userName.setBackground(beige);
		userName.setBounds(64, 236, 309, 34);
		userName.setOpaque(true);
		add(userName);
		
		userEmail = new JLabel();
		userEmail.setText(strUserEmail);
		userEmail.setOpaque(true);
		userEmail.setHorizontalAlignment(SwingConstants.CENTER);
		userEmail.setForeground(new Color(14, 29, 38));
		userEmail.setFont(new Font("SansSerif", Font.ITALIC, 20));
		userEmail.setBorder(new MatteBorder(1, 1, 1, 1, mainColor));
		userEmail.setBackground(new Color(242, 242, 199));
		userEmail.setBounds(527, 236, 309, 34);
		add(userEmail);
		
		userAge = new JLabel();
		userAge.setText(strUserAge);
		userAge.setOpaque(true);
		userAge.setHorizontalAlignment(SwingConstants.CENTER);
		userAge.setForeground(new Color(14, 29, 38));
		userAge.setFont(new Font("SansSerif", Font.ITALIC, 20));
		userAge.setBorder(new MatteBorder(1, 1, 1, 1, mainColor));
		userAge.setBackground(new Color(242, 242, 199));
		userAge.setBounds(64, 419, 309, 34);
		add(userAge);
		
		userID = new JLabel();
		userID.setText(strUserID);
		userID.setOpaque(true);
		userID.setHorizontalAlignment(SwingConstants.CENTER);
		userID.setForeground(new Color(14, 29, 38));
		userID.setFont(new Font("SansSerif", Font.ITALIC, 20));
		userID.setBorder(new MatteBorder(1, 1, 1, 1, mainColor));
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

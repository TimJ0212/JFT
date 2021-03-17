package Frontend;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JTextField;

import Backend.functions;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.UIManager;

import org.json.simple.parser.ParseException;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

public class LoginScreen {

	private JFrame frmJft;
	private JTextField usernameInput;
	private JTextField pwBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen window = new LoginScreen();
					window.frmJft.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmJft = new JFrame();
		frmJft.setIconImage(Toolkit.getDefaultToolkit().getImage(LoginScreen.class.getResource("/images/JFTLogo.png")));
		frmJft.getContentPane().setBackground(new java.awt.Color(224, 229, 225));
		frmJft.setTitle("JFT");
		frmJft.setBounds(100, 100, 450, 300);
		frmJft.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJft.getContentPane().setLayout(null);

		JLabel welcomeBox = new JLabel("Wilkommen bei JFT-Taxi");
		welcomeBox.setBounds(220, 22, 155, 16);
		frmJft.getContentPane().add(welcomeBox);

		JLabel usernameLable = new JLabel("Username");
		usernameLable.setBounds(176, 86, 62, 16);
		frmJft.getContentPane().add(usernameLable);

		usernameInput = new JTextField();
		usernameInput.setBounds(250, 81, 194, 26);
		frmJft.getContentPane().add(usernameInput);
		usernameInput.setColumns(10);

		JLabel usernamePasswort = new JLabel("Passwort");
		usernamePasswort.setBounds(186, 114, 56, 16);
		frmJft.getContentPane().add(usernamePasswort);

		pwBox = new JPasswordField();
		pwBox.setBounds(250, 112, 194, 26);
		frmJft.getContentPane().add(pwBox);
		pwBox.setColumns(10);

		JButton loginButton = new JButton("Login");
		loginButton.setBounds(305, 161, 85, 34);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameInput.getText();
				String password = pwBox.getText(); //NEW: Encryption
				System.out.println(username + " " + password);

				try {
					if (functions.login(username, password)) {
						Frontend.Menue.main(null);
						frmJft.dispose();
					} else {
						System.out.println("Falscher Nutzername oder falsches Password");
					}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		frmJft.getContentPane().add(loginButton);

		JButton debugButton = new JButton("Debug");
		debugButton.setBounds(359, 218, 85, 48);
		debugButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					functions.addCityToDB(functions.fetchJSON("resources/cities.json"));
				} catch (IOException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//frmJft.dispose();
			}
		});
		frmJft.getContentPane().add(debugButton);

		JButton registerButton = new JButton("Register");
		registerButton.setBounds(241, 218, 85, 48);
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frontend.registryWindow.main(null);
				frmJft.dispose();
			}
		});
		frmJft.getContentPane().add(registerButton);

		JPanel neueInfoPanel = new JPanel();
		neueInfoPanel.setBackground(UIManager.getColor("Button.disabledText"));
		neueInfoPanel.setBounds(0, 0, 163, 260);
		frmJft.getContentPane().add(neueInfoPanel);
		neueInfoPanel.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Was gibt es neues ?");
		lblNewLabel_3.setBounds(6, 6, 151, 16);
		neueInfoPanel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("V.1.3:");
		lblNewLabel_4.setBounds(6, 34, 61, 16);
		neueInfoPanel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Window Redesign");
		lblNewLabel_5.setForeground(UIManager.getColor("Button.highlight"));
		lblNewLabel_5.setBounds(6, 51, 151, 36);
		neueInfoPanel.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("V.1.2");
		lblNewLabel_6.setBounds(6, 99, 61, 16);
		neueInfoPanel.add(lblNewLabel_6);

		JLabel lblNewLabel_5_1 = new JLabel("Registrierung");
		lblNewLabel_5_1.setForeground(Color.WHITE);
		lblNewLabel_5_1.setBounds(6, 120, 151, 36);
		neueInfoPanel.add(lblNewLabel_5_1);
		
		JLabel welcomeLogo = new JLabel("");
		welcomeLogo.setHorizontalAlignment(SwingConstants.RIGHT);
		welcomeLogo.setBounds(359, 1, 75, 59);
		frmJft.getContentPane().add(welcomeLogo);
		Image image = new ImageIcon(this.getClass().getResource("/images/JFTLogo.png")).getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
		welcomeLogo.setIcon(new ImageIcon(image));
	}
}

package Frontend;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Backend.Hauptklasse;
import Backend.User;
import Backend.Database.DBCOutputResultSet;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class registryWindow {

	private JFrame frame;
	@SuppressWarnings("exports")
	public static JTextField usernameBox;
	private JTextField emBox;
	private JTextField pwBox;
	private JTextField nameBox;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registryWindow window = new registryWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public registryWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 657, 398);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton backButton = new JButton("...");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Frontend.LoginScreen.main(null);
			}
		});
		backButton.setBounds(603, 6, 48, 23);
		frame.getContentPane().add(backButton);
		usernameBox = new JTextField();
		usernameBox.setBounds(403, 28, 199, 42);
		frame.getContentPane().add(usernameBox);
		usernameBox.setColumns(10);

		emBox = new JTextField();
		emBox.setBounds(403, 92, 199, 42);
		frame.getContentPane().add(emBox);
		emBox.setColumns(10);

		JRadioButton FahrerButton = new JRadioButton("Fahrer");
		FahrerButton.setBounds(555, 307, 76, 23);
		frame.getContentPane().add(FahrerButton);
		buttonGroup.add(FahrerButton);

		JRadioButton FahrgastButton = new JRadioButton("Fahrgast", true);
		JLabel UsernameText = new JLabel("Username");
		UsernameText.setHorizontalAlignment(SwingConstants.LEFT);
		UsernameText.setBounds(403, 9, 92, 14);
		frame.getContentPane().add(UsernameText);

		JLabel EmailText = new JLabel("E-Mail");
		EmailText.setHorizontalAlignment(SwingConstants.LEFT);
		EmailText.setBounds(403, 82, 92, 14);
		frame.getContentPane().add(EmailText);

		JButton RegButton = new JButton("Registrieren");
		RegButton.setToolTipText("Registriere dich jetzt");
		RegButton.setBackground(UIManager.getColor("Button.select"));
		RegButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user = new User(usernameBox.getText(), nameBox.getText(), emBox.getText(), pwBox.getText()); // New:
																													// Encrypt
				try {
					Hauptklasse.loggedUser = user;
					DBCOutputResultSet.registerUserToDB(user, FahrerButton.isSelected());
					Frontend.LoginScreen.main(null);
					frame.dispose();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		RegButton.setBounds(403, 307, 119, 42);
		frame.getContentPane().add(RegButton);

		pwBox = new JPasswordField();
		pwBox.setBounds(403, 172, 199, 42);
		frame.getContentPane().add(pwBox);
		pwBox.setColumns(10);

		nameBox = new JTextField();
		nameBox.setBounds(403, 252, 199, 42);
		frame.getContentPane().add(nameBox);
		nameBox.setColumns(10);

		JLabel PasswordText = new JLabel("Password");
		PasswordText.setHorizontalAlignment(SwingConstants.LEFT);
		PasswordText.setBounds(403, 158, 92, 14);
		frame.getContentPane().add(PasswordText);

		JLabel Username = new JLabel("Name");
		Username.setHorizontalAlignment(SwingConstants.LEFT);
		Username.setBounds(403, 239, 92, 14);
		frame.getContentPane().add(Username);

		JPanel BildPanel = new JPanel();
		BildPanel.setBackground(Color.GRAY);
		BildPanel.setBounds(6, 6, 385, 358);
		frame.getContentPane().add(BildPanel);
		BildPanel.setLayout(null);

		JLabel TaxiBild = new JLabel("New label");
		TaxiBild.setHorizontalAlignment(SwingConstants.CENTER);
		TaxiBild.setIcon(new ImageIcon(registryWindow.class.getResource("/images/TaxiBild.jpg")));
		TaxiBild.setBounds(6, 6, 373, 346);
		BildPanel.add(TaxiBild);

		FahrgastButton.setBounds(555, 328, 86, 23);
		frame.getContentPane().add(FahrgastButton);

		buttonGroup.add(FahrgastButton);
	}
}

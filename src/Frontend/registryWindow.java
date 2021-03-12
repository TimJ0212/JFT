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
	private JTextField usernameBox;
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

		JButton btnNewButton = new JButton("...");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Frontend.LoginScreen.main(null);
			}
		});
		btnNewButton.setBounds(603, 6, 48, 23);
		frame.getContentPane().add(btnNewButton);
		usernameBox = new JTextField();
		usernameBox.setBounds(403, 28, 199, 42);
		frame.getContentPane().add(usernameBox);
		usernameBox.setColumns(10);

		emBox = new JTextField();
		emBox.setBounds(403, 92, 199, 42);
		frame.getContentPane().add(emBox);
		emBox.setColumns(10);


		JRadioButton FahrgastButton = new JRadioButton("Fahrgast");
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(403, 9, 92, 14);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("E-Mail");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(403, 82, 92, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JButton btnNewButton_1 = new JButton("Registrieren");
		btnNewButton_1.setBackground(UIManager.getColor("Button.select"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user = new User(usernameBox.getText(), nameBox.getText(), emBox.getText(), pwBox.getText());
				try {
					Hauptklasse.loggedUser = user;
					DBCOutputResultSet.registerUserToDB(user, buttonGroup.getSelection().equals(FahrgastButton));
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(403, 307, 119, 42);
		frame.getContentPane().add(btnNewButton_1);

		pwBox = new JPasswordField();
		pwBox.setBounds(403, 172, 199, 42);
		frame.getContentPane().add(pwBox);
		pwBox.setColumns(10);

		nameBox = new JTextField();
		nameBox.setBounds(403, 252, 199, 42);
		frame.getContentPane().add(nameBox);
		nameBox.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBounds(403, 158, 92, 14);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Name");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setBounds(403, 239, 92, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(6, 6, 385, 358);
		frame.getContentPane().add(panel);
				panel.setLayout(null);
				
				JLabel lblNewLabel_4 = new JLabel("New label");
				lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_4.setIcon(new ImageIcon(registryWindow.class.getResource("/images/TaxiBild.jpg")));
				lblNewLabel_4.setBounds(6, 6, 373, 346);
				panel.add(lblNewLabel_4);
								
										JRadioButton FahrerButton = new JRadioButton("Fahrer");
										FahrerButton.setBounds(555, 307, 76, 23);
										frame.getContentPane().add(FahrerButton);
										buttonGroup.add(FahrerButton);
										
												FahrgastButton.setBounds(555, 328, 86, 23);
												frame.getContentPane().add(FahrgastButton);
												
														
														buttonGroup.add(FahrgastButton);
	}
}

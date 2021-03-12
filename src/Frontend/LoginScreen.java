package Frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import Backend.functions;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.Color;

public class LoginScreen {

	private JFrame frmJft;
	private JTextField textField;
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
		frmJft.getContentPane().setBackground(new java.awt.Color(224, 229, 225));
		frmJft.setTitle("JFT");
		frmJft.setBounds(100, 100, 450, 300);
		frmJft.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJft.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Wilkommen bei JFT-Taxi");
		lblNewLabel.setBounds(250, 6, 155, 16);
		frmJft.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(176, 86, 62, 16);
		frmJft.getContentPane().add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(250, 81, 194, 26);
		frmJft.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Passwort");
		lblNewLabel_2.setBounds(186, 114, 56, 16);
		frmJft.getContentPane().add(lblNewLabel_2);

		pwBox = new JPasswordField();
		pwBox.setBounds(250, 112, 194, 26);
		frmJft.getContentPane().add(pwBox);
		pwBox.setColumns(10);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(305, 161, 85, 34);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
				String password = pwBox.getText();
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
		frmJft.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Debug");
		btnNewButton_1.setBounds(359, 218, 85, 48);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frontend.Menue.main(null);
				frmJft.dispose();
			}
		});
		frmJft.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Register");
		btnNewButton_2.setBounds(241, 218, 85, 48);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frontend.registryWindow.main(null);
				frmJft.dispose();
			}
		});
		frmJft.getContentPane().add(btnNewButton_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.disabledText"));
		panel.setBounds(6, 6, 163, 260);
		frmJft.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Was gibt es neues ?");
		lblNewLabel_3.setBounds(6, 6, 151, 16);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("V.1.3:");
		lblNewLabel_4.setBounds(6, 34, 61, 16);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Window Redesign");
		lblNewLabel_5.setForeground(UIManager.getColor("Button.highlight"));
		lblNewLabel_5.setBounds(6, 51, 151, 36);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("V.1.2");
		lblNewLabel_6.setBounds(6, 99, 61, 16);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_5_1 = new JLabel("Registrierung");
		lblNewLabel_5_1.setForeground(Color.WHITE);
		lblNewLabel_5_1.setBounds(6, 120, 151, 36);
		panel.add(lblNewLabel_5_1);
	}

}

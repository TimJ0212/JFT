package Frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import Backend.functions;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginScreen {

	private JFrame frmJft;
	private JTextField textField;
	private JTextField textField_1;

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
		lblNewLabel.setBounds(116, 0, 155, 16);
		frmJft.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(58, 86, 62, 16);
		frmJft.getContentPane().add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(132, 81, 194, 26);
		frmJft.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Passwort");
		lblNewLabel_2.setBounds(64, 117, 56, 16);
		frmJft.getContentPane().add(lblNewLabel_2);

		textField_1 = new JTextField();
		textField_1.setBounds(132, 112, 194, 26);
		frmJft.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(186, 150, 85, 34);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
				String password = textField_1.getText();
				System.out.println(username + " " + password);

				if (functions.login(username, password)) {
					Frontend.Menue.main(null);
					frmJft.dispose();
				} else {
					System.out.println("Falscher Nutzername oder falsches Password");
					// TODO: pw feld im Fenster leeren und eingabe visuell mit "*" ersetzen
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
	}

}

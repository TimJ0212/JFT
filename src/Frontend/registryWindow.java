package Frontend;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Backend.User;
import Backend.Database.DBCOutputResultSet;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("...");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Frontend.Menue.main(null);
			}
		});
		btnNewButton.setBounds(376, 11, 48, 23);
		frame.getContentPane().add(btnNewButton);

		usernameBox = new JTextField();
		usernameBox.setBounds(112, 33, 150, 20);
		frame.getContentPane().add(usernameBox);
		usernameBox.setColumns(10);

		emBox = new JTextField();
		emBox.setBounds(112, 64, 150, 20);
		frame.getContentPane().add(emBox);
		emBox.setColumns(10);

		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 36, 92, 14);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("E-Mail");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(10, 67, 92, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JButton btnNewButton_1 = new JButton("Registrieren");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user = new User(usernameBox.getText(), nameBox.getText(), emBox.getText(), pwBox.getText());
				try {
					DBCOutputResultSet.registerUserToDB(user);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(112, 157, 105, 23);
		frame.getContentPane().add(btnNewButton_1);

		pwBox = new JTextField();
		pwBox.setBounds(112, 95, 150, 20);
		frame.getContentPane().add(pwBox);
		pwBox.setColumns(10);

		nameBox = new JTextField();
		nameBox.setBounds(112, 126, 150, 20);
		frame.getContentPane().add(nameBox);
		nameBox.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(10, 98, 92, 14);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Name");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(10, 129, 92, 14);
		frame.getContentPane().add(lblNewLabel_3);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Fahrer");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(290, 63, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Fahrgast");
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(290, 94, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
	}
}

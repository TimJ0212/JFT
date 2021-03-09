package Frontend;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Backend.Database.DBCOutputStringArray;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class TaxiBereitstellScreen {

	private JFrame frmDuMchtestDein;
	private JTextField timeField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaxiBereitstellScreen window = new TaxiBereitstellScreen();
					window.frmDuMchtestDein.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TaxiBereitstellScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDuMchtestDein = new JFrame();
		frmDuMchtestDein.setTitle("Du möchtest dein Taxi bereistellen?");
		frmDuMchtestDein.setBounds(100, 100, 450, 300);
		frmDuMchtestDein.getContentPane().setBackground(new java.awt.Color(224, 229, 225));
		frmDuMchtestDein.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDuMchtestDein.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Welchen Ort:");
		lblNewLabel.setBounds(16, 6, 206, 16);
		frmDuMchtestDein.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("Wie viele Personen?");
		lblNewLabel_2.setBounds(306, 64, 121, 16);
		frmDuMchtestDein.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("Wann hast du Zeit? (hh:mm-hh:mm)");
		lblNewLabel_1.setBounds(16, 64, 245, 16);
		frmDuMchtestDein.getContentPane().add(lblNewLabel_1);

		timeField = new JTextField();
		timeField.setBounds(16, 92, 234, 26);
		frmDuMchtestDein.getContentPane().add(timeField);
		timeField.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel(" €");

		JButton btnNewButton = new JButton("Verdienst berechnen");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_3.setText(Backend.functions.calculateMoney(textField.getText())
						+ "€ würdest du verdienen");
			}
		});
		btnNewButton.setBounds(6, 174, 192, 29);
		frmDuMchtestDein.getContentPane().add(btnNewButton);

		JComboBox<String> comboBox = new JComboBox<String>();

		JButton btnNewButton_1 = new JButton("Los geht's");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] data = { comboBox.getSelectedItem().toString(), timeField.getText(),
						textField.getText() };
				DBCOutputStringArray.connect(data, false);
			}
		});
		btnNewButton_1.setBounds(306, 202, 108, 29);
		frmDuMchtestDein.getContentPane().add(btnNewButton_1);

		lblNewLabel_3.setBounds(16, 215, 182, 16);
		frmDuMchtestDein.getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(306, 92, 130, 26);
		frmDuMchtestDein.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frontend.Menue.main(null);
				frmDuMchtestDein.dispose();
			}
		});
		btnNewButton_2.setBounds(393, 23, 43, 29);
		frmDuMchtestDein.getContentPane().add(btnNewButton_2);
		
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Hauptbahnhof", "Schule", "Leine-Center"}));
		comboBox.setBounds(16, 25, 234, 27);
		frmDuMchtestDein.getContentPane().add(comboBox);
	}
}

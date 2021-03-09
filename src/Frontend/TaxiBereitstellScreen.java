package Frontend;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Backend.Database.DBCOutStAr;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class TaxiBereitstellScreen {

	private JFrame frmDuMchtestDein;
	private JTextField placeField;
	private JTextField timeFIeld;
	private final ButtonGroup buttonGroup = new ButtonGroup();

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
		lblNewLabel_2.setBounds(309, 6, 121, 16);
		frmDuMchtestDein.getContentPane().add(lblNewLabel_2);

		placeField = new JTextField();
		placeField.setBounds(16, 26, 234, 26);
		frmDuMchtestDein.getContentPane().add(placeField);
		placeField.setColumns(10);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("1");
		rdbtnNewRadioButton.setActionCommand("1");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(390, 27, 40, 23);
		frmDuMchtestDein.getContentPane().add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("3");
		rdbtnNewRadioButton_1.setActionCommand("3");
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(390, 48, 40, 23);
		frmDuMchtestDein.getContentPane().add(rdbtnNewRadioButton_1);

		JLabel lblNewLabel_1 = new JLabel("Wann hast du Zeit? (hh:mm-hh:mm)");
		lblNewLabel_1.setBounds(16, 64, 245, 16);
		frmDuMchtestDein.getContentPane().add(lblNewLabel_1);

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("5");
		rdbtnNewRadioButton_2.setActionCommand("5");
		buttonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setBounds(390, 72, 40, 23);
		frmDuMchtestDein.getContentPane().add(rdbtnNewRadioButton_2);

		timeFIeld = new JTextField();
		timeFIeld.setBounds(16, 92, 234, 26);
		frmDuMchtestDein.getContentPane().add(timeFIeld);
		timeFIeld.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel(" €");

		JButton btnNewButton = new JButton("Verdienst berechnen");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_3.setText(Backend.Hauptklasse.calculateMoney(buttonGroup.getSelection().getActionCommand())
						+ "€ würdest du verdienen");
			}
		});
		btnNewButton.setBounds(6, 174, 192, 29);
		frmDuMchtestDein.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Los geht's");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] data = { placeField.getText(), timeFIeld.getText(),
						buttonGroup.getSelection().getActionCommand() };
				DBCOutStAr.connect(data, false);
			}
		});
		btnNewButton_1.setBounds(306, 202, 108, 29);
		frmDuMchtestDein.getContentPane().add(btnNewButton_1);

		lblNewLabel_3.setBounds(16, 215, 182, 16);
		frmDuMchtestDein.getContentPane().add(lblNewLabel_3);
	}
}

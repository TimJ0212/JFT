package Frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JButton;

public class TaxiBestellScreen {

	private JFrame frmTaxiBestellen;
	private JTextField txtOrt;
	private JTextField textField_1;
	private JButton btnNewButton;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaxiBestellScreen window = new TaxiBestellScreen();
					window.frmTaxiBestellen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TaxiBestellScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTaxiBestellen = new JFrame();
		frmTaxiBestellen.setTitle("Taxi bestellen");
		frmTaxiBestellen.setBounds(100, 100, 450, 300);
		frmTaxiBestellen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 50, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmTaxiBestellen.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Ort der Abholung:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		frmTaxiBestellen.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		txtOrt = new JTextField();
		lblNewLabel.setLabelFor(txtOrt);
		GridBagConstraints gbc_txtOrt = new GridBagConstraints();
		gbc_txtOrt.insets = new Insets(0, 0, 5, 0);
		gbc_txtOrt.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtOrt.gridx = 1;
		gbc_txtOrt.gridy = 2;
		frmTaxiBestellen.getContentPane().add(txtOrt, gbc_txtOrt);
		txtOrt .setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Zeit der Abholung:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 4;
		frmTaxiBestellen.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 5;
		frmTaxiBestellen.getContentPane().add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		btnNewButton = new JButton("Suche");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 7;
		frmTaxiBestellen.getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		lblNewLabel_2 = new JLabel("Hier erscheint dein Ergebnis");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 9;
		frmTaxiBestellen.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		btnNewButton_1 = ine javanew JButton("Fahrt nehmen");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 9;
		frmTaxiBestellen.getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
	}

}

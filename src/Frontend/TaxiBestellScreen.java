package Frontend;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

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
		frmTaxiBestellen.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ort der Abholung:");
		lblNewLabel.setBounds(6, 10, 113, 16);
		frmTaxiBestellen.getContentPane().add(lblNewLabel);
		
		txtOrt = new JTextField();
		txtOrt.setBounds(131, 5, 130, 26);
		lblNewLabel.setLabelFor(txtOrt);
		frmTaxiBestellen.getContentPane().add(txtOrt);
		txtOrt .setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Zeit der Abholung:");
		lblNewLabel_1.setBounds(6, 38, 117, 16);
		frmTaxiBestellen.getContentPane().add(lblNewLabel_1);
		
		btnNewButton = new JButton("Suche");
		btnNewButton.setBounds(149, 83, 81, 29);
		frmTaxiBestellen.getContentPane().add(btnNewButton);
		
		lblNewLabel_2 = new JLabel("Hier erscheint dein Ergebnis");
		lblNewLabel_2.setBounds(113, 179, 177, 16);
		frmTaxiBestellen.getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(131, 33, 130, 26);
		frmTaxiBestellen.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		btnNewButton_1 = new JButton("Fahrt nehmen");
		btnNewButton_1.setBounds(302, 174, 130, 29);
		frmTaxiBestellen.getContentPane().add(btnNewButton_1);
	}

}

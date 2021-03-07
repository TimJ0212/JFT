package Frontend;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Backend.Database.DataBaseConnector;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class TaxiBestellScreen {

	@SuppressWarnings("exports")
	public static JFrame frmTaxiBestellen;
	private JTextField txtOrt;
	private JTextField txtZeit;
	private JButton searchButton;
	private JButton btnNewButton_1;
	private JScrollPane scrollPane;
	private javax.swing.JTable jt1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("unused")
			public void run() {
				try {
					TaxiBestellScreen window = new TaxiBestellScreen();
					TaxiBestellScreen.frmTaxiBestellen.setVisible(true);
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

		String[] column= {"FahrerID","Name","PersonenAnzahl","Bewertung","Preis"};
		searchButton = new JButton("Suche");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] newArgs = {txtOrt.getSelectedText(), txtZeit.getText()};
				jt1 = new javax.swing.JTable(DataBaseConnector.connect(newArgs, true),column);
				scrollPane.setViewportView(jt1);
			}
		});
		searchButton.setBounds(149, 83, 81, 29);
		frmTaxiBestellen.getContentPane().add(searchButton);
		
		txtZeit = new JTextField();
		txtZeit.setBounds(131, 33, 130, 26);
		frmTaxiBestellen.getContentPane().add(txtZeit);
		txtZeit.setColumns(10);
		
		btnNewButton_1 = new JButton("Fahrt nehmen");
		btnNewButton_1.setBounds(302, 174, 130, 29);
		frmTaxiBestellen.getContentPane().add(btnNewButton_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 124, 272, 136);
		frmTaxiBestellen.getContentPane().add(scrollPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 124, 272, 136);
		frmTaxiBestellen.getContentPane().add(scrollPane);
			
		scrollPane.setViewportView(jt1);
	}
}

package Frontend;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Backend.Database.DBCOutputStringArray;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

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
		frmDuMchtestDein.setIconImage(Toolkit.getDefaultToolkit().getImage(TaxiBereitstellScreen.class.getResource("/images/JFTLogo.png")));
		frmDuMchtestDein.setTitle("Du möchtest dein Taxi bereitstellen?");
		frmDuMchtestDein.setBounds(100, 100, 450, 300);
		frmDuMchtestDein.getContentPane().setBackground(new java.awt.Color(224, 229, 225));
		frmDuMchtestDein.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDuMchtestDein.getContentPane().setLayout(null);

		JLabel welcherOrtLabel = new JLabel("Welchen Ort:");
		welcherOrtLabel.setBounds(16, 6, 206, 16);
		frmDuMchtestDein.getContentPane().add(welcherOrtLabel);

		JLabel wieVielePersonenLabel = new JLabel("Wie viele Personen?");
		wieVielePersonenLabel.setBounds(16, 118, 121, 16);
		frmDuMchtestDein.getContentPane().add(wieVielePersonenLabel);

		JLabel wannZeitLabel = new JLabel("Wann hast du Zeit? (hh:mm-hh:mm)");
		wannZeitLabel.setBounds(16, 64, 245, 16);
		frmDuMchtestDein.getContentPane().add(wannZeitLabel);
		
		JLabel verdienstLabel = new JLabel("");
		verdienstLabel.setBounds(16, 204, 234, 26);
		frmDuMchtestDein.getContentPane().add(verdienstLabel);

		timeField = new JTextField();
		timeField.setBounds(16, 81, 234, 26);
		frmDuMchtestDein.getContentPane().add(timeField);
		timeField.setColumns(10);

		JButton berechnenButton = new JButton("Verdienst berechnen");
		berechnenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String[] sta = {};
				try {
					sta = Frontend.map.getCoords(Frontend.map.getStart());
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				String[] des = {};
				try {
					des = Frontend.map.getCoords(Frontend.map.getDestination());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				double[] dSta = {Double.parseDouble(sta[0]),Double.parseDouble(sta[1])};
				double[] dDes = {Double.parseDouble(des[0]),Double.parseDouble(des[1])};
				
				verdienstLabel.setText(Backend.functions.calculateMoney(textField.getText(),dDes[0], dDes[1],dSta[0],dSta[1])
						+ "€ würdest du verdienen");
			}
		});
		berechnenButton.setBounds(16, 174, 192, 29);
		frmDuMchtestDein.getContentPane().add(berechnenButton);

		JComboBox<String> comboBox = new JComboBox<String>();

		JButton goButton = new JButton("Los geht's");
		goButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] data = { comboBox.getSelectedItem().toString(), timeField.getText(),
						textField.getText() };
				DBCOutputStringArray.connect(data, false);
			}
		});
		
		Frontend.map.setDestination("Hannover"); //NEED TXT-Box with destination and start city
		Frontend.map.setStart("Laatzen");
		
		
		goButton.setBounds(324, 205, 100, 30);
		frmDuMchtestDein.getContentPane().add(goButton);
		
		textField = new JTextField();
		textField.setBounds(16, 137, 234, 26);
		frmDuMchtestDein.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton backButton = new JButton("Zur\u00FCck");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frontend.Menue.main(null);
				frmDuMchtestDein.dispose();
			}
		});
		backButton.setBounds(225, 205, 100, 30);
		frmDuMchtestDein.getContentPane().add(backButton);
		
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Hauptbahnhof", "Schule", "Leine-Center"}));
		comboBox.setBounds(16, 25, 234, 27);
		frmDuMchtestDein.getContentPane().add(comboBox);
		
		JLabel bestellenTaxiLogo = new JLabel("New label");
		Image image = new ImageIcon(this.getClass().getResource("/images/JFTLogo.png")).getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT);
		bestellenTaxiLogo.setIcon(new ImageIcon(image));
		bestellenTaxiLogo.setBounds(265, 6, 160, 160);
		frmDuMchtestDein.getContentPane().add(bestellenTaxiLogo);
		

	}
}

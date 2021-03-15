package Frontend;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Backend.Hauptklasse;
import javax.swing.SwingConstants;
import javax.swing.JPanel;

public class Menue {

	private JFrame frmMen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menue window = new Menue();
					window.frmMen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menue() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMen = new JFrame();
		frmMen.setTitle("Menü");
		frmMen.getContentPane().setBackground(new java.awt.Color(224, 229, 225));
		frmMen.setBackground(new Color(250, 235, 215));
		frmMen.setBounds(100, 100, 450, 300);
		frmMen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMen.getContentPane().setLayout(null);

		String welcomeMessage = Hauptklasse.loggedUser.getUsername() == null
				? "Wilkommen bei JFT-Taxi unbekannter Nutzer"
				: "Wilkommen bei JFT-Taxi " + Hauptklasse.loggedUser.getUsername();

		JButton btnNewButton_2 = new JButton("Logout");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frontend.LoginScreen.main(null);
				frmMen.dispose();
			}
		});
		btnNewButton_2.setBounds(277, 6, 117, 29);
		frmMen.getContentPane().add(btnNewButton_2);

		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(6, 6, 261, 260);
		frmMen.getContentPane().add(panel);
		panel.setLayout(null);
		JLabel lblNewLabel = new JLabel(welcomeMessage);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(6, 6, 249, 53);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("<html><body>Du kannst unseren Nutzern dein<br>Taxi in Echtzeit zur Verfügung stellen</body></html>");
		lblNewLabel_1.setBounds(10, 71, 234, 53);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("<html><body>Oder du buchst eine Fahrt bei einem unserer Fahrer</body></html>");
		lblNewLabel_1_1.setBounds(10, 149, 234, 53);
		panel.add(lblNewLabel_1_1);
		
				JButton btnNewButton = new JButton("Taxi bestellen");
				btnNewButton.setBounds(279, 152, 150, 73);
				frmMen.getContentPane().add(btnNewButton);
				
						JButton btnNewButton_1 = new JButton("Taxi bereitstellen");
						btnNewButton_1.setBounds(279, 66, 150, 74);
						frmMen.getContentPane().add(btnNewButton_1);
						btnNewButton_1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								frmMen.dispose();
								Frontend.TaxiBereitstellScreen.main(null);
							}
						});
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frmMen.dispose();
						Frontend.TaxiBestellScreen.main(null);
					}
				});
	}
}

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
		JLabel lblNewLabel = new JLabel(welcomeMessage);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		lblNewLabel.setBounds(40, 19, 353, 16);
		frmMen.getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("Taxi bestellen");
		btnNewButton.setBounds(230, 108, 163, 54);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frontend.TaxiBestellScreen.main(null);
				frmMen.dispose();
			}
		});
		frmMen.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Taxi bereitstellen");
		btnNewButton_1.setBounds(40, 108, 163, 54);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frontend.TaxiBereitstellScreen.main(null);
				frmMen.dispose();
			}
		});
		frmMen.getContentPane().add(btnNewButton_1);
	}

}

package Frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Window.Type;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

public class popup {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void test(boolean succes) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					popup window = new popup(succes);
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
	public popup(boolean succes) {
		initialize(succes);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(boolean succes) {
		frame = new JFrame();
		frame.setType(Type.POPUP);
		frame.setAlwaysOnTop(true);
		frame.setBounds(100, 100, 199, 95);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel statusBox = new JLabel("Status");
		
		if (succes) {
			statusBox.setText("Erfolgreich");
			statusBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
			statusBox.setForeground(SystemColor.desktop);
		} else {
			statusBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
			statusBox.setForeground(new Color(128, 0, 0));
			statusBox.setText("Nicht erfolgreich");
		}
		statusBox.setHorizontalAlignment(SwingConstants.CENTER);
		statusBox.setBounds(10, 11, 163, 35);
		frame.getContentPane().add(statusBox);
	}
}

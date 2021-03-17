package Frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

public class popup {

	private static JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void test(boolean succes) {
		Timer timer = new Timer(2000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.dispose();
            }
        });
        timer.setRepeats(false);
        timer.start();
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
			statusBox.setText("Benutzername schon vorhanden");
		}
		statusBox.setHorizontalAlignment(SwingConstants.CENTER);
		statusBox.setBounds(10, 11, 163, 35);
		frame.getContentPane().add(statusBox);
	}
}

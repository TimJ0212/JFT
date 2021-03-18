package Frontend;

import java.awt.EventQueue;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class map{
	
	private static JFrame frame;
	public static void main(String[]args) {
		
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("unused")
			public void run() {
				try {
					map window = new map();
					map.frame.setVisible(true);
				}catch(Exception e) {
					
				}
			}
		});
		
	}
	
	public map() {
		initialize();
	}
	
	private static void initialize() {
		JEditorPane jep = new JEditorPane();
		jep.setEditable(false);
		
		jep.setContentType("text/html");
		
		JScrollPane scrollPane = new JScrollPane(jep); 
		frame = new JFrame();
		frame.add(scrollPane);
		frame.setTitle("Map");
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
	}
}
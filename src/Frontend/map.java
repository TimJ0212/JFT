package Frontend;

import javax.swing.JFrame;

public class map{
	
	private JFrame frame;
	public static void main(String[]args) {
		
		
	}
	
	public map() {}
	
	private void initialize() {
		
		frame = new JFrame();
		frame.setTitle("Map");
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
	}
}
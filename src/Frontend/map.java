package Frontend;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.io.IOException;
import java.net.URL;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
		createWindow();
	}
	
	private static void createWindow() {    
	      JFrame frame = new JFrame("Map");
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      createUI(frame);
	      frame.setSize(560, 450);      
	      frame.setLocationRelativeTo(null);  
	      frame.setVisible(true);
	   }

	   private static void createUI(final JFrame frame){  
	      JPanel panel = new JPanel();
	      LayoutManager layout = new FlowLayout();  
	      panel.setLayout(layout);       

	      JEditorPane jEditorPane = new JEditorPane();
	      jEditorPane.setEditable(false);   
	      URL url= map.class.getResource("resources/map/map.html");

	      try {   
	         jEditorPane.setPage(url);
	      } catch (IOException e) { 
	         jEditorPane.setContentType("text/html");
	         jEditorPane.setText("<html>Page not found.</html>");
	      }

	      JScrollPane jScrollPane = new JScrollPane(jEditorPane);
	      jScrollPane.setPreferredSize(new Dimension(540,400));      

	      panel.add(jScrollPane);
	      frame.getContentPane().add(panel, BorderLayout.CENTER); 
	   }
}
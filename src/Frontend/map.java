package Frontend;

import java.awt.EventQueue;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;



import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class map{
	private JFrame frame;
	public map() {
		initAndShowGUI();
	}
	
	private void initAndShowGUI() {
        frame = new JFrame("Map");
        final JFXPanel fxPanel = new JFXPanel();
        frame.add(fxPanel);
        frame.setSize(300, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                initFX(fxPanel);
            }
       });
    }

    private void initFX(JFXPanel fxPanel) {
        Scene scene = createScene();
        fxPanel.setScene(scene);
    }

    private Scene createScene() {
      
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        
        webEngine.load(/*getClass().getResource("resources/map.html").toString()*/"file:///C:/Users/Jan/Documents/GitHub/JFT/resources/map/map.html");
        Scene scene = new Scene(webView);
        return (scene);
    }
    
    public static void main(String[] args) {
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					map m = new map();
					m.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
}
	

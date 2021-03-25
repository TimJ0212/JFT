package Frontend;

import java.awt.EventQueue;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	private static String start = "Hannover";
	private static String destination = "Laatzen";
	
	public map() {
		initAndShowGUI();
	}
	
	//private void getCoords();
	
	private void initAndShowGUI() {
        frame = new JFrame("Map");
        final JFXPanel fxPanel = new JFXPanel();
        frame.add(fxPanel);
        frame.setSize(600, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
					initFX(fxPanel);
				} catch (IOException | ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
       });
    }
	
	public static void setDestination(String desti) {
		destination = desti;
	}
	
	public static void setStart(String start_) {
		start = start_;
	}
	
	public static String getDestination() {
		return destination;
	}
	
	public static String getStart() {
		return start;
	}

    private void initFX(JFXPanel fxPanel) throws IOException, ClassNotFoundException, SQLException {
        Scene scene = createScene();
        fxPanel.setScene(scene);
    }

    static String[] getCoords(String city) throws SQLException, ClassNotFoundException {
    	
    	String req = "WHERE Stadt='%s'".formatted(city);
    	ResultSet rs = Backend.Database.DBCOutputResultSet.selectRSFromDBWHERE("Staedte", req);
    	String lat = "";
    	String lng = "";
    	while(rs.next()) {
    		lat = (String) rs.getObject("lat");
    		lng = (String) rs.getObject("lng");
    	}
    	String[] arr  = {lat, lng};
    	return arr;
    }
    
    private Scene createScene() throws IOException, ClassNotFoundException, SQLException {
      
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        writeHTML(55.4,47.2);
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
    
    public static void writeHTML(double lat, double lng) throws IOException, ClassNotFoundException, SQLException {
    	File f = new File("resources/map/map.html");
    	FileWriter fw = new FileWriter(f);
    	String[] st = getCoords(start);
    	String[] dt = getCoords(destination);
    	
    	String html = "<!DOCTYPE HTML>\r\n" + 
    			"<html>\r\n" + 
    			"<head>\r\n" + 
    			"<title>OpenLayers Simplest Example</title>\r\n" + 
    			"</head>\r\n" + 
    			"<body>\r\n" + 
    			"\r\n" + 
    			"<div id=\"Map\" style=\"height:95vh\"></div>\r\n" + 
    			"<script src=\"OpenLayers.js\"></script>\r\n" + 
    			"<script>\r\n" + 
    			"    var slon            = %f;\r\n".formatted(Double.parseDouble(st[1])).replace(',', '.') + 
    			"    var slat            = %f;\r\n".formatted(Double.parseDouble(st[0])).replace(',', '.') + 
    			"    var dlon            = %f;\r\n".formatted(Double.parseDouble(dt[1])).replace(',', '.') + 
    			"    var dlat            = %f;\r\n".formatted(Double.parseDouble(dt[0])).replace(',', '.') + 
    			"    var zoom            = 12;\r\n" + 
    			"\r\n" + 
    			"    var fromProjection  = new OpenLayers.Projection(\"EPSG:4326\");   // Transform from WGS 1984\r\n" + 
    			"    var toProjection    = new OpenLayers.Projection(\"EPSG:900913\"); // to Spherical Mercator Projection\r\n" + 
    			"    var sPosition       = new OpenLayers.LonLat(slon, slat).transform( fromProjection, toProjection);\r\n" + 
    			"    var dPosition       = new OpenLayers.LonLat(dlon, dlat).transform( fromProjection, toProjection);\r\n" + 
    			"\r\n" + 
    			"    map = new OpenLayers.Map(\"Map\");\r\n" + 
    			"    var mapnik         = new OpenLayers.Layer.OSM();\r\n" + 
    			"    map.addLayer(mapnik);\r\n" + 
    			"\r\n" + 
    			"    var markers = new OpenLayers.Layer.Markers( \"Markers\" );\r\n" + 
    			"    map.addLayer(markers);\r\n" + 
    			"    markers.addMarker(new OpenLayers.Marker(sPosition));\r\n" +
    			"    markers.addMarker(new OpenLayers.Marker(dPosition));\r\n" +
    			"\r\n" + 
    			"    map.setCenter(sPosition, zoom);\r\n" + 
    			"</script>\r\n" + 
    			"</body>\r\n" + 
    			"</html>"; // get pos from DB
    	
    	fw.write(html);
    	fw.flush();
    	fw.close();
    }
}
	

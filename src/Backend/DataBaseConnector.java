package Backend;

import java.sql.*;

public class DataBaseConnector {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://91.204.46.44/k146691_test?autoReconnect=true&useSSL=false";

	// Database credentials
	static final String USER = "k146691_tim";
	static final String PASS = "0Jmpn2#2";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: JDBC Treiber registrieren.
			Class.forName("com.mysql.cj.jdbc.Driver");

			// STEP 3: Verbindung öffnen
			System.out.println("Verbindung zur database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Abfrage ausführen
			System.out.println("Erstelle Abfrage...\n");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT * FROM Fahrt";
			ResultSet rs = stmt.executeQuery(sql);

			// STEP 5: Einzelne Ergebnisse aus dem Ergebnis Set holen
			while (rs.next()) {
				// Nach Spalte
				int FahrtID = rs.getInt("FahrtID");
				int StartID = rs.getInt("StartID");
				int ZielID = rs.getInt("ZielID");
				int FahrerID = rs.getInt("FahrerID");
				int FahrgastID = rs.getInt("FahrgastID");

				// Werte Ausgabe
				System.out.print("FahrtID: " + FahrtID);
				System.out.print(", StartID: " + StartID);
				System.out.print(", First: " + ZielID);
				System.out.print(", ZielID: " + FahrerID);
				System.out.println(", FahrgastID: " + FahrgastID);
			}
			// STEP 6: Lecks schließen
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Fehlerhandling
			se.printStackTrace();
		} catch (Exception e) {
			//  Fehlerhandling for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} 
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		System.out.println("\nEnde!");
	}// end main
}// end FirstExample

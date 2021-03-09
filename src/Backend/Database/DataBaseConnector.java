package Backend.Database;

import java.sql.*;

public class DataBaseConnector {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://91.204.46.44/k146691_test?autoReconnect=true&useSSL=false";

	// Database credentials
	static final String USER = "k146691_tim";
	static final String PASS = "0Jmpn2#2";

	/**
	 * Führt die Query aus.
	 * @param args
	 * @param trSEfaIN true≙Select; false ≙ Insert
	 * @return
	 */
	public static ResultSet connect(String[] args, boolean trSEfaIN) {

		String[][] data = new String[4][5]; // [rows][columns]
		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: JDBC Treiber registrieren.
			Class.forName("com.mysql.jdbc.Driver"); //Falls es nicht klappt durch: "com.mysql.cj.jdbc.Driver" ersetzen.

			// STEP 3: Verbindung �ffnen
			System.out.println("Verbindung zur database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Abfrage ausführen
			System.out.println("Erstelle Abfrage...\n");
			stmt = conn.createStatement();
			ResultSet rs;
			if (trSEfaIN) {
				rs = stmt.executeQuery(QueryCreator.getSelectSQL(args));
				return rs;
			} else {
				stmt.executeUpdate(QueryCreator.getInsertSQL(args));
			}

			// STEP 6: Lecks schließen
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Fehlerhandling
			se.printStackTrace();
		} catch (Exception e) {
			// Fehlerhandling for Class.forName
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
		return null;

	}// end main

}// end FirstExample

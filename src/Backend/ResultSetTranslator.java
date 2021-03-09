package Backend;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetTranslator {

	/**
	 * Macht aus einem ResultSet ein 2D-Array für die JTable.
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("exports")
	public static String[][] RST(ResultSet rs) {

		String[][] data = new String[4][5];
		// STEP 5: Einzelne Ergebnisse aus dem Ergebnis Set holen
		int i = 0;
		try {
			while (rs.next()) {
				for (int j = 0; j < 5; j++) {
					data[i][j] = rs.getString(j + 1);
				}
				i = i + 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}
}

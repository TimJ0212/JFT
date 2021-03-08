package Backend;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetTranslator {

	public String[][] RST(ResultSet rs) throws SQLException {
		// STEP 5: Einzelne Ergebnisse aus dem Ergebnis Set holen
		int i = 0;
		System.out.println(rs.next() == false);
		String[][] data = new String[4][5];
		while (rs.next()) {
			for (int j = 0; j < 5; j++) {
				data[i][j] = rs.getString(j + 1);
			}
			i = i + 1;
		}
		return data;
	}

}

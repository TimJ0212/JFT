package Backend;

import java.sql.*;

public class functions {

	public static String registerUserSQL(User user) {
		return ("INSERT INTO 'User' ('Username', 'Nachname', 'Passwort', 'Email') VALUES ('" + user.username + "', '"
				+ user.name + "', '" + user.password + "', '" + user.email + "');");
	}

	public static Boolean login(String username, String password) {

		return false;
	}

	public static String getUserInf(String username) {
		return ("SELECT * FROM 'User' WHERE Username='" + username + "'");
	}

	public static Boolean valInResultset(@SuppressWarnings("exports") ResultSet rs, String val) throws SQLException {
		return !rs.next();
	}

	public static String calculateMoney(String personen) {
		return String.valueOf(Integer.valueOf(personen) * 10);

	}
}

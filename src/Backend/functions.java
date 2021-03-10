package Backend;

import java.sql.*;

import Backend.Database.DBCOutputResultSet;

public class functions {

	public static String registerUserSQL(User user) {
		return ("INSERT INTO 'User' ('Username', 'Nachname', 'Passwort', 'Email') VALUES ('" + user.username + "', '"
				+ user.name + "', '" + user.password + "', '" + user.email + "');");
	}

	public static Boolean login(String username, String password) throws SQLException, ClassNotFoundException {
		ResultSet rs = DBCOutputResultSet.loginDB(username);
		int i = 0;
		while (rs.next()) {
			if (password == rs.getString(i))
				return true;
		}
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

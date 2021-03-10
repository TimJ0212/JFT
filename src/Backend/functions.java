package Backend;

import java.sql.*;

import Backend.Database.DBCOutputResultSet;

public class functions {

	public static String registerUserSQL(User user, Boolean driver) {
		return ("INSERT INTO `User` (`Username`, `Password`, `EMail`, `Name`, `Fahrer`) VALUES ('" + user.username
				+ "', '" + user.password + "', '" + user.email + "', '" + user.name + "'" + driver + "');");
	}

	public static Boolean login(String username, String password) throws SQLException, ClassNotFoundException {
		ResultSet rs = DBCOutputResultSet.loginDB(username);
		while (rs.next()) {
			if (password == rs.getString(1))
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

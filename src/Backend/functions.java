package Backend;

import java.sql.*;

import Backend.Database.DBCOutputResultSet;

public class functions {

	public static String registerUserSQL(User user, Boolean driver) {
		int x;
		if (driver)
			x = 1;
		else
			x = 0;
		String s = String.format("INSERT INTO Benutzer VALUES ('%s','%s','%s','%s','%d')", user.username, user.password,
				user.email, user.name, x);
		System.out.println(s);
		return s;
	}

	public static Boolean login(String username, String password) throws SQLException, ClassNotFoundException {
		ResultSet rs = DBCOutputResultSet.loginDB(username);
		while (rs.next()) {
			if (password == rs.getString(1))
				Hauptklasse.loggedUser = new User(username, password, null, null);
			return true;
		}
		return false;
	}

	public static String getUserInf(String username) {
		return ("SELECT * FROM 'Benutzer' WHERE Username='" + username + "'");
	}

	public static Boolean valInResultset(@SuppressWarnings("exports") ResultSet rs, String val) throws SQLException {
		return !rs.next();
	}

	public static String calculateMoney(String personen) {
		return String.valueOf(Integer.valueOf(personen) * 10);

	}
}

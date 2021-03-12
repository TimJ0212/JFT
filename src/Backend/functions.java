package Backend;

import java.sql.*;

import Backend.Database.DBCOutputResultSet;

public class functions {

	public static String registerUserSQL(User user, Boolean driver) throws SQLException, ClassNotFoundException {
		ResultSet rs = DBCOutputResultSet.fetchUserData(user.username);
		if (rs.next() && rs.getString(1).toUpperCase().equals(user.username.toUpperCase())) {
			System.out.println("Username bereits vergeben");
			return null; // Durch "nutzername bereits vergeben" ersetzen
		}
		int x;
		if (driver)
			x = 1;
		else
			x = 0;
		String s = String.format("INSERT INTO Benutzer VALUES ('%s','%s','%s','%s','%d')", user.username, user.password,
				user.email, user.name, x);
		return s;
	}

	public static Boolean login(String username, String password) throws SQLException, ClassNotFoundException {
		ResultSet rs = DBCOutputResultSet.fetchUserData(username);
		while (rs.next()) {
			if (password.equals(rs.getString(2))) {

				Hauptklasse.loggedUser = new User(rs.getString(1), password, null, null);
				return true;
			}
		}
		return false;
	}

	public static String getUserInf(String username) {
		return ("SELECT * FROM Benutzer WHERE UPPER(Username)='" + username.toUpperCase() + "'");
	}

	public static Boolean valInResultset(@SuppressWarnings("exports") ResultSet rs, String val) throws SQLException {
		return !rs.next();
	}

	public static String calculateMoney(String personen) {
		return String.valueOf(Integer.valueOf(personen) * 10);

	}
}

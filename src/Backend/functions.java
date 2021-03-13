package Backend;

import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Backend.Database.DBCOutputResultSet;

public class functions {

	public static String registerUserSQL(User user, Boolean driver) throws SQLException, ClassNotFoundException {
		ResultSet rs = DBCOutputResultSet.fetchUserData(user.username);
		if (rs.next() && rs.getString(1).toUpperCase().equals(user.username.toUpperCase())) {
			System.out.println("Username bereits vergeben");
			return null; // Durch "nutzername bereits vergeben" ersetzen
		}
		final String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
		Pattern pattern = Pattern.compile(regex);
	    Matcher matcher = pattern.matcher(user.email);
	    if(!matcher.matches()) {
	    	System.out.println("Email falsch");
	    	return null;
	    }
	    System.out.println("Email OK");
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
			if (password.equals(functions.decrypt(rs.getString(2)))) { //NEW: Encrypt

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
	
	public static String encrypt(String pw) {
		char[] chars = pw.toCharArray();
		String output = "";
		for(char c: chars) {
			 c +=1;
			 output = output +c;
		}	
		return output;
	}
	
	public static String decrypt(String pw) {
		char[] chars = pw.toCharArray();
		String output = "";
		for(char c: chars) {
			 c -=1;
			 output = output +c;
		}	
		return output;
	}
}

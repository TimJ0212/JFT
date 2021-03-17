package Backend;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Backend.Database.DBCOutputResultSet;

public class functions {

	public static String registerUserSQL(User user, Boolean driver) throws SQLException, ClassNotFoundException {
		ResultSet rs = DBCOutputResultSet.fetchUserData(user.username);
		if (rs.next() && rs.getString(1).toUpperCase().equals(user.username.toUpperCase())) {
			System.out.println("Username bereits vergeben");
			Frontend.popup.test(false);
			return null; // Error fixen und Durch "nutzername bereits vergeben" ersetzen
		}
		final String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(user.email);
		if (!matcher.matches()) {
			System.out.println("Email falsch");
			Frontend.popup.test(false);
			return null;
		}
		System.out.println("Email OK");
		int x;
		if (driver)
			x = 1;
		else
			x = 0;
		String s = String.format("INSERT INTO Benutzer VALUES ('%s','%s','%s','%s','%d')", user.username,
				encrypt(user.password), user.email, user.name, x);
		System.out.println(s);

		return s;
	}

	public static Boolean login(String username, String password) throws SQLException, ClassNotFoundException {
		ResultSet rs = DBCOutputResultSet.fetchUserData(username);
		while (rs.next()) {
			if (password.equals(decrypt(rs.getString(2)))) { // NEW: Decrypt
				System.out.println(rs.getString(2));
				Hauptklasse.loggedUser = new User(rs.getString(1), encrypt(password), null, null);
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
		if (Hauptklasse.loggedUser.getUsername() == null) {
			pw = pw + Frontend.registryWindow.usernameBox.getText().charAt(0);
		}
		pw = pw + Backend.Hauptklasse.loggedUser.getUsername().charAt(0);
		char[] chars = pw.toCharArray();
		String output = "";
		for (char c : chars) {
			c += 1;
			output = output + c;
		}
		return output;
	}

	public static String decrypt(String pw) {
		pw = pw.substring(0, pw.length() - 1);
		char[] chars = pw.toCharArray();
		String output = "";
		for (char c : chars) {
			c -= 1;
			output = output + c;
		}
		return output;
	}
	// DEBUG--------------------------------------------------------------------------------------------------------

	public static void addCitiesToDB(JSONArray JSONData) throws IOException, ParseException, ClassNotFoundException, SQLException {
		
		Object j = (Object) JSONData;
		JSONArray arr = (JSONArray) j;
		
		ResultSet rs = Backend.Database.DBCOutputResultSet.selectTableFromDB("Staedte");
		
		Boolean inDB = false;
		for(Object obj: arr) {
			
			String s = "INSERT INTO Staedte VALUES("+'"'+"%s"+'"'+", '%s', '%s',"+'"'+"%s"+'"'+", '%d')";
			JSONObject jo = (JSONObject) obj;
			
			while(rs.next()) {
				System.out.println("Looking for %s in DB".formatted(jo.get("city_ascii")));
				if(rs.getRef("Stadt").equals(jo.get("city_ascii"))) {
					inDB = true;
					System.out.println("Found %s in DB".formatted(jo.get("city_ascii")));
					break;
				}
				else {
					
				}
			}
			if(!inDB) {
				System.out.println("Adding %s to DB...".formatted(jo.get("city_ascii")));
				s = s.formatted(jo.get("city_ascii"),jo.get("lat").toString(),jo.get("lng").toString(),jo.get("country"),jo.get("id"));
				Backend.Database.DBCOutputResultSet.addCitySQL(s);
				System.out.println("Added %s to DB".formatted(jo.get("city_ascii")));
			}
			
		}

	}
	
	public static JSONArray fetchJSONArray(String filePath) throws IOException, ParseException {
		JSONParser jp = new JSONParser();
		File f = new File(filePath);
		FileReader fr = new FileReader(f);
		JSONArray arr = (JSONArray) jp.parse(fr);
	
		return arr;
	}
	
}

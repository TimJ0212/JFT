package Backend.Database;

import Backend.Hauptklasse;
import Frontend.TaxiBestellScreen;

public class QueryCreator {

	public static String getSelectSQL(String[] args) {
		
		if(TaxiBestellScreen.frmTaxiBestellen.isActive()) {
			System.out.println(args[0]);
			System.out.println(args[1]);
		}
		return "SELECT * FROM angeboteneFahrten";
	}
	
	public static String getInsertSQL(String[] args) {
		
		return "INSERT INTO angeboteneFahrten (FahererID, Ort, Zeit, PersonenAnzahl) VALUES ("+"\""+Hauptklasse.loggedUser.getUsername() +"\""+ "\""+  args[0] + "\"" + ", "+args[1]+", "+args[2]+")";
	}

}

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
		String de =  "INSERT INTO angeboteneFahrten (Fahrer, Ort, Zeit, PersonenAnzahl) VALUES ("+"\""+Hauptklasse.loggedUser.getUsername() +"\""+ ", " +"\""+  args[0] + "\"" + ", "+args[1]+", "+args[2]+")";
		System.out.println(de);
		return de;
	}

}

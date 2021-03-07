package Backend.Database;

import Frontend.TaxiBestellScreen;

public class QueryCreator {

	public static String getSQL(String[] args) {
		
		if(TaxiBestellScreen.frmTaxiBestellen.isActive()) {
			System.out.println(args[0]);
			System.out.println(args[1]);
		}
		
		
		
		return "SELECT * From angeboteneFahrten";
	}

}

package Backend;

public class Hauptklasse {
	public static void main(String[] args) {
	
		Frontend.LoginScreen.main(args);
	}
	public static String calculateMoney(String personen){
		
		return String.valueOf(Integer.valueOf(personen)*10);
		
	}
}
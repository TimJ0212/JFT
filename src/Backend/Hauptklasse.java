package Backend;

public class Hauptklasse {
	public static User loggedUser = new User(null, null, null, null);
	public static void main(String[] args) {

		System.out.println(functions.encrypt("Hey"));
		System.out.println(functions.decrypt(functions.encrypt("Hey")));
	
		Frontend.LoginScreen.main(args);
	}

}
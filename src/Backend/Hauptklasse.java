package Backend;

public class Hauptklasse {

	public static User loggedUser = new User(null, null, null, null);
	
	public static void main(String[] args) {
		System.out.println("hhhh");
		Frontend.LoginScreen.main(args);
	}

}

package Backend;

public class User {
	String username;
	String name;
	String email;
	String password;
	float lat;//y coords
	float lng;//x coords

	/**
	 * 
	 * @param un username
	 * @param n  name
	 * @param em email
	 * @param pw passwort
	 */
	public User(String un, String n, String em, String pw) {
		this.username = n == null ? "unbekannt" : un;
		this.name = n;
		this.email = em == null ? "unbekannt" : em;
		this.password = pw;
	}

	public String getUsername() {
		return this.username;
	}
	
	public void setPosition(float x, float y) {
		this.lat = y;
		this.lng = x;
	}
	
	public float[] getPosition() {
		float[] pos = {this.lng, this.lat};
		return pos;
	}
}

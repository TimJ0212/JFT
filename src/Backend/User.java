package Backend;

public class User {
    String username;
    String name;
    String email;
    String password;

    /**
     * 
     * @param un username
     * @param n  name
     * @param em email
     * @param pw passwort
     */
    public User(String un, String n, String em, String pw) {
        this.username = un.toLowerCase();
        this.name = n;
        this.email = em.toLowerCase();
        this.password = pw;
    }
}

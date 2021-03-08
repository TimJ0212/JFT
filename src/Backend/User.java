package Backend;

public class User {
    String username;
    String name;
    String vorname;
    String email;
    String password;

    public User(String un, String n, String vn, String em, String pw) {
        this.username = un;
        this.name = n;
        this.vorname = vn;
        this.email = em;
        this.password = pw;
    }
}

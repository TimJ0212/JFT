package Backend;

import java.sql.*;

public class functions {

    public static String registerUSer(User user) {
        return ("INSERT INTO User SET Username=" + '"' + user.username + '"' + " Nachname=" + '"' + user.name + '"'
                + " Passwort=" + '"' + user.password + '"' + " Email=" + '"' + user.email + '"');
    }

    public static Boolean login(String username, String password) {

        return false;
    }

    public static Boolean valInResultset(ResultSet rs, String val) throws SQLException {
        if (!rs.next())
            return true;
        return false;
    }

}

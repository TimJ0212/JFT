package Frontend;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

public class functions {

    public static void registerUSer(User user)
            throws IOException, ParseException, org.json.simple.parser.ParseException {

        Boolean valid = true;
        String filepath = "resources\\testjson.json";
        JSONObject key = new JSONObject();
        JSONObject obj = new JSONObject();
        JSONObject temp = (JSONObject) readJSON(filepath);
        Object temp2 = temp.get("user");
        JSONArray arr = (JSONArray) temp2;

        for (Object current_user : arr) {
            JSONObject username = (JSONObject) current_user;
            if (username.containsKey(user.username.toLowerCase())) {
                System.out.println("Benutzername bereits vergeben");
                valid = false;
            } else if (username.get("email").equals(user.email.toLowerCase())) {
                System.out.println("Email Adresse bereits vergeben");
                valid = false;
            }

        }
        if (valid) {
            obj.put("email", user.email.toLowerCase());
            obj.put("password", user.password);
            obj.put("name", user.name.toLowerCase());
            obj.put("vorname", user.vorname.toLowerCase());
            key.put(user.username.toLowerCase(), obj);
            arr.add(key);

            writeJSON(arr, filepath);
        }
    }

    public static Boolean login(String username, String password)
            throws IOException, ParseException, org.json.simple.parser.ParseException {

        JSONObject temp = (JSONObject) readJSON("resources\\testjson.json");
        Object temp2 = temp.get("user");
        JSONArray arr = (JSONArray) temp2;
        for (int i = 0; i < arr.size(); i++) {
            JSONObject obj = (JSONObject) arr.get(i);

            if (obj.containsKey(username)) {
                obj = (JSONObject) obj.get(username);
                if (obj.get("password").equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Object readJSON(String filepath)
            throws IOException, ParseException, org.json.simple.parser.ParseException {
        File file = new File(filepath);

        FileReader fr = new FileReader(file);
        JSONParser jp = new JSONParser();

        Object obj = jp.parse(fr);
        fr.close();
        return (obj);
    }

    public static void writeJSON(JSONArray arr, String filepath) throws IOException {
        FileWriter fw = new FileWriter(filepath);

        fw.write(arr.toJSONString());
        fw.flush();
        fw.close();
    }
}

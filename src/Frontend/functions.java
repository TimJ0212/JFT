package Frontend;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import org.json.simple.*;

public static final String filepath = "testjson.json";


public class functions {
    public static void registerUSer(User user) throws IOException, ParseException {
        String filepath = "testjson.json"; 
        JSONObject obj1 = new JSONObject();
        JSONObject obj2 = new JSONObject();
        JSONObject temp = (JSONObject) readJSON(filepath);
        Object temp2 = temp.get("user");
        JSONArray arr = (JSONArray) temp2;



        obj2.put("email", user.email);
        obj2.put("password", user.password);
        obj2.put("name", user.name);
        obj2.put("vorname", user.vorname);
        obj1.put(user.username, obj2);
        arr.add(obj1);

        writeJSON(arr, filepath);
    }
    }

    public static Boolean login(String username, String password) throws IOException, ParseException {

        JSONObject temp = (JSONObject) readJSON("testjson.json");
        Object temp2 = temp.get("user");
        JSONArray arr = (JSONArray) temp2;
        for(int i = 0; i<arr.size(); i++) {
            JSONObject obj = (JSONObject) arr.get(i);
            
            if(obj.containsKey(username)){
                obj = (JSONObject) obj.get(username);
                if(obj.get("password").equals(password)){
                    return true;
                }
            }
            
        }
        return false;
    }

    public static Object readJSON(String filepath) throws IOException, ParseException {
        File file = new File(filepath);
        
        FileReader fr = new FileReader(file);
        JSONParser jp = new JSONParser();
        
        Object obj = jp.parse(fr);
        fr.close();
        return(obj);
    }

    public static void writeJSON(JSONArray arr, String filepath) throws IOException {
        FileWriter fw = new FileWriter(filepath);

        fw.write(arr.toJSONString());
        fw.flush();
        fw.close();
    }
}

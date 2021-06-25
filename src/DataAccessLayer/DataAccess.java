package DataAccessLayer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class DataAccess {

    public static JSONArray read(String readTarget) throws NoDataFound {
        try {
            JSONParser parser = new JSONParser();
            Object file = parser.parse(new FileReader("src/Database/distances.json"));
            JSONObject jsonObject = (JSONObject) file;
            return (JSONArray) jsonObject.get(readTarget);
        } catch (
                Exception ex) {
            throw new NoDataFound();

        }
    }
}
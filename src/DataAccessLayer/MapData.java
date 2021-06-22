package DataAccessLayer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class MapData{
    static JSONArray mapArray;

    public static JSONArray read() throws NoDataFound {
        try {
            JSONParser parser = new JSONParser();
            Object file = parser.parse(new FileReader("src/Database/distances.json"));
            JSONObject jsonObject = (JSONObject) file;
            mapArray = (JSONArray) jsonObject.get("routes");
            return mapArray;
        } catch (
                Exception ex) {
            throw new NoDataFound();
        }

    }
}
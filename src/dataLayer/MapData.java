package dataLayer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;

public class MapData {
    JSONArray data;
    public MapData() {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader( "src/dataLayer/distances.json"));
            JSONObject jsonObject = (JSONObject) obj;
            this.data = (JSONArray) jsonObject.get("routes");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        for ( Object object : data) {
            JSONObject line = (JSONObject) object;
            System.out.println( object );
            String cityarray = (String) line.get("cityA");

            System.out.println( cityarray );
        }
    }
    public ArrayList getData(){
        return data;
    }
}

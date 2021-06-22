package ApplicationLayer.Controller;

import ApplicationLayer.Model.Graph;
import DataAccessLayer.MapData;
import DataAccessLayer.NoDataFound;
import org.json.simple.JSONArray;

public class DataController {

    private final JSONArray mapData;

    public DataController() throws NoDataFound{
        this.mapData = MapData.read();
        Graph.init(mapData);
    }

}

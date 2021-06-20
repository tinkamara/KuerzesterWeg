package ApplicationLayer.Controller;

import ApplicationLayer.Model.Graph;
import DataAccessLayer.MapData;
import DataAccessLayer.NoDataFound;
import org.json.simple.JSONArray;

public class DataController {

    private JSONArray mapData;

    public DataController() throws NoDataFound{
        this.mapData = MapData.readDB();
        Graph.init(mapData);
    }

}

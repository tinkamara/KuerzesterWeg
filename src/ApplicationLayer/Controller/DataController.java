package ApplicationLayer.Controller;

import ApplicationLayer.Model.Graph;
import dataLayer.MapData;

public class DataController {
    public DataController(){
        MapData mapData = new MapData();
        Graph graph = Graph.getGraph( mapData );
    }
}

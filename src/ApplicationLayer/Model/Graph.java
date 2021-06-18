package ApplicationLayer.Model;

import dataLayer.MapData;

public class Graph {
    private static Graph Graph;
    private Graph(MapData mapData) {

    }
    public static Graph getGraph( MapData mapData){
        if ( Graph == null){
            Graph = new Graph( mapData );
        }
        return Graph;

    }
}

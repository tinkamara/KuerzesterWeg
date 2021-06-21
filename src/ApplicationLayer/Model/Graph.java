package ApplicationLayer.Model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Graph {
    private static ArrayList<Edge> existingEdges;
    private static  ArrayList<Node> existingNodes;

    public static void init(JSONArray mapData){
        existingEdges = new ArrayList<Edge>();
        for ( Object line : mapData) {
            JSONObject jLine = (JSONObject) line;
            Edge edge = new Edge((String) jLine.get("cityA"), (String) jLine.get("cityB"), (int) (long) jLine.get("distance"));
            existingEdges.add(edge);
        }
        existingNodes = Node.getExistingNodes();

        for( Node node : existingNodes){
            for (Edge edge : existingEdges){
                if (edge.getCityA().equals(node)) {
                    node.addNeighbor(edge.getCityB(), edge.getDistance());
                } else if(edge.getCityB().equals(node)){
                    node.addNeighbor(edge.getCityA(), edge.getDistance());
                }
            }

        }
    }

    public static ArrayList<Edge> getExistingEdges() {
        return existingEdges;
    }

    public static ArrayList<Node> getExistingNodes() {
        return existingNodes;
    }
}


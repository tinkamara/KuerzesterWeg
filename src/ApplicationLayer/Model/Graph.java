package ApplicationLayer.Model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Graph {
    private static ArrayList<Edge> existingEdges;
    private static  ArrayList<Node> existingNodes;

    public static void init(JSONArray mapData){
        existingEdges = new ArrayList<>();
        for ( Object line : mapData) {
            JSONObject jLine = (JSONObject) line;
            Edge edge = new Edge((String) jLine.get("cityA"), (String) jLine.get("cityB"), (int) (long) jLine.get("distance"));
            existingEdges.add(edge);
            edge = new Edge((String) jLine.get("cityB"), (String) jLine.get("cityA"), (int) (long) jLine.get("distance"));
            existingEdges.add(edge);
        }
        existingNodes = Node.getExistingNodes();


    }


    public static ArrayList<String> getCities() {
        ArrayList<String> cities = new ArrayList<>();
        for( Node node : existingNodes){
            cities.add(node.getCity());
        }
        return cities;
    }

    public static ArrayList<Node> cloneExistingNodes(){
        ArrayList<Node> clonedNodes = new ArrayList();
        for (Node node : existingNodes){
            Node clonedNode = node.clone(node);
            clonedNodes.add(clonedNode);
        }
        return clonedNodes;
    }

    public static ArrayList<Edge> cloneExistingEdges(ArrayList<Node> clonedNodes){
        ArrayList<Edge> clonedEdges = new ArrayList<>();
        Node nodeA = null;
        Node nodeB = null;
           for (Edge edge : existingEdges) {
               for ( Node clonedNode : clonedNodes){
                   if (clonedNode.equals(edge.getCityA())){
                       nodeA = clonedNode;
                   }
                   if ( clonedNode.equals(edge.getCityB())){
                       nodeB = clonedNode;
                   }
               }
               Edge clonedEdge = new Edge(nodeA,nodeB,edge.getDistance());
               clonedEdges.add(clonedEdge);
           }

        return clonedEdges;
    }
}


package ApplicationLayer.Model;

import java.util.ArrayList;

public class Edge {

    private Node cityA;
    private Node cityB;
    private int distance;
    private static ArrayList<Edge> existingEdges;


    public Edge( String cityA, String cityB, int distance){
        this.distance = distance;
        this.cityA = Node.getNode( cityA );
        this.cityB = Node.getNode( cityB );
        existingEdges.add( this );
    }
    public static ArrayList getExistingEdges(){
        return existingEdges;
    }

    public Node getCityA() {
        return cityA;
    }

    public Node getCityB() {
        return cityB;
    }

    public int getDistance() {
        return distance;
    }
}

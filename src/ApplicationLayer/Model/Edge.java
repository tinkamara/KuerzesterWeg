package ApplicationLayer.Model;

import java.util.ArrayList;

public class Edge {

    private final Node cityA;
    private final Node cityB;
    private final int distance;
    private static ArrayList<Edge> existingEdges = new ArrayList<Edge>();


    public Edge( String cityA, String cityB, int distance){
        this.distance = distance;
        this.cityA = Node.getNode( cityA );
        this.cityB = Node.getNode( cityB );
        existingEdges.add( this );
    }
    public static ArrayList<Edge> getExistingEdges(){
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

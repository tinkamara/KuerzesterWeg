package ApplicationLayer.Model;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.TreeMap;

import static java.lang.Integer.MAX_VALUE;

public class Node implements  Comparable{
    private final String city;
    private Node predecessor;
    private int distance;
    private static ArrayList<Node> existingNodes = new ArrayList<Node>();
    private TreeMap<Node , Integer> neighbors;

    private Node( String city ){
    this.city = city;
    this.predecessor = null;
    this.distance = MAX_VALUE;
    existingNodes.add(this);
    this.neighbors = new TreeMap<>();
    }


    public static Node getNode(String city ) {
        Node retNode = null;

        for (Node exists : existingNodes) {
            if (city.equals(exists.getCity())) {
                retNode = exists;
            }
        }
        if (retNode == null) {
            retNode = new Node(city);
        }
            return retNode;

    }

    public void resetNode(){
        this.predecessor = null;
        this.distance = MAX_VALUE;
    }

    public TreeMap<Node, Integer> getNeighbors() {

        return neighbors;
    }

    public void addNeighbor(Node neighbor, int distance) {
        this.neighbors.put(neighbor, distance);
    }

    public static ArrayList<Node> getExistingNodes(){
        return existingNodes;
    }
    public String getCity() {
        return city;
    }

    public Node getPredecessor() {
        return predecessor;
    }

    public int getDistance() {
        return distance;
    }

    public void setPredecessor(Node predecessor) {
        this.predecessor = predecessor;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }




    @Override
    public int compareTo(@NotNull Object o) {
        return 1;
    }
}

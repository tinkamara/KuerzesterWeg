package ApplicationLayer.Model;

import java.util.ArrayList;

public class Node {
    private String city;
    private Node predecessor;
    private int distance;
    private static ArrayList<Node> existingNodes;

    private Node( String city ){
    this.city = city;
    this.predecessor = null;
    this.distance = -1;
    existingNodes.add(this);
    }
    public String getName(){
        return this.city;
    }
    public static Node getNode( String city ) {
        for (Node exists : existingNodes) {
            if (city == exists.getName()) {
                return exists;
            }
        }
        Node newNode = new Node( city );
        existingNodes.add(newNode);
        return newNode;
    }

    public static ArrayList getExistingNodes(){
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

}

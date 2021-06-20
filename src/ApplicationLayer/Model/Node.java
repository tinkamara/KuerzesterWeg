package ApplicationLayer.Model;

import java.util.ArrayList;

public class Node {
    private String city;
    private Node predecessor;
    private int distance;
    private static ArrayList<Node> existingNodes = new ArrayList<>();

    private Node( String city ){
    this.city = city;
    this.predecessor = null;
    this.distance = -1;
    existingNodes.add(this);
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

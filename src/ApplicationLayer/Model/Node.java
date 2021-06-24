package ApplicationLayer.Model;

import java.util.ArrayList;

import static java.lang.Integer.MAX_VALUE;

public class Node implements Cloneable {
    private final String city;
    private Node predecessor;
    private final static ArrayList<Node> existingNodes = new ArrayList<>();
    private int distanceToStart = MAX_VALUE;
    private int distanceToNeighbor = MAX_VALUE;
    private boolean used = false;

    private Node( String city ){
    this.city = city;
    this.predecessor = null;
    existingNodes.add(this);
    }
    private Node ( Node node){
        this.city = node.getCity();
        this.predecessor = node.predecessor;
        this.distanceToStart = node.getDistanceToStart();
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



    public static ArrayList<Node> getExistingNodes(){

        return existingNodes;
    }
    public String getCity() {

        return city;
    }

    public void updateDistanceToStart(int change){

        distanceToStart = change;
    }

    public int getDistanceToStart(){

        return distanceToStart;
    }

    public Node getPredecessor() {

        return predecessor;
    }


    public void setPredecessor(Node predecessor) {

        this.predecessor = predecessor;
    }


    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }


    protected Node clone(Node node) {
        return new Node(node);
    }

    public int getDistanceToNeighbor() {
        return distanceToNeighbor;
    }

    public void setDistanceToNeighbor(int distanceToNeighbor) {
        this.distanceToNeighbor = distanceToNeighbor;
    }
}

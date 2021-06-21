package ApplicationLayer.Model;

import java.util.*;

import static java.lang.Integer.MAX_VALUE;

public class Dijkstra {
    private final ArrayList<Node> emptyNodes;
    private Node start;
    private Node destination;
    private int totalDistance = 0;


    public Dijkstra(String start, String destination){
    this.start = Node.getNode(start);
    this.destination = Node.getNode(destination);
    this.emptyNodes = Node.getExistingNodes();
    this.initialize();

    while (this.emptyNodes.size() > 0) {
       Node nextNode = this.getNextNode(this.start);
       if(nextNode.equals(this.destination)){
           break;
        }
       this.start = nextNode;

        }
    }



    public void initialize(){
        for( Node node : this.emptyNodes) {
            node.resetNode();
        }
        this.start.setDistance(0);
        this.start.setPredecessor(null);
        this.start.updateDistanceToStart(0);
        emptyNodes.remove(this.start);
    }


    public Node getNextNode(Node start){
        int minimalDistance = MAX_VALUE;
        Node closest = null;


        TreeMap<Node, Integer> currentNeighbors = start.getNeighbors();

        Collection<Map.Entry<Node, Integer>> c = currentNeighbors.entrySet();

        for (Map.Entry<Node, Integer> neighbor : c) {
            minimalDistance = MAX_VALUE;
            closest = null;
            if (emptyNodes.contains(neighbor.getKey())) {
                neighbor.getKey().setPredecessor(start);
                neighbor.getKey().setDistance(neighbor.getValue());
                neighbor.getKey().updateDistanceToStart(totalDistance + neighbor.getValue());
                System.out.println(neighbor.getKey().getCity());
                if (neighbor.getValue() < minimalDistance) {
                    closest = neighbor.getKey();
                    minimalDistance = neighbor.getValue();
                }
                emptyNodes.remove(neighbor.getKey());
            } else if (neighbor.getKey().getDistanceToStart() > neighbor.getValue() + this.totalDistance) {
                neighbor.getKey().setPredecessor(start);
                neighbor.getKey().setDistance(neighbor.getValue());
                neighbor.getKey().updateDistanceToStart(totalDistance + neighbor.getValue());
                if (neighbor.getValue() < minimalDistance) {
                    closest = neighbor.getKey();
                    minimalDistance = neighbor.getValue();
                }

            }
        }
        totalDistance = totalDistance + minimalDistance;
        return closest;
    }

    public int getTotalDistance() {
        return totalDistance;
    }
    public ArrayList<String> getPath(){
        ArrayList<String> path = new ArrayList<>();
        while(this.destination.getPredecessor() != null){
            path.add(0, this.destination.getCity());
            this.destination = this.destination.getPredecessor();
        }
        path.add(0, this.destination.getCity());
        return path;
    }
}

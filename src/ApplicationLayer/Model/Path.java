package ApplicationLayer.Model;

import ApplicationLayer.View.UserInterface;

import java.util.ArrayList;
import java.util.PriorityQueue;

import static java.lang.Integer.MAX_VALUE;

public class Path {
    private final Node start;
    private Node destination;
    private final ArrayList<Node> nodes;
    private PriorityQueue<Node> priorityQueue;
    private int totalDistance;
    private UserInterface userInterface;

    public Path(String start, String destination, UserInterface userInterface) {
        this.userInterface = userInterface;
        this.start = Node.getNode(start);
        this.destination = Node.getNode(destination);
        this.nodes = Node.getExistingNodes();
        this.initialize();

        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();
            priorityQueue.remove(node);
            if (node.isUsed()) {
                continue;
            }
            node.setUsed(true);
            this.setNextNeighbor(node);
        }
        userInterface.updateDistance(this.destination.getDistanceToStart());
        userInterface.updatePath(this.calcPath());
    }

    public void initialize() {
        for (Node node : this.nodes) {
            node.resetNode();
        }
        this.start.setPredecessor(null);
        this.start.updateDistanceToStart(0);
        priorityQueue = new PriorityQueue<>();
        priorityQueue.add(this.start);
    }

    public void setNextNeighbor(Node node){
        for (Edge edge : Graph.getExistingEdges()) {
            if (node.equals(edge.getCityA())) {
                Node neighbor = edge.getCityB();
                if (neighbor.getDistanceToStart() == MAX_VALUE || neighbor.getDistanceToStart() > (edge.getDistance() + node.getDistanceToStart())) {

                    neighbor.setPredecessor(node);
                    neighbor.updateDistanceToStart((edge.getDistance() + node.getDistanceToStart()));
                    priorityQueue.add(neighbor);

                }
            }
        }
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public ArrayList<String> calcPath() {
        ArrayList<String> path = new ArrayList<>();
        while (this.destination.getPredecessor() != null) {
            path.add(0, this.destination.getCity());
            this.destination = this.destination.getPredecessor();
        }
        path.add(0, this.destination.getCity());
        return path;
    }
}
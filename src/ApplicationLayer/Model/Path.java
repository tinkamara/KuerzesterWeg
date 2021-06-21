package ApplicationLayer.Model;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Path {
    private Node start;
    private Node destination;
    private ArrayList<Node> nodes;
    private ArrayList<Edge> edges;
    private PriorityQueue<Node> priorityQueue;
    private int totalDistance = 0;

    public Path(String start, String destination) {
        this.start = Node.getNode(start);
        this.destination = Node.getNode(destination);
        this.nodes = Node.getExistingNodes();
        this.edges = Graph.getExistingEdges();
        this.initialize();

        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();
            System.out.println(node.getCity());
            if (node.isUsed()) {
                continue;
            }
            node.setUsed(true);
            for (Edge edge : edges) {
                if (node.equals(edge.getCityA())) {
                    Node neighbor = edge.getCityB();
                   // int distanceToNeighbor = edge.getDistance();
                    if (node.getDistanceToStart() > edge.getDistance() + totalDistance || true ) {
                        neighbor.updateDistanceToStart(edge.getDistance() + totalDistance);
                        neighbor.setPredecessor(node);
                        totalDistance = totalDistance + node.getDistance();
                        System.out.println(neighbor.getPredecessor().getCity());
                        priorityQueue.add(neighbor);
                    }
                }
            }
        }
    }

    public void initialize() {
        for (Node node : this.nodes) {
            node.resetNode();
        }
        this.start.setDistance(0);
        this.start.setPredecessor(null);
        this.start.updateDistanceToStart(0);
        priorityQueue = new PriorityQueue<>();
        priorityQueue.add(this.start);
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public ArrayList<String> getPath() {
        ArrayList<String> path = new ArrayList<>();
        while (this.destination.getPredecessor() != null) {
            path.add(0, this.destination.getCity());
            this.destination = this.destination.getPredecessor();
        }
        path.add(0, this.destination.getCity());
        return path;
    }
}
package ApplicationLayer.Model;

import ApplicationLayer.View.UserInterface;

import java.util.ArrayList;

import static java.lang.Integer.MAX_VALUE;

public class Path {
    private final Node start;
    private Node destination;
    private final ArrayList<Node> nodes;
    private ArrayList<Node> remainingNodes;

    public Path(String start, String destination, UserInterface userInterface) {
        this.start = Node.getNode(start);
        this.destination = Node.getNode(destination);
        this.nodes = Node.getExistingNodes();
        this.initialize();

        while (!remainingNodes.isEmpty()) {
            Node node = remainingNodes.get(0);
            remainingNodes.remove(node);
            if (node.isUsed()) {
                continue;
            }
            node.setUsed(true);
            this.setNextNeighbor(node);
        }
        userInterface.updateDistance(this.destination.getDistanceToStart());
        System.out.println(this.destination.getDistanceToStart());
        //userInterface.updatePath
        for(String string: this.calcPath()){
            System.out.println(string);
        }

    }

    public void initialize() {
        for (Node node : this.nodes) {
            node.resetNode();
        }
        this.start.setPredecessor(null);
        this.start.updateDistanceToStart(0);
        remainingNodes = new ArrayList<>();
        remainingNodes.add(this.start);
    }

    public void setNextNeighbor(Node node){
        for (Edge edge : Graph.getExistingEdges()) {
            if (node.equals(edge.getCityA())) {
                Node neighbor = edge.getCityB();
                if (neighbor.getDistanceToStart() == MAX_VALUE || neighbor.getDistanceToStart() > (edge.getDistance() + node.getDistanceToStart())) {

                    neighbor.setPredecessor(node);
                    neighbor.updateDistanceToStart((edge.getDistance() + node.getDistanceToStart()));
                    remainingNodes.add(neighbor);

                }
            }
        }
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
package ApplicationLayer.Model;

import presentationLayer.View.UserInterface;

import java.util.ArrayList;

import static java.lang.Integer.MAX_VALUE;

public class Path {
    private Node start = null;
    private Node destination = null;
    private ArrayList<Node> remainingNodes;
    private ArrayList<Edge> clonedEdges;

    public Path(String start, String destination, UserInterface userInterface) {
        this.initialize( start, destination);

        while (!remainingNodes.isEmpty()) {
            Node node = remainingNodes.get(0);
            remainingNodes.remove(node);
            if (node.isUsed()) {
                continue;
            }
            node.setUsed(true);
            this.getNextShortest(node);
        }
        userInterface.updateDistance(this.destination.getDistanceToStart());
        userInterface.updatePath(this.calcPath());


    }

    public void initialize( String start, String destination) {
        ArrayList<Node> clonedNodes = Graph.cloneExistingNodes();
        this.clonedEdges = Graph.cloneExistingEdges(clonedNodes);
        for (Node clonedNode : clonedNodes) {
            if (this.destination == null || this.start == null) {
                if (clonedNode.getCity().equals(destination)) {
                    this.destination = clonedNode;
                }
                if (clonedNode.getCity().equals(start)) {
                    this.start = clonedNode;
                }
            } else {
                break;
            }
        }
                this.remainingNodes = new ArrayList<>();
                remainingNodes.add(this.start);
                this.start.setPredecessor(null);
                this.start.updateDistanceToStart(0);


        }



    public void getNextShortest(Node node){
        for (Edge clonedEdge : this.clonedEdges) {
            if (node.equals(clonedEdge.getCityA())) {
                Node neighbor = clonedEdge.getCityB();
                if (neighbor.getDistanceToStart() == MAX_VALUE || neighbor.getDistanceToStart() > (clonedEdge.getDistance() + node.getDistanceToStart())) {

                    neighbor.setPredecessor(node);
                    neighbor.updateDistanceToStart((clonedEdge.getDistance() + node.getDistanceToStart()));
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
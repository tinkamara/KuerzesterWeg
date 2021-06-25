package ApplicationLayer.Model;

import java.util.ArrayList;

import static java.lang.Integer.MAX_VALUE;

public class Path {
    private Node start = null;
    private Node destination = null;
    private ArrayList<Node> remainingNodes;
    private ArrayList<Edge> clonedEdges;

    public Path(String start, String destination) {
        try {
            this.initialize(start, destination);

            while (!remainingNodes.isEmpty()) {
                Node node = remainingNodes.get(0);
                remainingNodes.remove(node);
                if (node.isUsed()) {
                    continue;
                }
                node.setUsed(true);
                this.getNextShortest(node);
            }
         //   userController.updateDistance(this.destination.getDistanceToStart());
           // userController.updatePath(this.calcPath());


        } catch (NullPointerException e) {
           // userController.showError(e.getMessage());
        }
    }

    public void initialize(String start, String destination) {
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


    public void getNextShortest(Node node) {
        for (Edge clonedEdge : this.clonedEdges) {
            if (node.equals(clonedEdge.getCityA())) {
                Node neighbor = clonedEdge.getCityB();
                if (neighbor.getDistanceToStart() == MAX_VALUE || neighbor.getDistanceToStart() > (clonedEdge.getDistance() + node.getDistanceToStart())) {

                    neighbor.setPredecessor(node);
                    neighbor.setDistanceToNeighbor(clonedEdge.getDistance());
                    neighbor.updateDistanceToStart((clonedEdge.getDistance() + node.getDistanceToStart()));
                    remainingNodes.add(neighbor);

                }
            }
        }
    }


    public ArrayList<String> calcPath() {
        ArrayList<String> path = new ArrayList<>();
        Node routeNode = this.destination;
        while (routeNode.getPredecessor() != null) {
            path.add(0, routeNode.getCity());
            path.add(0, "<< " + routeNode.getDistanceToNeighbor() + " km bis >>");
            routeNode = routeNode.getPredecessor();
        }
        path.add(0, routeNode.getCity());
        return path;
    }

    public int getTotalDistance() {
        return this.destination.getDistanceToStart();
    }
}
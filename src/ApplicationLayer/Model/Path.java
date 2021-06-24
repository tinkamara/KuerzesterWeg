package ApplicationLayer.Model;

import ApplicationLayer.View.UserInterface;

import java.util.ArrayList;

import static java.lang.Integer.MAX_VALUE;

public class Path {
    private Node start = null;
    private Node destination = null;
    private ArrayList<Node> remainingNodes;
    private ArrayList<Edge> edges;

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
        System.out.println(this.destination.getDistanceToStart());
        for(String string: this.calcPath()){
            System.out.println(string);
        }

    }

    public void initialize( String start, String destination) {
        this.edges = Graph.cloneExistingEdges();
        for (Edge edge : edges) {
            if (this.destination == null || this.start == null) {
                if (edge.getCityA().getCity().equals(destination)) {
                    this.destination = edge.getCityA();
                } else if (edge.getCityB().getCity().equals(destination)) {
                    this.destination = edge.getCityB();
                }
                if (edge.getCityA().getCity().equals(start)) {
                    this.start = edge.getCityA();
                } else if (edge.getCityB().getCity().equals(start)) {
                    this.destination = edge.getCityB();

                }
            } else {
                this.remainingNodes = new ArrayList<>();
                remainingNodes.add(this.start);
                this.start.setPredecessor(null);
                this.start.updateDistanceToStart(0);
                return;
            }
        }
    }

    public void getNextShortest(Node node){
        for (Edge edge : this.edges) {
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
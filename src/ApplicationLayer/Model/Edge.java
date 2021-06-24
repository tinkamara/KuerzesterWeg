package ApplicationLayer.Model;

public class Edge implements Cloneable {

    private final Node cityA;
    private final Node cityB;
    private final int distance;


    public Edge ( String cityA, String cityB, int distance){
        this.distance = distance;
        this.cityA = Node.getNode( cityA );
        this.cityB = Node.getNode( cityB );
    }
    private Edge(Edge edge){
        this.distance = edge.getDistance();
        this.cityA = edge.getCityA().clone(edge.getCityA());
        this.cityB = edge.getCityB().clone(edge.getCityB());
    }

    public Node getCityA() {

        return this.cityA;
    }

    public Node getCityB() {

        return this.cityB;
    }

    public int getDistance() {
        return this.distance;
    }


    protected Edge clone(Edge edge) {
        return new Edge(edge);
    }
}

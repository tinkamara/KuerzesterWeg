package ApplicationLayer.Model;

public class Edge {

    private final Node cityA;
    private final Node cityB;
    private final int distance;


    public Edge( String cityA, String cityB, int distance){
        this.distance = distance;
        this.cityA = Node.getNode( cityA );
        this.cityB = Node.getNode( cityB );
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
}

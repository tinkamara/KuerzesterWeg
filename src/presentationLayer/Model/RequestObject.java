package presentationLayer.Model;

import java.io.Serializable;

public class RequestObject implements Serializable {
    private String start;
    private String destination;

    public RequestObject(String start, String destination){
        this.start = start;
        this.destination = destination;
    }


    public String getStart() {
        return start;
    }

    public String getDestination() {
        return destination;
    }
}

package presentationLayer.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class AnswerObject implements Serializable {
    private ArrayList<String> path;
    private int distance;
    private String error = null;

    public AnswerObject(ArrayList<String> path, int distance) {
        this.path = path;
        this.distance = distance;
    }

    public AnswerObject(String error) {
        this.error = error;
    }

    public ArrayList<String> getPath() {
        return path;
    }

    public int getDistance() {
        return distance;
    }

    public String getError() {
        return error;
    }
}

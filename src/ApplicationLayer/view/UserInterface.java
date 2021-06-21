package ApplicationLayer.view;

import java.util.ArrayList;

public class UserInterface {
    private String error;
    private ArrayList<String> cities;



    public UserInterface( ArrayList<String> cities) {
        this.cities = cities;
        this.init();
    }
    public UserInterface( String error){
        this.error = error;
        this.init();
    }

    private void init() {

    }
}
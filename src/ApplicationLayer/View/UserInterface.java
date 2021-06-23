package ApplicationLayer.View;

import ApplicationLayer.Controller.UserController;

import java.util.ArrayList;

public class UserInterface {
    private String error;
    private ArrayList<String> cities;
    private String selectedStart;
    private String selectedDestination;
    private UserController controller;



    public UserInterface( ArrayList<String> cities, UserController controller) {
        this.controller = controller;
        this.cities = cities;
        this.init();
    }
    public UserInterface( String error){
        this.error = error;
        this.init();
    }

    private void init() {

    }

    //at destination/start change
    // controller.actionPerformed(event);


    public void updateDistance(int distance){

    }
    public void updatePath(ArrayList<String> path){

    }

    public void showError(String error){

    }

    public String getSelectedStart() {
        return selectedStart;
    }

    public String getSelectedDestination() {
        return selectedDestination;
    }
}
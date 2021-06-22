package ApplicationLayer.View;

import ApplicationLayer.Controller.UserController;
import javafx.scene.layout.VBox;

//neue Imports
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class UserInterface {
    private String error;
    private ArrayList<String> cities;
    private String selectedStart;
    private String selectedDestination;
    private UserController controller;

    //Elemente der GUI
    Stage window;
    Scene scene;
    Button button;
    ComboBox<String> comboBox;

    public UserInterface( ArrayList<String> cities, UserController controller) {
        this.controller = controller;
        this.cities = cities;
        this.init(Gui);
    }

    public Gui{

        window = new Stage();
        window.setTitle("ComboBox Demo");
        button = new Button("Submit");

        comboBox = new ComboBox<String>();
        comboBox.getItems().addAll(
                "A",
                "B",
                "C"
        );

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(button);

        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
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
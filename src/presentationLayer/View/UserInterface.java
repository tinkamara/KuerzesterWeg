package presentationLayer.View;

import presentationLayer.Controller.UserController;

import javax.swing.*;
import java.util.ArrayList;


public class UserInterface {
    private ArrayList<String> cities;
    private String selectedStart;
    private String selectedDestination;
    //Elemente des UI.form:

    private JPanel panelMain;
    private JTextPane OrtStartTextPane;
    private JComboBox<String> comboBox1;
    private JTextPane OrtZielTextPane;
    private JComboBox<String> comboBox2;
    private JTextPane DistanzTextPane;
    private JTextPane DistanceTextPane;
    private JTextPane PathTextPane;

    public UserInterface( ArrayList<String> cities, UserController controller) {
        this.cities = cities;
        this.init();
        this.selectedStart = (String) comboBox1.getSelectedItem();
        this.selectedDestination = (String) comboBox2.getSelectedItem();

        comboBox2.addActionListener(e -> {
            selectedDestination = (String) comboBox2.getSelectedItem();
        controller.actionPerformed(e);
        });
        comboBox1.addActionListener(e -> {
            selectedStart = (String) comboBox1.getSelectedItem();
            controller.actionPerformed(e);
        });
    }


    public UserInterface( String error){
        JFrame frame = new JFrame("Fehler");
        frame.setContentPane(this.panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        PathTextPane.setText(error);
    }

    private void init(){

        for (String elem:cities) {
            comboBox1.addItem(elem);
            comboBox2.addItem(elem);
        }


        JFrame frame = new JFrame("Streckenberechnung");

        frame.setContentPane(this.panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void updateDistance(int distance){
        DistanceTextPane.setText(distance + "km");

    }

    public void updatePath(ArrayList<String> path){

        String pathShown = "";
        for (String city : path){
            pathShown = pathShown.concat( city + "\n");
        }
        PathTextPane.setText(pathShown);
    }

    public void showError(String error){
    PathTextPane.setText(error);
    }

    public String getSelectedStart() {
        return selectedStart;
    }

    public String getSelectedDestination() {
        return selectedDestination;
    }
}
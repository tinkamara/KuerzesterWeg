package presentationLayer.View;

import presentationLayer.Controller.UserController;

import javax.swing.*;
import java.util.ArrayList;


public class UserInterface {
    private ArrayList<String> cities;
    private String selectedStart;
    private String selectedDestination;



    private JPanel panelMain;
    private JLabel startLabel;
    private JComboBox<String> startComboBox;
    private JLabel destinationLabel;
    private JComboBox<String> destinationComboBox;
    private JLabel distanceLabel;
    private JLabel distanceValueLabel;
    private JTextPane PathTextPane;
    private JLabel pathLabel;
    private JScrollPane pathScrollPane;

    public UserInterface( ArrayList<String> cities, UserController controller) {
        this.cities = cities;
        this.init();
        this.selectedStart = (String) startComboBox.getSelectedItem();
        this.selectedDestination = (String) destinationComboBox.getSelectedItem();

        destinationComboBox.addActionListener(e -> {
            selectedDestination = (String) destinationComboBox.getSelectedItem();
        controller.actionPerformed(e);
        });
        startComboBox.addActionListener(e -> {
            selectedStart = (String) startComboBox.getSelectedItem();
            controller.actionPerformed(e);
        });
    }


    public UserInterface( String error){
        JFrame frame = new JFrame("Error");
        frame.setContentPane(this.panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        PathTextPane.setText(error);
    }

    private void init(){

        for (String elem:cities) {
            startComboBox.addItem(elem);
            destinationComboBox.addItem(elem);
        }


        JFrame frame = new JFrame("Routenrechner");

        frame.setContentPane(this.panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public void updateDistance(int distance){
        distanceValueLabel.setText(distance + " km");

    }

    public void updatePath(ArrayList<String> path){

        String pathShown = null;
        if (path.size() <= 1){
            PathTextPane.setText("Wählen Sie \nStartpunkt und Ziel");
        }else {
            for (String city : path) {
                if (pathShown == null){
                    pathShown = city;
                } else
                pathShown = pathShown.concat("\n" + city );
            }
            PathTextPane.setText(pathShown);
        }
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
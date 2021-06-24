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

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UserInterface {
    private String error;
    private ArrayList<String> cities;
    private String selectedStart;
    private String selectedDestination;
    private UserController controller;

    //Elemente des UI.form:
    private JPanel panelMain;
    private JTextPane willkommenWillkommenTextPane;
    private JComboBox comboBox1;
    private JButton button1;

    public UserInterface( ArrayList<String> cities, UserController controller) {
        this.controller = controller;
        this.cities = cities;
        this.init();
    }

    public UserInterface( String error){
        this.error = error;
        this.init();
    }

    private void init(){
        button1.addActionListener(e -> JOptionPane.showMessageDialog(null, "Ich bin ein Looser"));
        button1.setVisible(true);
        comboBox1.setVisible(true);
        panelMain.add(button1);
        panelMain.add(comboBox1);

        for (String elem:cities) {
            comboBox1.addItem(elem);
        }

        JFrame frame = new JFrame("Gui");
        frame.setContentPane(this.panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
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
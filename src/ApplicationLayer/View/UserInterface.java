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

    //Beispielliste:
    private static final String[] stringCities = {"Stadt A", "Stadt B", "Stadt C"};

    //Code, der in eigenem Projekt funktioniert, hier aber nicht:
    public void userInterface() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Ich bin ein Looser");
            }
        });

        for (String elem:stringCities
        ) {comboBox1.addItem(elem);
        }

        comboBox1.addItem("Stadt X");
        comboBox1.addItem("Stadt Y");
        comboBox1.addItem("Stadt Z");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI");
        frame.setContentPane(new UserInterface().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    //Ende meines hinzugefügten Codes

    public UserInterface( ArrayList<String> cities, UserController controller) {
        this.controller = controller;
        this.cities = cities;
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
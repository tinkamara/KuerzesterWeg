package ApplicationLayer.View;

import ApplicationLayer.Controller.UserController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

/*import javafx.scene.layout.VBox;

//neue Imports
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

 */

public class UserInterface {
    private String error;
    private ArrayList<String> cities;
    private String selectedStart;
    private String selectedDestination;
    private UserController controller;

    //Elemente des UI.form:
    private JPanel panelMain = new JPanel();
    private JTextPane OrtStartTextPane;
    private JComboBox comboBox1;
    private JButton button1;
    private JComboBox comboBox2;
    private JTextPane OrtZielTextPane;
    private JTextPane DistanceTextPane;
    private JTextPane PathTextPane;
    private JTextPane DistanzTextPane;

    private int mouse = 13;

    public UserInterface( ArrayList<String> cities, UserController controller) {
        this.controller = controller;
        this.cities = cities;
        this.init();
        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //soll bei Änderung der Werte in ComboBox das Textfeld triggern
            }
        });
    }


    public UserInterface( String error){
        this.error = error;
        this.init();
    }

    private void init(){
        //button1.addActionListener(e -> JOptionPane.showMessageDialog(null, "Ich bin ein Looser"));
        //button1.setVisible(true);
        comboBox1.setVisible(true);
        //panelMain.add(button1);
        panelMain.add(OrtStartTextPane);
        panelMain.add(comboBox1);
        panelMain.add(OrtZielTextPane);
        panelMain.add(comboBox2);
        panelMain.add(DistanzTextPane);
        panelMain.add(DistanceTextPane);
        panelMain.add(PathTextPane);

        for (String elem:cities) {
            comboBox1.addItem(elem);
            comboBox2.addItem(elem);
        }

        String s = String.valueOf(mouse);
        DistanceTextPane.setText(s);

        String listString = "";
        for (String el : cities){
            listString = listString + el + "\n";
        }
        PathTextPane.setText(listString);

        JFrame frame = new JFrame("Streckenberechnung");
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
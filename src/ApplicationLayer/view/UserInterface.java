package ApplicationLayer.view;

import javax.swing.*;

public class UserInterface {
    private JButton berechnenButton;
    private JTextArea messages;
    private JComboBox chooseStart;
    private JComboBox chooseDest;
    private JTextPane start;
    private JTextPane ziel;
    private JTextPane routetext;
    private JScrollPane routeshow;
    private JTextField distance;



    public UserInterface() {
        this.init();
    }

    private void init() {
        berechnenButton = new JButton();
        messages = new JTextArea();
        chooseStart = new JComboBox<String>();
        chooseDest = new JComboBox<String>();
        start = new JTextPane();
        ziel = new JTextPane();
        routetext = new JTextPane();
        routeshow = new JScrollPane();
        distance = new JTextField();
    }
}
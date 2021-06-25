package ApplicationLayer.View;

import javax.swing.*;
import java.util.ArrayList;

public class ServerInterface {

    private final ArrayList<String> serverLog;
    private JPanel mainPanel;
    private JTextPane serverLogTextPane;
    private JButton stopButton;
    private JScrollPane serverLogScrollPane;

    public ServerInterface() {
        this.serverLog = new ArrayList<>();
        JFrame frame = new JFrame("Serverinterface");

        frame.setContentPane(this.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);

        stopButton.addActionListener(buttonClicked -> {
            if (JOptionPane.showConfirmDialog(frame, "Stop server?", "Server",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                System.exit(0);
            } else {
                addToLog("Server nicht gestoppt!");
            }

        });
    }


    public void addToLog(String string) {
        serverLog.add(string);
        String serverLogString = "";
        for (String line : serverLog) {
            serverLogString = serverLogString.concat("\n" + line);
        }
        serverLogTextPane.setText(serverLogString);
    }
}

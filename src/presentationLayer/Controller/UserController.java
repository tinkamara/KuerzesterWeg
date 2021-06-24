package presentationLayer.Controller;

import ApplicationLayer.Model.Graph;
import ApplicationLayer.Model.Path;
import presentationLayer.View.UserInterface;
import DataAccessLayer.NoDataFound;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class UserController implements ActionListener {
    private NoDataFound noDataFound;
    private UserInterface userInterface;
    private Path path;

    public UserController(){

    }

    public UserController(NoDataFound noDataFound){

        this.noDataFound = noDataFound;
    }

    public void startApplication() {
        if (this.noDataFound == null) {
            this.userInterface = new UserInterface(Graph.getCities(), this);
            this.path = new Path(Graph.getCities().get(0), Graph.getCities().get(0), userInterface);
        } else {
            this.userInterface = new UserInterface(noDataFound.getMessage());
        }
    }


    public void actionPerformed(ActionEvent e) {
        this.path = new Path(userInterface.getSelectedStart(), userInterface.getSelectedDestination(), userInterface);

    }
    public void savePath(File file){
        try {
            FileWriter writer = new FileWriter(file);
            int i = 0;
            for(String routePoint : path.calcPath()) {
                i++;
                if (i % 2 == 0) {
                    writer.write(routePoint + ";");

                } else {
                    writer.write(routePoint);
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

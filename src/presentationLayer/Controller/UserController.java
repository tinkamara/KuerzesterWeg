package presentationLayer.Controller;

import ApplicationLayer.Model.Graph;
import ApplicationLayer.Model.Path;
import presentationLayer.View.UserInterface;
import DataAccessLayer.NoDataFound;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserController implements ActionListener {
    private NoDataFound noDataFound;
    private UserInterface userInterface;

    public UserController(){

    }

    public UserController(NoDataFound noDataFound){

        this.noDataFound = noDataFound;
    }

    public void startApplication() {
        if (this.noDataFound == null) {
            this.userInterface = new UserInterface(Graph.getCities(), this);
            new Path(Graph.getCities().get(0), Graph.getCities().get(0), userInterface);
        } else {
            this.userInterface = new UserInterface(noDataFound.getMessage());
        }
    }


    public void actionPerformed(ActionEvent e) {
        new Path(userInterface.getSelectedStart(), userInterface.getSelectedDestination(), userInterface);

    }
}

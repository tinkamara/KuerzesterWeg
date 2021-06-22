package ApplicationLayer.Controller;

import ApplicationLayer.Model.Graph;
import ApplicationLayer.Model.Path;
import ApplicationLayer.View.UserInterface;
import DataAccessLayer.NoDataFound;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserController implements ActionListener {
    private NoDataFound noDataFound;

    public UserController(){
    Path calculatedPath = new Path( "Rostock", "Bonn");
        System.out.println(calculatedPath.getTotalDistance());
        for(String node : calculatedPath.getPath()){
            System.out.println(node);
        }
    }

    public UserController(NoDataFound noDataFound){
        this.noDataFound = noDataFound;
    }

    public void startApplication() {
        if(this.noDataFound == null) {
            UserInterface userInterface = new UserInterface(Graph.getCities());
        }else{
            UserInterface userInterface = new UserInterface(noDataFound.getMessage());
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

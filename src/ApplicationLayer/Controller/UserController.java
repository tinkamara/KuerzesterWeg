package ApplicationLayer.Controller;

import ApplicationLayer.view.UserInterface;
import DataAccessLayer.NoDataFound;

public class UserController {
    private NoDataFound noDataFound;

    public UserController(){

    }

    public UserController(NoDataFound noDataFound){
        this.noDataFound = noDataFound;
    }

    public void startApplication(){
        UserInterface userInterface = new UserInterface();



    }
}

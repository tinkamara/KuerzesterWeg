package MainPackage;

import ApplicationLayer.Controller.ServerController;
import presentationLayer.Controller.UserController;
import DataAccessLayer.NoDataFound;

public class StartApplication {

    public static void main(String[] args) {
        try {
            new ServerController();
            UserController userController = new UserController();
            userController.startApplication();
        }catch(NoDataFound noDataFound) {
            UserController userController = new UserController(noDataFound);
            userController.startApplication();
        }

    }
}

package MainPackage;

import ApplicationLayer.Controller.DataController;
import ApplicationLayer.Controller.UserController;

public class StartApplication {

    public static void main(String[] args) {
        DataController dataController = new DataController();
        UserController userController = new UserController();
        userController.startApplication();
    }
}

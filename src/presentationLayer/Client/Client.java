package presentationLayer.Client;

import presentationLayer.Controller.UserController;

public class Client {
    public static void main(String[] args) {
        UserController userController = new UserController();
        userController.startApplication();
    }
}

package ApplicationLayer.Server;

import ApplicationLayer.Controller.ServerController;

public class ApplicationServer {

    public static void main(String[] args) {
        ServerController serverController = new ServerController();
        serverController.run();

    }

}

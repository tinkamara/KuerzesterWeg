package ApplicationLayer.Server;

import ApplicationLayer.Controller.ServerController;
import DataAccessLayer.NoDataFound;

public class ApplicationServer {

    public static void main(String[] args){
        try{
            ServerController serverController = new ServerController();
            serverController.run();
        } catch (NoDataFound noDataFound){
            System.out.println(noDataFound.getMessage());
        }

        }

}

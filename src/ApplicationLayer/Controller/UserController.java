package ApplicationLayer.Controller;

import ApplicationLayer.Model.Dijkstra;
import ApplicationLayer.view.UserInterface;
import DataAccessLayer.NoDataFound;

public class UserController {
    private NoDataFound noDataFound;

    public UserController(){
    Dijkstra calculatedPath = new Dijkstra( "München", "Hannover");
        System.out.println(calculatedPath.getTotalDistance());
        for(String node : calculatedPath.getPath()){
            System.out.println(node);
        }
    }

    public UserController(NoDataFound noDataFound){
        this.noDataFound = noDataFound;
    }

    public void startApplication() {
        UserInterface userInterface = new UserInterface();
    }
    public void atDestChange(){
      //  Path shortestPath = new Path (start, destination);
        }


}

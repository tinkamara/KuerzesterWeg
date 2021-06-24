package ApplicationLayer.Controller;

import ApplicationLayer.Model.Graph;
import DataAccessLayer.DataAccess;
import DataAccessLayer.NoDataFound;

public class DataController {



    public DataController() throws NoDataFound{
        Graph.init(DataAccess.read("routes"));
    }

}

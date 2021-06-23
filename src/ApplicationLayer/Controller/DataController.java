package ApplicationLayer.Controller;

import DataAccessLayer.DataAccess;
import DataAccessLayer.NoDataFound;

import static ApplicationLayer.Model.Graph.init;

public class DataController {



    public DataController() throws NoDataFound{
        init(DataAccess.read());
    }

}

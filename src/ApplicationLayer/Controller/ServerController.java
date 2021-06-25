package ApplicationLayer.Controller;

import ApplicationLayer.Model.Graph;
import ApplicationLayer.Model.Path;
import DataAccessLayer.DataAccess;
import DataAccessLayer.NoDataFound;
import presentationLayer.Model.AnswerObject;
import presentationLayer.Model.RequestObject;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerController {


    public ServerController() throws NoDataFound {
        Graph.init(DataAccess.read("routes"));
    }
    public void run(){
        AnswerObject answerObject;
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            while (true){
                Socket socket = serverSocket.accept();
                InputStream input = socket.getInputStream();
                ObjectInputStream inputObject = new ObjectInputStream(input);
                RequestObject requestObject = (RequestObject) inputObject.readObject();
                if(requestObject.getStart() == null || requestObject.getDestination() == null){
                    answerObject = new AnswerObject(Graph.getCities(),0);
                }else {
                    Path path = new Path(requestObject.getStart(), requestObject.getDestination());
                    answerObject = new AnswerObject(path.calcPath(), path.getTotalDistance());
                }
                OutputStream output = socket.getOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(output);
                objectOutputStream.writeObject(answerObject);


            }
        } catch (IOException | ClassNotFoundException ioException) {
            ioException.printStackTrace();
        }
    }

}

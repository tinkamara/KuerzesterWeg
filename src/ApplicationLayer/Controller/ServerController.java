package ApplicationLayer.Controller;

import ApplicationLayer.Model.Graph;
import ApplicationLayer.Model.Path;
import ApplicationLayer.View.ServerInterface;
import DataAccessLayer.DataAccess;
import DataAccessLayer.NoDataFound;
import presentationLayer.Model.AnswerObject;
import presentationLayer.Model.RequestObject;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerController {

    private final ServerInterface serverInterface;
    private NoDataFound noDataFound = null;

    public ServerController() {

        this.serverInterface = new ServerInterface();
        try {
            Graph.init(DataAccess.read("routes"));
        } catch (NoDataFound noDataFound) {
            this.noDataFound = noDataFound;
            serverInterface.addToLog(noDataFound.getMessage());
        }
    }

    public void run() {
        AnswerObject answerObject;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(8888);
            //Server will be cancelled via ui
            //noinspection InfiniteLoopStatement
            while (true) {
                Socket socket = serverSocket.accept();
                InputStream input = socket.getInputStream();
                serverInterface.addToLog("Input erhalten");
                ObjectInputStream inputObject = new ObjectInputStream(input);
                RequestObject requestObject = (RequestObject) inputObject.readObject();
                if (noDataFound != null) {
                    answerObject = new AnswerObject(noDataFound.getMessage());
                } else if (requestObject.getStart() == null || requestObject.getDestination() == null) {
                    answerObject = new AnswerObject(Graph.getCities(), 0);
                } else {
                    Path path = new Path(requestObject.getStart(), requestObject.getDestination());
                    answerObject = new AnswerObject(path.calcPath(), path.getTotalDistance());
                }
                OutputStream output = socket.getOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(output);
                objectOutputStream.writeObject(answerObject);
                serverInterface.addToLog("Antwort gesendet");

            }
        } catch (IOException | ClassNotFoundException ioException) {
            serverInterface.addToLog(ioException.getMessage());
        }

    }


}

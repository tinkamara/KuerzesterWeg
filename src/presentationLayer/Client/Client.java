package presentationLayer.Client;

import presentationLayer.Controller.UserController;
import presentationLayer.Model.AnswerObject;
import presentationLayer.Model.RequestObject;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        UserController userController = new UserController();
        userController.startApplication();
    }

    public static AnswerObject requestServer(String start, String destination) {
        AnswerObject answerObject;
        try (Socket socket = new Socket("127.0.0.1", 8888)) {

            OutputStream output = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(output);

            RequestObject requestObject = new RequestObject(start, destination);
            objectOutputStream.writeObject(requestObject);

            PrintWriter writer = new PrintWriter(objectOutputStream, true);

            writer.println(requestObject);
            InputStream input = socket.getInputStream();
            ObjectInputStream inputObject = new ObjectInputStream(input);
            answerObject = (AnswerObject) inputObject.readObject();
            socket.close();
            return answerObject;
        } catch (IOException | ClassNotFoundException e) {
            answerObject = new AnswerObject(e.getMessage());
            return answerObject;
        }
    }
}

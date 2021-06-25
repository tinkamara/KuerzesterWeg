package presentationLayer.Controller;

import ApplicationLayer.Model.Path;
import DataAccessLayer.NoDataFound;
import presentationLayer.Model.AnswerObject;
import presentationLayer.Model.RequestObject;
import presentationLayer.View.UserInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class UserController implements ActionListener {
    private NoDataFound noDataFound;
    private UserInterface userInterface;
    private Path path;
    private AnswerObject currentAnswer;

    public UserController() {

    }

    public UserController(NoDataFound noDataFound) {

        this.noDataFound = noDataFound;
    }

    public void startApplication() {
    serverRequest(null,null);
    this.userInterface = new UserInterface(this.currentAnswer.getPath(), this);
    serverRequest(userInterface.getSelectedStart(), userInterface.getSelectedDestination());
    updatePath();
    updateDistance();
    }


    public void actionPerformed(ActionEvent cityChanged) {
       serverRequest(userInterface.getSelectedStart(), userInterface.getSelectedDestination());
        updatePath();
        updateDistance();

    }

    public void savePath(File file) {
        try {
            File checkedFile = checkFileName(file);

            FileWriter writer = new FileWriter(checkedFile);
            writeFile(writer);
        } catch (IOException notFound) {
            userInterface.showError(notFound.getMessage());
        }
    }
    public void updateDistance(){
        userInterface.updateDistance(this.currentAnswer.getDistance());
    }

    public void updatePath(){
        userInterface.updatePath(this.currentAnswer.getPath());
    }
    public void showError(){
        userInterface.showError(this.currentAnswer.getError());
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public File checkFileName(File file) throws IOException {
        if (file.getName().toLowerCase().endsWith(".csv")) {
            return file;
        } else {
            File newFile = new File(file.getAbsolutePath() + ".csv");
            newFile.createNewFile();
            file.delete();
            return newFile;
        }
    }

    public void writeFile(FileWriter writer) throws IOException {
        int i = 0;
        writer.write("Distanz;Ort;\nStart;");
        for (String routePoint : currentAnswer.getPath()) {
            i++;
            if (i % 2 == 0) {
                writer.write(routePoint + ";");

            } else {
                writer.write(routePoint + ";\n");
            }
        }
        writer.write("\nGesamtstrecke;" + currentAnswer.getDistance() + " km;");
        writer.close();
    }
    public void serverRequest(String start, String destination){
        try (Socket socket = new Socket("127.0.0.1", 8888)) {

            OutputStream output = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(output);

            RequestObject requestObject = new RequestObject(start, destination);
            objectOutputStream.writeObject(requestObject);

            PrintWriter writer = new PrintWriter(objectOutputStream, true);

            writer.println(requestObject);
            InputStream input = socket.getInputStream();
            ObjectInputStream inputObject = new ObjectInputStream(input);
            AnswerObject answerObject = (AnswerObject) inputObject.readObject();
            this.currentAnswer = answerObject;



        } catch (UnknownHostException ex) {

            System.out.println("Server not found: " + ex.getMessage());

        } catch (IOException ex) {

            System.out.println("I/O error: " + ex.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

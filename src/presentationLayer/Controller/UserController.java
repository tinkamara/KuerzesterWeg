package presentationLayer.Controller;

import presentationLayer.Client.Client;
import presentationLayer.Model.AnswerObject;
import presentationLayer.View.UserInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class UserController implements ActionListener {
    private UserInterface userInterface;
    private AnswerObject currentAnswer;

    public UserController() {

    }


    public void startApplication() {
        this.currentAnswer = Client.requestServer(null, null);

        if (this.currentAnswer.getError() == null) {
            this.userInterface = new UserInterface(this.currentAnswer.getPath(), this);
        } else {
            this.userInterface = new UserInterface(this.currentAnswer.getError());
        }

        this.currentAnswer = Client.requestServer(userInterface.getSelectedStart(), userInterface.getSelectedDestination());
        if (this.currentAnswer.getError() == null) {
            updatePath();
            updateDistance();
        } else {
            showError();
        }
    }


    public void actionPerformed(ActionEvent cityChanged) {
       this.currentAnswer= Client.requestServer(userInterface.getSelectedStart(), userInterface.getSelectedDestination());
       if(this.currentAnswer.getError() == null) {
           updatePath();
           updateDistance();
       }else{
           showError();
       }

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

}

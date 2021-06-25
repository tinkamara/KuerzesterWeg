package presentationLayer.Controller;

import ApplicationLayer.Model.Graph;
import ApplicationLayer.Model.Path;
import DataAccessLayer.NoDataFound;
import presentationLayer.View.UserInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class UserController implements ActionListener {
    private NoDataFound noDataFound;
    private UserInterface userInterface;
    private Path path;

    public UserController() {

    }

    public UserController(NoDataFound noDataFound) {

        this.noDataFound = noDataFound;
    }

    public void startApplication() {
        if (this.noDataFound == null) {
            this.userInterface = new UserInterface(Graph.getCities(), this);
            this.path = new Path(Graph.getCities().get(0), Graph.getCities().get(0), userInterface);
        } else {
            this.userInterface = new UserInterface(noDataFound.getMessage());
        }
    }


    public void actionPerformed(ActionEvent cityChanged) {
        this.path = new Path(userInterface.getSelectedStart(), userInterface.getSelectedDestination(), userInterface);

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
        for (String routePoint : path.calcPath()) {
            i++;
            if (i % 2 == 0) {
                writer.write(routePoint + ";");

            } else {
                writer.write(routePoint + ";\n");
            }
        }
        writer.write("\nGesamtstrecke;" + path.getTotalDistance() + " km;");
        writer.close();
    }
}

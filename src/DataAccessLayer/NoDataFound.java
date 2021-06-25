package DataAccessLayer;

public class NoDataFound extends Throwable {

    //message als Attribut für mögliche Erweiterung

    private final String message = "Fehler beim Datenbankzugriff des Servers.";

    public NoDataFound() {

    }

    @Override
    public String getMessage() {
        return this.message;
    }

}

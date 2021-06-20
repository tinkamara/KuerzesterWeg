package DataAccessLayer;

public class NoDataFound extends Throwable{
    private String message;

    public NoDataFound() {
        this.message = "Fehler beim Datenbankzugriff";
    }

    @Override
    public String getMessage() {
        return this.message;
    }

}

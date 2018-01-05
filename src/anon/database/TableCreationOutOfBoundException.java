package anon.database;

public class TableCreationOutOfBoundException extends Throwable {
    @Override
    public String getMessage() {
        return "This Object Already Created A Table";
    }
}
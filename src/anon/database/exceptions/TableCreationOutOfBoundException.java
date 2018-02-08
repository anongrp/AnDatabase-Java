package anon.database.exceptions;

public class TableCreationOutOfBoundException extends Throwable {
    @Override
    public String getMessage() {
        return "This Object Already Created A Table";
    }
}
package anon.database.exceptions;

public class DatabaseConnectionException extends Throwable {
    @Override
    public String getMessage() {
        return "Database Connection Failed Exception";
    }
}

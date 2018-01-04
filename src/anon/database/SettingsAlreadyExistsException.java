package anon.database;

public class SettingsAlreadyExistsException extends Throwable {
    @Override
    public String getMessage() {
        return "Settings Already Exists.";
    }
}
package anon.database;

public class DatabaseNotFoundException extends Throwable {
    private String msg;
    public DatabaseNotFoundException(){
        msg = "DatabaseNotFoundException : Some Problem Occur";
    }

    @Override
    public String getMessage() {
        return msg;
    }
}

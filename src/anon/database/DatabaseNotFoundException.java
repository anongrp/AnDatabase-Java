package anon.database;

public class DatabaseNotFoundException extends Throwable {
    private String msg;
    public DatabaseNotFoundException(){
        msg = "DatabaseNotFoundException , Some Problem Occur";
        System.out.println(msg);
    }
}

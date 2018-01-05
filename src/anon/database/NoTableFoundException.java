package anon.database;

public class NoTableFoundException extends Throwable {
    String msg = "No ";
    public NoTableFoundException(String data){
        msg = msg+data+" Found";
    }
    @Override
    public String getMessage() {
        return msg;
    }
}

package anon.database;

public class ColumnIndexOutOfBoundException extends Throwable {

    @Override
    public String getMessage() {
        return "Column Index Out Of Bound";
    }

}

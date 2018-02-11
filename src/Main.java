import anon.database.*;
import anon.database.connect.Connection;
import anon.database.exceptions.ColumnIndexOutOfBoundException;
import anon.database.exceptions.DatabaseConnectionException;
import anon.database.exceptions.NoTableFoundException;
import anon.database.exceptions.TableCreationOutOfBoundException;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, TableCreationOutOfBoundException, ColumnIndexOutOfBoundException, DatabaseConnectionException, NoTableFoundException {

        Database maindb = null;
        Table login_tb = null;
        String[] column = new String[]{"name","email","dob","phone"};
        String[] data = new String[]{"Anikesh","anikeshpatel4@gmail.com","30/10/1999","9098221375"};
        if (Connection.connect("AnDatabase")){
            maindb = new Database("maindb");
            login_tb = new Table("table1",maindb,column);
        }else {
            System.out.println("Some Erro");
        }

        System.out.println(login_tb.execQuery("update name=Anon where key=4"));
    }
}

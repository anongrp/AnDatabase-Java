import anon.database.*;
import anon.database.connect.Connection;
import anon.database.exceptions.*;

import java.io.File;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, TableCreationOutOfBoundException, ColumnIndexOutOfBoundException, DatabaseConnectionException, NoTableFoundException, FileTypeNotSupportedException {

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

        System.out.println(login_tb.exportToXML(new File("C:/Users/Gaurav/Desktop/data.xml")));
        System.out.println(login_tb.importInANDB("C:/Users/Gaurav/Desktop/data.xml"));
    }
}

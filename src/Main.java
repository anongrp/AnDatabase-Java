import anon.database.*;
import anon.database.connect.Connection;
import anon.database.exceptions.ColumnIndexOutOfBoundException;
import anon.database.exceptions.DatabaseConnectionException;
import anon.database.exceptions.NoTableFoundException;
import anon.database.exceptions.TableCreationOutOfBoundException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


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

        /*ArrayList table = login_tb.getFullTable();
        System.out.println(table);*/

        /*for (int i=0;i<100000;i++){
            login_tb.insertRow(data);
            System.out.println(i);
        }*/

        /*System.out.println(Security.encrypt("AnDatabase",1234567890));
        System.out.println(Security.decrypt(Security.encrypt("AnDatabase",1234567890),1234567890));*/
    }
}

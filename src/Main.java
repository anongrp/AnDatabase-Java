import anon.database.*;
import anon.database.connect.Connection;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws IOException, TableCreationOutOfBoundException, ColumnIndexOutOfBoundException, DatabaseConnectionException, NoTableFoundException {

        Database maindb;
        Table login_tb = null;

        if (Connection.connect("Software_Name")){

            maindb = new Database("mainDatabase");
            login_tb = new Table("Login Data",maindb);
            login_tb.setColumns(new String[]{"Id","First_name","Last_name","Email","Gender","Password"});
        }

        /*System.out.println(login_tb.exportToCSV(new File("C:\\users\\Anikesh\\Desktop\\Data.csv")));*/
    }
}

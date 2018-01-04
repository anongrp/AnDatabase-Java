import anon.database.*;
import anon.database.connect.Connection;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) throws IOException, DatabaseNotFoundException, ColumnIndexOutOfBoundException, TableCreationOutOfBoundException {

        Connection.connect("Tublime Text");
        Database mainDB = new Database("mainDB");
        Table studentTB = new Table();
        studentTB.createTable("MainTB",mainDB);
        String[] colName = new String[]{"id", "name","email"};
        String[] rowData = new String[]{"6","sahitya","lucky@gmail.com"};
        studentTB.setColumns(colName);
        studentTB.addRow(rowData);

        studentTB.createTable("Second",mainDB);


    }
}


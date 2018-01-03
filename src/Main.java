import anon.database.ColumnIndexOutOfBoundException;
import anon.database.Database;
import anon.database.DatabaseNotFoundException;
import anon.database.Table;
import anon.database.connect.Connection;

import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException, DatabaseNotFoundException, ColumnIndexOutOfBoundException {

        Connection.connect("Tublime Text");
        Database mainDB = new Database("mainDB");
        Table studentTB = new Table();
        studentTB.createTable("MainTB",mainDB);
        String[] colName = new String[]{"id", "name","email"};
        String[] rowData = new String[]{"1","Anikesh","anikeshpatel4@gmail.com"};
        studentTB.addColumns(colName);
        studentTB.addRow(rowData);

        studentTB.deleteElement("name","Gaurav");

    }
}


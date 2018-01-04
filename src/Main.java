import anon.database.*;
import anon.database.connect.Connection;
import java.io.IOException;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) throws IOException, DatabaseNotFoundException, ColumnIndexOutOfBoundException, SettingsAlreadyExistsException, TableCreationOutOfBoundException {

        Connection.connect("Tublime Text");
        Database mainDB = new Database("mainDB");
        Table studentTB = new Table();
        studentTB.createTable("MainTB",mainDB);
        //studentTB.createTable("table2",mainDB);
        String[] colName = new String[]{"id", "name","email"};
        String[] rowData = new String[]{"6","sahitya","lucky@gmail.com"};
        studentTB.setColumns(colName);
        studentTB.addRow(rowData);
        ArrayList<String> a1=studentTB.getRow("name","sahitya");
        System.out.println(a1);

        //AnDatabase.Settings.setCaseSensitivity(false);
        System.out.println(Security.decrypt(Security.encrypt("Anikesh",7864),7864));

    }
}


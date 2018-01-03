import anon.database.Database;
import anon.database.DatabaseNotFoundException;
import anon.database.Table;
import anon.database.connect.Connection;

import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException, DatabaseNotFoundException {

        if (Connection.connect("Tublime Text")){
            Database mainDB = new Database("mainDB");
            Table studentTB = new Table();
            studentTB.createTable("MainTB",mainDB);
        }else{
            throw new DatabaseNotFoundException();
        }
    }
}


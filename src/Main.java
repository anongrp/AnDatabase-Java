import anon.database.Database;
import anon.database.Table;
import anon.database.connect.Connection;

import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException {

        if (Connection.connect("Tublime Text")){
            System.out.println("Connection Ok");
            Database mainDB = new Database("mainDB");
            Database primaryDB = new Database("Primary");
            Table studentTB = new Table("MainTB1",mainDB);
            studentTB.addColumn("id");
            studentTB.addColumn("name");

        }else{
            System.out.println("Not Ok");
        }
    }
}


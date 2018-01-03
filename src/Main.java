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
            Table table=new Table("table3",2,primaryDB);
            String col[]={"name","Email","Mobile NO."};
            table.addColumn(col);
            String row1[]={"gaurav","gauravthakur40127@gmail.com","   8871568598"};
            table.addRow(row1);

        }else{
            System.out.println("Not Ok");
        }
    }
}
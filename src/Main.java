import anon.database.Database;
import anon.database.Table;
import anon.database.connect.Connection;

public class Main{
    public static void main(String[] args) {

        if (Connection.connect("Tublime Text")){
            System.out.println("Connection Ok");
            Database mainDB = new Database("mainDB");
            Database primaryDB = new Database("Primary");
            Table studentTB = new Table("MainTB",mainDB);
        }else{
            System.out.println("Not Ok");
        }
    }
}

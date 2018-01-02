package anon.database;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Table {
    private String tbName = "tb-temp";
    private File tbDir;
    private boolean status=false;

    // Default Constructor
    public Table(){}

    // Constructor
    public Table(String tbName,Integer column,Database database){
        createTable(tbName,column,database);
    }

    /* Method For Create Table */
    public boolean createTable(String tbName,Database database) {
        this.tbName = "tb-"+tbName;
        tbDir = new  File(database.dbDir.getAbsolutePath()+"\\"+this.tbName);

        if (database.dbStatus){
            tbDir.mkdir();
            status=true;
        }
        return false;
    }

}

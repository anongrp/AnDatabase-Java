package anon.database;
import java.io.File;

public class Table {
    private String tbName = "tb-temp";
    private Integer column;
    private File tbDir;
    private boolean status=false;

    // Default Constructor
    public Table(){}

    // Constructor
    public Table(String tbName,Integer column,Database database){
        createTable(tbName,column,database);
    }

    /* Method For Create Table */
    public boolean createTable(String tbName,Integer column,Database database) {
        this.tbName = "tb-"+tbName;
        this.column = column;
        tbDir = new  File(database.dbDir.getAbsolutePath()+"\\"+this.tbName);

        if (database.dbStatus){
            tbDir.mkdir();
            status=true;
        }
        return false;
    }
}
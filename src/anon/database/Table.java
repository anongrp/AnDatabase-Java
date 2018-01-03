package anon.database;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Table {
    private String tbName = "tb-temp";
    private File tbDir;
    private boolean status=false;
    private int countForColumn=0;
    private int countForRow=0;

    // Default Constructor
    public Table(){}

    // Constructor
    public Table(String tbName,Database database) throws IOException {
        createTable(tbName,database);
    }

    /* Method For Create Table */
    public boolean createTable(String tbName, Database database) throws IOException {
        this.tbName = "tb-"+tbName;
        tbDir = new  File(database.dbDir.getAbsolutePath()+"\\"+this.tbName+".andb");

        if (database.dbStatus){
            tbDir.createNewFile();
            status=true;
        }
        return false;
    }
    public void addColumn(String ColumnName) throws IOException {
        countForColumn++;
        BufferedWriter WriteColumnData=new BufferedWriter(new FileWriter(tbDir,true));
        WriteColumnData.write("¤ȸ"+countForColumn+ColumnName);
        WriteColumnData.close();
    }

}





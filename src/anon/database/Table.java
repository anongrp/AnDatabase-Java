package anon.database;
import java.io.*;

public class Table {
    private String tbName = "tb-temp";
    private File tbDir;
    private boolean status = false;
    private int countForColumn = 0;
    private int countForRow = 0;
    private int columns;


    // Default Constructor
    public Table() {  }

    // Constructor
    public Table(String tbName, Database database) throws IOException {
        createTable(tbName, database);
    }

    /* Method For Create Table */
    public boolean createTable(String tbName, Database database) throws IOException {
        this.tbName = "tb-" + tbName;
        tbDir = new File(database.dbDir.getAbsolutePath() + "\\" + this.tbName + ".andb");
        if (database.isDatabaseAvailable() && !(tbDir.exists())) {
            tbDir.createNewFile();
            status = true;
        }
        return false;
    }


    public boolean isTableAvailable(){
        return tbDir.exists();
    }


    public void addColumns(String columnName[]) throws IOException {
        countForColumn++;
        columns = columnName.length;
        BufferedWriter writeColumnData = new BufferedWriter(new FileWriter(tbDir, true));
        if (tbDir.length() == 0){
            for (int i = 0; i < columnName.length; i++) {
                writeColumnData.write("¤*ȸ" + columnName[i]);
            }
            writeColumnData.write("¤*ȸ");
        }
        writeColumnData.close();
    }

    public void addRow(String RowName[]) throws IOException, ColumnIndexOutOfBoundException {
        countForRow++;
        BufferedWriter writeRowData = new BufferedWriter(new FileWriter(tbDir, true));
        writeRowData.newLine();
        for (int i = 0; i < RowName.length; i++) {
            if (i+1 > columns) {
                throw new ColumnIndexOutOfBoundException();
            } else {
                writeRowData.write("ȸ" + RowName[i]);
            }
        }
        writeRowData.close();
    }
}
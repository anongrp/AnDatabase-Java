package anon.database;
import java.io.*;
import java.util.HashMap;
import java.util.Hashtable;

public class Table {
    private String tbName = "tb-temp";
    private File tbDir;
    private boolean status = false;
    private int countForColumn = 0;
    private int countForRow = 0;
    private int columns;
    private HashMap<Integer,String> colInfo = new HashMap<>();


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


    public void addColumns(String columnNames[]) throws IOException {
        countForColumn++;
        columns = columnNames.length;
        setColInfo(columnNames);
        BufferedWriter writeColumnData = new BufferedWriter(new FileWriter(tbDir, true));
        if (tbDir.length() == 0){
            for (int i = 0; i < columnNames.length; i++) {
                writeColumnData.write("¤" + columnNames[i]);
            }
            writeColumnData.write("¤");
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
        writeRowData.write("ȸ");
        writeRowData.close();
    }


    private void setColInfo(String[] colNames){
        for (int i=1;i<=colNames.length;i++){
            colInfo.put(i,colNames[i-1]);
        }
    }


    private String getDataFromRow(String row, Integer index){
        row = "ȸ 1 ȸ Anikesh ȸ anikeshpatel4@gmail.com ȸ";
        index = 2;

        return row;
    }
}






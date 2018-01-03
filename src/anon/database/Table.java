package anon.database;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Table {
    private String tbName = "tb-temp";
    private File tbDir;
    private boolean status = false;
    private int countForColumn = 0;
    private int countForRow = 0;
    private Integer Column = 0;

    // Default Constructor
    public Table() {  }

    // Constructor
    public Table(String tbName, Integer Column, Database database) throws IOException {
        createTable(tbName, database);
        this.Column = Column;
    }

    /* Method For Create Table */
    public boolean createTable(String tbName, Database database) throws IOException {
        this.tbName = "tb-" + tbName;
        tbDir = new File(database.dbDir.getAbsolutePath() + "\\" + this.tbName + ".andb");

        if (database.isDatabaseAvailable()) {
            tbDir.createNewFile();
            System.out.println("table created");
            status = true;
        }
        return false;
    }



    public void addColumn(String ColumnName[]) throws IOException {
        countForColumn++;
        if (countForColumn > Column) {
            throw new ArrayIndexOutOfBoundsException("Column Index Out Of Bound.");
        }
        BufferedWriter WriteColumnData = new BufferedWriter(new FileWriter(tbDir, true));
        for (int i = 0; i < ColumnName.length; i++) {
            WriteColumnData.write("¤ȸ" + (i+1) + ColumnName[i]);
        }
        WriteColumnData.close();
    }

    public void addRow(String RowName[]) throws IOException {
        countForRow++;
        BufferedWriter WriteRowData = new BufferedWriter(new FileWriter(tbDir, true));
        WriteRowData.newLine();
        for (int i = 0; i < RowName.length; i++) {
            if (i > Column) {
                throw new ArrayIndexOutOfBoundsException("Row Index Out Of Bound.");
            } else {
                WriteRowData.write("ȸ" + (i+1) + RowName[i]);
            }
        }
        WriteRowData.close();
    }
}
package anon.database;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Table {
    private String tbName = "tb-temp";
    public File tbDir;
    private boolean status = false;
    private int columns;
    private String[] columnNames;
    private HashMap<String,Integer> colInfo = new HashMap<>();


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
        return status;
    }


    public boolean isTableAvailable(){
        return tbDir.exists();
    }


    public void setColumns(String columnNames[]) throws IOException {
        columns = columnNames.length;
        this.columnNames = columnNames;
        setColInfo(columnNames);
        if (tbDir.length() == 0){
            BufferedWriter writeColumnData = new BufferedWriter(new FileWriter(tbDir, true));
            for (int i = 0; i < columnNames.length; i++) {
                writeColumnData.write("¤" + columnNames[i]);
            }
            writeColumnData.write("¤");
            writeColumnData.close();
        }
    }


    public void addRow(String RowName[]) throws IOException, ColumnIndexOutOfBoundException {
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
            colInfo.put(colNames[i-1],i);
        }
    }


    private int counter(String rowData,Character target){
        char[] data = rowData.toCharArray();
        Integer count=0;
        for (int i=0;i<data.length;i++){
            if (data[i]==target){
                count++;
            }
        }
        return count;
    }


    private ArrayList<String> searcher(String data,String colName) throws IOException {
        Integer rowNo = colInfo.get(colName);
        Integer dataNo;
        BufferedReader readRowData = new BufferedReader(new FileReader(tbDir));
        String rowData;
        ArrayList<String> finalData = new ArrayList<String>();
        while ((rowData = readRowData.readLine()) != null){
            if (rowData.contains(data)){
                dataNo = counter(rowData.substring(0,rowData.indexOf(data)),'ȸ');
                if (rowNo.equals(dataNo)){
                    finalData.add(rowData);
                }
            }
        }
        return finalData;
    }


    private String getDataFromTable(String row,String colName){
        return getFetchedData(row).get(colInfo.get(colName));
    }


    public boolean deleteElement(String colName,String target) throws IOException {
        boolean deleteStatus = false;
        String deleteRow = "";
        ArrayList<String> rows = new ArrayList<String>();
        ArrayList<String> finalRow = searcher(target,colName);
        if (!finalRow.isEmpty()){
            deleteRow = finalRow.get(0);
        }
        BufferedWriter tableWriter = new BufferedWriter(new FileWriter(tbDir,true));
        BufferedReader tableReader = new BufferedReader(new FileReader(tbDir));
        String data;
        try {
            while ((data = tableReader.readLine()) != null){
                if (!data.equals(deleteRow)){
                    rows.add(data);
                }
            }
            PrintWriter writer = new PrintWriter(tbDir);
            writer.print("");
            writer.close();
            ;
            for (int j=0;j<rows.size();j++){
                if (!(rows.get(j).equals(""))){
                    tableWriter.write(rows.get(j));
                    if (!(rows.size() == j+1)){
                        tableWriter.newLine();
                    }
                }
            }
            deleteStatus = true;
        }catch (Exception e){
            deleteStatus = false;
        }finally {
            tableReader.close();
            tableWriter.close();
            return deleteStatus;
        }
    }


    private ArrayList<String> getFetchedData(String fullRow){
        ArrayList<Integer> symbolPositions = new ArrayList<Integer>();
        ArrayList<String> fechedData = new ArrayList<String>();
        if (fullRow != null){
            char[] dataArray = fullRow.toCharArray();
            for (int i=0;i<dataArray.length;i++){
                if (dataArray[i] == 'ȸ'){
                    symbolPositions.add(i);
                }
            }
            try {
                for (int j=0;j<symbolPositions.size();j++){
                    fechedData.add(fullRow.substring(symbolPositions.get(j)+1,symbolPositions.get(j+1)));
                }
            }catch (Exception ignored){
            }
        }else {
            fechedData.add(null);
        }
        return fechedData;
    }


    public ArrayList<String> getRow(String colName,String target) throws IOException {
        String row = null;
        try {
            row = searcher(target,colName).get(0);
        }catch (Exception ignored){
        }finally {
            return getFetchedData(row);
        }
    }
}






package anon.database;
import anon.database.exceptions.ColumnIndexOutOfBoundException;
import anon.database.exceptions.TableCreationOutOfBoundException;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Table {
    private Integer primaryKey;
    private String tbName = "tb-temp";
    public File tbDir;
    private Integer objectCallCounter=0;
    private boolean status = false;
    private int noOfColumns;
    private String[] columnNames;
    private HashMap<String,Integer> colInfo = new HashMap<>();


    // Default Constructor
    public Table() { }

    // Constructor
    public Table(String tbName, Database database) throws IOException, TableCreationOutOfBoundException {
        createTable(tbName, database);
    }

    /* Method For Create Table */
    public boolean createTable(String tbName, Database database) throws IOException, TableCreationOutOfBoundException {
        objectCallCounter++;
        if (objectCallCounter>1)
            throw new TableCreationOutOfBoundException();
        else {
            this.tbName = "tb-" + tbName;
            tbDir = new File(database.dbDir.getAbsolutePath() + File.separator + this.tbName + ".andb");
            if (database.isDatabaseAvailable() && !(tbDir.exists())) {
                tbDir.createNewFile();
                status = true;
            }
            return status;
        }
    }


    public boolean isTableAvailable(){
        return tbDir.exists();
    }


    public void setColumns(String columnNames[]) throws IOException {

        String[] columns = new String[columnNames.length+1];
        columns[0] = "key";
        for (int i=1;i<columns.length;i++){
            columns[i] = columnNames[i-1];
        }
        noOfColumns = columns.length;
        this.columnNames = columns;
        setColInfo(columnNames);
        if (tbDir.length() == 0){
            BufferedWriter writeColumnData = new BufferedWriter(new FileWriter(tbDir, true));
            for (int i = 0; i < columns.length; i++) {
                writeColumnData.write("¤" + columns[i]);
            }
            writeColumnData.write("¤");
            writeColumnData.close();
        }
    }


    public void addRow(String row[]) throws IOException, ColumnIndexOutOfBoundException {
        String[] finalRow = new String[row.length + 1];
         if (rowCounter() == 1){
             primaryKey = 1;
             finalRow[0] = primaryKey.toString();
             for (int i=1;i<finalRow.length;i++){
                 finalRow[i] = row[i-1];
             }

         }else {
             BufferedReader reader = new BufferedReader(new FileReader(tbDir));
             String lastRow = "",temp;
             while ((temp = reader.readLine()) != null){
                 lastRow = temp;
             }
             ArrayList<String> lastRowData = getFetchedData(lastRow);
             primaryKey = Integer.parseInt(lastRowData.get(0)) + 1;

             finalRow[0] = primaryKey.toString();
             for (int i=1;i<finalRow.length;i++){
                 finalRow[i] = row[i-1];
             }
         }

        BufferedWriter writeRowData = new BufferedWriter(new FileWriter(tbDir, true));
        writeRowData.newLine();
        if (noOfColumns < finalRow.length) {
            throw new ColumnIndexOutOfBoundException();
        }
        else if (noOfColumns > finalRow.length){
            Integer blankCell = noOfColumns - finalRow.length;
            for (int i = 0; i < finalRow.length; i++) {
                writeRowData.write("ȸ" + finalRow[i]);
            }
            for (int i=0;i<blankCell;i++){
                writeRowData.write("ȸ" + "Null");
            }
            writeRowData.write("ȸ");
            writeRowData.close();
        }
        else {
            for (int i = 0; i < finalRow.length; i++) {
                writeRowData.write("ȸ" + finalRow[i]);
            }
            writeRowData.write("ȸ");
            writeRowData.close();
        }
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

    private int rowCounter() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(tbDir));
        String data;
        Integer counter = 0;
        while ((data = reader.readLine()) != null){
            counter++;
        }
        return counter;
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
                if (dataArray[i] == 'ȸ' || dataArray[i] == '¤'){
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


    public ArrayList<ArrayList<String>> getTable(Integer limit) throws IOException {
        ArrayList<ArrayList<String>> tableData = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(tbDir));
        String rowData;
        for (int i=0;i<limit;i++){
            rowData = reader.readLine();
            tableData.add(getFetchedData(rowData));
        }
        return tableData;
    }


    public ArrayList<ArrayList<String>> getFullTable() throws IOException {
        ArrayList<ArrayList<String>> tableData = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(tbDir));
        String rowData;
        while ((rowData = reader.readLine()) != null){
            tableData.add(getFetchedData(rowData));
        }
        return tableData;
    }


    public boolean exportToCSV(File csvFile) throws IOException {
        boolean status = false;
        final String COMMA_DELIMITER = ",";
        final String NEW_LINE_SEPARATOR = "\n";

        ArrayList<ArrayList<String>> tableData = getFullTable();

        FileWriter writer = null;
        try {
            csvFile.createNewFile();
            writer = new FileWriter(csvFile);
            Integer counter = -1;
            for (Object i : tableData){
                counter++;
                for (Object j : tableData.get(counter)){
                    writer.append(j.toString());
                    writer.append(COMMA_DELIMITER);
                }
                writer.append(NEW_LINE_SEPARATOR);
            }
            status = true;
            writer.close();
        }catch (Exception e){
            status = false;
        }
        return status;
    }

    public boolean exportToJSON(File jsonFile) throws IOException {
        boolean status = false;
        final String COMMA_DELIMITER = ",";
        final String NEW_LINE_SEPARATOR = "\n";
        final String DATA_SEPARATOR = ":";
        final String BRACKET_OPEN = "{";
        final String BRACKET_CLOSE = "}";
        final String SINGLE_TAB = "\t";
        final String DOUBLE_TAB = "\t\t";

        ArrayList<ArrayList<String>> tableData = getFullTable();
        FileWriter writer = null;
        Integer tempCounter = 0;
        try {
            jsonFile.createNewFile();
            writer = new FileWriter(jsonFile);
            writer.append(BRACKET_OPEN+NEW_LINE_SEPARATOR+SINGLE_TAB+'"'+tbName.substring(tbName.indexOf("-")+1,tbName.length())+'"'+": ["+NEW_LINE_SEPARATOR);

            for (ArrayList<String> row:tableData){
                writer.append(SINGLE_TAB+BRACKET_OPEN);
                for (int i=0;i<row.size();i++){
                    writer.append(SINGLE_TAB+NEW_LINE_SEPARATOR+DOUBLE_TAB+'"'+columnNames[i]+'"'+DATA_SEPARATOR+'"'+row.get(i)+'"'+COMMA_DELIMITER);
                }
                if (tempCounter+1 < tableData.size()){
                    writer.append(NEW_LINE_SEPARATOR+SINGLE_TAB+BRACKET_CLOSE+COMMA_DELIMITER+NEW_LINE_SEPARATOR);
                }else {
                    writer.append(NEW_LINE_SEPARATOR+SINGLE_TAB+BRACKET_CLOSE+COMMA_DELIMITER);
                }
                tempCounter++;
            }

            writer.append("]"+NEW_LINE_SEPARATOR+BRACKET_CLOSE);

        }catch (Exception e){
            status = false;
        }finally {
            writer.close();
        }

        return status;
    }


    @Override
    public String toString() {
        ArrayList<ArrayList<String>> list = null;
        try {
            list = this.getFullTable();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Integer count=0;
        if (list != null){
            for (ArrayList data : list){
                if (count.equals(0))
                    System.out.println("   "+data);
                else
                    System.out.println(count+") "+data);
                count++;
            }
        }
        return "\n\n"+super.toString();
    }
}

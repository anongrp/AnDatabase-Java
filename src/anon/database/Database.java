package anon.database;

import anon.database.connect.Connection;
import anon.database.exceptions.DatabaseConnectionException;
import anon.database.exceptions.NoTableFoundException;

import java.io.File;
import java.util.ArrayList;

public class Database {
    private String dbName="db-temp";
    private boolean dbStatus;
    public File dbDir;

    //  Default Constructor
    public Database(){ }

    //  Constructor
    public Database(String dbName) throws DatabaseConnectionException {
        createDB(dbName);
    }

    /*  Method For Creating DB  */
    public boolean createDB(String dbName) throws DatabaseConnectionException {
        this.dbName = "db-" + dbName;
        dbDir = new File(Connection.dbLocation + File.separator + this.dbName);

        if (!dbDir.exists() && Connection.status){
            dbDir.mkdir();
            dbStatus = true;
        }
        if (!Connection.status){
            throw new DatabaseConnectionException();
        }
        return dbStatus;
    }

    public boolean isDatabaseAvailable(){
        return dbDir.exists();
    }

    public String getDataBaseName() {
        return dbName.substring(dbName.indexOf("-")+1,dbName.length());
    }

    public boolean getDatabaseStatus(){
        return dbStatus;
    }

    public ArrayList<String> listTables() throws NoTableFoundException {
        File[] tablesDir = dbDir.listFiles();
        ArrayList<String> listTables = new ArrayList<>();
        String tableName;
        try {
            for (int i=0;i<tablesDir.length;i++){
                if (tablesDir[i].isFile()){
                    tableName = tablesDir[i].getName();
                    tableName = tableName.substring(tableName.indexOf("-")+1,tableName.indexOf("."));
                    listTables.add(tableName);
                }
            }
        }catch (Exception e){
            throw new NoTableFoundException("Tables");
        }
        return listTables;
    }

    @Override
    public String toString() {
        ArrayList<String> tables;
        try {
            tables = this.listTables();
            if (tables.size() == 0){
                tables = null;
            }
        } catch (NoTableFoundException e) {
            tables = null;
        }

        System.out.println("Database Name : "+this.getDataBaseName()+"\n");
        System.out.println("Total Tables In "+this.getDataBaseName()+" : ");
        Integer count=0;
        if (tables != null){
            for (String table : tables){
                count++;
                System.out.println(count+". "+table);
            }
        }else {
            System.out.println("No Tables");
        }
        return "\n\n"+super.toString();
    }

    /*public boolean exportDatabase(String pathForDatabase){
        boolean status = false;
        File dbDir = new File(pathForDatabase+dbName);
        File[] tables = this.dbDir.listFiles();
        try {
            dbDir.mkdir();
            for (int i=0;i<tables.length;i++){
                if (tables[i].isFile()){
                    // Code Here
                }
            }
        }catch (Exception e){
            status = false;
        }finally {
            return status;
        }
    }*/

}
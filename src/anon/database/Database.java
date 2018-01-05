package anon.database;

import anon.database.connect.Connection;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
        dbDir = new File(Connection.dbLocation + "\\" + this.dbName);

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
        return dbName;
    }

    public boolean getDatabaseStatus(){
        return dbStatus;
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
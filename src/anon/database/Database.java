package anon.database;

import anon.database.connect.Connection;
import java.io.File;

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
}
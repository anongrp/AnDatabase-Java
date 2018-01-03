package anon.database;

import anon.database.connect.Connection;

import java.io.File;

public class Database {
    private String dbName="db-temp";
    public boolean dbStatus=false;
    public File dbDir;

    //  Default Constructor
    public Database(){ }

    //  Constructor
    public Database(String dbName){
        createDB(dbName);
    }

    /*  Method For Creating DB  */
    public boolean createDB(String dbName) {
        this.dbName = "db-" + dbName;
        dbDir = new File(Connection.dbLocation + "\\" + this.dbName);

        if (!dbDir.exists() && Connection.status){

            System.out.println(dbDir.getAbsolutePath());
            dbDir.mkdir();
            dbStatus = true;
        }
        return dbStatus;
    }


    public String getDataBaseName() {
        return dbName;
    }

    public boolean getDatabaseStatus(){
        return dbStatus;
    }
}
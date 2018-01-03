package anon.database.drop;

import anon.database.Database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DropDatabase {
    public static boolean drop(Database dropDatabase) throws IOException {
        boolean dropStatus = false;
        try {
            Files.delete(Paths.get(dropDatabase.dbDir.getAbsolutePath()));
            dropStatus = true;
        }catch (Exception e){
            dropStatus = false;
        }finally {
            return dropStatus;
        }
    }
}

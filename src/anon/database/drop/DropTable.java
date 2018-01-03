package anon.database.drop;

import anon.database.Table;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DropTable {
    public static boolean drop(Table dropTable) throws IOException {
        boolean dropStatus = false;
        try {
            Files.delete(Paths.get(dropTable.tbDir.getAbsolutePath()));
            dropStatus = true;
        }catch (Exception e){
            dropStatus = false;
        }finally {
            return dropStatus;
        }
    }
}

package anon.database;
import anon.database.connect.Connection;
import java.io.*;

public class AnDatabase {

    private static final String ANONDBDIR = "C:\\Users\\"+System.getProperty("user.name")+"\\AppData\\Roaming\\andb";
    private static File mainPrefFile = new File(ANONDBDIR+"\\"+Connection.projectName+".pref");
    private static BufferedWriter writer;
    public AnDatabase() throws IOException {
        File mainPrefDir = new File(ANONDBDIR);
        if (!mainPrefDir.exists())
            mainPrefDir.mkdir();
        if (!mainPrefFile.exists())
            mainPrefFile.createNewFile();
    }

    public static class Settings{
        public static void setEncryptionKey(Integer key) throws IOException {
            writer = new BufferedWriter(new FileWriter(mainPrefFile,true));
            writer.write("{key:"+key+"}");
            writer.newLine();
            writer.close();
        }
        public static void setRealTimeEncryption(boolean response) throws IOException {
            writer = new BufferedWriter(new FileWriter(mainPrefFile,true));
            writer.write("{realTimeEncryption:"+response+"}");
            writer.newLine();
            writer.close();
        }
        public static void setCaseSensitivity(boolean response) throws IOException {
            writer = new BufferedWriter(new FileWriter(mainPrefFile,true));
            writer.write("{caseSensitivity:"+response+"}");
            writer.newLine();
            writer.close();
        }

    }


}
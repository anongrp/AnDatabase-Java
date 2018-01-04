package anon.database;
import anon.database.connect.Connection;

import java.io.*;
import java.security.*;
public class AnDatabase {

    private final String ANONDBDIR = "C:\\Users\\"+System.getProperty("user.name")+"\\AppData\\Roaming\\andb";
    private File mainPrefFile = new File(ANONDBDIR+"\\"+Connection.projectName+".pref");
    private BufferedWriter writer;
    public AnDatabase() throws IOException {
        File mainPrefDir = new File(ANONDBDIR);
        if (!mainPrefDir.exists())
            mainPrefDir.mkdir();
        if (!mainPrefFile.exists())
            mainPrefFile.createNewFile();
    }

    public class Settings{
        public void setEncryptionKey(Integer key) throws IOException {
            writer = new BufferedWriter(new FileWriter(mainPrefFile,true));
            writer.write("{key:"+key+"}");
            writer.newLine();
            writer.close();
        }
        public void setRealTimeEncryption(boolean response) throws IOException {
            writer = new BufferedWriter(new FileWriter(mainPrefFile,true));
            writer.write("{realTimeEncryption:"+response+"}");
            writer.newLine();
            writer.close();
        }

    }

    public Settings getSetting(){
        return new Settings();
    }

    public void encryptor(String data){

    }

}
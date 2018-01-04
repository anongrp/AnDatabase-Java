package anon.database;
import anon.database.connect.Connection;

import java.io.*;
public class AnDatabase {

    /*private static final String ANONDBDIR = "C:\\Users\\"+System.getProperty("user.name")+"\\AppData\\Roaming\\andb";
    private static File mainPrefFile = new File(ANONDBDIR+"\\"+Connection.projectName+".pref");
    private static BufferedWriter writer;
    public AnDatabase() throws IOException {
    }
    public static class Settings {
        private static Boolean funExists = true;
        private static boolean isFunctionExists(String functionName) {
            try {
                BufferedReader readPrefFile = new BufferedReader(new FileReader(mainPrefFile));
                while (readPrefFile.readLine() != null) {
                    if (readPrefFile.readLine().contains(functionName)) {
                        funExists = false;
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                return funExists;
            }
        }
        public static void setEncryptionKey(Integer key) throws IOException, SettingsAlreadyExistsException {
            File mainPrefDir = new File(ANONDBDIR);
            if (!mainPrefDir.exists()) {
                mainPrefDir.mkdir();
                mainPrefFile.createNewFile();
                writer = new BufferedWriter(new FileWriter(mainPrefFile, true));
                writer.write("{key:" + key + "}");
                writer.newLine();
                writer.close();
            } else {
                if (!mainPrefFile.exists()) {
                    mainPrefFile.createNewFile();
                    writer = new BufferedWriter(new FileWriter(mainPrefFile, true));
                    writer.write("{key:" + key + "}");
                    writer.newLine();
                    writer.close();
                } else {
                    Boolean funExists = isFunctionExists("setEncryptionKey");
                    if (!funExists) {
                        writer = new BufferedWriter(new FileWriter(mainPrefFile, true));
                        writer.write("{key:" + key + "}");
                        writer.newLine();
                        writer.close();
                    } else {
                        throw new SettingsAlreadyExistsException();
                    }
                }
            }
        }
        public static void setRealTimeEncryption(boolean response) throws IOException, SettingsAlreadyExistsException {
            File mainPrefDir = new File(ANONDBDIR);
            if (!mainPrefDir.exists()) {
                mainPrefDir.mkdir();
                mainPrefFile.createNewFile();
                writer = new BufferedWriter(new FileWriter(mainPrefFile, true));
                writer.write("{realTimeEncryption:" + response + "}");
                writer.newLine();
                writer.close();
            } else {
                if (!mainPrefFile.exists()) {
                    mainPrefFile.createNewFile();
                    writer = new BufferedWriter(new FileWriter(mainPrefFile, true));
                    writer.write("{realTimeEncryption:" + response + "}");
                    writer.newLine();
                    writer.close();
                }
                else{
                    Boolean funExists = isFunctionExists("setRealTimeEncryption");
                    if (!funExists) {
                        writer = new BufferedWriter(new FileWriter(mainPrefFile, true));
                        writer.write("{realTimeEncryption:" + response + "}");
                        writer.newLine();
                        writer.close();
                    } else {
                        throw new SettingsAlreadyExistsException();
                    }
                }
            }
        }
        public static void setCaseSensitivity(Boolean response) throws IOException, SettingsAlreadyExistsException {
            File mainPrefDir = new File(ANONDBDIR);
            if (!mainPrefDir.exists())
            {
                mainPrefDir.mkdir();
                mainPrefFile.createNewFile();
                writer = new BufferedWriter(new FileWriter(mainPrefFile,true));
                writer.write("{caseSensitivity:"+response+"}");
                writer.newLine();
                writer.close();
            }
            else {
                if (!mainPrefFile.exists())
                {
                    mainPrefFile.createNewFile();
                    writer = new BufferedWriter(new FileWriter(mainPrefFile,true));
                    writer.write("{caseSensitivity:"+response+"}");
                    writer.newLine();
                    writer.close();
                }
                else {
                    Boolean funExists=isFunctionExists("setCaseSensitivity");
                    if (!funExists)
                    {
                        writer = new BufferedWriter(new FileWriter(mainPrefFile,true));
                        writer.write("{caseSensitivity:"+response+"}");
                        writer.newLine();
                        writer.close();
                    }
                    else {
                        throw new SettingsAlreadyExistsException();
                    }
                }
            }
        }
    }*/
}
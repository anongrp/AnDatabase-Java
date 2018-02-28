package anon.database.connect;

import java.io.File;

public class Connection {

    public static String dbLocation;
    public static String projectName;
    public static boolean status=false;


    /*^^^^^ Method For Connect Database To Client ^^^^*/
    public static boolean connect(String projectName){

        Connection.projectName = projectName;
        if (System.getProperty("os.name").toLowerCase().contains("windows")){
            dbLocation = "C:\\Users\\"+System.getProperty("user.name")+"\\AppData\\Local\\"+projectName;
            Connection.status = true;
        }
        if (System.getProperty("os.name").toLowerCase().contains("linux")){
            dbLocation = "/home/"+System.getProperty("user.name")+File.separator+"."+projectName;
            Connection.status = true;
        }


        return initSpace();
    }

    private static boolean initSpace(){
        boolean isAvailable=false;
        try {
            File projectDir = new File(dbLocation);
            if (!(projectDir.exists())){
                projectDir.mkdir();
            }
            isAvailable=true;
        }catch (Exception e){
            isAvailable=false;
        }finally {
            return isAvailable;
        }
    }
}

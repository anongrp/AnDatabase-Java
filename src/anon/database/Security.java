package anon.database;

public class Security {

    public static String encrypt(String data,Integer key){
        key = keyDesigner(key);
        char[] pureData = data.toCharArray();
        char[] encrypted = new char[pureData.length];
        for (int i=0;i<pureData.length;i++){
            encrypted[i] = incrementor(pureData[i],key);
        }
        return String.valueOf(encrypted);
    }

    public static String decrypt(String data,Integer key){
        key = keyDesigner(key);
        char[] pureData = data.toCharArray();
        char[] decrypted = new char[pureData.length];
        for (int i=0;i<pureData.length;i++){
            decrypted[i] = decrementor(pureData[i],key);
        }
        return String.valueOf(decrypted);
    }

    private static char incrementor(char data,int noOfTimes) {
        for (int i = 0; i < noOfTimes; i++) {
            data = ++data;
        }
        return data;
    }

    private static char decrementor(char data,int noOfTimes){
        for (int i=0;i<noOfTimes;i++){
            data = --data;
        }
        return data;
    }

    private static Integer keyDesigner(Integer key){
        Integer finalKey = 0;
        for (int i=0;i<key.toString().length();i++){
            finalKey += Integer.parseInt(String.valueOf(key.toString().toCharArray()[i]));
        }
        finalKey += 500;
        return finalKey;
    }

}

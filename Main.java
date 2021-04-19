import java.util.*;
import java.io.*;

public class Main {

//    static Scanner _in = new Scanner(System.in);
    private static java.lang.String keyfileName = "key.csv";
    static public Object input(Object str){
        Object f_str = new Main();
        f_str = str;
        return f_str;
    }
    
    public static String getKey(Map<String, String> map, String value) {
        for (Map.Entry<String, String> entry: map.entrySet()) {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
    

    static public String encrypt(Object ob){
        String line = "";
        String str = ob.toString();
        HashMap<String, String> charMap = new HashMap<>();
        String encryptedString = "";
        char[] chArr;
        try {
            //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader("key.csv"));
            while((line = br.readLine()) != null){
                String[] data = line.split(",");
                charMap.put(data[0], data[1]);
            }
            //Assigning characters to character array
            chArr = new char[str.length()];
            for (int i = 0;i < str.length();i++){
                chArr[i] = str.charAt(i);
            }
            // Getting final encrypted String
            for (int i = 0;i < chArr.length;i++){
                char ss = chArr[i];
                String F = String.valueOf(ss);
                encryptedString += charMap.get(F);
            }
            System.out.println();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return encryptedString;
    }
    
    static public String decrypt(String str){
        String line = "";

        String decryptedString = "";
        List<String> stringCodes = new ArrayList<>();
        HashMap<String, String> charMap = new HashMap<>();
        char[] chArr;
        try {
            //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader("key.csv"));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                charMap.put(data[0], data[1]);
            }

            //Getting encrypted values to List
            for(int i = 0; i < str.length()-1;i+=2){
                char c1, c2;
                String s2;
                c1 = str.charAt(i);
                if((c1=='c') || (c1=='d')) {
                    s2 = str.substring(i+1, i+4);
                    String f = c1 + s2;
                    stringCodes.add(f);
                    i+=2;
                }
                else {
                    c2 = str.charAt(i + 1);
                    String f = c1 + String.valueOf(c2);
                    stringCodes.add(f);
                }
            }

            for(int i = 0; i < stringCodes.size();i++){
                String ss = stringCodes.get(i);
                String F = getKey(charMap, ss);
                decryptedString += F;
            }

        }
        catch (Exception e) {
                e.printStackTrace();
            }
        return decryptedString;
    }

    public static void main(String[] args) {
        Scanner _in = new Scanner(System.in);
        Main ob = new Main();
        System.out.print("Your Choice: ");
        String c = _in.next();
        String choice = c.toLowerCase();
        switch (choice.charAt(0)){
            case 'm':
                System.out.print("Enter your message: ");
                Object obj = "This Message is to be encrpyted. This is a test message";
                System.out.println(encrypt(obj));
                break;
            default:
                System.out.println("Something went wrong");
        }
        System.out.println("decrypted Message: ");
        System.out.println(decrypt(FINAL_STRING));
    }
}

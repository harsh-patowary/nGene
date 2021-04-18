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
    }
}
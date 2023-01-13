import java.io.*;
import java.util.*;

class EncDe{

    public static void writeFile(String data){
        try {
            FileWriter fw = new FileWriter("fileName.txt");
            fw.write(data);
            fw.close();
            System.out.println("Successfully wrote to the file.");
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }

    public static String encrypt() throws Exception{
        String toBeEncrypted = readFile();
        String Encrypted = "";
        for(int i = 0;i <toBeEncrypted.length();i++){
            Encrypted += (char)(toBeEncrypted.charAt(i)+2);
        }
        writeFile(Encrypted);
        return(Encrypted);
    }

    public static String decrypt() throws Exception{
       String toBeDecrypted = readFile();
       String Decrypted = "";
       for(int i=0;i<toBeDecrypted.length();i++){
        Decrypted += (char)(toBeDecrypted.charAt(i)-2);
       }
       writeFile(Decrypted);
       return(Decrypted);

    }

    public static String readFile() throws Exception{
        FileReader fr = new FileReader("fileName.txt");
    
        // Declaring loop variable
        int i;
        // Holds true till there is nothing to read
        String data = "";
        while ((i = fr.read()) != -1)
        {   // Print all the content of a file
            data += (char)i;
            // System.out.println(i);
        }
        fr.close();
        return(data);
    }

    public static void main(String []args) throws Exception {
        Scanner obj = new Scanner(System.in);

        System.out.println("(1)Encrypt\n(2)Decrypt\n(3)Read");
        int opt = obj.nextInt();
        if(opt == 1){
            System.out.println(encrypt());
        }else if(opt == 2){
           System.out.println(decrypt());
        }else if(opt == 3){
           System.out.println(readFile());
        }
        
obj.close();
    }
}

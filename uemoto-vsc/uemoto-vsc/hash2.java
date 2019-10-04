import java.io.PipedWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Scanner;

//import org.graalvm.compiler.options.OptionKey;




public class hash2{

    public static void main(String[] args) {
        
        String inpw ="";
        String setpw ="0504";
        String sha1 ="";
        String setsha = "";

        System.out.println(" パスワードを入力　");
        Scanner sc = new Scanner(System.in);
        inpw = sc.nextLine();

        
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            byte[] result = digest.digest(inpw.getBytes());
            sha1 = String.format("%040x", new BigInteger(1, result));
        } catch (Exception e){
            e.printStackTrace();
            
        }

        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            byte[] result = digest.digest(setpw.getBytes());
            setsha = String.format("%040x", new BigInteger(1, result));
        } catch (Exception e){
            e.printStackTrace();
            
        }


        
        if (setsha == sha1){
            System.out.println("OK");
        }else{
            System.out.println("パスワードが間違っています");
        }

        System.out.println( "ハッシュ化した暗号(入力)" );
        System.out.println( sha1 );

        System.out.println( "ハッシュ化した暗号(設定)" );
        System.out.println( setsha );
     }  
}
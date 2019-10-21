import java.math.BigInteger;
import java.security.MessageDigest;

public class Main3 {
 
    public static void main(String[] args) {
         
        String value = "Hash";
        String sha1 = "";
         
         
      ///ハッシュ化(SHA-1)
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            byte[] result = digest.digest(value.getBytes());
            sha1 = String.format("%040x", new BigInteger(1, result));
        } catch (Exception e){
            e.printStackTrace();
        }
         
        System.out.println( "MessageDigest" );
        System.out.println( sha1 );
         
    }
}
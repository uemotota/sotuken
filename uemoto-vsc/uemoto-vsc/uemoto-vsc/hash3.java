import java.io.PipedWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Scanner;

//import org.graalvm.compiler.options.OptionKey;




public class hash3{

    public static void main(String[] args) {


        String inpw ="";
        String setpw ="";
        String sha1 ="";
        String setsha = "";

        ///パスワードの設定
        System.out.println(" パスワードの設定をします　");
        System.out.println(" 設定するパスワードを入力してください　");
        Scanner sc1 = new Scanner(System.in);
        setpw = sc1.nextLine();


        ///設定されたパスワードのハッシュ化
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            byte[] result = digest.digest(setpw.getBytes());
            setsha = String.format("%040x", new BigInteger(1, result));

        } catch (Exception e){
            e.printStackTrace();
            
        }


        for(int i=0; i<3; i++){    
            
            ///パスワードの入力
            System.out.println("");
            System.out.println(" パスワードを入力してください　");
            Scanner sc2 = new Scanner(System.in);
            inpw = sc2.nextLine();


            ///入力されたパスワードのハッシュ化
            try{
                MessageDigest digest = MessageDigest.getInstance("SHA-1");
                byte[] result = digest.digest(inpw.getBytes());
                sha1 = String.format("%040x", new BigInteger(1, result));

            } catch (Exception e){
                e.printStackTrace();
            
            }


            ///ハッシュ値の比較
            if (setsha.equals(sha1)){
                System.out.println("");
                System.out.println("[[[OK]]]");

                System.out.println("");
                System.out.println( "↓↓↓ハッシュ化した暗号(入力値)↓↓↓" );
                System.out.println( sha1 );

                System.out.println("");
                System.out.println( "↓↓↓ハッシュ化した暗号(設定値)↓↓↓" );
                System.out.println( setsha );

                break;

            }else{
                System.out.println("");
                System.out.println("パスワードが間違っています");

                System.out.println("");
                System.out.println( "↓↓↓ハッシュ化した暗号(入力値)↓↓↓" );
                System.out.println( sha1 );
                
            }

            System.out.println("");
            System.out.println("最初からやり直してください");
        
        }
    }
}
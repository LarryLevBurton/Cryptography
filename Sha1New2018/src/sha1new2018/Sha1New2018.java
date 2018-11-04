/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sha1new2018;

import java.io.*;
import java.util.logging.*;
import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 

 
/**
 *
 * @author r-yang
 *  (from https://gist.github.com/giraam/7413306 with minor changes)
 */
public class Sha1New2018 {

    public static String sha1(String input) {
    String sha1 = null;
    try {
        MessageDigest msdDigest = MessageDigest.getInstance("SHA-1");
        msdDigest.update(input.getBytes("UTF-8"), 0, input.length());
        sha1 = DatatypeConverter.printHexBinary(msdDigest.digest());
        sha1 = sha1.toLowerCase();
    } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
        Logger.getLogger(Sha1New2018.class.getName()).log(Level.SEVERE, null, e);
    }
    return sha1;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
  /*
		try { 
			System.out.println("SHA1 hash of string: " + Sha1New2018.sha1(rawString)); 
		} catch (NoSuchAlgorithmException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		} catch (UnsupportedEncodingException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		} 
	*/
        BufferedReader userInput = new BufferedReader (new InputStreamReader(System.in)); 
  
//	System.out.print("Enter string:"); 
//	String rawString = userInput.readLine(); 

//	System.out.println("SHA1 hash of string: " + Sha1New2018.sha1(rawString));
//        char text[] = {' ',' ',' ',' ',' ',' '};    
//
//        String givenHash = "c2543fff3bfa6f144c2f06a7de6cd10c0b650cae";
//        decrypt(givenHash, text,0);
//        givenHash = "b47f363e2b430c0647f14deea3eced9b0ef300ce";
//        decrypt(givenHash, text,0);
//        givenHash = "e74295bfc2ed0b52d40073e8ebad555100df1380";
//        decrypt(givenHash, text,0);
//        givenHash = "0f7d0d088b6ea936fb25b477722d734706fe8b40";
//        decrypt(givenHash, text,0);
//        givenHash = "77cfc481d3e76b543daf39e7f9bf86be2e664959";
//        decrypt(givenHash, text,0);
//        givenHash = "5cc48a1da13ad8cef1f5fad70ead8362aabc68a1";
//        decrypt(givenHash, text,0);
//        givenHash = "4bcc3a95bdd9a11b28883290b03086e82af90212";
//        decrypt(givenHash, text,0);
//        givenHash = "7302ba343c5ef19004df7489794a0adaee68d285";
//        decrypt(givenHash, text,0);
//        givenHash = "21e7133508c40bbdf2be8a7bdc35b7de0b618ae4";
//        decrypt(givenHash, text,0);
//        givenHash = "6ef80072f39071d4118a6e7890e209d4dd07e504";
//        decrypt(givenHash, text,0);
//        givenHash = "02285af8f969dc5c7b12be72fbce858997afe80a";
//        decrypt(givenHash, text,0);
//        givenHash = "57864da96344366865dd7cade69467d811a7961b";
//        decrypt(givenHash, text,0);


        String givenHash = "745f6778338b484cd6f0664e833b61773bbd18d1";

	loopText(givenHash);
 
    }
    
public static void loopText(String givenHash){
    char text[] = {' ',' ',' '};

//    for(int textPositionA = 0; textPositionA < text.length; textPositionA++){
               text = loopChar(givenHash, text,0);

//    }

}
    

    public static char[] loopChar(String hash,char text[],int pivot){
//        char characters[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','u','r','s','t','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9'};
        char characters[] = {'a','b','c'};

        String newHash = "";// = Sha1New2018.sha1();
        String textString = "";
            if(pivot >= text.length){
                System.out.println("return");
                return text;
            }else{
                for(int textPositionB = 0; textPositionB < characters.length; textPositionB++){
                    if(textPositionB != pivot){
                        for(int charPositionA = 0; charPositionA < characters.length; charPositionA++){
                            text[textPositionB] = characters[charPositionA];
                            System.out.println(text);
        //                    System.out.println("Call " + pivot+ " " + text.length + " " + charPositionA);
                            text = loopChar(hash,text, pivot);
                        }
                    }
                }
            }
            
                    
//                    if(pivot < text.length){
//                    }else{
//                        return 0;
//                    }

//                    
//                System.out.println(pivot);    
//                System.out.println(text);                
//                System.out.println("char: "+ characters.length );
//                System.out.println(charPositionA);
//                if(pivot < (text.length)-1){
//                }
//            }
                
//        }

        return text;
    }        
}
    
    


//                 if(newHash == hash){
//                   System.out.println("Password: "+ textString + "Hash: "+ newHash +"\n");       
//                   System.out.println("Password has been cracked\n"); 
//
//                   return;
//                }else{
//    //                decrypt(hash, text);
//                }




//////////////////

//    textString = new String(text);
//                            textString = new String(text).replaceAll("\\s+", "");

//                        newHash = Sha1New2018.sha1(textString);
//                        System.out.println("2: "+hash);
//                        System.out.println("3: "+newHash + "\n");
//                        if(hash.equals(newHash)){;
//                            System.out.println("Password: "+ textString + " Hash: "+ newHash +"\n");
//                            System.out.println("Password has been cracked\n"); 
//                        }
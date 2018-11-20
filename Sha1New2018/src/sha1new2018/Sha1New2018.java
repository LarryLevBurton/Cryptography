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
import java.util.Arrays;

 
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

        BufferedReader userInput = new BufferedReader (new InputStreamReader(System.in)); 
  
 
        String[] givenHash = new String[12];
        givenHash[0] = "c2543fff3bfa6f144c2f06a7de6cd10c0b650cae";
        givenHash[1] = "b47f363e2b430c0647f14deea3eced9b0ef300ce";
        givenHash[2] = "e74295bfc2ed0b52d40073e8ebad555100df1380";
        givenHash[3] = "0f7d0d088b6ea936fb25b477722d734706fe8b40";
        givenHash[4] = "77cfc481d3e76b543daf39e7f9bf86be2e664959";
        givenHash[5] = "5cc48a1da13ad8cef1f5fad70ead8362aabc68a1";
        givenHash[6] = "4bcc3a95bdd9a11b28883290b03086e82af90212";
        givenHash[7] = "7302ba343c5ef19004df7489794a0adaee68d285";
        givenHash[8] = "21e7133508c40bbdf2be8a7bdc35b7de0b618ae4";
        givenHash[9] = "6ef80072f39071d4118a6e7890e209d4dd07e504";
        givenHash[10] = "02285af8f969dc5c7b12be72fbce858997afe80a";
        givenHash[11] = "57864da96344366865dd7cade69467d811a7961b";

            char text[] = {' ',' ',' ',' ',' ',' '}; 
            int textPositionA = 0;
//            for(int textPositionA = 0; textPositionA < text.length; textPositionA++){
//            for(int i = 0; i < givenHash.length; i++){

                int temp = findWord(givenHash,text,textPositionA);
//            } 
    }
    
        // a variable to remember the start time,  use the following methods 

        public static long timeStart(long timer) {
                return timer = System.currentTimeMillis();
        }

        public static String timeStop(String s, long timer) {
            timer = System.currentTimeMillis() - timer;
            switch (s) {
                case "showMs":
                case "":
                    return timer + " milliseconds";
                case "showSec":
                    return timer/1000 + " seconds";
                case "showMin":
                    return timer/60000 +" Minutes " + (timer%60000)/1000 + " seconds";//+ "  milliseconds");
                default:
                    break;
            }
                return null;
         }   

    
        public static int findWord(String[] hash,char text[],int pivot){
                char characters[] = {' ','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9'};
                String newHash = "";
                String textString = "";
                int count = 0;
                long timer = 0,time = 0;
                timer = timeStart(timer);

//                Timer timer = new Timer();
            for(int pos0 = 0; pos0 < characters.length;pos0++){
                text[0] = characters[pos0];
              for(int pos1 = 0; pos1 < characters.length;pos1++){
                    text[1] = characters[pos1];
                for(int pos2 = 0; pos2 < characters.length;pos2++){
                        text[2] = characters[pos2];
                    for(int pos3 = 0; pos3 < characters.length;pos3++){
                        text[3] = characters[pos3];
                        for(int pos4 = 0; pos4 < characters.length;pos4++){
                            text[4] = characters[pos4];
                            for(int pos5 = 0; pos5 < characters.length;pos5++){
                                text[5] = characters[pos5];
                                textString = new String(text).replaceAll("\\s+", "");
                                newHash = Sha1New2018.sha1(textString);
                                if(Arrays.stream(hash).anyMatch(newHash::equals)){
                                    for(int i = 0; i < hash.length; i++){
                                        if(hash[i].equals(newHash)){
//                                            time = System.currentTimeMillis() - timer;
                                            System.out.println(i + " : " + textString + " : " + timeStop("showMin", timer) +" : "+ newHash); 
                                            hash[i] = ""; 
                                            break;
                                        }
                                    }
//                                        System.out.println("Password has been cracked\n"); 
                                    count++;
                                    if(count == hash.length){
                                        return 0;
                                    }
                                }

                                }
                            }
                        }
                    }
                }  
            }
            return 0;
        }

    public static int loopChar(String[] hash,char text[],int pivot){
        char characters[] = {' ','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','u','r','s','t','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9'};
        int count = 0;
        int temp2 = 0;
        String newHash = "";
        String textString = "";
        if(pivot >= text.length){
            return -1;
        }else{
            for(int textPositionB = pivot++; textPositionB < text.length; textPositionB++){
                if(textPositionB != pivot){
                    for(int charPositionA = 0; charPositionA < characters.length; charPositionA++){
                        text[textPositionB] = characters[charPositionA];
                        textString = new String(text).replaceAll("\\s+", "");
                        newHash = Sha1New2018.sha1(textString);
//                        System.out.println(textString);
                        if(Arrays.stream(hash).anyMatch(newHash::equals)){
                            System.out.println("Password has been cracked\n"); 
                            count++;
                        }
//                        if(hash.equals(newHash)){
//                            return 1;
//                        }
                        temp2 = loopChar(hash,text, pivot);
                        if(count == hash.length){
                            return count;
                           
                        }
                       
                    }
                }
            }
        }
            
                 
        return 0;
    } 
    
}
    

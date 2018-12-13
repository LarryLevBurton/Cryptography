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

/*  
    Description:    This is the main function for task 3
                    (Password brute force) using Sha1 encryption.
    Parameters:     args the command line arguments  
    Returns:        void
    Author(s):      Laurence Burton (15003639)  
*/   
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

 
  
        //Array storing hash which need to be cracked
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

        //Function for brute force. 
        findWord(givenHash);

    }
    
     /*  
        Description:    Sets up a starting point for the timer
        Parameters:     long : timer
        Returns:        long: start point of timer. 
        Author(s):      Rong Yang
    */   
        public static long timeStart(long timer) {
                return timer = System.currentTimeMillis();
        }

    /*  
        Description:    Generates length of time depending 
                        on what you input. 
        Parameters:     String s: used to select format
                        long: time from when the timer started 
        Returns:        String of to print results. 
        Author(s):      Rong Yang
    */   
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

    /*  
        Description:    Sets up a starting point for the timer
        Parameters:     String[] hash: an array of hash that 
                                    need to be cracked
        Returns:        Int: 1 all have been crack 
                             0 if any are left. 
        Author(s):      Laurence Burton (15003639)
    */  
        public static int findWord(String[] hash){
            char text[] = {' ',' ',' ',' ',' ',' '};
            //Array of character to loop throug. Space is included so that words smaller then 6 will be generated. 
            char characters[] = {' ','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9'};
            String newHash = "";
            String textString = "";
            //Count of how many machets have been generated. 
            int count = 0;
            
            long timer = 0;
            timer = timeStart(timer);
            //Loops through the first position of the password. 
            for(int pos0 = 0; pos0 < characters.length;pos0++){
                //Puts a new letter from the character array into the first position
                text[0] = characters[pos0];
                //The previous two line are repeated for each charact in the word. (6 letters = 6 loops)
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
                                    //Removes spaces from word
                                    textString = new String(text).replaceAll("\\s+", "");
                                    //Generates new hash with new word. 
                                    newHash = Sha1New2018.sha1(textString);
                                    //Checks if the new hash equals any of the old hashes. 
                                    if(Arrays.stream(hash).anyMatch(newHash::equals)){
                                        //Loops through array of hashes.
                                        for(int i = 0; i < hash.length; i++){
                                            //Compares the newley generated hash to the current position in the array of hash. 
                                            if(hash[i].equals(newHash)){
                                                System.out.println(i + " : " + textString + " : " + timeStop("showMin", timer) +" : "+ newHash); 
                                                //Removes hash from array/
                                                hash[i] = ""; 
                                                //Stops looks at hashs and keeps generating words. 
                                                break;
                                            }
                                        }
                                        count++;
                                        //Checks if all hashed have been cracked.
                                        if(count == hash.length){
                                            return 1;
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

         /*  
        Description:    Old function for cracking a keys
                        that is extremly slow
        Parameters:     String[] hash: an array of hash that 
                                    need to be cracked
                        char text[]: last word that was generated. 
                        int pivot: current position that being changed. 
        Returns:        Int: # all have been crack 
                             0 if any are left. 
        Author(s):      Laurence Burton (15003639)
    */
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
                        if(Arrays.stream(hash).anyMatch(newHash::equals)){
                            System.out.println("Password has been cracked\n"); 
                            count++;
                        }
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
    

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Math.abs;
import static java.lang.Math.ceil;
import static java.lang.Math.floor;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static oracle.jrockit.jfr.events.Bits.intValue;

/**
 *
 * @author Laurence Burton (15003639)
 */
public class Factorization {

    /*  
    Description:    This is the main function for task 4
                    for generating prime factors for a large
                    number.
    Parameters:     args the command line arguments  
    Returns:        void
    Author(s):      Laurence Burton (15003639)  
*/   
    public static void main(String[] args) throws IOException {
        



//  Task 4a      
//        fermat(1, 224573);        
//        fermat(2, 299203);    
//        fermat(3, 1963867);
//        fermat(4, 6207251);
//        fermat(5, 14674291);
//        fermat(6, 23128513);
//        fermat(7, 254855791);
//        fermat(8, 428279361);
//
//        fermat(9, 159649552547L);
//        fermat(10, 189061250479L);
//        fermat(11, 2211744201787L);
//        fermat(12, 7828669742987L);
//        fermat(13, 48560209712519L);
//        fermat(14, 35872004189003L);
//        fermat(15, 737785058178599L);
//        fermat(16, 576460921650883L);
//        fermat(17, 1957432135202107L);
//        fermat(18, 2450609331732137L);

//Task 4b        
        dixon(1, 299);
//        dixon(1, 224573);
//        dixon(2, 299203);    
//        dixon(3, 1963867);
//        dixon(4, 6207251);
//        dixon(5, 14674291);
//        dixon(6, 23128513);
//        dixon(7, 254855791);
//        dixon(8, 428279361);
//
//        dixon(9, 159649552547L);
//        dixon(10, 189061250479L);
//        dixon(11, 2211744201787L);
//        dixon(12, 7828669742987L);
//        dixon(13, 48560209712519L);
//        dixon(14, 35872004189003L);
//        dixon(15, 737785058178599L);
//        dixon(16, 576460921650883L);
//        dixon(17, 1957432135202107L);
//        dixon(18, 2450609331732137L);
        
    }
    
/*  
        Description:    Generates prime factors of a number using 
                        Fermats algorithm. 
        Parameters:     int id: id of number
                        long n: number to be factorised
        Returns:        Int: 1 all have been crack 
                             0 if any are left. 
        Author(s):      Laurence Burton (15003639)
*/  
    public static void fermat(int id, long n){
        long timer = 0;
        timer = timeStart(timer);
        double x = 0, y = 0;          
        //This while loop implements the Fermat algorith (a2 − N = b2) increment y until the correct number has been generated. 
        while ((sqrt(n+((++y)*y))%1) != 0){}
        x = sqrt(n+(y*y));
        //To find the factors you have to do X= X-Y and Y= = X+Y. I've done this within the print statement below.
        System.out.println("ID: "+ id + " The factor of " + n + " is " + intValue(x+y) +" * "+ intValue(x-y) +"" + " Time take: "+ timeStop("showMs", timer));

    }
        
/*  
        Description:    Generates prime factors of a number using 
                        Dixon algorithm. 
        Parameters:     int id: id of number
                        long n: number to be factorised
        Returns:        Int: 1 all have been crack 
                             0 if any are left. 
        Author(s):      Laurence Burton (15003639)
*/   
     public static void dixon(int id, long n){
         //Sets up timer
        long timer = 0;
        timer = timeStart(timer);
  
        
        
        Random random = new Random();
        long randomNumber[] = {0,0};        
        long randomNumberSq[] = {0,0};
        long powerMulti = 1;

        int squareRoot =  (int)sqrt(n);
        long rNum[] = {0,0};
        long results[][] = {{0,0,0,0},{0,0,0,0}};
        
        int numberPlace = 0;

        //Loop through untill a smooth number has been randomily generated.
        //Higher then square root of the number and less the numer. 
        while(numberPlace < 2){
            randomNumber[numberPlace] = random.nextInt((int)n+1 ) + (int)(squareRoot);
            randomNumberSq[numberPlace]= randomNumber[numberPlace] * randomNumber[numberPlace];
            rNum[numberPlace] = (randomNumberSq[numberPlace])%n;
            
            //Checks if the number is smooth
            if(isItSmooth(rNum[numberPlace],3) == 1){ 
                //generates the power list (smooth 7)
                results[numberPlace] = generateSmooth(rNum[numberPlace],3);
                //Moves on to the second random number
                numberPlace++;
            }
        }

        //Multiples the two smooth numbers
        long randomNumMulti = (randomNumber[0] * randomNumber[1]);
        
        
        //Loops through the power lists.
        //Adds the pairs together and times them to the previous power. 
        for(int j = 0; j < 4; j++){
            long temp = results[0][j]+results[1][j];
            if(temp != 0) {powerMulti *= temp; }
        }

        //squre root of the powers 
        long sqrtMulti = (long)sqrt(powerMulti);
        //Gets the GCD of x+y and N
        long x = gcd(randomNumMulti+sqrtMulti,n);
        //Gets the GCD of x-y and N
        long y = gcd(abs(randomNumMulti-sqrtMulti),n);

       //checks if the result is correct
       if((x*y) != n){
           //If it isn't it will run again
           dixon(id,n);
           return;
       } else{
         //If it was correct it will print the result
        System.out.println("ID: "+ id + " The factor of " + n + " is " + y +" * "+ x + " Time take: "+ timeStop("showMin", timer));

        return;
       }
    }

    /*  
        Description:    Checks if the given number is smooth
        Parameters:     long number: Number to be checked
                        int p: What smooth you want(e.g. 7)
        Returns:        Int: 1 Number is smooth 
                             0 Number isn't smooth 
        Author(s):      Laurence Burton (15003639)
*/   
    public static long isItSmooth(long number, int p){
        //Checks if the number is 0;
        if(number == 0){return 0;}
        long x = 0;
        int i = 0;        
        long powerList[] = {2,3,5,7};   
        
        while(number > 1){
            x  = number%powerList[i];
            if(x != 0){
                if(i == p){
                    return 0;
                }
                i++;
            }else if(x == 0){
                number = (number/powerList[i]);
            }
        }
        return 1;
      }


/*  
    Description:    Checks if the generate the power 
                    list for a smooth number
    Parameters:     long number: Number to be checked
                    int p: What smooth you want(e.g. 7)
    Returns:        long[]: the power list is returned    
    Author(s):      Laurence Burton (15003639)
*/    
    public static long[] generateSmooth(long number, int p){
        long x = 0;
        int i = 0;
        long powerList[] =  {2,3,5,7};        
        long results[] =    {0,0,0,0};//2,3,5,7
     
        while(number != 0){
            //Mods number by power X
            x  = number%powerList[i];
            //If the remainder isn't 0 then that number can't be dived by that power.
            //I is increment so that the next power is used. 
            if(x != 0){
                //Checks if there is any more power left to use
                if(i == p){
                    return results;
                }
                i++;
            }else{
                //If the number could be dived the number is update with the result
                number = (number/powerList[i]);
                //And the result list is updated. 
                 results[i]++;
            }
        }
        return null;
      }
    
    
    public static long gcd(long a, long b){

        long x = b%a;
        
        while (x != 0){
            
            b = a; 
            a = x;
            x = b%a;
 
        }
        return a;
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
}
 


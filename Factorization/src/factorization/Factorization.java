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
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static oracle.jrockit.jfr.events.Bits.intValue;
import java.math.*; 

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
        BigInteger number1 = new BigInteger ("224573");
        BigInteger number2 = new BigInteger ("299203");
        BigInteger number3 = new BigInteger ("1963867");
        BigInteger number4 = new BigInteger ("6207251");
        BigInteger number5 = new BigInteger ("14674291");
        BigInteger number6 = new BigInteger ("23128513");
        BigInteger number7 = new BigInteger ("254855791");
        BigInteger number8 = new BigInteger ("428279361");

        BigInteger number9 = new BigInteger ("159649552547");
        BigInteger number10 = new BigInteger ("189061250479");
        BigInteger number11 = new BigInteger ("2211744201787");
        BigInteger number12 = new BigInteger ("7828669742987");
        BigInteger number13 = new BigInteger ("48560209712519");
        BigInteger number14 = new BigInteger ("35872004189003");
        BigInteger number15 = new BigInteger ("737785058178599");
        BigInteger number16 = new BigInteger ("576460921650883");
        BigInteger number17 = new BigInteger ("1957432135202107");       
        BigInteger number18 = new BigInteger ("2450609331732137");



        fermat(1,number1);        
        fermat(2,number2);    
        fermat(3,number3);
        fermat(4,number4);
        fermat(5,number5);
        fermat(6,number6);
        fermat(7,number7);
        fermat(8,number8);

        fermat(9,number9);
        fermat(10,number10);
        fermat(11,number11);
        fermat(12,number12);
        fermat(13,number13);
        fermat(14,number14);
        fermat(15,number15);
        fermat(16,number16);
        fermat(17,number17);     
        fermat(18,number18);


        
//Task 4b        
//long  i = isItSmooth(45,3);
//System.out.println(i);
//int  results[] = generateSmooth(45,3);
//System.out.println(results[0]+ " : " + results[1] + " : " +results[2]+ " : "+ results[3]);
//        dixon(1, 299);
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
//        
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
    public static void fermat(int id, BigInteger n){
            
        //Vars for timer
        long timer = 0;
        timer = timeStart(timer);

        BigInteger ONE = BigInteger.valueOf(1);       
        BigInteger X = BigInteger.valueOf(1);
        BigInteger Y = BigInteger.valueOf(0);
        BigInteger sqrtT = BigInteger.valueOf(0);
        BigInteger sqrtTmultiply = BigInteger.valueOf(0);
        BigInteger A = getIntSqrt(n);
        //Adds one to a
        A = A.add(ONE);
        
        //Squares A and subtracts the number 
        BigInteger Bsq = ((A.multiply(A)).subtract(n)).abs();
        //Gets the square root of BSQ
        BigInteger T = getIntSqrt(Bsq);
        
        //Loops untill T is a square number. 
        while ((sqrtT.multiply(sqrtT)).compareTo(T) != 0){
                //Adds one to Y
                Y = Y.add(ONE);              
                T = n.add(Y.multiply(Y));
                sqrtT = getIntSqrt(T);
           }
        X = getIntSqrt(n.add(Y.multiply(Y))); 

        //To find the factors you have to do X = X-Y and Y= = X + Y. I've done this within the print statement below.
        System.out.println("ID: "+ id + " The factor of " + n + " is " + X.subtract(Y) +" * "+ X.add(Y) +"" + " Time take: "+ timeStop("showMs", timer));

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
        long randomNumber = 0;  
        long randomNumberTemp = 0;        

        long randomNumberSq = 0;
        long powerMulti = 1;
        long randomNumMulti = 1;
        int notEven = 0;
        int count = 0;
        long rNum = 0;
        int pwr[] = {2,3,5,7};
        int results[]= {0,0,0,0};
        int results2[] = {0,0,0,0};
        long results3[] = {0,0,0,0};
        int squareRoot =  (int)sqrt(n);

        
        //Loop through untill a smooth number has been randomily generated.
        //Higher then square root of the number and less the numer. 
        while(notEven == 0 ){
            randomNumberTemp = random.nextInt((int)n+1 ) + (int)(squareRoot);
            while(randomNumberTemp == randomNumMulti){
                randomNumberTemp = random.nextInt((int)n+1 ) + (int)(squareRoot);
                System.out.println("no: " + randomNumberTemp + " : " + randomNumber);
            }
            
//            System.out.println("Random: " + randomNumberTemp + " : " + randomNumber + " : " + randomNumMulti);
            randomNumber = randomNumberTemp;
//            System.out.println(randomNumber);
            randomNumberSq = randomNumber * randomNumber;
            rNum = randomNumberSq%n;
            //Checks if the number is smooth
            if(isItSmooth(rNum,3) == 1){                
                //generates the power list (smooth 7)
                results = generateSmooth(rNum,3);

                //gets the total count of powers
                //Adds one to the count of numbers that have been generated.

                results3[0] += results[0];
                results3[1] += results[1];
                results3[2] += results[2];
                results3[3] += results[3];
                
                //Save first number to results2
                if(count == 0){
                    randomNumMulti = randomNumber;
                    results2[0] += results[0];
                    results2[1] += results[1];
                    results2[2] += results[2];
                    results2[3] += results[3];      
                    count++;

                }
//                System.out.println("r1: " + results[0] + " : " + results[1] + " : " + results[2] + " : " + results[3]);
////              System.out.println("r2: " + results2[0] + " : " + results2[1] + " : " + results2[2] + " : " + results2[3]);
//                System.out.println("r3: " + results3[0] + " : " + results3[1] + " : " + results3[2] + " : " + results3[3]);

                //checks if the total power list is even
                if((results3[0]%2 == 0)&&(results3[1]%2 == 0)&&(results3[2]%2 == 0)&&(results3[3]%2 == 0) && count == 1){
                    //if it's even time the resutl
                    randomNumMulti *= randomNumber;
                    break;   
                }else{
                    results3[0] = results2[0];
                    results3[1] = results2[1];
                    results3[2] = results2[2];
                    results3[3] = results2[3];
                }
            }
        }
        //multiplies the powerlist
        for(int j = 0; j < 4; j++){
            long temp = (long) pow(pwr[j],results3[j]);
            if(temp != 0) {
                powerMulti *= temp;
            }
        }

        
        
        //Loops through the power lists.
        //Adds the pairs together and times them to the previous power. 
        long sqrtPower = (long)sqrt(powerMulti);
        sqrtPower %= n;
        randomNumMulti %= n;

        //squre root of the powers 
        //Gets the GCD of x+y and N
        System.out.println(randomNumMulti + " : " +sqrtPower);
        long x = randomNumMulti+sqrtPower;
        long y = abs(randomNumMulti-sqrtPower);

        //Gets the GCD of x-y and N
        x = gcd((x),n);
        y = gcd(y,n);

        
        System.out.println("ID: "+ id + " The factor of " + n + " is " + x+" * "+ y + " Time take: "+ timeStop("showMs", timer));
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
    public static int[] generateSmooth(long number, int p){
        long x = 0;
        int i = 0;
        int powerList[] =  {2,3,5,7};        
        int results[] =    {0,0,0,0,0};//2,3,5,7,count
     
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
                 results[4]++;

            }
        }
        return null;
      }
    
    
    public static long gcd(long a, long b){

     
//        System.out.println(a);
//        System.out.println(b);

        long x = b%a;
//        System.out.println(x);
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
    
    
    /* this is my code to help you to work out big integer sqrt - rong
 */

/* It returns s where s^2 =< x < (s+1)^2, that is s = floor(sqrt(x))
    */
   public static BigInteger getIntSqrt(BigInteger x){
           BigInteger s; // final result 
           BigInteger currentRes = BigInteger.valueOf(0); // init value is 0
           BigInteger currentSum = BigInteger.valueOf(0); // init value is 0
           BigInteger sum = BigInteger.valueOf(0);
           String xS = x.toString(); // change input x to a string xS

           int lengthOfxS = xS.length();
           int currentTwoBits;
           int i=0; // index
           if(lengthOfxS % 2 != 0) {// if odd length, add a dummy bit
               xS = "0".concat(xS); // add 0 to the front of string xS
               lengthOfxS++;
           }

           while(i < lengthOfxS){ // go through xS two by two, left to right
               currentTwoBits = Integer.valueOf(xS.substring(i,i+2));
               i += 2;

               // sum = currentSum*100 + currentTwoBits
               sum = currentSum.multiply(BigInteger.valueOf(100));
               sum = sum.add(BigInteger.valueOf(currentTwoBits));
               // subtraction loop
               do {
                   currentSum = sum; // remember the value before subtract
                   // in next 3 lines, we work out currentRes = sum - 2*currentRes - 1
                   sum = sum.subtract(currentRes);
                   currentRes = currentRes.add(BigInteger.valueOf(1)); // currentRes++
                   sum = sum.subtract(currentRes);

               } while(sum.compareTo(BigInteger.valueOf(0)) >= 0); // stop when sum < 0
               currentRes = currentRes.subtract(BigInteger.valueOf(1)); // go one step back
               currentRes = currentRes.multiply(BigInteger.valueOf(10));
           }
           s = currentRes.divide(BigInteger.valueOf(10)); // go one step back
           return s;

   }

    
}
 


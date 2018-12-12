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


//
//        fermat(1,number1);        
//        fermat(2,number2);    
//        fermat(3,number3);
//        fermat(4,number4);
//        fermat(5,number5);
//        fermat(6,number6);
//        fermat(7,number7);
//        fermat(8,number8);
//
//        fermat(9,number9);
//        fermat(10,number10);
//        fermat(11,number11);
//        fermat(12,number12);
//        fermat(13,number13);
//        fermat(14,number14);
//        fermat(15,number15);
//        fermat(16,number16);
//        fermat(17,number17);     
//        fermat(18,number18);


        
//Task 4b        
//        dixon(1,number1);        
//        dixon(2,number2);    
//        dixon(3,number3);
//        dixon(4,number4);
//        dixon(5,number5);
//        dixon(6,number6);
//        dixon(7,number7);
//        dixon(8,number8);

//        dixon(9,number9);
//        dixon(10,number10);
        dixon(11,number11);
//        dixon(12,number12);
//        dixon(13,number13);
//        dixon(14,number14);
//        dixon(15,number15);
//        dixon(16,number16);
//        dixon(17,number17);     
//        dixon(18,number18);
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
     public static void dixon(int id, BigInteger n){
        //Sets up timer
        long timer = 0;
        timer = timeStart(timer);
//        BigInteger ONE = BigInteger.valueOf(1);       

        Random random = new Random();
//        long randomNumber = 0;  
//        long randomNumberTemp = 0;        
        BigInteger randomNumberTemp = BigInteger.valueOf(0);
        BigInteger randomNumber = BigInteger.valueOf(0);

        BigInteger randomNumberSq = BigInteger.valueOf(0);
        BigInteger powerMulti = BigInteger.valueOf(1);
        BigInteger randomNumMulti = BigInteger.valueOf(1);

//        long randomNumberSq = 0;
//        long powerMulti = 1;
//        long randomNumMulti = 1;

        int notEven = 0;
        int count = 0;
        BigInteger rNum = BigInteger.valueOf(0);
        int pwr[] = {2,3,5,7};
        int results[]= {0,0,0,0};
        int results2[] = {0,0,0,0};
        long results3[] = {0,0,0,0};
        
        BigInteger squareRoot =  getIntSqrt(n);
        int maxNumBitLength = n.bitLength();
        
//        System.out.println(n);

        
//        //Loop through untill a smooth number has been randomily generated.
//        //Higher then square root of the number and less the numer. 
        while(notEven == 0 ){
            randomNumberTemp = new BigInteger(maxNumBitLength, random).add(squareRoot);
//            System.out.println("random: " + randomNumberTemp);

//            randomNumberTemp = random.nextInt((int)n+1 ) + (int)(squareRoot);
            while(randomNumberTemp.compareTo(randomNumMulti) == 0){
                randomNumberTemp = new BigInteger(maxNumBitLength, random).add(squareRoot);
                System.out.println("no: " + randomNumberTemp + " : " + randomNumber);
            }
//            
            randomNumber = randomNumberTemp;
            randomNumberSq = randomNumber.multiply(randomNumber);
            rNum = randomNumberSq.mod(n);
//            //Checks if the number is smooth
            if(isItSmooth(rNum,3) == 1){   
//                //generates the power list (smooth 7)
                results = generateSmooth(rNum,3);
//
//                //gets the total count of powersTrue 
//                //Adds one to the count of numbers that have been generated.

                results3[0] += results[0];
                results3[1] += results[1];
                results3[2] += results[2];
                results3[3] += results[3];
//                
//                //Save first number to results2
                if(count == 0){
                    randomNumMulti = randomNumber;
                    results2[0] += results[0];
                    results2[1] += results[1];
                    results2[2] += results[2];
                    results2[3] += results[3];      
                    count++;

                }

//                //checks if the total power list is even
                if((results3[0]%2 == 0)&&(results3[1]%2 == 0)&&(results3[2]%2 == 0)&&(results3[3]%2 == 0) && count == 1){
                    //if it's even times the results
//                    System.out.println(randomNumber);
                    randomNumMulti = randomNumMulti.multiply(randomNumber);
                    notEven = 1;
                    break;   
                }else{
                    results3[0] = results2[0];
                    results3[1] = results2[1];
                    results3[2] = results2[2];
                    results3[3] = results2[3];
                }
            }
        }

//        //multiplies the powerlist
        for(int j = 0; j < 4; j++){
            long temp = (long) pow(pwr[j],results3[j]);
            BigInteger tempBI = BigInteger.valueOf(temp);
            if(temp != 0) {
                powerMulti = powerMulti.multiply(tempBI);
            }
        }
//
//        
//        
//        //Loops through the power lists.
//        //Adds the pairs together and times them to the previous power. 
//        long sqrtPower = (long)sqrt(powerMulti);
        BigInteger sqrtPower = getIntSqrt(powerMulti);//.valueOf(temp);

        sqrtPower =sqrtPower.mod(n);// %= n;
        randomNumMulti = randomNumMulti.mod(n);//.randomNumMulti %= n;
//
//        //squre root of the powers 
//        //Gets the GCD of x+y and N
//        System.out.println(randomNumMulti + " : " +sqrtPower);
        BigInteger x = randomNumMulti.add(sqrtPower);
        BigInteger y = randomNumMulti.subtract(sqrtPower).abs();
//
//        //Gets the GCD of x-y and N
        x = gcd((x),n);
        y = gcd(y,n);

//        
        System.out.println("ID: "+ id + " The factor of " + n + " is " + x +" * "+ y + " Time take: "+ timeStop("showMs", timer));
    }


    /*  
        Description:    Checks if the given number is smooth
        Parameters:     long number: Number to be checked
                        int p: What smooth you want(e.g. 7)
        Returns:        Int: 1 Number is smooth 
                             0 Number isn't smooth 
        Author(s):      Laurence Burton (15003639)
*/   
    public static long isItSmooth(BigInteger number, int p){
        BigInteger ZERO = BigInteger.valueOf(0);    
        BigInteger ONE = BigInteger.valueOf(1);
        //Checks if the number is 0;
        if(number.equals(ZERO)){return 0;}
            BigInteger x = BigInteger.valueOf(0);
            int i = 0;        
            int powerList[] = {2,3,5,7};   
        
        while(number.compareTo(ONE) == 1){
            BigInteger TEMP =  BigInteger.valueOf(powerList[i]);
            x  = number.mod(TEMP);
            if(x.compareTo(ZERO) != 0){
                if(i == p){
                    return 0;
                }
                i++;
            }else{
                number = number.divide(TEMP);
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
    public static int[] generateSmooth(BigInteger number, int p){
        BigInteger ONE = BigInteger.valueOf(1);
        BigInteger x = BigInteger.valueOf(0);
        BigInteger ZERO =  BigInteger.valueOf(0);

        int i = 0;
        int powerList[] =  {2,3,5,7};        
        int results[] =    {0,0,0,0,0};//2,3,5,7,count
     
        while(number.compareTo(ZERO) == 1){
            BigInteger TEMP =  BigInteger.valueOf(powerList[i]);
            //Mods number by power X
            x  = number.mod(TEMP);//%powerList[i];
            //If the remainder isn't 0 then that number can't be dived by that power.
            //I is increment so that the next power is used. 
            if(x.compareTo(ZERO) != 0){
                //Checks if there is any more power left to use
                if(i == p){
                    return results;
                }
                i++;
            }else if(x.compareTo(ZERO) == 0) {
                //If the number could be dived the number is update with the result
                number  = number.divide(TEMP);//%powerList[i];
                //Add the result list is updated. 
                 results[i]++;    
                 //Adds 1 to the count 
                 results[4]++;
            }
        }
        return null;
      }
    
    
    public static BigInteger gcd(BigInteger a, BigInteger b){
        BigInteger ZERO =  BigInteger.valueOf(0);


        BigInteger x = b.mod(a);
        while (x.compareTo(ZERO) == 1){
            b = a; 
            a = x;
            x = b.mod(a);
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
 


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
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static oracle.jrockit.jfr.events.Bits.intValue;

/**
 *
 * @author larry
 */
public class Factorization {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        


//        BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
//        System.out.print("Please enter a number to get factorised: ");
//        String input = buffer.readLine();
//        int number =  Integer.parseInt(input);
//        fermat(0, number);

//       System.out.print("Please enter a number to get factorised: " + gcd(54,888));
        dixon(1, 299);
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
//        
    }

    public static void fermat(int id, long n){

        double x = 0, y = 0;          
        while ((sqrt(n+((++y)*y))%1) != 0){}
        
        x = sqrt(n+(y*y));
        System.out.println("ID: "+ id + " The factor of " + n + " is (" + intValue(x) +"^2) - ("+ intValue(y) +"^2)" );


        return;
    }
     public static void dixon(int id, long n){
        Random random = new Random();
        long randomNumber[] = {0,0};        
        long randomNumberSq[] = {0,0};

        double squareRoot = sqrt(n);
        long rNum[] = {0,0};
        int i = 0;
        long results[][] = {{0,0,0,0},{0,0,0,0}};
//        long rNum 
        
        int k = 1;

        while(k == 1){
            randomNumber[0] = random.nextInt((int)(squareRoot)) + 1;
            randomNumber[0] = 25;
            randomNumberSq[0]= randomNumber[0] * randomNumber[0];

            rNum[0] = (randomNumberSq[0])%n;
            System.out.println("X: " + rNum[0]);
            
//            if(1 == 1){ //check if it's smooth
////                break;
//            }else{
                results[0] = isItSmooth(rNum[0],3);
                System.out.println(results[0][0]+" "+results[0][1]+" " + results[0][2]+ " " +results[0][3]);

                break;
//            }

        }
        
        while(true){
            randomNumber[1] = random.nextInt((int)(squareRoot)) + 1;
            randomNumber[1] = 29;
            randomNumberSq[1]= randomNumber[1] * randomNumber[1];

            rNum[1] = (long)(randomNumberSq[1])%n;
                        System.out.println("X: " + rNum[1]);

//            if(1 == 1){ //check if it's smooth
////                break;
//            }else{
                results[1] = isItSmooth(rNum[1],3);
                System.out.println(results[1][0]+" "+results[1][1]+" " + results[1][2]+ " " +results[1][3]);
                break;
//            }

        }

        long temp = (randomNumber[0] * randomNumber[1]);
        long temp2 = results[0][0]+results[1][0];        
        long temp3 = results[0][1]+results[1][1];
        long temp4 = results[0][2]+results[1][2];
        long temp5 = results[0][3]+results[1][3];
        long temp6 = 1;
        if(temp2 != 0){temp6 *= pow(2,temp2);}    
        if(temp3 != 0){temp6 *= pow(3,temp3);}      
        if(temp4 != 0){temp6 *= pow(5,temp4);}     
        if(temp5 != 0){temp6 *= pow(7,temp5);}    


        System.out.println(temp2 + " : "  + temp3 + " : "  + temp4 + " : "  + temp5);      
        System.out.println(results[0][0]+" "+results[0][1]+" " + results[0][2]+ " " +results[0][3]);
        System.out.println(results[1][0]+" "+results[1][1]+" " + results[1][2]+ " " +results[1][3]);


//        long temp6 = (long) (pow(2,temp2)*pow(3,temp3)*pow(5,temp4)*pow(7,temp5));      
//        long temp7 = (long) (pow(3,temp3));

        System.out.println(randomNumber[0] + " * " + randomNumber[1] + " = " + temp);
        System.out.println("Power: " + sqrt(temp6));
        System.out.println("N: " + n);
//+results[0][2]+results[0][3];
        

//        long temp3 = results[1][0]+results[1][1]+results[1][2]+results[1][3];
        long x = gcd(temp+(long)sqrt(temp6),n);
        long y = gcd(abs(temp-(long)sqrt(temp6)),n);
//        
        System.out.println("ID: "+ id + " The factor of " + n + " is (" + y +"^2) - ("+ x +"^2)" );

        return;
    }

     
     public static int isItPrime(int number){
         for (int i = 2; i <= (number/2); i++){
             if (number%i == 0){
                 return 0;
             }
         }
     return 1;
     }
      public static long[] isItSmooth(long number, int p){

        long x = 0;
        int i = 0;
        long q[] = {2,3,5,7};        
        long results[] = {0,0,0,0};//2,3,5,7
     
        while(true){
            x  = number%q[i];
            if(x != 0){
                if(i == p){
                    return results;
                }
                i++;
            }else{
                number = (number/q[i]);
                 results[i]++;
            }
        }
      }
    public static long gcd(long a, long b){
        System.out.println("A:" + a + " B: " + b);
//        a = 54;
//        b = 888;
        long x = b%a;
        
        while (x != 0){
            
            b = a; 
            a = x;
            x = b%a;
                System.out.println("A:" + a + " B: " + b + " X: "+ x);
 
        }
        return a;
     }

}
 

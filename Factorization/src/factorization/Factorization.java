/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Math.ceil;
import static java.lang.Math.sqrt;
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

        fermat(1, 224573);
        fermat(2, 299203);    
        fermat(3, 1963867);
        fermat(4, 6207251);
        fermat(5, 14674291);
        fermat(6, 23128513);
        fermat(7, 254855791);
        fermat(8, 428279361);

        fermat(9, 159649552547L);
        fermat(10, 189061250479L);
        fermat(11, 2211744201787L);
        fermat(12, 7828669742987L);
        fermat(13, 48560209712519L);
        fermat(14, 35872004189003L);
        fermat(15, 737785058178599L);
        fermat(16, 576460921650883L);
        fermat(17, 1957432135202107L);
        fermat(18, 2450609331732137L);
        
    }

    public static void fermat(int id, long n){

        double x = 0, y = 0;          
        while ((sqrt(n+((++y)*y))%1) != 0){}
        
        x = sqrt(n+(y*y));
        System.out.println("ID: "+ id + " The factor of " + n + " is (" + intValue(x) +"^2) - ("+ intValue(y) +"^2)" );


        return;
    }
    
}
 

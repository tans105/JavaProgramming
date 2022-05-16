package competitiveProgramming.hackerarth;

//1,4,5,10,11,12..
//2,3,6,7,8,9,13..
//3,6,11,20


/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
* uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/
import java.util.*;
//Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class BricksGame {
 public static void main(String args[] ) throws Exception {
	 Scanner sc = new Scanner(System.in);
     int num = sc.nextInt();
     boolean cont = true;
     int i = 1;
     int sum = 0;
     while(cont) {
         //Motu 
         sum += i;
         System.out.println("Sum 1:"+sum);
         if(sum >= num) {
             System.out.println("Motu");
             cont = false;
             break;
         }
         //Patlu
         sum += i*2;
         if(sum >= num) {
             System.out.println("Patlu");
             cont = false;
             break;
         }
         System.out.println("Sum 2:"+sum);
         i++;
     }
 }
}

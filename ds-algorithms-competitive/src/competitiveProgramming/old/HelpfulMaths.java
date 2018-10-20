package competitiveProgramming.old;

import java.util.Scanner;
import java.util.Arrays;

public class HelpfulMaths {
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        String s=sc.next();
        int j=0; 
        
        char[] num=new char [s.length()/2+1];
        int[] num1=new int [s.length()/2+1];
        for(int i=0;i<s.length()/2+1;i++){
        num[i]=s.charAt(j);
        num1[i] = Character.getNumericValue(num[i]);
        j=j+2;
            
           
        }
        Arrays.sort(num1);
        String s1=null;;
        for (int number : num1) {
      
       s1=s1+number+"+";
       
        }
        System.out.println(s1.substring(4, s1.length()-1));
    }
    
}

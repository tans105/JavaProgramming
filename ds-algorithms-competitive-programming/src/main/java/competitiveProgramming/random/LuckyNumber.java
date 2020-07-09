package competitiveProgramming.random;

import java.util.Scanner;


public class LuckyNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String num=sc.next();
        int count=0;
        for(int i=0;i<num.length();i++){
        if(num.charAt(i)=='4'|num.charAt(i)=='7')
                count++;
               
        }
        if((count==7|count==4))
            System.out.println("YES");
        else 
            System.out.println("NO");
    }
    
}

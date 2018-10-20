package competitiveProgramming.old;

import java.util.Scanner;


public class Stringreverse {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        String s1=null;
        
        int j=s.length();
        for(int i=0;i<s.length();i++){
        s1+=s.charAt(j-1);
        
            j--;
        }
        System.out.println(s1.substring(4));
    }
    
}

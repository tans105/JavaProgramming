package competitiveProgramming.random;

import java.util.Scanner;

public class Alphabets {

    public static void main(String args[]) {
        int n = 0;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        String s[] = new String[n];
        String s1[] = new String[n];
        int[] count = new int[n];
        int i=0,j=0;

        while (i < n) {
            s[i] = sc.next();
            count[i] = s[i].length() - 2;
            i++;
         
        }
        
         while (j < n){
            s1[j]=s[j].substring(0, 1)+count[j]+s[j].substring(s[j].length()-1,s[j].length());
            
            if(s[j].length()>10)
            System.out.println(s1[j]);
            else
                System.out.println(s[j]); 
            j++;
         }
         
    }
}
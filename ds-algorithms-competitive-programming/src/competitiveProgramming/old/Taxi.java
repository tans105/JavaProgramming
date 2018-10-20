package competitiveProgramming.old;

import java.util.Scanner;


public class Taxi {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    float sum=0;
    int[] arr=new int[n];
    
    for(int i=0;i<n;i++){
      
    arr[i]=sc.nextInt();
    sum=sum+arr[i];
      
    }
    
    
       double sum1=sum/4;
       System.out.println((int)Math.ceil(sum1));
    }
}

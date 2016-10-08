package problems;

import java.util.Scanner;



public class Pizza{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();


        for(int i=0;i<n;i++){
            int[] arr1=new int[10];
            int[] arr2=new int[10];
            for(int j=0;j<10;j++){
                arr1[j]=sc.nextInt();

            }
            for(int j=0;j<10;j++){
                arr2[j]=sc.nextInt();

            }

            int count=0;
            for(int j=0;j<10;j++){
                for(int k=0;k<10;k++){
                    if(arr1[j]==arr2[k]) count++;
                }
            }
            System.out.println(count);
        }

    }
}
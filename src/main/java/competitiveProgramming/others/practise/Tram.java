package competitiveProgramming.others.practise;

import java.util.Scanner;

public class Tram {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0, sum1 = 0, sum2=0;
        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < 2 * n; i++) {
            if (i % 2 == 0) {
                a[i / 2] = sc.nextInt();
            } else {
                b[i / 2] = sc.nextInt();
            }

        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            
            sum = sum + b[i] - a[i];
            max=Math.max(sum,max);
           
           
        }
        System.out.println(max);



    }
}

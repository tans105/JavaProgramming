package competitiveProgramming.old;

import java.util.Scanner;

public class candles {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int sum = 0;
        while (a != 0) {
            sum = sum + a/b;
            if (a % b == 0) {
                a = a / b;
            } else {
                a = a /b + a % b;
                break;
            }


        }
        System.out.println(sum);
    }
}

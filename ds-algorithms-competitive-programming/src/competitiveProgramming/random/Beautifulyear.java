package competitiveProgramming.random;

import java.util.Scanner;

public class Beautifulyear {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Digits d = new Digits(num + 1);
        int[] arr1 = new int[4];
        arr1 = d.digit();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (arr1[i] == arr1[j]) System.out.println(arr1); {
                
                }
            }
        }


    }
}

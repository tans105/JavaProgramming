package competitiveProgramming.random;

import java.util.Scanner;

public class Team {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        int[] arr = new int[3 * n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();

        }


        int count = 0;

        for (int j = 1; j <= arr.length; j++) {
            if (j % 3 == 0) {
                sum = arr[j-1] + arr[j - 2] + arr[j - 3];
                if (sum > 1) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}

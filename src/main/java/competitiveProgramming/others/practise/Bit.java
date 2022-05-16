package competitiveProgramming.others.practise;

import java.util.Scanner;

public class Bit {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = 0;
        String[] arr = new String[n];
        char[] arr1 = new char[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
            arr1[i] = arr[i].charAt(1);
            if (arr1[i] == '+') {
                k++;
            } else {
                --k;
            }
        }
        System.out.println(k);


    }
}

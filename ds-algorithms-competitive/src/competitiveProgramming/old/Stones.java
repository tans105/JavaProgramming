package competitiveProgramming.old;

import java.util.Scanner;

public class Stones {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String color = sc.next();

        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            if (color.charAt(i) == color.charAt(i + 1)) {
                count++;
            }

        }
        System.out.println(count);
    }
}

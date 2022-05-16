package competitiveProgramming.others.practise;

import java.util.Scanner;

public class Football {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String comb = sc.next();
        int count = 0;
        for (int i = 0; i < comb.length()-1; i++) {
            if (comb.charAt(i) == comb.charAt(i + 1)) {
                count++;

            } else {
                count = 0;
            }
            if (count == 6) {
                System.out.println("YES");
                return;
            }

        }
        System.out.println("NO");
    }
}

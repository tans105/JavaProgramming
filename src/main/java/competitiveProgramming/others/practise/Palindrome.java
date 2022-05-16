package competitiveProgramming.others.practise;

import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int count = 0;
        if (s.length() % 2 == 0)//even length
        {
            for (int i = 0; i < s.length() / 2; i++) {
                if (s.charAt(i) == s.charAt(s.length() - i - 1)) {
                    count++;
                }

            }
            if (count == s.length() / 2) {
                System.out.println("whoa its a palindrome");
            } else {
                System.out.println("sorry fucker");
            }
        } else {
            for (int i = 0; i < s.length() / 2; i++) {
                if (s.charAt(i) == s.charAt(s.length() - i - 1)) {
                    count++;
                }

            }
            if (count == s.length() / 2) {
                System.out.println("whoa its a palindrome");
            } else {
                System.out.println("sorry fucker");
            }
        }

    }
}
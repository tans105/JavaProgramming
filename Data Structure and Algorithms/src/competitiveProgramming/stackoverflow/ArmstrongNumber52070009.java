package competitiveProgramming.stackoverflow;

import java.util.Scanner;

class ArmstrongNumber52070009 {
	public static void main(String[] args) {
		int c = 0, a;
		int n1, n2;// Range in which armstrong number need to find

		Scanner s = new Scanner(System.in);
		System.out.println("Enter the first number");
		n1 = s.nextInt();
		System.out.println("Enter the second number");
		n2 = s.nextInt();

		for (int i = n1; i <= n2; ++i) {
			while (i > 0) {
				a = i % 10;
				System.out.println(a);
				i = i / 10;
				System.out.println(i);
				c = c + (a * a * a);
				System.out.println(c);
			}
			if (i == c)
				System.out.println(c + "armstrong number");
			else
				System.out.println(c + "Not armstrong number");

		}
	}
}
package competitiveProgramming.others.practise;

import java.util.Scanner;

public class Fraction {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;

		// i/j
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (j != i && i < j) {
					count++;
					if (j % i == 0 && i != 1) {
						count--;
					}
				}
			}
		}
		System.out.println(count);
	}
}

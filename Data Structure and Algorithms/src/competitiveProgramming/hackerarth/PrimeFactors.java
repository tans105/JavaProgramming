package competitiveProgramming.hackerarth;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeFactors {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			int minPrime = getMinPrimeFactors(num);
			System.out.println(num - minPrime);
		}
	}

	private static int getMinPrimeFactors(int num) {
		if (num == 2) {
			return 2;
		}
		if (num == 3) {
			return 3;
		}
		int minPrime = num;
		for (int i = 2; i <= num; i++) {
			if (num % i == 0 && isPrime(i)) {
				minPrime = i;
				break;
			}
		}
		return minPrime;
	}

	private static boolean isPrime(int num) {
		boolean flag = false;
		for (int i = 2; i <= num / 2; ++i) {
			// condition for nonprime number
			if (num % i == 0) {
				flag = true;
				break;
			}
		}

		if (!flag)
			return true;
		else
			return false;
	}
}

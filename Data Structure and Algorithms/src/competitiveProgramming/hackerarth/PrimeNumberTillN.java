package competitiveProgramming.hackerarth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/prime-number-8/

public class PrimeNumberTillN {
	@SuppressWarnings({ "rawtypes", "resource" })
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List primeNumber = findPrimeBetween(n);
		for(int i=0;i<primeNumber.size();i++) {
			System.out.print(primeNumber.get(i) + " ");
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static List findPrimeBetween(int n) {
		if (n == 2) {
			return Arrays.asList(2);
		} else if (n == 3) {
			return Arrays.asList(2, 3);
		} else {
			List primeNumberList = new ArrayList();
			primeNumberList.add(2);
			primeNumberList.add(3);
			for (int i = 4; i < n; i++) {
				if (isPrime(i)) {
					primeNumberList.add(i);
				}
			}
			return primeNumberList;
		}
	}

	private static boolean isPrime(int num) {
		Boolean isPrime = true;
		for (int i = 2; i < num; i++) {
			if(num%i==0) {
				return false;
			}
		}
		return isPrime;
	}
}

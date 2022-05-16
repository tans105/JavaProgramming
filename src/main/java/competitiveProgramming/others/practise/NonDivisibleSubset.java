package competitiveProgramming.others.practise;

import java.util.Scanner;

public class NonDivisibleSubset {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		Integer[] arr = new Integer[n];
		String num = "";
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			num+=arr[i].toString();
		}
		System.out.println(num);
		
	}
}

package competitiveProgramming.hackerarth;

import java.util.Arrays;
import java.util.Scanner;

public class SymmetricMatrix {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int k = sc.nextInt();
			String[] arr = new String[k];
			for (int j = 0; j < k; j++) {
				arr[j] = sc.next();
			}
			if (checkHorizontal(makeVertical(arr, k), k) && checkHorizontal(arr, k)) {
				System.out.println("BOTH");
			}
			if (checkHorizontal(makeVertical(arr, k), k) && !checkHorizontal(arr, k)) {
				System.out.println("VERTICAL");
			}
			if (checkHorizontal(arr, k) && !checkHorizontal(makeVertical(arr, k), k)) {
				System.out.println("HORIZONTAL");
			} 
			if(!checkHorizontal(arr, k) && !checkHorizontal(makeVertical(arr, k), k)){
				System.out.println("NO");
			}
		}

	}

	private static String[] makeVertical(String[] arr, int k) {
		String[] copy = new String[k];
		for (int i = 0; i < k; i++) {
			copy[i] = "";
			for (int j = 0; j < k; j++) {
				copy[i] += arr[j].charAt(i);
			}
		}
		return copy;
	}

	private static boolean checkHorizontal(String[] str, int k) {
		boolean isHorizontal = false;
		int count = 0;
		for (int i = 0; i < k / 2; i++) {
			if (str[i].equalsIgnoreCase(str[k - i - 1])) {
				count++;
			}
		}
		if (count == k / 2)
			isHorizontal = true;
		return isHorizontal;

	}

	public static void printArray(String[] arr, int k) {
		for (int i = 0; i < k; i++) {
			System.out.println(arr[i]);
		}
	}
}

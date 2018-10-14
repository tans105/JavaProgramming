package competitiveProgramming.hackerarth;

import java.util.Scanner;

//https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/best-index-1-45a2f8ff/
public class BestIndex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int sum = 0;
		int temp = 0;
		for (int i = 0; i < n; i++) {
			temp = getSpecialSum(arr, i, n);
			if (temp > sum) {
				sum = temp;
			}
		}
		System.out.println(sum);
	}

	private static int getSpecialSum(int[] arr, int index, int size) {
		int sum = arr[index];
		int numberOfTermsToBeAdded = 1;
		while (index <= size) {
			numberOfTermsToBeAdded = getIndexToBeAdded(numberOfTermsToBeAdded);
			if (index + numberOfTermsToBeAdded >= size) {
				break;
			}
			for (int i = index + 1; i <= index + numberOfTermsToBeAdded; i++) {
				sum += arr[i];
			}
			index = index + numberOfTermsToBeAdded;
		}
		return sum;
	}

	private static int getIndexToBeAdded(int init) {
		return init + 1;
	}
}

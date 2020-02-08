package competitiveProgramming.random;

import java.util.Scanner;

public class CircularArrayRotation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int q = sc.nextInt();
		int[] arr = new int[n];
		int[] query = new int[q];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 0; i < q; i++) {
			query[i] = sc.nextInt();

		}
		for (int i = 0; i < k; i++) {
			int temp = arr[n - 1];
			for (int j = n - 1; j >= 1; j--) {
				arr[j] = arr[j - 1];
			}
			arr[0] = temp;
		}

		for (int i = 0; i < q; i++) {
			System.out.println(arr[query[i]]);
		}

	}
}

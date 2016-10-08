package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NextBiggerNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer num = sc.nextInt();
		int len = num.toString().length();
		int[] intArray = toIntegerArray(len, num);

		int max = -1;
		int min = 10;

		for (int i = 0; i < len; i++) {

			if (intArray[i] > max) {
				max = intArray[i];
			}
			if (intArray[len - i - 1] < min) {
				min = intArray[len - i - 1];
			}
		}

		if (min == intArray[len - 1]) {
			System.out.println("Decreasing");
			//not possible
		}
		if (max == intArray[len - 1]) {
			System.out.println("Increasing");
			//swap last two
		} else {

			int curr = -1;
			int prev = intArray[len - 1];
			int currIndex = -1;
			int prevIndex = -1;
			for (int i = 1; i < len; i++) {
				curr = intArray[len - i - 1];
				if (curr < prev) {
					currIndex = i;
					prevIndex = i - 1;
					break;
				}
				prev = curr;
			}
			currIndex = len - 1 - currIndex;
			prevIndex = len - 1 - prevIndex;

			//swap current with left most
			int temp = intArray[len - 1];
			intArray[len - 1] = intArray[currIndex];
			intArray[currIndex] = temp;

			//count the elements to be sorted
			int count = len - prevIndex;

			//sort the remaining
			int arr[] = new int[count];
			for (int i = 0; i < count; i++) {
				arr[i] = intArray[prevIndex + i];
			}
			arr = sortArray(arr);
			int[] finalArray = new int[len];
			int j = 0;
			for (int i = 0; i < len; i++) {
				if (i < len - count) {
					finalArray[i] = intArray[i];
				} else {
					finalArray[i] = arr[j];
					j++;
				}

			}
			for (int i = 0; i < finalArray.length; i++) {
				System.out.print(finalArray[i]);
			}
		}
	}

	static int[] toIntegerArray(int len, Integer num) {
		int[] arr = new int[len];
		String s = num.toString();
		for (int i = 0; i < len - 1; i++) {
			arr[i] = Integer.parseInt(s.substring(i, i + 1));
		}
		arr[len - 1] = Integer.parseInt(s.substring(len - 1));
		return arr;
	}

	static int[] sortArray(int[] a) {
		int n = a.length;
		int temp;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (a[i] > a[j]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		return a;
	}
}

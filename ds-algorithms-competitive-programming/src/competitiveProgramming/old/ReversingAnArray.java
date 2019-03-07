package competitiveProgramming.old;

import java.util.Arrays;

/**
 * 
 * @author tanmay
 *         Reverse an array
 */
public class ReversingAnArray {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 4, 5, 6, 7, 8, 9, 0, 10 ,11};
		boolean isOdd = arr.length % 2 == 0 ? false : true;
		int temp;
		int len = arr.length;
		int loopCount = 0;
		if (isOdd) {
			loopCount = len / 2 - 1;
		} else {
			loopCount = len / 2;
		}
		for (int i = 0; i < loopCount; i++) {
			temp = arr[len - i - 1];
			arr[len - i - 1] = arr[i];
			arr[i] = temp;

		}
		printArray(arr);
	}

	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}

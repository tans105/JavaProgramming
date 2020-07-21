package competitiveProgramming.archive.algorithms.searching;

/*
 * complexity- O(logn)
 * 
 */

public class BinarySearch {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
		int left = 0;
		int right = arr.length;
		int mid = 0;
		int toFind = 11;
		while (left != right) {
			mid = 1 + (right - 1) / 2;
			if (arr[mid] == toFind) {
				break;
			} else if (arr[mid] > toFind) {
				right = mid - 1;
			} else {
				left = mid + 1;

			}
		}
		System.out.println(arr[mid]);
	}
}

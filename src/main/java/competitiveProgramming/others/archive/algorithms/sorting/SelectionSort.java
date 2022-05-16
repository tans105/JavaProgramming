package competitiveProgramming.others.archive.algorithms.sorting;

/*
 * The good thing about selection sort is it never makes more than O(n) swaps and can be useful when memory write is a costly operation.
 * complexity->O(n^2)
 */
public class SelectionSort {
	public static void main(String[] args) {

		SelectionSort ob = new SelectionSort();
		int arr[] = { 64, 25, 12, 22, 11 };
		ob.sort(arr);
		System.out.println("Sorted array");
		ob.printArray(arr);

		
		/*
		 * my solution
		 */
		int[] arr1 = { 1, 5, 4, 1, 3, 2, 1 };
		int temp = 0;
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 1; j < arr1.length; j++) {
				if (arr1[j] > arr1[i]) {
					temp = arr1[i];
					arr1[i] = arr1[j];
					arr1[j] = temp;
				} else {
					continue;
				}
			}
		}

		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}
	}

	void sort(int arr[]) {
		int n = arr.length;

		// One by one move boundary of unsorted subarray
		for (int i = 0; i < n - 1; i++) {
			// Find the minimum element in unsorted array
			int min_idx = i;
			for (int j = i + 1; j < n; j++)
				if (arr[j] < arr[min_idx])
					min_idx = j;

			// Swap the found minimum element with the first
			// element
			int temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
		}
	}

	void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}

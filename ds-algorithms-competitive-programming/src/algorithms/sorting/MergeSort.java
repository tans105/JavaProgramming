package algorithms.searchingandsorting;

public class MergeSort {
	public static void main(String[] args) {
		int arr[] = { 5, 4, 3, 2, 1 };

		System.out.println("Given Array");
		printArray(arr);

		MergeSort ob = new MergeSort();
		ob.sort(arr, 0, arr.length - 1);

		System.out.println("\nSorted array");
		printArray(arr);
	}

	void sort(int[] arr, int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;
			sort(arr, l, m);
			sort(arr, m + 1, r);
			System.out.println("left is......" + l + " middle is....." + m + " right is......" + r );
			merge(arr, l, m, r);
		}

	}

	void merge(int[] arr, int l, int m, int r) {

		int[] L = new int[m - l + 1];
		int[] R = new int[r - m];
//		System.out.println("left is......" + l + " middle is....." + m + " right is......" + r + " Left Array Length " + L.length + " Right Array Length " + R.length);

		for (int i = 0; i < L.length; i++) {
			L[i] = arr[l + i];
		}
		for (int i = 0; i < R.length; i++) {
			R[i] = arr[m + i + 1];
		}
//		printArray(L);
//		printArray(R);

		int k = l;// main counter
		int i = 0;// left counter
		int j = 0;// right counter

		while (i < L.length && j < R.length) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		while (i < L.length) {
			arr[k++] = L[i];
			i++;
		}

		while (j < R.length) {
			arr[k++] = R[j];
			j++;
		}
//		System.out.println("COmplete Array ----------");
//		printArray(arr);
	}

	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}

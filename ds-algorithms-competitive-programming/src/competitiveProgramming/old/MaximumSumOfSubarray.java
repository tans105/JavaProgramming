package competitiveProgramming.old;

public class MaximumSumOfSubarray {
	public static void main(String[] args) {
		int arr[] = { 12, 3, -2, -14, 15, 15 };
		int maxSoFar = 0;
		int maxEndingHere = 0;

		for (int i = 0; i < arr.length; i++) {
			maxEndingHere = maxEndingHere + arr[i];
			if (maxEndingHere < 0) {
				maxEndingHere = 0;
			}
			if (maxEndingHere > maxSoFar) {
				maxSoFar = maxEndingHere;
			}

		}
		System.out.println(maxSoFar);
	}
}

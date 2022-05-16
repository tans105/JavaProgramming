package competitiveProgramming.others.practise;

public class SortArray {
	public static void main(String[] args) {
		int[] arr = { 0, 2, 1, 2, 0 };

		int count1 = 0;
		int count0 = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				count0++;
			}
			if (arr[i] == 1) {
				count1++;
			}
		}

		int index0 = count0;
		int index1 = index0 + count1;
		int index2 = index1;

		for (int i = 0; i < arr.length; i++) {
			if (i < index0)
				arr[i] = 0;
			if (i > index0 && i < index2)
				arr[i] = 1;
			if (i > index2)
				arr[i] = 2;
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}

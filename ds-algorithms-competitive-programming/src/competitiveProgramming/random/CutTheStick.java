package competitiveProgramming.random;

import java.util.*;

public class CutTheStick {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int arr_i = 0; arr_i < n; arr_i++) {
			arr[arr_i] = in.nextInt();
			list.add(arr[arr_i]);
		}
		int offset = 0;

		ArrayList<Integer> index = new ArrayList<Integer>();
		int size = list.size();
		while (offset != size - 1) {
			int min = findMin(list);
			for (int i = 0; i < size; i++) {
				if (list.get(i) == 0 && !index.contains(i)) {
					index.add(i);
					offset++;
				} 
				list.set(i, list.get(i) - min);
			}
			System.out.println(size - index.size());
		}

	}

	static public int findMin(ArrayList<Integer> list) {
		int min = Collections.max(list);
		for (int i = 0; i < list.size(); i++) {
			int element = list.get(i);
			if (element < min && element > 0) {
				min = element;
			}
		}
		return min;
	}
}
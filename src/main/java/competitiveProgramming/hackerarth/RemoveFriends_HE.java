package competitiveProgramming.hackerarth;

import java.util.LinkedList;
import java.util.Scanner;

public class RemoveFriends_HE {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();//number of test cases
		int[] n = new int[t];
		int[] k = new int[t];
		for (int j = 0; j < t; j++) {
			n[j] = sc.nextInt();
			k[j] = sc.nextInt();
			LinkedList<Integer> list = new LinkedList<Integer>();
			for (int m = 0; m < n[j]; m++) {
				list.add(sc.nextInt());
			}
			int removed = 0;
			for (int i = 0; i < list.size() - 1; i++) {
				if (list.get(i) < list.get(i + 1)) {
					list.set(i, -1);
					removed++;
				}
				if (removed == k[j]) {
					break;
				}
			}
			int diff = k[j] - removed;

			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) != -1 && diff > 0) {
					diff--;
					continue;
				}
				if (diff <= 0 && list.get(i) != -1)
					System.out.print(list.get(i) + " ");

			}

			System.out.println();
		}

		//	

	}

}

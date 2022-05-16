package competitiveProgramming.hackerarth;

import java.util.LinkedList;
import java.util.Scanner;

public class RemoveFriendsRevised_HE {
	public static void main(String[] args) {
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
			for (int i = 0; i < k[j]; i++) {
				deleteFriend(list);
			}
			for(int i=0;i<list.size();i++){
				System.out.print(list.get(i)+" ");
			}
//			System.out.println(list);
			System.out.println();
		}

	}

	public static LinkedList<Integer> deleteFriend(LinkedList<Integer> list) {
		boolean delete = false;
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i) < list.get(i + 1)) {
				list.remove(i);
				delete = true;
				break;
			}
		}
		if (delete = false) {
			list.remove(list.size() - 1);
		}
		return list;
	}
}

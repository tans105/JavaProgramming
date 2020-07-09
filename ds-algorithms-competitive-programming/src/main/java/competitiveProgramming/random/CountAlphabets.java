package competitiveProgramming.random;

import java.util.Scanner;

public class CountAlphabets {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String[] arr = toStringArray(s);

		String prev = arr[0];
		Integer count = 0;
		int j = 0;
		for (int i = 0; i < arr.length; i++) {

			if (arr[i].equals(prev)) {
				count++;
			} else {
				arr[j] = prev;
				arr[j + 1] = count.toString();
				j = j + 2;
				count = 1;

			}
			prev = arr[i];
		}
		arr[j]=prev;
		arr[j+1]=count.toString();
		j=j+2;
		for(int i=j;i<arr.length;i++){
			arr[i]=" ";
		}
		printArray(arr);
	}

	static String[] toStringArray(String s) {
		String[] arr = new String[s.length()];
		for (int i = 0; i < s.length() - 1; i++) {
			arr[i] = s.substring(i, i + 1);
		}
		arr[s.length() - 1] = s.substring(s.length() - 1);
		return arr;

	}

	static void printArray(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	}

}

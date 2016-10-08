package problems;

import java.util.Scanner;

public class BeautifulString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] strings = new String[n];
		for (int j = 0; j < n; j++) {
			strings[j] = sc.next();

			int count = 0;
			int indexA = 0;
			int indexB = 1;
			int indexC = 2;
			String myString = strings[j];
			for (int i = 0; i < myString.length(); i++) {
				if (i == indexA) {
					if (myString.charAt(i) == 'a') {
						indexA += 3;
						continue;
					} else {
						indexA += 3;
						count++;
					}
				}
				if (i == indexB) {
					if (myString.charAt(i) == 'b') {
						indexB += 3;
						continue;
					} else {
						indexB += 3;
						count++;
					}
				}
				if (i == indexC) {
					if (myString.charAt(i) == 'c') {
						indexC += 3;
						continue;
					} else {
						indexC += 3;
						count++;
					}
				}
			}

			System.out.println(count);

		}
	}
}

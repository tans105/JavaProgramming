package problems;

import java.util.Scanner;

public class RepeatedString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		Double num = sc.nextDouble();
		Double factor = num / s.length();
		int countA = getCountOfA(s);
		int remainder=(int) (num%s.length());
		System.out.printf("%.0f\n", countA*Math.floor(factor)+getCountOfA(s.substring(0,remainder)));
	}

	public static int getCountOfA(String s) {
		int count = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a')
				count++;
		}
		return count;
	}

}

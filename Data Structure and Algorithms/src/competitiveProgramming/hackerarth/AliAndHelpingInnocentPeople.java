package competitiveProgramming.hackerarth;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/cartag-948c2b02/

public class AliAndHelpingInnocentPeople {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String name = s.nextLine();
		int count = 0;
		int val = 0;
		int sum = 0;
		int previousVal = 0;
		Boolean invalid = false;
		List vowels = Arrays.asList("A", "E", "I", "O", "U", "Y");
		for (int i = 0; i < name.length(); i++) {
			try {
				val = Integer.parseInt(name.substring(i, i + 1));
				count++;
				if (count == 2) {
					sum = val + previousVal;
					System.out.println(sum);
					if (sum % 2 != 0) {
						invalid = true;
						break;
					}
					count = 1;
					previousVal = val;
				} else {
					previousVal = val;
				}
			} catch (Exception e) {
				String str = name.substring(i, i + 1);
				if (!str.equals("-") && vowels.contains(str)) {
					System.out.println(str);
					invalid = true;
				}
				sum = 0;
				count = 0;
				val = 0;
				previousVal = 0;
			}
		}

		if (invalid) {
			System.out.println("invalid");
		} else {
			System.out.println("valid");
		}
	}
}

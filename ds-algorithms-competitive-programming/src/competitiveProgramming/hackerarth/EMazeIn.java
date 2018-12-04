package competitiveProgramming.hackerarth;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/
import java.util.*;
// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class EMazein {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		String dir = sc.next();
		int x = 0, y = 0;
		for (int i = 0; i < dir.length(); i++) {
			if (dir.charAt(i) == 'L') {
				x = x - 1;
			}
			if (dir.charAt(i) == 'R') {
				x = x + 1;
			}
			if (dir.charAt(i) == 'D') {
				y = y - 1;
			}
			if (dir.charAt(i) == 'U') {
				y = y + 1;
			}
		}
		System.out.println(x + " " + y);

	}
}

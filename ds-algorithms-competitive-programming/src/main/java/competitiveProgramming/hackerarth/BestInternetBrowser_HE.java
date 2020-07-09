package competitiveProgramming.hackerarth;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author tanmay
 * @link https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/the-best-internet-browser-3/
 */
public class BestInternetBrowser_HE {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			String address = sc.next();
			String orig=address;
			address = address.replace("a", "");
			address = address.replace("e", "");
			address = address.replace("i", "");
			address = address.replace("o", "");
			address = address.replace("u", "");
			int index = address.substring(4).indexOf('.');
			String newStr = address.substring(4, index + 4) + ".com";
			System.out.println(newStr.length() + "/" + orig.length());
		}
	}
}

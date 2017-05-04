package CompetitiveProgramming.HackerEarth;

import java.util.Scanner;

public class ToggleString_HE {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		StringBuffer sb=new StringBuffer(s);
		for (int i = 0; i < s.length(); i++) {
			if (Character.isLowerCase(s.charAt(i))) {
				sb.setCharAt(i, Character.toUpperCase(s.charAt(i)));
			} else {
				sb.setCharAt(i, Character.toLowerCase(s.charAt(i)));
			}
			
		}
		System.out.println(sb.toString());
	}
}

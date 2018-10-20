package competitiveProgramming;

public class LongestSubstring {
	public static void main(String[] args) {
		System.out.println(longestString("dsaad"));
	}

	public static String longestString(String s) {
		String longestSoFar = "";
		String longestEver = "";
		for (int i = 0; i < s.length(); i++) {
			if (longestSoFar.length() == 0) {
				longestSoFar = longestSoFar + s.charAt(i);
			}
			if (!longestSoFar.contains(s.substring(i, i + 1))) {
				longestSoFar = longestSoFar + s.substring(i, i + 1);
				if (longestSoFar.length() > longestEver.length()) {
					longestEver = longestSoFar;
				}
			} else {
				longestSoFar = s.substring(i, i + 1);
				if(longestEver.length()==0){
					longestEver=longestSoFar;
				}
			}
		}
		return longestEver;
	}
}

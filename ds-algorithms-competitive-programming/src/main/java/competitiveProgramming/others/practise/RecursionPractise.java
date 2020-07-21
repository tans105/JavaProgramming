package competitiveProgramming.others.practise;

public class RecursionPractise {

	public static void main(String[] args) {
		/*
		 * int[] arr = { 1, 2, 11, 23, 11, 23, 11, 11 };
		 * System.out.println(array11(arr, 0));
		 */

		String s = "hello";
		System.out.println(pairStar(s));
	}

	/*
	 * 
	 */
	public static String pairStar(String s) {
		if (s.equals(""))
			return s;
		if (s.substring(0, 1).equals(s.substring(1, 2))) {
			System.out.println("hehe");
			return s.substring(0, 1) + "*" + s.substring(1, 2) + pairStar(s.substring(3));
		} else {
			System.out.println("woho");
			return s.charAt(0) + pairStar(s.substring(1));
		}
	}

	/*
	 * input- hello output- h*e*l*l*o
	 */
	public static String allStar(String s) {
		if (s.substring(1).equals(""))
			return s;
		else {
			return s.charAt(0) + "*" + allStar(s.substring(1));
		}

	}

	/*
	 * count the number of times 11 appear in an array
	 */
	public static int array11(int[] arr, int index) {
		if (index == arr.length)
			return 0;
		if (arr[index] == 11)
			return 1 + array11(arr, index + 1);
		else
			return array11(arr, index + 1);
	}

	/*
	 * Removes character input -xxnxx output-n
	 */
	public static String removeX(String s) {
		if (s.equals(""))
			return s;
		if (s.charAt(0) == 'x')
			return "" + removeX(s.substring(1));
		else {
			return s.charAt(0) + removeX(s.substring(1));
		}
	}

	/*
	 * Convert a string sequence to another string sequence
	 */

	public static String changePi(String str) {
		if (str.length() < 2)
			return str;
		if (str.substring(0, 2).equals("pi"))
			return "3.14" + changePi(str.substring(2));
		return str.charAt(0) + changePi(str.substring(1));
	}

}

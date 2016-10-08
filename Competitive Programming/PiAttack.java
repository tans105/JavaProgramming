package problems;

public class PiAttack {
	public static void main(String[] args) {
		String s = "aspiasccbpizxzpi";
		System.out.println(changePi(s));
		/*System.out.println(s.replaceAll("p", "3.14"));*/
	}

	public static String changePi(String str) {
	    if (str.length() < 2) return str;
	    if (str.substring(0, 2).equals("pi"))
	        return "3.14" + changePi(str.substring(2));
	    return str.charAt(0) + changePi(str.substring(1));
	}
}

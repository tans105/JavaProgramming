package competitiveProgramming.others.practise;

public class RemoveX {
	public static void main(String[] args) {
		String s = "xnxx";
		System.out.println(removeX(s));
	}

	public static String removeX(String s) {
		if (s.equals(""))
			return s;
		if (s.charAt(0) == 'x')
			return "" + removeX(s.substring(1));
		else {
			return s.charAt(0) + removeX(s.substring(1));
		}
	}
}

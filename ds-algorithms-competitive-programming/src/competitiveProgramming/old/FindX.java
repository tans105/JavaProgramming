package competitiveProgramming.old;

public class FindX {
	public static void main(String[] args) {
		String s = "xhxxhxxxs";
		System.out.println(countX(s));
	}

	public static int countX(String s) {

		
		if (s.equals(""))
			return 0;
		if (s.substring(0, 1).equals("x")) {
			return 1 + countX(s.substring(1));
		} else {
			return countX(s.substring(1));
		}
	}

}

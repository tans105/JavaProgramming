package competitiveProgramming;

public class SearchAStringInAParagraph {
	public static void main(String[] args) {
		String text = "HelloreadersHello";
		String key = "Hello";
		approach1(text, key);
	}

	public static void approach1(String strOrig, String key) {
		int intIndex = strOrig.indexOf(key);

		if (intIndex == -1) {
			System.out.println("Hello not found");
		} else {
			System.out.println("Found Hello at index " + intIndex);
		}
	}

	public static void approach2(String text, String key) {
		int len = key.length();
		char[] strArray = key.toCharArray();
		for (int i = 0; i < text.length() - key.length(); i++) {
			
		}
	}
}

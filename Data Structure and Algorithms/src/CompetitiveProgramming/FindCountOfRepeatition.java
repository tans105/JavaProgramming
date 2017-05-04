package CompetitiveProgramming;

public class FindCountOfRepeatition {
	public static void main(String[] args) {
		String val = "daaabbbbccccccaaasssssssdddddwwwww";//i=2 counter=2 a3 d1a3b4c5

		Integer counter = 1;
		Integer smallCnt = 0;
		int len = val.length();
		for (int i = 0; i < len; i++) {
			if (val.charAt(i) == val.charAt(i + 1)) {
				counter++;
				continue;
			}
			val += val.charAt(i) + counter.toString();
			counter = 1;
		}
		
		System.out.println(val.substring(len));
	}
}

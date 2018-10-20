package competitiveProgramming;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountOfNumber {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		map.put('0', 0);
		map.put('1', 0);
		map.put('2', 0);
		map.put('3', 0);
		map.put('4', 0);
		map.put('5', 0);
		map.put('6', 0);
		map.put('7', 0);
		map.put('8', 0);
		map.put('9', 0);

		for (int i = 0; i < n.toString().length(); i++) {
			////System.out.println(n.toString().charAt(i));
			if (map.containsKey(n.toString().charAt(i))) {
				map.put(n.toString().charAt(i), map.get(n.toString().charAt(i)) + 1);
			}
		}
		//System.out.println(map);

		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
}

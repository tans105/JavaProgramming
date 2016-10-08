package problems;

import java.util.ArrayList;

import org.apache.commons.lang3.math.NumberUtils;

public class SumOfNumbers {
	public static void main(String[] args) {

		String s = "geeks4geeks";
		String temp = "";
		Integer sum = 0;

		for (int i = 0; i < s.length(); i++) {
			String myNum = s.substring(i, i + 1);
			if (NumberUtils.isNumber(myNum)) {
				temp += myNum;
				System.out.println("temp is :" + temp);
			} else {
				if (NumberUtils.isNumber(temp)) {
					sum += Integer.parseInt(temp);
					temp = "";
				}
			}

		}
		System.out.println(sum);
	}
}

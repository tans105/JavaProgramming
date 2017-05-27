package competitiveprogramming;

import java.util.LinkedList;
import java.util.List;

public class ConvertNumberToBitWise {
	public LinkedList convertToBits(int num) {
		List list = new LinkedList<Integer>();
		if (num == 0) {
			list.add(0);
			return (LinkedList) list;
		} else {
			while (num != 1) {
				if (num % 2 == 0) {
					list.add(num % 2);
					num = num / 2;
				} else {
					list.add(num % 2);
					num = (int) Math.floor(num / 2);
				}
			}
			list.add(1);
			return (LinkedList) list;
		}
	}
	
	public LinkedList reverseBitWise(int num){
		List list = new LinkedList<Integer>();
		if (num == 0) {
			list.add(1);
			return (LinkedList) list;
		} else {
			while (num != 1) {
				if (num % 2 == 0) {
					list.add(1);
					num = num / 2;
				} else {
					list.add(0);
					num = (int) Math.floor(num / 2);
				}
			}
			list.add(0);
			return (LinkedList) list;
		}
	}
}

package CompetitiveProgramming;

import java.util.LinkedList;

public class HammingDistance {
	public static void main(String[] args) {
		ConvertNumberToBitWise convert = new ConvertNumberToBitWise();
		LinkedList<Integer> l1 = convert.convertToBits(0);
		int lengthL1 = l1.size();
		LinkedList<Integer> l2 = convert.convertToBits(1);
		int lengthL2 = l2.size();
		System.out.println(l1);
		System.out.println(l2);
		int diff = lengthL1 - lengthL2;
		if (diff > 0) {
			l2 = prependZeros(l2, diff);
		} else {
			l1 = prependZeros(l1, -diff);
		}
		System.out.println(l1);
		System.out.println(l2);
		System.out.println(computeHammingDistance(l1, l2));
	}

	private static int computeHammingDistance(LinkedList<Integer> l1, LinkedList<Integer> l2) {
		int count = 0;
		for (int i = 0; i < l1.size(); i++) {
			if (l1.get(i) != l2.get(i)) {
				count++;
			}
		}
		return count;

	}

	public static LinkedList<Integer> prependZeros(LinkedList<Integer> list, int diff) {
		for (int i = 0; i < diff; i++) {
			list.add(0);
		}
		return list;
	}
}

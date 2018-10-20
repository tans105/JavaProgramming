package competitiveProgramming.hackerarth;
//https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/anagrams-651/description/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * 37+70 number of uncommon characters + new length ( b - a )
 */

public class Anagrams {
	@SuppressWarnings({ "rawtypes", "unused" })
	public static void main(String[] args) {

		String s1 = "aiustdiagsdiiiiiiiiiyasdhkagdyafdfasdfausda";
		String s2 = "ajkgdiuagdiyafdiayfdkafdkadfad";
		List l1 = toCharList(s1.toCharArray());
		List l2 = toCharList(s2.toCharArray());
		List l1clone = toCharList(s1.toCharArray());
		List l2clone = toCharList(s2.toCharArray());
		System.out.println(getCount(l1, l2, l1clone, l2clone));

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List toCharList(char[] arr) {
		List l = new ArrayList();
		for (int i = 0; i < arr.length; i++) {
			l.add(arr[i]);
		}
		return l;
	}

	@SuppressWarnings("rawtypes")
	public static int getCount(List l1, List l2, List l1Clone, List l2Clone) {
		int count = 0;
		ListIterator itr = l1Clone.listIterator();

		while (itr.hasNext()) {
			if (!l2.contains(itr.next())) {
				itr.remove();
				count++;
			}
		}

		itr = l2Clone.listIterator();

		while (itr.hasNext()) {
			if (!l1.contains(itr.next())) {
				itr.remove();
				count++;
			}
		}

		int size1 = l1Clone.size();
		int size2 = l2Clone.size();
		return (size1 > size2) ? count + (size1 - size2) : count + (size2 - size1);
	}
}

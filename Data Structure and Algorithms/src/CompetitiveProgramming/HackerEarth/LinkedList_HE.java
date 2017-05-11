package CompetitiveProgramming.HackerEarth;

import java.util.LinkedList;

public class LinkedList_HE {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(0);
		list.add(6);
		list.add(6);
		list.add(12);
		list.add(12);
		list.add(13);
		list.add(13);
		list.add(14);
		list.add(14);
		LinkedList<Integer> compressedList=compressParticulars(list);
		System.out.println(compressedList);
		for(int i=0;i<compressedList.size()-2;i++){
			System.out.println("interval --"+compressedList.get(i)+" "+compressedList.get(i+1) );
		}
	}
	public static LinkedList<Integer> compressParticulars(LinkedList<Integer> list){
		LinkedList<Integer> dummy=new LinkedList<Integer>();
		dummy.add(list.get(0));
		for(int i=1;i<list.size()-1;i=i+2){
			dummy.add(list.get(i));
		}
		dummy.add(list.get(list.size()-1));
		return dummy;
	}
}

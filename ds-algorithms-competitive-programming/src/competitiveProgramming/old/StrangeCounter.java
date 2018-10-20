package competitiveProgramming.old;

import java.util.Scanner;
import java.util.Stack;

public class StrangeCounter {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long time = sc.nextLong();
		// long offset=3;
		// long value=3;
		//
		// for(int i=0;i<time-1;i++){
		//
		// value--;
		// if(value==0){
		// offset=offset*2;
		//
		// value=offset;
		// }
		//
		//
		// }
		// System.out.println(value);
		double i = (1 / Math.log10(2)) * Math.log10(time / 3);
		double startN=3*Math.pow(2, i);
		
		double startT=3;
		int j=0;
		while(j!=10){
			System.out.println(startT+3*Math.pow(2, j));
			j++;
		}
		
		
		

	}
}

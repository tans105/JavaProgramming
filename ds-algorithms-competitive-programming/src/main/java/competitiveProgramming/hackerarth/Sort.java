package competitiveProgramming.hackerarth;

import java.util.Scanner;

public class Sort {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		long n=sc.nextLong();
		for(long l=0;l<n;l++){
			long num=sc.nextLong();
			Double d=Math.pow(2, (num-1)*2)+5;
			System.out.println(d.intValue());
		}
	}
}

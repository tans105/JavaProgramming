package competitiveProgramming.hackerarth;

import java.util.Scanner;

public class MaxProduct_HE {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		long n=sc.nextLong();
		long[] arr=new long[(int) n];
		for(int i=1;i<=n;i++){
			if(i<=2){
				System.out.println("-1");
				continue;
			}
			System.out.println(i*(i-1)*(i-2));
		}
		
	}
}

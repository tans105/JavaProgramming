package problems;

import java.util.ArrayList;
import java.util.Scanner;

public class HourGlass {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int[] arr = new int[6 * 6];
		for (int i = 0; i < 36; i++) {
			arr[i] = in.nextInt();
		}
		int max = 0;
		int sum = 0;
		for (int i = 0; i < 21; i++) {
			
			sum = sum + arr[i] + arr[i + 1] + arr[i + 2] + arr[i + 7] + arr[i + 12] + arr[i + 13] + arr[i + 14];
			if(sum>max){
				max=sum;
			}
			
			sum=0;

		}
		System.out.println(max);
		
	}
}

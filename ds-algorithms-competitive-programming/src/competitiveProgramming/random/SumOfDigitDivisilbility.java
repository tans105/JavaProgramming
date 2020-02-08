package competitiveProgramming.random;

import java.util.Scanner;

/*
 * Asked by Drishti Soft
 */
public class SumOfDigitDivisilbility {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] arr = new int[n];
		int[] arr1 = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			
		}
		
		
		for (int i = 0; i < n; i++) {
			int sum = 0;
			arr1[i]=arr[i];
			while (arr[i] != 0) {
				sum = sum + arr[i] % 10;
				arr[i] = arr[i] / 10;

			}

			if(arr1[i]%sum==0){
				System.out.println("1");
			}
			else{
				System.out.println("0");
			}
		}

	}
}

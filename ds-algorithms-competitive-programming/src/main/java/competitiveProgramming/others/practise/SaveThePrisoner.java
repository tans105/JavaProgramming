package competitiveProgramming.others.practise;

import java.util.Scanner;

public class SaveThePrisoner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int s = sc.nextInt();
		int toBeWarned=0;
		
		toBeWarned=s+(m)%n-1;
		
		System.out.println(toBeWarned);
	}
}

package competitiveProgramming.old;

import java.util.*;

public class Staircase {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = n; i > 0; i--) {
			
			
			for (int j = 0; j < i-1; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k < n-i+1 ; k++) {
				System.out.print("#");
			}
			System.out.println();
		}
	}
}

package competitiveProgramming.hackerarth;

import java.util.Scanner;

public class GCDGame_HE {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int j = 0; j < n; j++) {
			int arijit = sc.nextInt();
			int chandu = sc.nextInt();
			//System.out.println("ARIJIT " + arijit + " Chandu " + chandu);
			int i = 0;
			
			String winner = "";
			if (chandu == 1 && arijit == 1) {
				winner = "Draw";
			}
			while (arijit != 1 || chandu != 1) {
				if (chandu == 1 && arijit == 1) {
					winner = "Draw";
					break;
				}
				if (chandu == 1) {
					winner = "Arjit";
					break;
				}
				if (arijit == 1) {
					winner = "Chandu Don";
					break;
				}
				int gcd = gcd(arijit, chandu);
				System.out.println("GCD of :" + arijit + " " + chandu + " is " + gcd);
				if (i % 2 == 0) {//arjit
					if (gcd > 1) {
						chandu = Math.min(chandu - 1, chandu / gcd);
					}
					if (gcd == 1) {
						chandu--;
					}
				} else {//chandu
					if (gcd > 1) {
						arijit = Math.min(arijit - 1, arijit / gcd);
					}
					if (gcd == 1) {
						arijit--;
					}
				}
				i++;
				/*
				 * System.out.println("ARIJIT " + arijit);
				 * System.out.println("CHANDU :" + chandu);
				 */

			}
			System.out.println(winner);
		}
	}

	public static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
}

package competitiveProgramming.hackerarth;

import java.util.Arrays;
import java.util.Scanner;

public class IkshuAndHisMachineGun_HE {

	public static void main(String args[]) {
		Scanner ob = new Scanner(System.in);
		int n = ob.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = ob.nextInt();
		Arrays.sort(a);
		for (int i = 0; i < n; i++)
			System.out.print((a[i] - i) + " ");
	}
}
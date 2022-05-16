package competitiveProgramming.hackerarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeGame_HE {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T > 0) {
			String[] str = br.readLine().split(" ");

			int N = Integer.parseInt(str[0]);
			long[] arr = new long[N];
			long L = Long.parseLong(str[1]);
			long R = Long.parseLong(str[2]);
			str = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				arr[j] = Long.parseLong(str[j]);
			}
			long count = 0;
			for (long j = L; j <= R; j++) {
				boolean fl = false;
				for (int k = 0; k < arr.length; k++) {
					if (j % arr[k] == 0) {
						fl = true;
						break;
					}
				}
				if (fl) {
					count++;
				}
			}
			System.out.println(count);
			T--;

		}
	}

	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}

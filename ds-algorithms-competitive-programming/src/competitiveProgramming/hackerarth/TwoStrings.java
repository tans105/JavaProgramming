package competitiveProgramming.hackerarth;

import java.util.Arrays;
import java.util.Scanner;

//https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/roy-and-profile-picture/
public class TwoStrings {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		String s1,s2;
		char[] c1,c2;
		boolean flag = false;
		for(int i=0;i<n;i++) {
			s1=sc.next();
			s2=sc.next();
			c1 = s1.toCharArray();
			Arrays.sort(c1);
			c2 = s2.toCharArray();
			Arrays.sort(c2);
			if(c1.length!=c2.length) {
				System.out.println("NO");
				continue;
			}else {
				for(int j=0;j<c1.length;j++) {
					if(c1[j]!=c2[j]) {
						System.out.println("NO");
						flag = true;
						break;
					}
				}
				if(!flag) {
					System.out.println("YES");	
				}
				flag = false;
			}
		}
	}
}

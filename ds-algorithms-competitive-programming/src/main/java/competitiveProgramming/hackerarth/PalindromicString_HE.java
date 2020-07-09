package competitiveProgramming.hackerarth;

import java.util.Scanner;

public class PalindromicString_HE {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		int count=0;
		for(int i=0;i<s.length()/2;i++){
			if(s.charAt(i)==s.charAt(s.length()-i-1)){
				count++;
			}
		}
		System.out.println(count);
		if(count==s.length()/2){
			System.out.println("YES");
		}
		else{
			System.out.println("NO");
		}
	}
}

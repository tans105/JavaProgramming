package competitiveProgramming.random;
import java.util.Scanner;

public class Hq {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		String str = scn.nextLine();
		
		if(str.contains("H") ||str.contains("Q") ||str.contains("9")){
			System.out.println("YES");
		} else{
			System.out.println("NO");
		}
		scn.close();
	}

}
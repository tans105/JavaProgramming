
import java.util.Scanner;

public class Petya_strings {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();

        if (s1.toLowerCase().compareTo(s2.toLowerCase())>0)
    		System.out.println(1);
    	else
    		if (s1.toLowerCase().compareTo(s2.toLowerCase())<0)
    			System.out.println(-1);
    		else
    			System.out.println(0);

    }
}

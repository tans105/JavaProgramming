package competitiveProgramming.old;
import java.util.Scanner;

public class capslock {

    public static void main (String [] args) {
    	Scanner sc=new Scanner(System.in);
    
    	
    	String b=sc.nextLine();
    	if (b.toUpperCase().equals(b))
    		System.out.println(b.toLowerCase());
    	else
    	if (b.substring(1).toUpperCase().equals(b.substring(1))){
    	System.out.println((b.charAt(0)+"").toUpperCase() +b.substring(1).toLowerCase());
    	}
    	else
    		System.out.println(b);
    		
    	
    }
    
    
}
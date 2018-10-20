package competitiveProgramming.old;
import java.util.*;

public class JVMCrash {
	public static void main(String[] args) {
		for(int i=0;i<Integer.MAX_VALUE;i++){
			Calendar.getInstance();
			System.out.println(i);
		}
	}
}

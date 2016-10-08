
import java.util.Scanner;

public class substring {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(0)) {
                for (int j = 0; j < s2.length(); j++) {
                    if (s1.charAt(i + j) == s2.charAt(j)) {
                        count++;
                        
                    } else {
                        count = 0;
                        break;

                    }
                   
                }

            }
 if(count==s2.length())break;
        }
        System.out.println(count);

    }
}

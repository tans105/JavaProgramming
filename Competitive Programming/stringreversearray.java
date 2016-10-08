
import java.util.Scanner;

public class stringreversearray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] chararray = new char[s.length()];
        char[] chararray1 = new char[s.length()];
        chararray = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            chararray1[i] = chararray[s.length() - i - 1];
            System.out.print(chararray1[i]);
        }

    }
}

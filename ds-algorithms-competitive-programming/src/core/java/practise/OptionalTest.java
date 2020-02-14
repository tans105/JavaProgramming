package core.java.practise;

import javax.swing.text.html.Option;
import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        String[] arr = new String[10];
        arr[5] = "A";
        if (Optional.ofNullable(arr[5]).isPresent()) {
            System.out.println("1");
        } else {
            System.out.println(2);
        }


        Optional<String> s = Optional.of(arr[5]);
        if(s.isPresent())  {
            System.out.println("Yes");
        }
    }
}

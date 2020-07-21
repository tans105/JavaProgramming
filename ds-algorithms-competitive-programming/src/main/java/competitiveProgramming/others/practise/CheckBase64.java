package competitiveProgramming.others.practise;


import java.util.Base64;

public class CheckBase64 {
    public static void main(String[] args) {
        CheckBase64 base = new CheckBase64();
        System.out.println(base.isBase64("bmlrdV9wZ190aW1wYTA1"));
    }

    public boolean isBase64(String str) {
        if(str == null || str.length() == 0) return false;

        try {
            Base64.getDecoder().decode(str);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }
}

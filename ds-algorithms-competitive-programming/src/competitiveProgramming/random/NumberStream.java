package competitiveProgramming.random;

public class NumberStream {

    public static String NumberStream(String str) {
        if(str == null || str.length() == 0) return "false";

        int currentCount = 1;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i - 1)) {
                if (currentCount >= Integer.parseInt(String.valueOf(str.charAt(i - 1)))) {
                    return "true";
                }
                currentCount = 1;
            } else {
                currentCount++;
            }
        }
        return "false";
    }

    public static void main(String[] args) {
        System.out.println(NumberStream(""));
        System.out.println(NumberStream("5556293383563665"));
        System.out.println(NumberStream("6539923335"));
        System.out.println(NumberStream("5788888888882339999"));
    }
}

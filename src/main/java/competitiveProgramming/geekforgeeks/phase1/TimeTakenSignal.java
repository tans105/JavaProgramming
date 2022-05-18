package competitiveProgramming.geekforgeeks.phase1;
//https://www.geeksforgeeks.org/find-time-taken-for-signal-to-reach-all-positions-in-a-string/

public class TimeTakenSignal {
    public static void main(String[] args) {
        String input = "oooxoooooooooxooo";
        int max = 0;
        int i = 0;
        boolean x = false;
        int count = 0;
        while (i < input.length()) {
            if (input.charAt(i) == 'x' && x) { //x-x linkage
                x = false;
                if ((int) Math.ceil((double) count / (2)) > max) {
                    max = (int) Math.ceil((double) count / (2));
                }
                count = 0;
            } else if (input.charAt(i) == 'x' && !x) { //x start
                if (count > max) {
                    max = count;
                }
                count = 0;
                x = true;
            }

            if (input.charAt(i) == 'o') {
                count++;
            }
            i++;
        }
        if (count > max) {
            max = count;
        }
        System.out.println(max);
    }
}

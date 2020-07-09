package competitiveProgramming.hackerrank;

public class CountHoles {
    public static void main(String[] args) {
        System.out.println(countHoles(819));
    }

    public static int countHoles(int num) {

        int remainder;
        int holes = 0;
        while (num != 0) {
            remainder = num % 10;
            num = num / 10;

            if (remainder == 0 || remainder == 4 || remainder == 6 || remainder == 9) {
                holes++;
            }
            if (remainder == 8) {
                holes += 2;
            }
        }
        return holes;
    }

}

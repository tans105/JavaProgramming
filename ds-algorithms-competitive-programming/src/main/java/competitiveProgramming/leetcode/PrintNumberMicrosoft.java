package competitiveProgramming.leetcode;

//https://leetcode.com/discuss/interview-question/310636/microsoft-online-technical-screen
public class PrintNumberMicrosoft {
    public static void main(String[] args) {
        int num = 1234567;
        printNumberVertically(num);
    }

    private static void printNumberVertically(int num) {
        int temp = num;
        int numberOfDigit = 0;
        while (temp != 0) {
            temp = temp / 10;
            numberOfDigit++;
        }

        int temp1;
        for (int i = numberOfDigit - 1; i >= 0; i--) {
            temp1 = (int) (num / Math.pow(10, i));
            num = (int) (num - (temp1 * (Math.pow(10, i))));
            System.out.println(temp1);
        }
    }
}

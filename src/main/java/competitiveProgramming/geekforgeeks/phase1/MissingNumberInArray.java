package competitiveProgramming.geekforgeeks.phase1;

//https://practice.geeksforgeeks.org/problems/missing-number-in-array/0
public class MissingNumberInArray {
    public static void main(String[] args) {
        int num = 5;
        int[] arr = new int[]{1, 2, 3, 5};
        int sum = 0;
        int total = (num * (num + 1)) / 2;
        for (int anArr : arr) {
            sum += anArr;
        }

        System.out.println(total - sum);
    }
}

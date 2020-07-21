package competitiveProgramming.archive.algorithms.dynamicprogramming;

public class FibonacciSeries {
    public static void main(String[] args) {
        System.out.println(fib(1));
    }

    public static int fib(int N) {
        if (N == 1) {
            return 1;
        }
        if(N == 0) {
            return 0;
        }
        int[] arr = new int[N];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 1; i < arr.length - 1; i++) {
            arr[i + 1] = arr[i - 1] + arr[i];
        }

        return arr[N - 1];
    }
}

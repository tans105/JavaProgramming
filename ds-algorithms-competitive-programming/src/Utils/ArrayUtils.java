package Utils;

public class ArrayUtils {

    public static void print2DArray(char[][] T) {
        for (int i = 0; i < T.length; i++) {
            for (int j = 0; j < T[i].length; j++) {
                System.out.print("T[" + i + "," + j + "] " + T[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void print2DArray(int[][] T) {
        for (int i = 0; i < T.length; i++) {
            for (int j = 0; j < T[i].length; j++) {
                System.out.print("T[" + i + "," + j + "] " + T[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void print2DArray(String[][] T) {
        for (int i = 0; i < T.length; i++) {
            for (int j = 0; j < T[i].length; j++) {
                System.out.print("T[" + i + "," + j + "] " + T[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void print2DArray(Object[][] T) {
        for (int i = 0; i < T.length; i++) {
            for (int j = 0; j < T[i].length; j++) {
                System.out.print("T[" + i + "," + j + "] " + T[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void printArray(int[] array) {
        for (int j : array) {
            System.out.print(j + "\t");
        }
        System.out.println();
    }

    public static void printArray(char[] array) {
        for (char j : array) {
            System.out.print(j + "\t");
        }
        System.out.println();
    }

    public static void printArray(Object[] array) {
        for (Object j : array) {
            System.out.print(j + "\t");
        }
        System.out.println();
    }

    public static int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int anArr : arr)
            if (max < anArr)
                max = anArr;
        return max;
    }

    public static int getMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int anArr : arr)
            if (min > anArr)
                min = anArr;
        return min;
    }

}

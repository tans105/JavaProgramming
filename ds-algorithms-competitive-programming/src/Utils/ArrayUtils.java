package Utils;

import java.io.PrintStream;

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
        int max = 0;
        for (int anArr : arr)
            if (max < anArr)
                max = anArr;
        return max;
    }

}

package utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

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

    public static int[][] parse2DArray(String str) {
        str = str.substring(2, str.length() - 2);
        str = str.replace("]", "#");
        str = str.replace("[", "#");
        String[] filteredArraysAsString = str.split("#,#");
        List<int[]> finalList = new ArrayList<>();

        for (String array : filteredArraysAsString) {
            finalList.add(parseArray(array, true));
        }

        int[][] result = new int[finalList.size()][finalList.get(0).length];

        for (int i = 0; i < finalList.size(); i++) {
            result[i] = finalList.get(i);
        }
        return result;
    }

    public static int[] parseArray(String str, boolean checked) {
        if (!checked) {
            str = str.substring(2, str.length() - 2);
        }
        return Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).toArray();
    }

}

package competitiveProgramming.leetcode.phase1;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/spiral-matrix/
public class SpiralMatrix {
    public static void main(String[] args) {
        int arr[][] = {
                {1, 2, 3, 4}

        };
        System.out.println(spiralOrder(arr));

    }

    private static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralOrder = new ArrayList<>();

        if (matrix == null || matrix.length == 0) {
            return spiralOrder;
        }

        Integer x = matrix.length;
        Integer y = matrix[0].length;
        List<String> visitedIndex = new ArrayList<>();

        boolean isHorizontal = true;
        boolean isIncreasing = true;

        Integer i = 0;
        Integer j = 0;

        while (visitedIndex.size() != x * y) {
            if (visitedIndex.contains(i.toString() + j.toString())) { //if we encounter a visited node
                if (isHorizontal && isIncreasing) { //horizontal right
                    j--;
                    i++;
                    isHorizontal = false;
                    isIncreasing = true;
                } else if (isHorizontal && !isIncreasing) {//horizontal left
                    j++;
                    i--;
                    isHorizontal = false;
                    isIncreasing = false;
                } else if (!isHorizontal && isIncreasing) {//vertical right
                    i--;
                    j--;
                    isHorizontal = true;
                    isIncreasing = false;
                } else if (!isHorizontal && !isIncreasing) {//vertical left
                    i++;
                    j++;
                    isHorizontal = true;
                    isIncreasing = true;
                }
//                isHorizontal = !isHorizontal;
//                isIncreasing = !isIncreasing;
            } else if (i.equals(x)) { //we went beyond lets shoot back and change direction
                i--;
                j--;
                isHorizontal = true;
                isIncreasing = false;
            } else if (i < 0) {
                i++;
                j++;
                isHorizontal = true;
                isIncreasing = true;
            } else if (j.equals(y)) {
                j--;
                i++;
                isHorizontal = false;
                isIncreasing = true;
            } else if (j < 0) {
                j++;
                i--;
                isHorizontal = false;
                isIncreasing = false;
            } else { //new node
                if (isHorizontal && isIncreasing) { //horizontal right
                    visitedIndex.add(i.toString() + j.toString());
                    spiralOrder.add(matrix[i][j]);
                    j++;
                } else if (isHorizontal && !isIncreasing) {//horizontal left
                    visitedIndex.add(i.toString() + j.toString());
                    spiralOrder.add(matrix[i][j]);
                    j--;
                } else if (!isHorizontal && isIncreasing) {//vertical right
                    visitedIndex.add(i.toString() + j.toString());
                    spiralOrder.add(matrix[i][j]);
                    i++;
                } else if (!isHorizontal && !isIncreasing) {//vertical left
                    visitedIndex.add(i.toString() + j.toString());
                    spiralOrder.add(matrix[i][j]);
                    i--;
                }
            }
        }
        return spiralOrder;
    }
}

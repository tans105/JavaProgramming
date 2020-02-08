package competitiveProgramming.geekforgeeks.mustdoquestions.arrays;

//https://practice.geeksforgeeks.org/problems/equilibrium-point/0
public class EquillibriumPoint {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 2, 2};
        System.out.println(getEquilibriumPoint(arr));
    }

    private static int getEquilibriumPoint(int[] arr) {
        int start = 0, end = arr.length - 1, startSum = arr[start], endSum = arr[end];
        int traversedElements = 0;
        while (start < end) {

            if (startSum < endSum) {
                start++;
                startSum += arr[start];
                traversedElements++;
            } else {
                end--;
                endSum += arr[end];
                traversedElements++;
            }


            if (startSum == endSum && traversedElements == arr.length - 1) {
                return (start + 1);
            }
        }
        return 0;
    }
}

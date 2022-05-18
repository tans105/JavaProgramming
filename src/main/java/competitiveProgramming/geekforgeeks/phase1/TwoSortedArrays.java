package competitiveProgramming.geekforgeeks.phase1;
//https://www.geeksforgeeks.org/oyo-interview-experience-off-campus/

public class TwoSortedArrays {
    public static void main(String[] args) {
        int[] A = new int[]{20, 30, 50, 70, 90};
        int[] B = new int[]{20, 40, 80, 120, 140};
        int index = 4;
        int find = B[index] - A[index];
        System.out.println(find);
        int left = 0;
        int right = A.length - 1;
        while (left <= right) {
            if (A[left] + A[right] > find) {
                right--;
            }
            if (A[left] + A[right] < find) {
                left++;
            }
            if (A[left] + A[right] == find) {
                System.out.println("Hurrah");
                break;
            }
        }
        System.out.println("Finish");
    }
}

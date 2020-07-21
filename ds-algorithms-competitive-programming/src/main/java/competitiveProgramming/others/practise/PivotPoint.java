package competitiveProgramming.others.practise;

public class PivotPoint {
    public static void main(String[] args) {
        int index = getPivotPoint(new int[]{7, 8, 9, 1, 2, 3, 4});
        System.out.println(index);
    }

    private static int getPivotPoint(int[] arr) {
        return getPivotPointHelper(arr, 0, arr.length);
    }

    private static int getPivotPointHelper(int[] arr, int low, int high) {
        if (low >= high) return -1;

        int mid = (low + high) / 2;

        if (mid < high && arr[mid] > arr[mid + 1])
            return mid;
        if (mid > low && arr[mid] < arr[mid - 1])
            return (mid - 1);

        if (arr[low] > arr[mid]) {
            return getPivotPointHelper(arr, low, mid - 1);
        } else {
            return getPivotPointHelper(arr, mid + 1, high);
        }
    }
}

package searchingandsorting;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 2, 1, 7, 8, 10, 9, 0};
        printArray(arr);
        quickSort(arr, 0, arr.length - 1);
        printArray(arr);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, 0, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static void printArray(int arr[]) {
        int n = arr.length;
        for (int anArr : arr) System.out.print(anArr + " ");
        System.out.println();
    }


    private static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}

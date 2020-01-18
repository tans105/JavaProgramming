package competitiveProgramming.random;

public class FirstOneOccurance {
    public static void main(String[] args) {
        System.out.println(firstOccurance("000001"));
    }

    private static int firstOccurance(String s) {
        char[] arr = s.toCharArray();
        int low = 0;
        int high = s.length() - 1;
        boolean hasOne = false;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == '1') {
                hasOne = true;
                high = mid - 1;
            }

            if (arr[mid] == '0') {
                low = mid + 1;
            }
        }

        return (hasOne) ? low : -1;
    }
}

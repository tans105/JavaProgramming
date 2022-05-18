package applications.mycustomlist;

import java.util.Arrays;

public class MyCustomList {
    private int[] arr;
    private int currentIndex;
    private static final int THRESHOLD = 2;
    private static int length = 0;

    public MyCustomList() {
        arr = new int[THRESHOLD];
        currentIndex = 0;
    }

    public void add(int value) {
        if (currentIndex == arr.length) {
            arr = Arrays.copyOf(arr, arr.length + THRESHOLD);
        }

        arr[currentIndex] = value;
        currentIndex++;
    }

    public int get(int index) {
        if (index < arr.length) {
            return arr[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void remove(int index) {
        if (index < arr.length) {
            int start = index, end = arr.length - 1;
            while (start < end) {
                arr[start] = arr[start + 1];
                start++;
            }
            arr[end] = 0;
            currentIndex--;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public int size() {
        return currentIndex;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        for (int val : arr) {
            if (val > 0) builder.append(val).append(' ');
        }
        if (builder.length() > 0) {
            builder.deleteCharAt(builder.length() - 1);
        }
        builder.append(']');
        return builder.toString();
    }

    /**
     * Runner
     * @param args
     */
    public static void main(String[] args) {
        MyCustomList list = new MyCustomList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);
        System.out.println(list.get(2));
        System.out.println(list.size());
        list.remove(0);
        System.out.println(list);
        System.out.println(list.get(0));
        System.out.println(list.size());
    }
}

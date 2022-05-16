package competitiveProgramming.leetcode.phase1;

import java.util.*;

/**
 * 89. Gray Code
 * Medium
 * <p>
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * <p>
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: [0,1,3,2]
 * Explanation:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * <p>
 * For a given n, a gray code sequence may not be uniquely defined.
 * For example, [0,2,3,1] is also a valid gray code sequence.
 * <p>
 * 00 - 0
 * 10 - 2
 * 11 - 3
 * 01 - 1
 * Example 2:
 * <p>
 * Input: 0
 * Output: [0]
 * Explanation: We define the gray code sequence to begin with 0.
 * A gray code sequence of n has size = 2n, which for n = 0 the size is 20 = 1.
 * Therefore, for n = 0 the gray code sequence is [0].
 */
public class GrayCode {
    public static void main(String[] args) {
        int n = 6;
        System.out.println(grayCode(n));
    }

    public static List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        if (n == 0) {
            list.add(0);
            return list;
        }
        Map<String, Integer> intToBinaryMapping = new HashMap<>();

        Stack<String> pending = new Stack<>();
        String s;
        for (int i = (int) (Math.pow(2, n) - 1); i >= 0; i--) {
            s = String.format("%" + n + "s", Integer.toBinaryString(i)).replace(' ', '0');
            intToBinaryMapping.put(s, i);
            pending.push(s);
        }
        List<String> aux = new ArrayList<>();
        String lastAdded = pending.peek();
        String current = pending.peek();
        list.add(intToBinaryMapping.get(current));
        pending.pop();
        while (!pending.isEmpty()) {
            boolean set = false;
            current = pending.peek();
            aux = new ArrayList<>();
            while (!isDiffOne(lastAdded, current) && !pending.isEmpty()) {
                current = pending.pop();
                aux.add(current);
                set = true;
            }
            if (!set) {
                pending.pop();
            }
            lastAdded = current;
            list.add(intToBinaryMapping.get(current));
            for (int i = 0; i < aux.size() - 1; i++) {
                pending.push(aux.get(i));
            }
            System.out.println(list);
        }
        return list;
    }

    public static boolean isDiffOne(String one, String two) {
        int count = 0;
        for (int i = 0; i < one.length(); i++) {
            if (count > 1) {
                return false;
            }
            if (one.charAt(i) != two.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }

}

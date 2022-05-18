package competitiveProgramming.geekforgeeks.phase1;
/*
Given String, arrange in such a way that no two alphabets are together
For eg. aabbc => ababc/acbab..
 */

public class RearrangeWord {
    public static void main(String[] args) {
        String str = "aabbc";
        PriorityQueueUsingLinkedList pl = new PriorityQueueUsingLinkedList();
        for (int i = 0; i < str.length(); i++) {
            if (!pl.contains(str.charAt(i))) {
                pl.enqueue(new Element(str.charAt(i), calculateFrequency(str.charAt(i), str)));
            }
        }
        rearrange(pl);
    }

    private static void rearrange(PriorityQueueUsingLinkedList pl) {
        StringBuilder str = new StringBuilder();
        Element prev = null;
        while (pl.size() > 0) {
            Element k = pl.peek();
            pl.dequeue();
            str.append(k.value);
            if (prev != null && prev.priority > 0)
                pl.enqueue(prev);

            (k.priority)--;
            prev = k;
        }
        System.out.println(str);
    }

    public static int calculateFrequency(char c, String s) {
        int freq = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                freq++;
            }
        }
        return freq;
    }
}

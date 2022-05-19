package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.year_2020.august.week2;

/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3422/


Iterator for Combination

Design an Iterator class, which has:

    A constructor that takes a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
    A function next() that returns the next combination of length combinationLength in lexicographical order.
    A function hasNext() that returns True if and only if there exists a next combination.



Example:

CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.

iterator.next(); // returns "ab"
iterator.hasNext(); // returns true
iterator.next(); // returns "ac"
iterator.hasNext(); // returns true
iterator.next(); // returns "bc"
iterator.hasNext(); // returns false



Constraints:

    1 <= combinationLength <= characters.length <= 15
    There will be at most 10^4 function calls per test.
    It's guaranteed that all calls of the function next are valid.


 */
public class CombinationIterator {
    private String str;
    int[] indexes;
    int significantPlace;
    int len;

    public CombinationIterator(String str, int k) {
        this.indexes = new int[k];

        for (int i = 0; i < k; i++) {
            indexes[i] = i;
        }
        this.len = indexes.length;
        this.str = str;
        this.significantPlace = len - 1;
    }

    private boolean hasNext() {
        return indexes[len - 1] != str.length();
    }

    private String next() {
        if (!hasNext()) return null;

        StringBuilder builder = new StringBuilder();
        for (int index : indexes) {
            builder.append(str.charAt(index));
        }
        reorder();
        return builder.toString();
    }

    /**
     * The method will change and update the indexes array
     * say the current index to be printed is 012, it will change to 013
     *
     * if the capacity exceeds, it will call the shuffle method which acts based on the significant position
     * A significant position is the place from which the index will start increasing
     *
     * Eg. If the significant value is 1 i.e 1th index value will increase by one, 2th index, 3rd index .... will reset accordingly
     */
    private void reorder() {
        if (indexes[significantPlace] + 1 == str.length()) {

            int j = 0;
            for (int i = len - 1; i >= 0; i--) {
                if (indexes[i] == str.length() - 1 - j) {
                    j++;
                } else {
                    significantPlace = i;
                    break;
                }

            }
            shuffle();
            significantPlace = len - 1;
        } else {
            indexes[significantPlace]++;
        }
    }

    /**
     * Takes the value of the significant index and update the index of significant index and all the following indexes
     *
     */
    private void shuffle() {
        int ref = indexes[significantPlace];
        for (int i = significantPlace; i < len; i++) {
            indexes[i] = ++ref;
        }
    }

    public static void main(String[] args) {
        CombinationIterator iterator = new CombinationIterator("abcde", 4); // creates the iterator.

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

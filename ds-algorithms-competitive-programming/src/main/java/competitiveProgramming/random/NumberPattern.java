package competitiveProgramming.random;

import utils.LoggingUtil;

/*
M -> Descending
N -> Ascending

MNM -> 2143 (2->1, 1->4, 4->3)
M - 21 (2->1)
MM - 321 (3->2, 2->1)
NN - 123 (1->2, 2->3)
NNMMM - 126543 (1->2, 2->6, 6->5, 5->4, 4->3)
 */
public class NumberPattern {
    public static void main(String[] args) {
//        smallestPossibleNumberMatchingPattern("MNM"); //2143
//        smallestPossibleNumberMatchingPattern("M");
//        smallestPossibleNumberMatchingPattern("NMMM");
//        smallestPossibleNumberMatchingPattern("N");
//        smallestPossibleNumberMatchingPattern("NNMMM");
        smallestPossibleNumberMatchingPattern("MMNMMNNM");
    }

    static int smallestPossibleNumberMatchingPattern(String pattern) {
        char[] arr = pattern.toCharArray();
        StringBuilder number = new StringBuilder();
        int lastRecorded = getStartingPoint(number, arr);
        int maxSoFar = lastRecorded;

        System.out.println(lastRecorded);
        int index = 0;

        while (index < arr.length) {
            if (arr[index] == 'M') {
                int start = index;
                boolean isNPrevious = false;
                if (index - 1 >= 0 && arr[index - 1] == 'N') isNPrevious = true;

                int counter = 0;
                while (index < arr.length && arr[index] == 'M') {
                    counter++;
                    index++;
                }


                if (isNPrevious) {
                    number.deleteCharAt(start);
                    number.insert(start, maxSoFar + counter);
                }

                if (counter == 1) {
                    if (isNPrevious) number.append(maxSoFar - 1 + counter);
                    else number.append(maxSoFar - 1);
                } else {
                    maxSoFar = maxSoFar + counter;
                    for (int i = 0; i < counter; i++) {
                        int value = maxSoFar - 1 - i;
                        number.append(value);
                    }
                }
            } else {
                number.append(++maxSoFar);
                index++;
            }
        }

        return Integer.parseInt(number.toString());

    }

    private static int getStartingPoint(StringBuilder number, char[] pattern) {
        char start = pattern[0];
        int counter = 1;
        for (int i = 1; i < pattern.length; i++) {
            if (start == 'M' && pattern[i] == 'M') {
                counter++;
                continue;
            }
            break;
        }

        if (counter == 1 && start == 'M') {
            number.append(2);
            return 2;
        }

        if (start == 'N') {
            number.append(1);
            return 1;
        }


        number.append(counter + 1);
        return counter + 1;
    }
}

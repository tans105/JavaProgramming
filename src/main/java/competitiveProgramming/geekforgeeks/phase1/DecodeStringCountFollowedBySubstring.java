package competitiveProgramming.geekforgeeks.phase1;


/*
https://www.geeksforgeeks.org/decode-string-recursively-encoded-count-followed-substring/

Decode a string recursively encoded as count followed by substring
An encoded string (s) is given, the task is to decode it. The pattern in which the strings are encoded is as follows.

<count>[sub_str] ==> The substring 'sub_str'
                      appears count times.
Examples:

Input : str[] = "1[b]"
Output : b

Input : str[] = "2[ab]"
Output : abab

Input : str[] = "2[a2[b]]"
Output : abbabb

Input : str[] = "3[b2[ca]]"
Output : bcacabcacabcaca

 */
public class DecodeStringCountFollowedBySubstring {
    public static void main(String[] args) {
        System.out.println(decode("3[b2[ca]]"));
    }

    private static String decode(String s) {
        char[] arr = generateStringArary(s);
        return decode(arr);
    }

    private static String decode(char[] arr) {
        StringBuilder builder = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            try {
                int count = Integer.parseInt(String.valueOf(arr[i]));
                String s = builder.toString();
                for (int j = 0; j < count; j++) {
                    temp.append(s);
                }
                builder = new StringBuilder();
                builder.append(temp);
                temp = new StringBuilder();
            } catch (Exception e) {
                builder.insert(0, arr[i]);
            }
        }
        return builder.toString();
    }

    private static char[] generateStringArary(String s) {
        String[] arr = s.split("]");
        StringBuilder builder = new StringBuilder();

        for (String str : arr) {
            builder.append(str);
        }

        arr = builder.toString().split("\\[");

        builder = new StringBuilder();
        for (String str : arr) {
            if (str != null && !str.equals("")) {
                builder.append(str);
            }

        }

        return builder.toString().toCharArray();
    }


}

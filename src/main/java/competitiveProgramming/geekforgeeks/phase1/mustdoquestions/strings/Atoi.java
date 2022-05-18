package competitiveProgramming.geekforgeeks.phase1.mustdoquestions.strings;

/*
Your task  is to implement the function atoi. The function takes a string(str) as argument and converts it to an integer and returns it.

Input:
The first line of input contains an integer T denoting the no of test cases . Then T test cases follow. Each test case contains a string str .

Output:
For each test case in a new line output will be an integer denoting the converted integer, if the input string is not a numerical string then output will be -1.

Constraints:
1<=T<=100
1<=length of (s,x)<=10

Example(To be used only for expected output) :
Input:
2
123
21a

 */
public class Atoi {
    public static void main(String[] args) {
        System.out.println(atoi("-123"));
    }

    public static Integer atoi(String str) {
        int num = 0;
        boolean isNegative = false;

        if (str.charAt(0) == '-') {
            isNegative = true;
            str = str.substring(1);
        }
        char[] arr = str.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            num += Math.pow(10, arr.length - i - 1) * (arr[i] - '0');
        }

        return (isNegative) ? num * -1 : num;
    }
}

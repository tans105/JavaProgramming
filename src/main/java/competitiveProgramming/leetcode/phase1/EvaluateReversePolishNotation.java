package competitiveProgramming.leetcode.phase1;

import java.util.Stack;

/*
150. Evaluate Reverse Polish Notation

Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Note:

Division between two integers should truncate toward zero.
The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
Example 1:

Input: ["2", "1", "+", "3", "*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: ["4", "13", "5", "/", "+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:

Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
Output: 22
Explanation:
  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
 */
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

    private static int evalRPN(String[] tokens) {
        Stack<String> primary = new Stack<>();
        Stack<String> aux = new Stack<>();

        for (int i = tokens.length - 1; i >= 0; i--) {
            primary.push(tokens[i]);
        }

        while (primary.size() != 1) {
            while (!isOperation(primary.peek())) {
                aux.push(primary.pop());
            }
            String operation = primary.pop();
            Integer op1 = Integer.parseInt(aux.pop());
            Integer op2 = Integer.parseInt(aux.pop());
            Integer result = null;
            switch (operation) {
                case "-":
                    result = op2 - op1;
                    break;
                case "+":
                    result = op1 + op2;
                    break;
                case "*":
                    result = op1 * op2;
                     break;
                case "/":
                    result = op2 / op1;
            }
            aux.push(result.toString());

            while(!aux.isEmpty()) {
                primary.push(aux.pop());
            }
        }

        return Integer.parseInt(primary.pop());
    }


    private static boolean isOperation(String s) {
        return s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*");
    }
}

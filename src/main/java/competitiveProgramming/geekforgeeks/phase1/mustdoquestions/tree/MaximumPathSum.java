package competitiveProgramming.geekforgeeks.phase1.mustdoquestions.tree;

import utils.TreeUtils;
import utils.pojo.TreeNode;

/*
https://practice.geeksforgeeks.org/problems/maximum-path-sum/1

Maximum path sum

Given a binary tree in which each node element contains a number. Find the maximum possible sum from one leaf node to another.

Input Format:
The input contains T, denoting number of testcases. For each testcase there will be two lines. The first line contains number of edges. The second line contains two nodes and a character separated by space. The first node denotes data value, second node denotes where it will be assigned to the previous node which will depend on character 'L' or 'R' i.e. the 2nd node will be assigned as left child to the 1st node if character is 'L' and so on. The first node of second line is root node. The struct or class Node has a data part which stores the data, pointer to left child and pointer to right child. There are multiple test cases. For each test case, the function will be called individually.

Output Format:
For each testcase, in a new line, print he maximum possible sum.

Your Task:
This is a function problem. You only need to complete the function maxPathSum that returns the maximum sum from one lead to other.

Constraints:
1 <=T <= 100
1 <= N <= 30

Example:
Input:
1
12
-15 5 L -15 6 R 5 -8 L 5 1 R -8 2 L -8 -3 R 6 3 L 6 9 R 9 0 R 0 4 L 0 -1 R -1 10 L

Output:
27

Explanation:
Testcase 1: The maximum possible sum from one leaf node to another is (3 + 6 + 9 + 0 + -1 + 10 = 27)
 */
public class MaximumPathSum {
    public static void main(String[] args) {
        TreeNode node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{10, 2, 10, 20, 1, null, -25, null, null, null, null, 3, 4});
        maximumPathSum(node, node.val);
        System.out.println(maxSum);
    }

    static int maxSum = 0;

    private static void maximumPathSum(TreeNode node, int sum) {
        if (node == null) {
            maxSum = Math.max(sum, maxSum);
        } else {
            maximumPathSum(node.left, sum + node.val);
            maximumPathSum(node.right, sum + node.val);
        }
    }
}

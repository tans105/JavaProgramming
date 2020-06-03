package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.june;

import utils.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;

/*
https://leetcode.com/explore/featured/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3349/

Two City Scheduling

There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].

Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.



Example 1:

Input: [[10,20],[30,200],[400,50],[30,20]]
Output: 110
Explanation:
The first person goes to city A for a cost of 10.
The second person goes to city A for a cost of 30.
The third person goes to city B for a cost of 50.
The fourth person goes to city B for a cost of 20.

The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.



Note:

    1 <= costs.length <= 100
    It is guaranteed that costs.length is even.
    1 <= costs[i][0], costs[i][1] <= 1000

 */
public class TwoCityScheduling {

    public static void main(String[] args) {
        int[][] costs = ArrayUtils.parse2DArray("[[10,20],[30,200],[400,50],[30,20]]");
        System.out.println(twoCitySchedCost(costs));
    }

    public static int twoCitySchedCost(int[][] costs) {
        /*
        Sort the array with subtraction weight coefficient.
        If someone's cost is like [40, 41], his weight coefficient is -1 so that he can go to either A or B.
        But if someone's cost is like [40, 40000], his weight coefficient is -39960 so that he would absolutely go to A.
        After sort the array, people from 0 to N-1 should go to A and people from N to 2N-1 should go to B. Then count the sum.
         */
        Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));
        int l = costs.length, N = l / 2, count = 0;
        for (int i = 0; i < l; i++) {
            if (i < N)
                count += costs[i][0];
            else
                count += costs[i][1];
        }
        return count;
    }
}

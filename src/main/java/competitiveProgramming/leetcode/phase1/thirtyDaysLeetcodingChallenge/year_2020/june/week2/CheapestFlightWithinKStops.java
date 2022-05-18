package competitiveProgramming.leetcode.phase1.thirtyDaysLeetcodingChallenge.year_2020.june.week2;

import utils.ArrayUtils;

import java.util.*;

/*
https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3360/

Cheapest Flights Within K Stops
There are n cities connected by m flights. Each flight starts from city u and arrives at v with a price w.

Now given all the cities and flights, together with starting city src and the destination dst, your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.

Example 1:
Input:
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 1
Output: 200
Explanation:
The graph looks like this:


The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
Example 2:
Input:
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 0
Output: 500
Explanation:
The graph looks like this:


The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.


Constraints:

The number of nodes n will be in range [1, 100], with nodes labeled from 0 to n - 1.
The size of flights will be in range [0, n * (n - 1) / 2].
The format of each flight will be (src, dst, price).
The price of each flight will be in the range [1, 10000].
k is in the range of [0, n - 1].
There will not be any duplicated flights or self cycles.
 */
public class CheapestFlightWithinKStops {
    public static void main(String[] args) {
        System.out.println(findCheapestPrice(3, ArrayUtils.parse2DArray("[[0,1,100],[1,2,100],[0,2,500]]"), 0, 2, 1));
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();

        for (int[] flight : flights) {
            Map<Integer, Integer> adjacents = prices.getOrDefault(flight[0], new HashMap<>());
            adjacents.put(flight[1], flight[2]);
            prices.put(flight[0], adjacents);
        }

        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        queue.offer(new int[]{0, src, K + 1});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int stops = current[2];
            int station = current[1];
            int price = current[0];

            if (station == dst) return price;

            if (!prices.containsKey(station)) {
                break;
            } else {
                if (stops > 0) {
                    Map<Integer, Integer> adj = prices.getOrDefault(station, new HashMap<>());
                    for (int a : adj.keySet()) {
                        queue.add(new int[]{price + adj.get(a), a, stops - 1});
                    }
                }
            }
        }

        return -1;
    }
}

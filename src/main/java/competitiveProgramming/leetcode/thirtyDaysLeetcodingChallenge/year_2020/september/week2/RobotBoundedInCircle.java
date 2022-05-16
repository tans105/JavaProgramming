package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.year_2020.september.week2;

/*
https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/556/week-3-september-15th-september-21st/3463/

Robot Bounded In Circle

On an infinite plane, a robot initially stands at (0, 0) and faces north.  The robot can receive one of three instructions:

    "G": go straight 1 unit;
    "L": turn 90 degrees to the left;
    "R": turn 90 degress to the right.

The robot performs the instructions given in order, and repeats them forever.

Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.



Example 1:

Input: "GGLLGG"
Output: true
Explanation:
The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to (0,0).
When repeating these instructions, the robot remains in the circle of radius 2 centered at the origin.

Example 2:

Input: "GG"
Output: false
Explanation:
The robot moves north indefinitely.

Example 3:

Input: "GL"
Output: true
Explanation:
The robot moves from (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ...



Note:

    1 <= instructions.length <= 100
    instructions[i] is in {'G', 'L', 'R'}


 */
public class RobotBoundedInCircle {
    public static void main(String[] args) {
        System.out.println(isRobotBounded("GGLLGG"));
        System.out.println(isRobotBounded("GG"));
        System.out.println(isRobotBounded("GL"));
    }

    public static boolean isRobotBounded(String instructions) {
        if (instructions == null || instructions.length() == 0) return false;

        int x = 0;
        int y = 0;
        int direction = 1; //N - 1, W - 2, S - 3, E - 4

        for (int i = 0; i < instructions.length(); i++) {
            char current = instructions.charAt(i);

            if (current == 'G') {
                switch (direction) {
                    case 1: {
                        y++;
                        break;
                    }
                    case 2: {
                        x--;
                        break;
                    }
                    case 3: {
                        y--;
                        break;
                    }

                    case 4: {
                        x++;
                        break;
                    }
                }
            } else if (current == 'L') {
                switch (direction) {
                    case 1: {
                        direction = 2;
                        break;
                    }
                    case 2: {
                        direction = 3;
                        break;
                    }
                    case 3: {
                        direction = 4;
                        break;
                    }

                    case 4: {
                        direction = 1;
                        break;
                    }
                }
            } else {
                switch (direction) {
                    case 1: {
                        direction = 4;
                        break;
                    }
                    case 2: {
                        direction = 1;
                        break;
                    }
                    case 3: {
                        direction = 2;
                        break;
                    }

                    case 4: {
                        direction = 3;
                        break;
                    }
                }
            }
        }

        return (x == 0 && y == 0) || direction != 1;
    }
}

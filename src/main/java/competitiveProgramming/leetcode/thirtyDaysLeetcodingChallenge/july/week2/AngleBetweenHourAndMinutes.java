package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.july.week2;

/*
https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3390/

Angle Between Hands of a Clock

Solution
Given two numbers, hour and minutes. Return the smaller angle (in degrees) formed between the hour and the minute hand.

Example 1:

Input: hour = 12, minutes = 30
Output: 165
Example 2:

Input: hour = 3, minutes = 30
Output: 75
Example 3:

Input: hour = 3, minutes = 15
Output: 7.5
Example 4:

Input: hour = 4, minutes = 50
Output: 155
Example 5:

Input: hour = 12, minutes = 0
Output: 0


Constraints:

1 <= hour <= 12
0 <= minutes <= 59
Answers within 10^-5 of the actual value will be accepted as correct.
 */
public class AngleBetweenHourAndMinutes {
    public static void main(String[] args) {
        System.out.println(angleClock(12, 30));
        System.out.println(angleClock(3, 30));
        System.out.println(angleClock(3, 15));
        System.out.println(angleClock(4, 50));
        System.out.println(angleClock(12, 0));
        System.out.println(angleClock(1, 57));
    }

    public static double angleClock(int hour, int minutes) {
        if (hour == 12) hour = 0;

        double hourAngle = ((hour) + (((double) minutes / 60))) * 30;
        double minuteAngle = minutes * 6;


        return Math.min(Math.abs(hourAngle - minuteAngle), 360 - Math.abs(hourAngle - minuteAngle));
    }
}

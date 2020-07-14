package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.july;

import utils.LoggingUtil;

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

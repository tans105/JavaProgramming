package competitiveProgramming.random;

import java.util.Arrays;
import java.util.Comparator;

public class ChannelBoundary {
    public static void main(String[] args) {
        int[][] circles = new int[][]{
                {2, 0, 3},
                {7, 12, 4}
        };

        System.out.println(getHalfDistance(10, circles.length, circles));

        circles = new int[][]{
                {2, 0, 3},
                {7, 8, 4}
        };

        System.out.println(getHalfDistance(10, circles.length, circles));
    }

    private static int getHalfDistance(int channel, int len, int[][] circles) {

        Arrays.sort(circles, Comparator.comparingDouble(a -> a[1]));

        double min = Integer.MAX_VALUE;

        for (int i = 0; i < circles.length; i++) {
            if (i == 0) { //corner case
                min = distanceFromChannel(circles[i][0], circles[i][2], channel);


            } else if (i == circles.length - 1) { //corner case
                double distanceFromChannel = distanceFromChannel(circles[i][0], circles[i][2], channel);
                double distanceFromBottomCircle = distanceFromCircle(circles[i], circles[i - 1]);
                min = Math.min(min, Math.min(distanceFromChannel, distanceFromBottomCircle));


            } else {
                double distanceFromTopCircle = distanceFromCircle(circles[i], circles[i + 1]);
                double distanceFromBottomCircle = distanceFromCircle(circles[i], circles[i - 1]);
                double distanceFromChannel = distanceFromChannel(circles[i][0], circles[i][2], channel);

                min = Math.min(min, Math.min(distanceFromChannel, Math.min(distanceFromTopCircle, distanceFromBottomCircle)));
            }
        }

        return (int) Math.floor(min / 2);
    }

    private static double distanceFromChannel(int x, int radius, int channel) {
        int len1 = x - radius;
        if (len1 < 0) len1 = Integer.MAX_VALUE;

        int len2 = channel - (x + radius);
        if (len2 < 0) len2 = Integer.MAX_VALUE;

        return Math.min(len1, len2);
    }

    private static double distanceFromCircle(int[] c1, int[] c2) {
        double distanceFromCentre = Math.sqrt((c1[0] - c2[0]) * (c1[0] - c2[0]) + (c1[1] - c2[1]) * (c1[1] - c2[1]));
        return (int) (distanceFromCentre - c1[2] - c2[2]);
    }
}

package competitiveProgramming.leetcode.phase1;

/*
223. Rectangle Area

Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

Rectangle Area

Example:

Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2
Output: 45
Note:

Assume that the total area is never beyond the maximum possible value of int.
 */
public class RectangleArea {
    public static void main(String[] args) {
        RectangleArea area = new RectangleArea();
        System.out.println(area.computeArea(-2, -2, 2, 2, -1, -1, 1, 1));
    }

    public int computeArea(int x1, int y1, int x2, int y2, int a1, int b1, int a2, int b2) {
        if(x1 == a1 && x2 == a2 && y1 == b1 && y2 == b2) return Math.abs(x2 - x1) * Math.abs(y2 - y1);
        int[] xCoordinates = new int[]{x1, x2, x1, x2};
        int[] yCoordinates = new int[]{y1, y2, y2, y1};
        int[] aCoordinates = new int[]{a1, a2, a1, a2};
        int[] bCoordinates = new int[]{b1, b2, b2, b1};

        int[] xRange = new int[2];
        xRange[0] = Math.min(x1, x2);
        xRange[1] = Math.max(x1, x2);

        int[] yRange = new int[2];
        yRange[0] = Math.min(y1, y2);
        yRange[1] = Math.max(y1, y2);

        int[] aRange = new int[2];
        aRange[0] = Math.min(a1, a2);
        aRange[1] = Math.max(a1, a2);

        int[] bRange = new int[2];
        bRange[0] = Math.min(b1, b2);
        bRange[1] = Math.max(b1, b2);

        int[] intersectionPoints = new int[4];
        int count;
        count = getIntersection(xCoordinates, yCoordinates, aRange, bRange, 0, intersectionPoints);
        count += getIntersection(aCoordinates, bCoordinates, xRange, yRange, 2, intersectionPoints);

//        ArrayUtils.printArray(intersectionPoints);
//        System.out.println(count);

        int totalArea = Math.abs(x2 - x1) * Math.abs(y2 - y1) + Math.abs(a2 - a1) * Math.abs(b2 - b1);
        int intersectionArea = Math.abs(intersectionPoints[0] - intersectionPoints[2]) * Math.abs(intersectionPoints[1] - intersectionPoints[3]);
        return (count < 2) ? totalArea : totalArea - intersectionArea;
    }

    private int getIntersection(int[] xCoordinates, int[] yCoordinates, int[] aRange, int[] bRange, int startIndex, int[] intersectionPoint) {
        for (int i = 0; i < 4; i++) {
            if (xCoordinates[i] >= aRange[0] && xCoordinates[i] <= aRange[1] && yCoordinates[i] >= bRange[0] && yCoordinates[i] <= bRange[1]) {
//                LoggingUtil.logNewLine(xCoordinates[i], yCoordinates[i]);
                intersectionPoint[startIndex++] = xCoordinates[i];
                intersectionPoint[startIndex] = yCoordinates[i];
                return 1;
            }
        }
        return 0;
    }
}

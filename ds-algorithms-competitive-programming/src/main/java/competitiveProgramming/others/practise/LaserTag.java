package competitiveProgramming.others.practise;

public class LaserTag {
    public static void main(String[] args) {
        System.out.println(canMatch(3, 1));
        System.out.println(canMatch(4, 1));
        System.out.println(canMatch(5, 1));
    }

    private static int canMatch(int students, int time) {
        int timeNeeded;
        if (students % 2 != 0) timeNeeded = (students / 2 + 1);
        else timeNeeded = students / 2;

        return (time >= timeNeeded * 0.5) ? 1 : 0;
    }


}

package recursion;

public class HanoiTower {
    public static void main(String[] args) {
        int N = 4;
        HanoiTowerUtil(N, "A", "B", "C");
    }

    private static void HanoiTowerUtil(int n, String beg, String aux, String end) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + beg + " to " + end);
            return;
        }
        HanoiTowerUtil(n - 1, beg, end, aux);
        System.out.println("Move disk " + n + " from " + beg + " to " + end);
        HanoiTowerUtil(n - 1, aux, beg, end);
    }
}

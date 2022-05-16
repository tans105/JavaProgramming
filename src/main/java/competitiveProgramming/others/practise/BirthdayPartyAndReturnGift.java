package competitiveProgramming.others.practise;

public class BirthdayPartyAndReturnGift {
    public static void main(String[] args) {
        System.out.println(findDamaged(7, 5, 3));
    }

    public static int findDamaged(int N, int T, int D) {
        return D + (T % N - 1);
    }
}

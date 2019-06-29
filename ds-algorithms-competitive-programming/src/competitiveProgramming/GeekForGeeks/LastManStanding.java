package competitiveProgramming.GeekForGeeks;


import java.util.ArrayList;
import java.util.List;

public class LastManStanding {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(3);
        list.add(1);
        list.add(4);
        System.out.println(getLastManStanding(list, 0));
    }

    private static int getLastManStanding(List<Integer> list, Integer start) {
        List<Integer> finalList = lastManStandingDriver(list, start);
        return finalList.get(0);
    }

    private static List<Integer> lastManStandingDriver(List<Integer> list, Integer start) {
        if (list.size() == 1) {
            return list;
        } else {
            int removedIndexValue = list.get(start);
            list.remove((int) start);
            int newIndex = (start + removedIndexValue - 1) % list.size();
            return lastManStandingDriver(list, newIndex);
        }
    }


}

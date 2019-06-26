package competitiveProgramming.Hackerrank;

import Utils.LoggingUtil;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("dancinginthedark");
        list.add("rio");
        list.add("beedi");
        list.add("liveoak");
        list.add("liveoak");
        list.add("dogma");
        list.add("fishing");

        System.out.println(playlist(list, 0, "liveoak"));
    }

    public static int playlist(List<String> songs, int k, String q) {
//        System.out.println(songs);
        if (songs == null) {
            return 0;
        }
        int minDistanceSoFar = Integer.MAX_VALUE;
        int minimumTotal = Integer.MAX_VALUE;

        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).equals(q)) {
//                LoggingUtil.logNewLine(Math.abs(i - k), Math.abs(k + (songs.size() - i)));
                minDistanceSoFar = Math.min(Math.abs(i - k), Math.abs(k + (songs.size() - i)));
                minimumTotal = Math.min(minimumTotal, minDistanceSoFar);
            }
        }

        return minimumTotal;
    }
}

package competitiveProgramming.others.practise;

import java.util.Arrays;
import java.util.List;

public class RestockTheWarehouse {
    public static void main(String[] args) {
        List l = Arrays.asList(1,2,3,2,1);
        System.out.println(restock(l, 4));
    }

    public static int restock(List<Integer> itemCount, int target) {
        int sum = 0;
        for(int item: itemCount ) {
            if(sum >= target) break;
            sum+= item;
        }
        return Math.abs(target - sum);
    }
}

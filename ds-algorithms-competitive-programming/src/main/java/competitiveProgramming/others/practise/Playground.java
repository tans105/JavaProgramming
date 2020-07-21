package competitiveProgramming.others.practise;

import java.util.HashMap;

public class Playground implements infer1, infer2{
    public static void main(String[] args) {
        HashMap map = new HashMap();
        System.out.println(map.put(null, 10));
        System.out.println(map.put(null,20));
    }

    @Override
    public void name() {

    }
}

interface infer1 {
    void name();
}

interface infer2 {
    void name();
}

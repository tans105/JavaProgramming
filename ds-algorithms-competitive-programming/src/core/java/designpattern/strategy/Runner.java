package core.java.designpattern.strategy;

import core.java.designpattern.strategy.sorts.HeapSort;
import core.java.designpattern.strategy.sorts.QuickSort;
import core.java.designpattern.strategy.sortstrategy.SortStrategy;

public class Runner {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 2, 1};
        SortStrategy strat = new SortStrategy(arr);
        strat.runSort(new HeapSort());
        strat.runSort(new QuickSort());
    }
}

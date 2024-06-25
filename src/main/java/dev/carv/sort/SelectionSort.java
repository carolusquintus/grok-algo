package dev.carv.sort;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public List<T> sort(List<T> items) {
        var clonedItems = new ArrayList<>(items);
        var sortedItems = new ArrayList<T>(items.size());

        for (int i = 0; i < items.size(); i++) {
            var smallestIndex = findSmallest(clonedItems);
            sortedItems.add(clonedItems.get(smallestIndex));
            clonedItems.remove(smallestIndex);
        }

        return sortedItems;
    }

    private int findSmallest(List<T> items) {
        var smallest = items.get(0);
        int smallestIndex = 0;

        for (int i = 1; i < items.size(); i++) {
            var current = items.get(i);
            int comparison = smallest.compareTo(current);

            if (comparison > 0) {
                smallest = current;
                smallestIndex = i;
            }
        }

        return smallestIndex;
    }

}

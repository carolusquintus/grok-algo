package dev.carv.search;

import java.util.List;

public class BinarySearch<T extends Comparable<T>> implements Search<T> {

    @Override
    public T search(T searchItem, List<T> items) {
        int low = 0;
        int high = items.size() - 1;

        while (low <= high) {
            int middle = (low + high) / 2;
            var guess = items.get(middle);

            int comparison = guess.compareTo(searchItem);

            if (comparison > 0) {
                high = middle - 1;
            } else if (comparison < 0) {
                low = middle + 1;
            } else { // Equivalent to (comparison == 0)
                return guess;
            }
        }
        return null;
    }

}

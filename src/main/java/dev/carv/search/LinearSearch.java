package dev.carv.search;

import java.util.List;

public class LinearSearch<T> implements Search<T>{

    public T search(T searchItem, List<T> items) {
        for (var item : items) {
            if (searchItem.equals(item)) {
                return item;
            }
        }
        return null;
    }

}

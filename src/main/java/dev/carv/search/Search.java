package dev.carv.search;

import java.util.List;

public interface Search<T> {

    T search(T searchItem, List<T> items);

}

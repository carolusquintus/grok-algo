package dev.carv.generator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.function.Supplier;

public class Generator<T> {

    public List<T> apply(int quantity, Supplier<T> supplier) {
        var set = new HashSet<T>(quantity);

        for (int i = 0; i < quantity; i++) {
            set.add(supplier.get());
        }

        return new ArrayList<>(set);
    }

    public List<T> applyAsync(int quantity, Supplier<T> supplier) {
        return null;
    }

}

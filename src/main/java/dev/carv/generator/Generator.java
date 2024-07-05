package dev.carv.generator;

import java.util.List;
import java.util.function.Supplier;

public interface Generator<T> {

    List<T> apply(int quantity, Supplier<T> supplier);

}

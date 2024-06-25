package dev.carv.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Supplier;

public class AsyncGenerator<T> implements Generator<T> {

    @Override
    public List<T> apply(int quantity, Supplier<T> supplier) {
        var pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        var action = new ActionSupplier<>(0, quantity, supplier);
        pool.invoke(action);

        return new ArrayList<>(action.getResult());
    }

}

package dev.carv.generator;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.RecursiveAction;
import java.util.function.Supplier;

@RequiredArgsConstructor
public class ActionSupplier<T> extends RecursiveAction {

    private final int start;
    private final int end;
    private final Supplier<T> supplier;

    private final Set<T> result = new HashSet<>();

    public List<T> getResult() {
        return new ArrayList<>(result);
    }

    @Override
    protected void compute() {
        int threshold = 2_500;

        if (end - start <= threshold) {
            for (int i = start; i < end; i++) {
                result.add(supplier.get());
            }
        } else {
            int middle = (end + start) / 2;
            var left = new ActionSupplier<T>(start, middle, supplier);
            var right = new ActionSupplier<T>(middle, end, supplier);

            left.fork();
            right.compute();
            left.join();

            result.addAll(left.result);
            result.addAll(right.result);
        }
    }
}

package dev.carv.generator;

import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.RecursiveAction;

@RequiredArgsConstructor
public class AsyncGenerator extends RecursiveAction {

    private final int start;
    private final int end;

    private final Faker faker = new Faker();

    private final Set<String> result = new HashSet<>();

    public List<String> getResult() {
        return new ArrayList<>(result);
    }

    @Override
    protected void compute() {
        int threshold = 2_500;
        if (end - start <= threshold) {
            for (int i = start; i < end; i++) {
                result.add(faker.name().firstName());
            }
        } else {
            int middle = (end + start) / 2;
            var left = new AsyncGenerator(start, middle);
            var right = new AsyncGenerator(middle, end);

            left.fork();
            right.compute();
            left.join();

            result.addAll(left.result);
            result.addAll(right.result);
        }
    }

}

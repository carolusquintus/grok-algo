package dev.carv.generator;

import java.util.List;

public interface Generator<T> {

    List<T> generate(int quantity);

    List<T> generateAsync(int quantity);

}

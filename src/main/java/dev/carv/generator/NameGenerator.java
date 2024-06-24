package dev.carv.generator;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class NameGenerator implements Generator<String> {

    private final Faker faker = new Faker();

    @Override
    public List<String> generate(int quantity) {
        var namesSet = new HashSet<String>(quantity);

        for (int i = 0; i < quantity; i++) {
            var newName = faker.name().firstName();
            namesSet.add(newName);
        }

        return new ArrayList<>(namesSet);
    }

    @Override
    public List<String> generateAsync(int quantity) {
        return null;
    }

}

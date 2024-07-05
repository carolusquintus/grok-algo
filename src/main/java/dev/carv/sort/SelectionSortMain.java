package dev.carv.sort;

import com.github.javafaker.Faker;
import dev.carv.generator.AsyncGenerator;
import dev.carv.generator.LinearGenerator;
import dev.carv.search.BinarySearch;
import dev.carv.search.LinearSearch;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;

import java.util.List;

import static java.util.concurrent.TimeUnit.MICROSECONDS;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

@Slf4j
public class SelectionSortMain {

    private static final String THOUSANDS = "%,d";

    public static void main(String[] args) {
        Faker faker = new Faker();
        var watch = new StopWatch();

        var asyncGenerator = new AsyncGenerator<String>();
        watch.start();
        var usernames = asyncGenerator.apply(5_000, () -> faker.name().username());
        watch.stop();
        log.debug("Generate {} items async", THOUSANDS.formatted(usernames.size()));
        log.debug("Time {}ms", watch.getTime(MILLISECONDS));


        var selection = new SelectionSort<String>();
        watch.reset();
        watch.start();
        List<String> sortedUsernames = selection.sort(usernames);
        watch.stop();
        log.debug("Sorted by selectionSort");
        log.debug("Total: {}", THOUSANDS.formatted(sortedUsernames.size()));
        log.debug("Time {}ms", watch.getTime(MILLISECONDS));


        var randomItem = usernames.get(faker.random().nextInt(0, usernames.size()));
        watch.reset();
        watch = new StopWatch();
        watch.start();
        var binary = new BinarySearch<String>();
        var found = binary.search(randomItem, sortedUsernames);
        watch.stop();

        log.debug("Random item to find: {}", randomItem);
        log.debug("Found {}", found);
        log.debug("Time {}μs", watch.getTime(MICROSECONDS));



        log.debug("------------------------------------------------");



        var linearGenerator = new LinearGenerator<String>();
        watch.reset();
        watch.start();
        usernames = linearGenerator.apply(5_000, () -> faker.name().username());
        watch.stop();
        log.debug("Generate {} items linear", THOUSANDS.formatted(usernames.size()));
        log.debug("Time {}ms", watch.getTime(MILLISECONDS));


        watch = new StopWatch();
        watch.reset();
        watch.start();
        sortedUsernames = selection.sort(usernames);
        watch.stop();
        log.debug("Sorted by selectionSort");
        log.debug("Total: {}", THOUSANDS.formatted(usernames.size()));
        log.debug("Time {}ms", watch.getTime(MILLISECONDS));


        randomItem = usernames.get(faker.random().nextInt(0, usernames.size()));
        watch.reset();
        watch.start();
        var linear = new LinearSearch<String>();
        found = linear.search(randomItem, sortedUsernames);
        watch.stop();
        log.debug("Random item to find: {}", randomItem);
        log.debug("Found {}", found);
        log.debug("Time {}μs", watch.getTime(MICROSECONDS));
    }

}

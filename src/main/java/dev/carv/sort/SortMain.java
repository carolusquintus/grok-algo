package dev.carv.sort;

import com.github.javafaker.Faker;
import dev.carv.generator.AsyncGenerator;
import dev.carv.generator.LinearGenerator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

@Slf4j
public class SortMain {

    public static void main(String[] args) {
        Faker faker = new Faker();

        var generator = new LinearGenerator<String>();
        var watch = new StopWatch();
        watch.start();
        var names = generator.apply(5_000, () -> faker.name().name());
        watch.stop();
        log.debug("Total: {}", names.size());
        log.debug("Time {}ms", watch.getTime(MILLISECONDS));

        var asyncGenerator = new AsyncGenerator<String>();
        watch = new StopWatch();
        watch.start();
        var usernames = asyncGenerator.apply(5_000, () -> faker.name().username());
        watch.stop();
        log.debug("Total: {}", usernames.size());
        log.debug("Time {}ms", watch.getTime(MILLISECONDS));
    }

}

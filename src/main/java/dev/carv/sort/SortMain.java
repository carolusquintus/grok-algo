package dev.carv.sort;

import dev.carv.generator.AsyncGenerator;
import dev.carv.generator.NameGenerator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;

import java.util.concurrent.ForkJoinPool;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

@Slf4j
public class SortMain {

    public static void main(String[] args) {
        var generator = new NameGenerator();

        var watch = new StopWatch();
        watch.start();
        var names = generator.generate(5_000);
        watch.stop();

        log.debug("Total: {}", names.size());
        log.debug("Time {}ms", watch.getTime(MILLISECONDS));

        var pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        var parallel = new AsyncGenerator(0, 5_000);
        watch.reset();
        watch.start();
        pool.invoke(parallel);
        watch.stop();
        names = parallel.getResult();
        log.debug("Total: {}", names.size());
        log.debug("Time {}ms", watch.getTime(MILLISECONDS));
    }

}

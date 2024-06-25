package dev.carv.search;

import dev.carv.util.Reader;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;

import static java.util.concurrent.TimeUnit.MICROSECONDS;

@Slf4j
public class SearchMain {

    public static void main(String[] args) {
        var names = Reader.readCSVResource("names.csv");

        var watch = new StopWatch();
        watch.start();
        var linear = new LinearSearch<String>();
        var found = linear.search("Hallie", names);
        watch.stop();
        log.debug("Found {}", found);
        log.debug("Time {}μs", watch.getTime(MICROSECONDS));


        watch = new StopWatch();
        watch.start();
        var binary = new BinarySearch<String>();
        found = binary.search("Jonas", names);
        watch.stop();
        log.debug("Found {}", found);
        log.debug("Time {}μs", watch.getTime(MICROSECONDS));
    }

}
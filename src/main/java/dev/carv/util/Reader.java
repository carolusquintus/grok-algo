package dev.carv.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    public static List<String> readCSVResource(String path) {
        var list = new ArrayList<String>();

        try (var reader = Files.newBufferedReader(Path.of(ClassLoader.getSystemResource(path).toURI()))) {
            return reader.lines().toList();
        } catch (URISyntaxException | IOException e) {
            return list;
        }
    }
}

package io.github.benas.xstream.components;

import java.util.stream.Stream;
import io.github.benas.xstream.Stage;

public class NumberLines implements Stage<String, String> {

    private long number = 1;

    public NumberLines() {
    }

    public static NumberLines numberLines() {
        return new NumberLines();
    }
    
    @Override
    public Stream<String> apply(Stream<String> input) {
        return input.map(s -> number++ + " " + s);
    }
    
}
